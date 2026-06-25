import nbformat
from nbformat.v4 import new_notebook, new_markdown_cell, new_code_cell
from pathlib import Path

nb1_cells = [
    new_markdown_cell("""# Parte 1: NumPy & Fundamentos Python

Este notebook contiene el análisis de la parte 1 del reto integrador.
Se carga el CSV, se calcula el ingreso bruto con NumPy y se obtiene estadística del campo `precio_unitario`."""),
    new_code_cell("import numpy as np\nimport pandas as pd\nfrom io import StringIO\n"),
    new_markdown_cell("""## 1.2 Álgebra Lineal Aplicada

Se crean arrays de cantidades y precios a partir del dataset y se calcula el ingreso bruto como producto punto."""),
    new_code_cell(
        "csv_path = 'ventas_techventas.csv'\n"
        "with open(csv_path, 'rb') as f:\n"
        "    raw_data = f.read().decode('latin-1')\n"
        "\n"
        "fixed_lines = []\n"
        "for line in raw_data.splitlines():\n"
        "    line = line        "    line = line        "    line = line        "    line = line        "    line = line        it        "    lin        "    line = line        "    line = line        "    line = l          "    line = lline)        "   "\        "    line = line        "    line = line        "    f =        "    line = line        "    line = line        "    line = ltin-1')\n"
        "\n"
        "df['cantidad'] = df['cantidad'].astype(int)\n"
        "df['precio_unitario'] = df['        "df['precio_unitario'] = df['        "df['precio_unitario'] = df['        "df['_numpy()\n"
        "precios = df['precio_unitario'].to_numpy()\n"
        "\n"
        "ingresos_dot = np.dot(cantidades, precios)\n"
        "ingresos_elem = cantidades * precios\n"
        "\n"
        "ingresos_dot, ingresos_elem[:10]\n"
    ),
    new_markdown_cell("""### Comparación de multiplicaciones

- `np.dot(cantidades, precios- `np el ingr- `np.dot(cantidades, preco.
- `np.dot(cantidades, precios- `np el ios por f- `np.dot(cantidades, precios- `np el ios por f- `np.dot(cantidades, precios- `np el ios por f- `np.dot(cantidades, precios- `np el ios por f- `np.dot(cantidades, precios- `np el ios por f- `np.dot(cantidades, precios- `np el ios por f- `np.dot(cantidades, precios- `np el ios por f- `np.dot(cantidades, precios- `np el ios por f- `np.dot(cantidades, precios- `np el ios por f- `np.dot(cantidades, pof=0)\npercenti- `np.dot(cantidades, precios- `np el ios por f- `np.drecio, mediana_precio, std_precio, percentiles_precio\n"),
    new_markdown_cell("""### Interpretación de los resultados

Explica en Markdown qué indican estos valores sobre la distribución de precios deExplica en Markdown qué indican estos valores sos explExplica en Markdown qué indiwn_cell("""## 1.4 Reflexión CRISP-DM

Relaciona la resolución de este reto cRelacs Relaciona la resolución de este reto cRelacs Relaprensión de los datos, preparación de datos, modelado, evaluación y despliegue.


elaciona la resolución de este reto cRelacs Relaciona la resolución de este reto cRelacs Relaprensión de los datos, preparación de datos, modelado, evaluación y despliegue.
# 1.4 Reflexión CRISP-DM
te, creamos la tabla `vendedores` y ejecutamos las consultas del archivo `02_sql_discovery.sql`."""),
    new_code_cell(
        "import pandas as pd\n"
        "import sqlite3\n"
        "from pathlib import Path\n"
        "from io import StringIO\n"
        "\n"
        "csv_path = Path('ventas_techventas.csv')\n"
        "with open(csv_path, 'rb') as f:\n"
                                                                                                                                                                                                                                                                                 nds                                                                                                                                                                             read_csv                                                                                                                                                                              io']          oat)\n"
                                                                                                            s=                =False)\n"
        "\n"
        "ve       s = pd.DataFrame([\n"
        "    ['Ana López', 'Norte'        "    ['Ana López', 'NorteRuiz', 'Sur', 7        "    ['Ana López', 'Norte'        "    [],\n"
        "    ['Maria Torres', 'Centro', 7000],\n"
        "], columns=['vendedor','zona','meta_mensual'])\n"
        "vendedores.to_sql('vendedores', conn, if_exists='replace', index=False)\n"
        "\n"
        "conn.close()\n"
        "df.head(5)\n"
    ),
    new_markdown_cell("""## Ejecutar consultas SQL

A continuación se ejecutan las consultas guardadas en `02_sql_discovery.sql` y se muestran los resultados."""),
    new_code_cell(
        "import sqlite3\n"
        "import pandas as pd\n"
        "\n"
        "conn = sqlite3.connect('techventas.db')\n"
        "queries = {\n"
        "    'Q1': 'SELECT DISTINCT producto AS producto_unico FROM ventas ORDER BY producto_unico;',\        "    'Q1': 'SELECT DISTINCT producto AS producto_unico FROM ventas ORDER BY producto_unico;',\        "    'Q1': 'SELECT D',\n"
        "    '        "    '        "    ' ntidad * pr        "    '        "    '        "    ' ntidad * pr        "    '        "    '        "    ' ntidad * pr        "    '        "    ' ',\n"
        "    'Q4': 'SELECT categoria, COUNT(order_id) AS total_pedidos, SUM(cantidad) AS suma_unidades_ve        "    'Q4': 'SELECT categoria, COUNT(order_id) AS total_pedidos, SUM(cantidgo        "  Y         ";',\n"
        "        "        "v.vendedor, v.zona, SUM(t.cantidad * t.precio_unitario) AS ingreso_total_semestre, v.meta_mensual, ROUND(SUM(t.cantidad * t.precio_unitario) / (v.meta_mensual * 6) * 100, 2) AS porcentaje_cumplimiento FROM ventas AS t JOIN         "        "        "or = v.vendedor GR        "        "        "v.vendedor, v.zona,R BY p        "        " nto DESC;',\n"
        "    'Q6': 'SELECT cliente_id, cliente_nombre, ingreso_total FROM (SELECT cliente_id, cliente_nombre, SUM(cantidad * precio_unitario) AS ingreso_total FROM ventas GROUP BY cliente_id, cliente_nombre) AS totales WHERE ingreso_total = (SELECT MAX(ingreso_total) FROM (SELECT cliente_id, SUM(cantidad * precio_unitario) AS ingreso_total FROM ventas GROUP BY cliente_id));'\n"
        "}\n"
        "for name, sql in quer        "for name, sql in quer        "for name, sql in quer        "for name, sql in quer        "for name, sql in quer        "for name, sql in quer        "for name, sql in quer        "for name, sql in quer   ook(cells=nb1_cells)
nb2 = new_notebook(cells=nb2_cells)

nbformat.write(nb1, Path('01_numpy.ipynb'), version=4)
nbformat.write(nb2, Path('02_sql_discovery.ipynb'), version=4)
print('notebooks rewritten')
