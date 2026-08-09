package com.example.inventario.view;

import java.text.NumberFormat;
import java.util.Locale;

import com.example.inventario.model.Producto;
import com.example.inventario.model.ProductoElectronico;
import com.example.inventario.model.ProductoPerecedero;
import com.example.inventario.service.InventarioService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Vista principal del CRUD. Toda la interfaz está construida en Java.
 */
@Route("")
@PageTitle("Gestión de Inventario")
public class InventarioView extends VerticalLayout {

        private static final String TIPO_PERECEDERO = "Perecedero";
        private static final String TIPO_ELECTRONICO = "Electrónico";
        private static final NumberFormat MONEDA = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-CO"));

        private final InventarioService servicio = InventarioService.getInstancia();

        private final TextField codigo = new TextField("Código");
        private final TextField nombre = new TextField("Nombre");
        private final ComboBox<String> categoria = new ComboBox<>("Categoría");
        private final NumberField precio = new NumberField("Precio unitario");
        private final IntegerField stock = new IntegerField("Unidades en stock");
        private final ComboBox<String> tipo = new ComboBox<>("Tipo de producto");
        private final IntegerField datoEspecifico = new IntegerField();

        private final Grid<Producto> grid = new Grid<>(Producto.class, false);
        private String codigoEnEdicion;

        public InventarioView() {
                configurarAspectoGeneral();
                configurarFormulario();
                configurarGrid();

                H1 titulo = new H1("Gestión de Inventario");
                titulo.getStyle().set("margin-bottom", "0");
                Paragraph descripcion = new Paragraph(
                                "Administra productos perecederos y electrónicos.");
                descripcion.getStyle()
                                .set("color", "var(--lumo-secondary-text-color)")
                                .set("margin-top", "0");

                VerticalLayout panelFormulario = crearPanelFormulario();
                VerticalLayout panelListado = crearPanelListado();

                add(titulo, descripcion, panelFormulario, panelListado);
                setHorizontalComponentAlignment(Alignment.CENTER,
                                titulo, descripcion, panelFormulario);
                setHorizontalComponentAlignment(Alignment.STRETCH, panelListado);
        }

        private void configurarAspectoGeneral() {
                setSizeFull();
                setPadding(true);
                setSpacing(true);
                getStyle()
                                .set("max-width", "1400px")
                                .set("margin", "0 auto")
                                .set("background", "var(--lumo-contrast-5pct)");
        }

        private void configurarFormulario() {
                tipo.setItems(TIPO_PERECEDERO, TIPO_ELECTRONICO);
                tipo.setValue(TIPO_PERECEDERO);
                tipo.setRequiredIndicatorVisible(true);
                tipo.setWidthFull();
                tipo.addValueChangeListener(evento -> actualizarCampoEspecifico(evento.getValue()));

                categoria.setItems(servicio.obtenerCategorias());
                categoria.setRequiredIndicatorVisible(true);
                categoria.setWidthFull();

                codigo.setRequiredIndicatorVisible(true);
                nombre.setRequiredIndicatorVisible(true);
                precio.setRequiredIndicatorVisible(true);
                stock.setRequiredIndicatorVisible(true);
                datoEspecifico.setRequiredIndicatorVisible(true);

                precio.setMin(0);
                precio.setStep(1000);
                precio.setPrefixComponent(new Paragraph("$"));
                stock.setMin(0);
                datoEspecifico.setMin(0);

                codigo.setWidthFull();
                nombre.setWidthFull();
                precio.setWidthFull();
                stock.setWidthFull();
                datoEspecifico.setWidthFull();
                actualizarCampoEspecifico(TIPO_PERECEDERO);
        }

        private VerticalLayout crearPanelFormulario() {
                H2 subtitulo = new H2("Datos del producto");
                FormLayout formulario = new FormLayout();
                formulario.setResponsiveSteps(
                                new FormLayout.ResponsiveStep("0", 1),
                                new FormLayout.ResponsiveStep("450px", 2));
                formulario.add(codigo, nombre, categoria, tipo,
                                precio, stock, datoEspecifico);
                formulario.setColspan(datoEspecifico, 2);

                Button guardar = new Button("Guardar", evento -> guardarProducto());
                guardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
                Button nuevo = new Button("Nuevo", evento -> limpiarFormulario());

                VerticalLayout panel = new VerticalLayout(
                                subtitulo, formulario, new HorizontalLayout(guardar, nuevo));
                panel.setWidth("440px");
                panel.setMinWidth("320px");
                panel.getStyle()
                                .set("background", "var(--lumo-base-color)")
                                .set("border-radius", "var(--lumo-border-radius-l)")
                                .set("box-shadow", "var(--lumo-box-shadow-xs)");
                return panel;
        }

