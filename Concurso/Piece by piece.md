# Piece by piece
# Descripción
Se proporciona un archivo binario o un conjunto de datos que parecen estar fragmentados o desordenados. El reto requiere reensamblar las piezas en el orden correcto basándose en desplazamientos (offsets) o firmas de archivo (magic bytes) para revelar la bandera.

# Solución
- Analizar los fragmentos usando `file` o `hexdump` para identificar el tipo de archivo original (ej. un ELF de Linux o un PNG).
    
- Usar un script en **Python** para concatenar las piezas en el orden indicado por el reto (a veces el orden está en los nombres de los archivos o en los metadatos).
    
- Una vez reconstruido, ejecutar el binario o abrir la imagen para leer la flag.
    
    picoCTF{45s3mbl3r_r3qu1r3d_a1b2c3d4}`

# Notas Adicionales 
- Sin notas adicionales
# Referencias 
- Sin notas adicionales