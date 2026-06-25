# 🚀 Reto Integrador: Unidad 1 - El Lenguaje y la Filosofía de los Datos

**Máster en Inteligencia Artificial | Dev Senior Code**


---

## 📁 Estructura del Proyecto

```
reto_unidad1/
├── README.md                          ← Este archivo
├── setup.md                           ← Instrucciones de entorno (deprecated)
├── requirements.txt                   ← Dependencias Python
│
├── data/
│   └── ventas_techventas.csv         ← Dataset (60 transacciones con errores)
│
├── notebooks/
│   ├── 01_numpy.ipynb                ← Parte 1: NumPy & Fundamentos
│   ├── 02_sql_discovery.ipynb        ← Parte 2: SQL & Data Discovery
│   └── 03_pandas_pipeline.ipynb      ← Parte 3: Pandas & Feature Engineering
│
├── sql/
│   └── 02_sql_discovery.sql          ← Queries SQL para exploración
│
├── output/
│   └── techventas.db                 ← Base de datos SQLite (generada)
│
└── .venv/                            ← Entorno virtual (conda)
```

---

## 🔧 Requisitos Previos

- **Python:** 3.11.15
- **Conda:** Instalado y configurado
- **Entorno virtual:** `reto_u1` (ya creado)

### Verificar el entorno

```bash
conda activate reto_u1
python --version  # Debe mostrar Python 3.11.15
```

---

## ⚙️ Instalación y Setup

### 1️⃣ Activar el entorno virtual

```bash
conda activate reto_u1
```

### 2️⃣ Instalar dependencias (si no están instaladas)

```bash
pip install numpy pandas sqlalchemy jupyter matplotlib seaborn
```

### 3️⃣ Verificar instalación

```bash
python -c "import numpy, pandas, sqlalchemy; print('✅ Dependencias instaladas correctamente')"
```

### 4️⃣ Iniciar Jupyter

```bash
jupyter notebook
```

---

## 📊 Estructura de los Notebooks

### **Parte 1: NumPy & Fundamentos Python** (`01_numpy.ipynb`)

**Objetivo:** Dominar álgebra lineal y estadística descriptiva

**Temas:**
- ✅ Carga y exploración de CSV
- ✅ Arrays con NumPy
- ✅ Multiplicación matricial: `np.dot()` vs elemento a elemento
- ✅ Estadísticas: media, mediana, desviación estándar, percentiles
- ✅ Reflexión CRISP-DM

**Salida esperada:**
- Ingreso bruto total del semestre
- Análisis estadístico de precios
- Mapeo a ciclo CRISP-DM

---

### **Parte 2: SQL para Data Discovery** (`02_sql_discovery.ipynb` + `02_sql_discovery.sql`)

**Objetivo:** Consultar, filtrar y relacionar datos con SQL

**Queries incluidas:**

| Query | Descripción |
|-------|-------------|
| **Q1** | `SELECT DISTINCT` - Productos únicos |
| **Q2** | `WHERE + BETWEEN` - Filtro por trimestre y cantidad |
| **Q3** | `GROUP BY + HAVING` - Vendedores por ingresos |
| **Q4** | `COUNT + SUM + AVG` - Resumen por categoría |
| **Q5** | `JOIN` - Cumplimiento de metas de vendedores |
| **Q6** | Subconsulta - Cliente con mayor ingreso |

**Tablas generadas:**
- `ventas` (47 transacciones válidas)
- `vendedores` (4 vendedores con metas mensuales)

---

### **Parte 3: Pandas & Pipeline** (`03_pandas_pipeline.ipynb`)

**Objetivo:** Construir un pipeline profesional: carga → limpieza → transformación → exportación

**Fases:**

| Fase | Descripción |
|------|-------------|
| **3.1** | Carga con parseo de fechas y encoding |
| **3.2** | Detección de valores nulos y errores |
| **3.3** | Feature Engineering (ingresos, períodos) |
| **3.4** | Merge con metas y cumplimiento |
| **3.5** | Exportación a SQLite |

**Features creadas:**
```python
ingreso_bruto = cantidad × precio_unitario
ingreso_neto = ingreso_bruto × (1 - descuento)
mes = período mensual (YYYY-MM)
cumplimiento_pct = (ingresos / meta) × 100
```

**Resumen de resultados:**

| Métrica | Valor |
|---------|-------|
| Registros cargados | 60 |
| Registros válidos | 47 |
| Registros descartados | 13 (21.7%) |
| Ingresos totales | $67,500.50 USD |
| Número de pedidos | 47 |
| Ticket promedio | $1,436.18 USD |
| Cumplimiento general | 36.9% |

---

## 🚀 Cómo Ejecutar

### Opción 1: Ejecutar Todo de Una Vez

```bash
conda activate reto_u1
jupyter notebook
```

En Jupyter, abre cada notebook y ejecuta:
- **Kernel** → **Restart & Run All**

### Opción 2: Ejecutar Paso a Paso

```bash
conda activate reto_u1
jupyter notebook
```

1. Abre `01_numpy.ipynb` y ejecuta todas las celdas
2. Abre `02_sql_discovery.ipynb` y ejecuta todas las celdas
3. Abre `03_pandas_pipeline.ipynb` y ejecuta todas las celdas

---

## 📊 Resultados Principales

### 🏢 Desempeño por Región

| Región | Ingresos |
|--------|----------|
| Norte | $23,625.50 |
| Centro | $13,390.75 |
| Oeste | $10,503.50 |
| Sur | $10,225.75 |
| Este | $9,755.00 |

### 📦 Productos Más Vendidos

| Categoría | Ingresos |
|-----------|----------|
| Electrónica | $31,800.00 |
| Almacenamiento | $22,500.75 |
| Periféricos | $8,669.75 |
| Redes | $4,530.00 |

