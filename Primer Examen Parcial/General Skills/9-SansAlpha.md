Reto
SansAlpha
Descripción
The Multiverse is within your grasp! Unfortunately, the server that contains the secrets of the multiverse is in a universe where keyboards only have numbers and (most) symbols.`ssh -p 60762 ctf-player@mimas.picoctf.net`Use password: `f3b61b38`
Solución
Primero me conecté por SSH con las credenciales del reto y vi que la shell bloqueaba cualquier comando que tuviera letras, así que no podía usar directamente `ls`, `cat` o `base64`; para saltarme esa restricción aproveché comodines y patrones del sistema para invocar el binario de `base64` sin escribir letras de forma explícita y lo apliqué sobre el archivo de la bandera, con lo que obtuve una cadena codificada en base64: cmV0dXJuIDAKcGljb0NURns3aDE1X211MTcxdjNyNTNfMTVfbTRkbjM1NV82NDBiNmFkZH0= después la decodifiqué y el resultado mostró la bandera correcta: picoCTF{7h15_mu171v3r53_15_m4dn355_640b6add}
Notas adicionales
Referencias