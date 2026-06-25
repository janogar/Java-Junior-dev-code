-- 02_sql_discovery.sql
-- SQL queries para explorar los datos del reto TechVentas.

-- Q1: Lista todos los productos únicos disponibles.
SELECT DISTINCT producto AS producto_unico
FROM ventas
ORDER BY producto_unico;

-- Q2: Filtra pedidos del primer trimestre (ene-mar 2024) con cantidad mayor a 5.
SELECT *
FROM ventas
WHERE fecha BETWEEN '2024-01-01' AND '2024-03-31'
  AND cantidad > 5
ORDER BY fecha;

-- Q3: Vendedores cuyo ingreso bruto total supera $10,000 USD.
SELECT vendedor,
       SUM(cantidad * precio_unitario) AS ingreso_bruto_total
FROM ventas
GROUP BY vendedor
HAVING ingreso_bruto_total > 10000
ORDER BY ingreso_bruto_total DESC;

-- Q4: Por categoría: total de pedidos, suma de unidades vendidas y precio unitario promedio.
SELECT categoria,
       COUNT(order_id) AS total_pedidos,
       SUM(cantidad) AS suma_unidades_vendidas,
       AVG(precio_unitario) AS precio_unitario_promedio
FROM ventas
GROUP BY categoria
ORDER BY categoria;

-- Q5: Calcula el % de cumplimiento de meta de cada vendedor.
-- Se asume que la meta es mensual y el periodo cubre seis meses.
SELECT v.vendedor,
       v.zona,
       SUM(t.cantidad * t.precio_unitario) AS ingreso_total_semestre,
       v.meta_mensual,
       ROUND(SUM(t.cantidad * t.precio_unitario) / (v.meta_mensual * 6) * 100, 2) AS porcentaje_cumplimiento
FROM ventas AS t
JOIN vendedores AS v
  ON t.vendedor = v.vendedor
GROUP BY v.vendedor, v.zona, v.meta_mensual
ORDER BY porcentaje_cumplimiento DESC;

-- Q6: Encuentra el cliente que generó el mayor ingreso total en el primer semestre.
SELECT cliente_id,
       ingreso_total
FROM (
    SELECT cliente_id,
           SUM(cantidad * precio_unitario) AS ingreso_total
    FROM ventas
    GROUP BY cliente_id
) AS totales
WHERE ingreso_total = (
    SELECT MAX(ingreso_total)
    FROM (
        SELECT cliente_id,
               SUM(cantidad * precio_unitario) AS ingreso_total
        FROM ventas
        GROUP BY cliente_id
    )
);