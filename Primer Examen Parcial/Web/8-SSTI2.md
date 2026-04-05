Reto
SSTI2
Descripción
I made a cool website where you can announce whatever you want! I read about input sanitization, so now I remove any kind of characters that could be a problem :)I heard templating is a cool and modular way to build web apps! Check out my website [here](http://shape-facility.picoctf.net:61050/)!
Solución
Explotamos una vulnerabilidad de **SSTI** en Jinja2. Saltamos el filtro de puntos (`.`) usando **corchetes** (`[]`) para acceder a las librerías de Python del servidor. Importamos el módulo **`os`**, ejecutamos el comando **`ls`** para encontrar el archivo secreto y luego **`cat flag`** para que el servidor nos imprimiera la bandera en pantalla.
Notas adicionales
Referencias