        private void configurarGrid() {
                grid.addColumn(Producto::getCodigo)
                                .setHeader("Código").setAutoWidth(true).setSortable(true);
                grid.addColumn(Producto::getNombre)
                                .setHeader("Producto").setAutoWidth(true).setSortable(true);
                grid.addColumn(Producto::getCategoria)
                                .setHeader("Categoría").setAutoWidth(true).setSortable(true);
                grid.addColumn(this::obtenerTipo)
                                .setHeader("Tipo").setAutoWidth(true);
                grid.addColumn(producto -> MONEDA.format(producto.getPrecio()))
                                .setHeader("Precio").setAutoWidth(true);
                grid.addColumn(Producto::getStock)
                                .setHeader("Stock").setAutoWidth(true).setSortable(true);
                grid.addColumn(this::obtenerDatoEspecifico)
                                .setHeader("Detalle").setAutoWidth(true);

                // Polimorfismo: cada clase hija ejecuta su propia implementación.
                grid.addColumn(producto -> MONEDA.format(producto.calcularValorInventario()))
                                .setHeader("Valor inventario").setAutoWidth(true);

                grid.addComponentColumn(producto -> {
                        Button eliminar = new Button("Eliminar", evento -> {
                                servicio.eliminar(producto.getCodigo());
                                if (producto.getCodigo().equals(codigoEnEdicion)) {
                                        limpiarFormulario();
                                }
                                actualizarGrid();
                                mostrarNotificacion(
                                                "Producto eliminado correctamente.", true);
                        });
                        eliminar.addThemeVariants(
                                        ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_TERTIARY);
                        return eliminar;
                }).setHeader("Acciones").setAutoWidth(true).setFlexGrow(0);

                grid.setWidthFull();
                grid.setHeight("560px");
                grid.addItemClickListener(evento -> cargarProducto(evento.getItem()));
                actualizarGrid();
        }

        private VerticalLayout crearPanelListado() {
                H2 subtitulo = new H2("Productos registrados");
                VerticalLayout panel = new VerticalLayout(subtitulo, grid);
                panel.setMinWidth("600px");
                panel.getStyle()
                                .set("background", "var(--lumo-base-color)")
                                .set("border-radius", "var(--lumo-border-radius-l)")
                                .set("box-shadow", "var(--lumo-box-shadow-xs)");
                return panel;
        }

        private void guardarProducto() {
                try {
                        validarFormulario();
                        Producto producto = construirProducto();
                        if (codigoEnEdicion == null) {
                                servicio.registrar(producto);
                                mostrarNotificacion(
                                                "Producto registrado correctamente.", true);
                        } else {
                                servicio.actualizar(producto);
                                mostrarNotificacion(
                                                "Producto actualizado correctamente.", true);
                        }

                        categoria.setItems(servicio.obtenerCategorias());
                        actualizarGrid();
                        limpiarFormulario();
                } catch (IllegalArgumentException excepcion) {
                        mostrarNotificacion(excepcion.getMessage(), false);
                }
        }

        private Producto construirProducto() {
                if (TIPO_PERECEDERO.equals(tipo.getValue())) {
                        return new ProductoPerecedero(
                                        codigo.getValue(), nombre.getValue(), categoria.getValue(),
                                        precio.getValue(), stock.getValue(),
                                        datoEspecifico.getValue());
                }
                return new ProductoElectronico(
                                codigo.getValue(), nombre.getValue(), categoria.getValue(),
                                precio.getValue(), stock.getValue(),
                                datoEspecifico.getValue());
        }

        private void validarFormulario() {
                if (codigo.isEmpty() || nombre.isEmpty()
                                || categoria.isEmpty() || tipo.isEmpty()
                                || precio.isEmpty() || stock.isEmpty()
                                || datoEspecifico.isEmpty()) {
                        throw new IllegalArgumentException(
                                        "Complete todos los campos obligatorios.");
                }
                if (precio.getValue() < 0 || stock.getValue() < 0
                                || datoEspecifico.getValue() < 0) {
                        throw new IllegalArgumentException(
                                        "Los valores numéricos no pueden ser negativos.");
                }
        }

        private void cargarProducto(Producto producto) {
                codigoEnEdicion = producto.getCodigo();
                codigo.setValue(producto.getCodigo());
                codigo.setReadOnly(true);
                nombre.setValue(producto.getNombre());
                categoria.setValue(producto.getCategoria());
                precio.setValue(producto.getPrecio());
                stock.setValue(producto.getStock());

                if (producto instanceof ProductoPerecedero perecedero) {
                        tipo.setValue(TIPO_PERECEDERO);
                        datoEspecifico.setValue(perecedero.getDiasParaVencer());
                } else if (producto instanceof ProductoElectronico electronico) {
                        tipo.setValue(TIPO_ELECTRONICO);
                        datoEspecifico.setValue(electronico.getMesesGarantia());
                }
        }

        private void limpiarFormulario() {
                codigoEnEdicion = null;
                codigo.clear();
                codigo.setReadOnly(false);
                nombre.clear();
                categoria.clear();
                precio.clear();
                stock.clear();
                tipo.setValue(TIPO_PERECEDERO);
                datoEspecifico.clear();
                grid.deselectAll();
                codigo.focus();
        }

        private void actualizarCampoEspecifico(String tipoSeleccionado) {
                datoEspecifico.setLabel(TIPO_ELECTRONICO.equals(tipoSeleccionado)
                                ? "Meses de garantía"
                                : "Días para vencer");
                datoEspecifico.clear();
        }

        private String obtenerTipo(Producto producto) {
                return producto instanceof ProductoPerecedero
                                ? TIPO_PERECEDERO
                                : TIPO_ELECTRONICO;
        }

        private String obtenerDatoEspecifico(Producto producto) {
                if (producto instanceof ProductoPerecedero perecedero) {
                        return perecedero.getDiasParaVencer() + " días";
                }
                ProductoElectronico electronico = (ProductoElectronico) producto;
                return electronico.getMesesGarantia() + " meses";
        }

        private void actualizarGrid() {
                grid.setItems(servicio.listarOrdenadosPorNombre());
        }

        private void mostrarNotificacion(String mensaje, boolean exito) {
                Notification notificacion = Notification.show(
                                mensaje, 3000, Notification.Position.TOP_CENTER);
                notificacion.addThemeVariants(exito
                                ? NotificationVariant.LUMO_SUCCESS
                                : NotificationVariant.LUMO_ERROR);
        }
}