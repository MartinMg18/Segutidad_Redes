Reto
rsa-pop-quiz
Descripción
Class, take your seats! It's PRIME-time for a quiz...

nc fickle-tempest.picoctf.net 58408
Solución
primero fui leyendo cada caso que me daba el reto y antes de calcular cualquier cosa identifiqué qué datos me estaban dando y qué me pedían para decidir si era posible resolverlo con la información disponible, cuando me daban p y q calculé n multiplicándolos, cuando me daban p y n despejé q dividiendo n entre p, cuando me daban p y q y me pedían totient calculé φ(n) = (p - 1)(q - 1), cuando me daban plaintext, e y n obtuve el ciphertext usando c = m^e mod n, cuando me daban p, q y e calculé primero φ(n) y luego la llave privada con d como el inverso modular de e respecto a φ(n), en los casos donde solo aparecían e y n o ciphertext, e y n respondí que no era factible porque faltaban datos para recuperar los factores o la llave privada, y finalmente en el último problema como sí me dieron p, ciphertext, e y n primero saqué q dividiendo n entre p, luego calculé φ(n), después obtuve d como inverso modular y con eso descifré el mensaje usando m = c^d mod n, y al convertir ese resultado a texto obtuve la flag
Notas adicionales
Referencias