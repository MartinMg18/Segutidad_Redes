Reto
What Lies Within
Descripción
There's something in the [building](https://challenge-files.picoctf.net/c_fickle_tempest/c0eec6af0f04316e2bdc4a9f095afd0e2d0121f5e543dbc4a65bb0038d72a993/buildings.png). Can you retrieve the flag?
Solución
```
┌──(kali㉿kali)-[~/what]
└─$ zsteg building.png
[!] #<Errno::ENOENT: No such file or directory @ rb_sysopen - building.png>
                                                                             
┌──(kali㉿kali)-[~/what]
└─$ zsteg buildings.png

```
Notas adicionales
Descargué el archivo **buildings.png** y utilicé la herramienta **zsteg** en Kali Linux para analizar si la imagen tenía información oculta en los bits menos significativos (LSB). El análisis reveló una cadena de texto escondida dentro de la imagen donde se encontraba la flag **picoCTF**.
Referencias








