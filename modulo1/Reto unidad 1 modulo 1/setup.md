# Setup del Entorno - Reto Unidad 1

**⚠️ NOTA:** Ver `README.md` para documentación completa.

## Estado del Entorno

✅ **Ya creado:** `conda reto_u1` con Python 3.11.15

## Activar el Entorno

```bash
conda activate reto_u1
```

## Instalar Dependencias

```bash
pip install -r requirements.txt
```

O manualmente:
```bash
pip install numpy pandas sqlalchemy jupyter matplotlib seaborn
```

## Verificar Instalación

```bash
python -c "import numpy, pandas, sqlalchemy; print('✅ OK')"
```

## Ejecutar Notebooks

```bash
conda activate reto_u1
jupyter notebook
```

Luego abre cada notebook (01, 02, 03) y ejecuta:
- **Kernel** → **Restart & Run All**

---

**Para más detalles:** Ver [README.md](README.md)
