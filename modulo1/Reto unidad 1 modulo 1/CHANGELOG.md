# Changelog - Reto Integrador Unidad 1

## ✅ [Completado] - Junio 2026

### Parte 1: NumPy & Fundamentos Python ✅

- [x] Entorno virtual con conda (Python 3.11.15)
- [x] Carga de CSV con encoding y parseo de fechas
- [x] Creación de arrays con cantidades y precios
- [x] Cálculo de ingreso bruto con `np.dot()` vs elemento a elemento
- [x] Estadísticas descriptivas (media, mediana, std, percentiles 25/75)
- [x] Reflexión sobre ciclo CRISP-DM
- [x] Documentación en notebooks/01_numpy.ipynb

**Resultado:** 
- Ingreso bruto total del semestre: Calculado ✅
- Análisis estadístico de precios: Completado ✅

---

### Parte 2: SQL para Data Discovery ✅

- [x] Carga de datos en SQLite con `pandas.to_sql()`
- [x] Creación de tabla `vendedores` con metas mensuales
- [x] Query Q1: `SELECT DISTINCT` - Productos únicos
- [x] Query Q2: `WHERE + BETWEEN` - Filtro por trimestre
- [x] Query Q3: `GROUP BY + HAVING` - Vendedores por ingresos
- [x] Query Q4: `COUNT + SUM + AVG` - Resumen por categoría
- [x] Query Q5: `JOIN` - Cumplimiento de metas
- [x] Query Q6: Subconsulta - Cliente con mayor ingreso
- [x] Documentación en notebooks/02_sql_discovery.ipynb
- [x] Queries guardadas en sql/02_sql_discovery.sql

**Resultado:**
- Base de datos SQLite funcional ✅
- 6 queries ejecutadas sin errores ✅
- Tabla vendedores sincronizada ✅

---

### Parte 3: Pandas & Pipeline ✅

#### 3.1 - Carga del CSV ✅
- [x] Lectura con encoding `latin-1`
- [x] Parseo de fechas con `parse_dates=['fecha']`
- [x] Exploración con `df.info()`
- [x] Identificación de 60 registros iniciales

#### 3.2 - Detección y Limpieza ✅
- [x] Detección de valores nulos con `isna()`
- [x] Identificación de productos en blanco: 12 registros
- [x] Identificación de cantidades negativas: 1 registro
- [x] Eliminación de registros inválidos
- [x] Resultado: 47 registros válidos (78.3% tasa de validez)

#### 3.3 - Feature Engineering ✅
- [x] Creación de `ingreso_bruto` = cantidad × precio_unitario
- [x] Creación de `ingreso_neto` = ingreso_bruto × (1 - descuento)
- [x] Creación de `mes` = período mensual (YYYY-MM)
- [x] Agrupación mensual con `groupby() + agg()`
- [x] Resumen mensual calculado

#### 3.4 - Merge con Metas ✅
- [x] Creación de DataFrame `vendedores` con 4 vendedores
- [x] Limpieza de nombres de vendedores (encoding issues)
- [x] Merge con tabla de performance
- [x] Cálculo de cumplimiento de metas
- [x] Resultado: Cumplimiento general 36.9% ⚠️

#### 3.5 - Exportación a SQLite ✅
- [x] Exportación de tabla `ventas` (47 registros)
- [x] Exportación de tabla `vendedores` (4 vendedores)
- [x] Exportación de tabla `vendedor_performance`
- [x] Exportación de tabla `resumen_mensual`
- [x] Verificación con `read_sql()`

**Resultado:**
- Pipeline completado ✅
- Base de datos SQLite generada ✅
- Todas las tablas validadas ✅

---

## 📊 Resumen de Resultados

| Métrica | Valor |
|---------|-------|
| Registros originales | 60 |
| Registros válidos | 47 |
| Registros descartados | 13 (21.7%) |
| Ingresos totales | $67,500.50 USD |
| Cumplimiento general | 36.9% |
| Queries ejecutadas | 6/6 ✅ |
| Tablas generadas | 4/4 ✅ |

---

## 📁 Archivos Principales Creados

- ✅ `README.md` - Documentación completa del proyecto
- ✅ `requirements.txt` - Dependencias Python
- ✅ `.gitignore` - Configuración Git
- ✅ `notebooks/01_numpy.ipynb` - Parte 1 (NumPy)
- ✅ `notebooks/02_sql_discovery.ipynb` - Parte 2 (SQL)
- ✅ `notebooks/03_pandas_pipeline.ipynb` - Parte 3 (Pandas)
- ✅ `sql/02_sql_discovery.sql` - Queries SQL
- ✅ `output/techventas.db` - Base de datos SQLite

---

## 🔄 Cambios Recientes

### Reestructuración (Junio 2026)

1. **Creación de README profesional**
   - Documentación completa de proyecto
   - Estructura clara y navegable
   - Requisitos e instrucciones detalladas
   - Resultados principales documentados

2. **Creación de requirements.txt**
   - Versiones pinned para reproducibilidad
   - Todas las dependencias necesarias

3. **Simplificación de setup.md**
   - Apunta a README como referencia principal
   - Instrucciones concisas

4. **Creación de .gitignore**
   - Configuración profesional para Git
   - Exclusión de archivos temporales y sensibles

---

## 📌 Estado Actual

✅ **Proyecto Completado**

Todos los requisitos del reto integrador han sido cumplidos:
- NumPy ✅
- SQL ✅
- Pandas ✅
- Documentación ✅
- Setup profesional ✅

**Listo para:** Presentación, GitHub, o evaluación

---

## 🎯 Siguientes Pasos (Opcional)

- [ ] Subir a repositorio GitHub público
- [ ] Agregar visualizaciones con matplotlib/seaborn
- [ ] Crear presentación ejecutiva para el CEO
- [ ] Automatizar limpieza de datos con scripts
- [ ] Crear dashboard interactivo con Streamlit

---

**Última actualización:** 2026-06-21  
**Versión:** 1.0  
**Estado:** Completado ✅
