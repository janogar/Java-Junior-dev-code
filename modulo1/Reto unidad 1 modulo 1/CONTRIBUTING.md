# Contribuir al Reto Integrador

Este documento describe cómo extender o mejorar el proyecto.

---

## 🎯 Ideas para Expandir

### 1. Visualizaciones

Crear gráficos con **matplotlib** o **seaborn**:

```python
import matplotlib.pyplot as plt
import seaborn as sns

# Gráfico de ingresos por vendedor
sns.barplot(data=resumen_vendedor, x=resumen_vendedor.index, y='ingresos_total')
plt.title('Ingresos por Vendedor - Semestre 2024')
plt.show()
```

### 2. Dashboard Interactivo

Crear un dashboard con **Streamlit**:

```bash
pip install streamlit
streamlit run dashboard.py
```

### 3. Predicción de Metas

Usar regresión con **scikit-learn**:

```python
from sklearn.linear_model import LinearRegression
# Predecir si se cumplirán metas en próximos meses
```

### 4. Automatización

Crear un script que:
- Cargue nuevos datos mensualmente
- Ejecute limpieza automáticamente
- Actualice reportes

```python
# automation/update_pipeline.py
import subprocess
subprocess.run(['jupyter', 'nbconvert', '--to', 'notebook', '--execute', 'notebooks/03_pandas_pipeline.ipynb'])
```

### 5. Tests Unitarios

Validar la limpieza de datos:

```python
# tests/test_cleaning.py
def test_no_null_products():
    assert df['producto'].notna().all()

def test_positive_quantities():
    assert (df['cantidad'] > 0).all()
```

---

## 📋 Estructura para Contribuir

1. **Crea una rama nueva**
   ```bash
   git checkout -b feature/nombre-feature
   ```

2. **Realiza tus cambios**
   - Sigue el código existente
   - Comenta tu código
   - Actualiza documentación

3. **Prueba localmente**
   ```bash
   jupyter notebook
   # Ejecuta todos los notebooks
   ```

4. **Commit y Push**
   ```bash
   git add .
   git commit -m "Feat: descripción clara del cambio"
   git push origin feature/nombre-feature
   ```

5. **Abre un Pull Request**
   - Describe qué cambió
   - Explica por qué es útil

---

## 🐛 Reportar Bugs

Si encuentras un problema:

1. Verifica que sea reproducible
2. Abre un issue con:
   - Descripción clara
   - Pasos para reproducir
   - Resultado esperado vs actual

---

## 📚 Recursos Útiles

- [Pandas Documentation](https://pandas.pydata.org/docs/)
- [NumPy User Guide](https://numpy.org/doc/stable/user/)
- [SQLite Query Language](https://www.sqlite.org/lang.html)
- [Streamlit Documentation](https://docs.streamlit.io/)
- [Scikit-learn Guide](https://scikit-learn.org/stable/)

---

## ✅ Checklist para Contribuyentes

- [ ] Código sigue la estructura existente
- [ ] Añadiste comments explicativos
- [ ] Ejecutaste todos los notebooks y funcionan
- [ ] Actualizaste README.md si es necesario
- [ ] Añadiste tus cambios a CHANGELOG.md
- [ ] Verificaste que no hay errores de encoding

---

**¡Gracias por contribuir! 🎉**
