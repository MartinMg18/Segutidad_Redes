Reto
### Glory of the Garden
Descripción
This file contains more than it seems.Get the flag from [garden.jpg](https://challenge-files.picoctf.net/c_fickle_tempest/19722024edeecca10f263776ab05c8b1235b136dcf25aa6e976d3860513ffcd5/garden.jpg).
Solución
```


┌──(kali㉿kali)-[~]
└─$ hexeditor garden.jpg
                                                                             
┌──(kali㉿kali)-[~]
└─$ strings garden.jpg | grep picoCTF
Here is a flag: picoCTF{more_than_m33ts_the_3y37fde8891}
```
Notas adicionales
Descargué el archivo **garden.jpg** y lo analicé en la terminal de **Kali Linux** buscando texto oculto dentro del binario. Usé el comando `strings garden.jpg | grep picoCTF` para extraer las cadenas legibles y así encontrar la flag dentro de la imagen.
Referencias



