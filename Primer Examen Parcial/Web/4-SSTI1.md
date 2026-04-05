Reto
SSTI1
Descripción
I made a cool website where you can announce whatever you want! Try it out!I heard templating is a cool and modular way to build web apps! Check out my website [here](http://rescued-float.picoctf.net:64771/)!
Solución
Primero probé si el input era vulnerable a SSTI utilizando `{{7*7}}`, lo que devolvió `49` y confirmó que se podían ejecutar expresiones del lado del servidor; después utilicé un payload de Jinja2 para acceder a funciones internas de Python y así importar el módulo `os`, con el que ejecuté el comando `cat flag` directamente desde el servidor, lo que permitió obtener la bandera.
Notas adicionales
Referencias