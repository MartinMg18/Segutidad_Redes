Reto
Bookmarklet
Descripción
Why search for the flag when I can make a bookmarklet to print it for me?Browse [here](http://titan.picoctf.net:61907/), and find the flag!
Solución
Copié el código del bookmarklet y analicé que la bandera estaba cifrada usando una resta de caracteres con una clave (`picoctf`), así que repliqué la operación inversa restando el valor ASCII de cada carácter con la clave repetida, lo que permitió obtener la bandera en texto plano: `picoCTF{p@g3_turn3r_cebccdfe}`.
Notas adicionales
Referencias