### 👥 Desempeño de Vendedores

| Vendedor | Ingresos | Meta | Cumplimiento |
|----------|----------|------|--------------|
| Carlos Ruiz | $19,255.50 | $45,000 | 42.8% ⚠️ |
| Ana López | $19,449.00 | $48,000 | 40.5% ⚠️ |
| Luis Mora | $18,025.00 | $48,000 | 37.6% ⚠️ |
| Maria Torres | $10,771.00 | $42,000 | 25.6% ⚠️ |

### 📈 Tendencia Mensual

| Mes | Ingresos | Pedidos | Unidades |
|-----|----------|---------|----------|
| Enero | $11,446 | 8 | 71 |
| Febrero | $9,725 | 8 | 97 |
| Marzo | $12,459 | 9 | 98 |
| Abril | $14,659 | 9 | 107 |
| Mayo | $10,925 | 8 | 98 |
| Junio | $8,287 | 5 | 73 |

---

## 📦 Archivos de Salida

### Base de Datos SQLite (`output/techventas.db`)

Contiene 4 tablas:

1. **`ventas`** - 47 transacciones limpias
   ```
   order_id | fecha | cliente_id | región | producto | cantidad | 
   precio_unitario | descuento | vendedor | ingreso_bruto | ingreso_neto | mes
   ```

2. **`vendedores`** - Datos de vendedores y metas
   ```
   vendedor | zona | meta_mensual
   ```

3. **`vendedor_performance`** - Cumplimiento mensual
   ```
   mes | vendedor | ingresos_mes | meta_mensual | cumplimiento_pct
   ```

4. **`resumen_mensual`** - Ingresos totales por mes
   ```
   mes | ingreso_total | total_pedidos | total_unidades
   ```

### Consultar la Base de Datos

```python
import pandas as pd
import sqlite3

conn = sqlite3.connect('output/techventas.db')
df = pd.read_sql('SELECT * FROM ventas LIMIT 5', conn)
print(df)
conn.close()
```

---

## 🧹 Estrategia de Limpieza

| Problema | Registros | Acción |
|----------|-----------|--------|
| Productos en blanco | 12 | ELIMINAR |
| Cantidades negativas | 1 | ELIMINAR |
| Descuentos inválidos | 0 | ELIMINAR |
| **Total descartados** | **13** | **21.7%** |

### Justificación

- **Productos en blanco:** No se pueden vender datos vacíos
- **Cantidades negativas:** Errores de entrada, no representan operaciones válidas
- **Descuentos inválidos:** Violarían políticas de la empresa

---

## 📚 Ciclo CRISP-DM

Este reto cubre todas las fases:

1. **Comprensión del Negocio** → TechVentas, CEO, metas mensuales
2. **Comprensión de Datos** → Exploración CSV, detección de errores
3. **Preparación de Datos** → Limpieza, tratamiento de nulos
4. **Modelado** → Feature engineering, agregaciones
5. **Evaluación** → Cumplimiento de metas, análisis de tendencias
6. **Despliegue** → SQLite para consultas futuras

---

## 💡 Insights Clave para la Gerencia

### ⚠️ Puntos Críticos

1. **Cumplimiento bajo:** Solo 36.9% de la meta global
2. **Dispersión por vendedor:** Desde 25.6% (Maria Torres) hasta 42.8% (Carlos Ruiz)
3. **Datos inconsistentes:** 21.7% del dataset tenía errores
4. **Tendencia decreciente:** Junio fue el mes más débil ($8,287)

### ✅ Fortalezas

- Region Norte lidera con $23,625.50
- Categoría Electrónica genera 47% de los ingresos
- Datos validados en 47 transacciones confiables

---

## 🛠️ Troubleshooting

### Error: "Módulo no encontrado"

```bash
conda activate reto_u1
pip install numpy pandas sqlalchemy jupyter
```

### Error: "Archivo CSV no encontrado"

Asegúrate de estar en el directorio correcto:
```bash
cd /path/to/proyecto
```

### Error: "Port 8888 already in use"

```bash
jupyter notebook --port 8889
```

---

## 📖 Referencias

- **NumPy Documentation:** https://numpy.org/doc/
- **Pandas Documentation:** https://pandas.pydata.org/docs/
- **SQLite Documentation:** https://www.sqlite.org/docs.html
- **CRISP-DM Guide:** https://en.wikipedia.org/wiki/Cross-industry_standard_process_for_data_mining

---

## 📝 Notas Importantes

- El dataset `ventas_techventas.csv` contiene **errores intencionales** para que practiques limpieza
- Todos los notebooks están listos para ejecutar con **Restart & Run All**
- La base de datos SQLite se genera automáticamente al ejecutar el notebook 3
- Los nombres de vendedores tienen problemas de encoding en el CSV original

---

## 🎓 Criterios de Evaluación

| Criterio | Puntos | Estado |
|----------|--------|--------|
| Entorno y Setup | 15% | ✅ Completado |
| NumPy & Álgebra | 25% | ✅ Completado |
| SQL Discovery | 25% | ✅ Completado |
| Pipeline Pandas | 25% | ✅ Completado |
| Calidad del Repo | 10% | ✅ Completado |
| **TOTAL** | **100%** | ✅ |

---

## 📞 Contacto

**Estudiante:** Sol Piccolo  
**Programa:** Máster en Inteligencia Artificial  
**Plataforma:** Dev Senior Code  
**Cohorte:** [Ver calendario en plataforma]

---

## 📄 Licencia

Este proyecto es parte del programa educativo de **Dev Senior Code**.

---

**Última actualización:** Junio 2026  
**Estado:** ✅ Completado y Funcional
