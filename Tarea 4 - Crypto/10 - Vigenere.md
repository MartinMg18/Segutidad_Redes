Reto
Vigenere
Descripción
Can you decrypt this message? Decrypt this [message](https://artifacts.picoctf.net/c/160/cipher.txt) using this key "CYLAB".
Solución
Primero descargué el archivo del reto y abrí el contenido para ver el texto cifrado. Después identifiqué que era un cifrado Vigenere porque el reto lo indicaba y usé la llave `CYLAB`. Con esa llave fui restando cada letra de la clave a cada letra del mensaje cifrado, repitiendo la clave hasta cubrir todo el texto. Al aplicar el descifrado, el texto cambió de `rgnoDVD{O0NU_WQ3_G1G3O3T3_A1AH3S_f85729e7}` a `picoCTF{D0NT_US3_V1G3N3R3_C1PH3R_d85729g7}`, que es la bandera final.
Notas adicionales
Referencias