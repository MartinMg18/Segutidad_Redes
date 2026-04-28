Reto
substitution2
Descripción
It seems that another encrypted message has been intercepted. The encryptor seems to have learned their lesson though and now there isn't any punctuation! Can you still crack the cipher?Download the message [here](https://artifacts.picoctf.net/c/114/message.txt).
Solución
Primero descargué el archivo del enlace del reto y revisé su contenido con `cat`. Al ver que era un texto cifrado con una bandera también cifrada al final, identifiqué que se trataba de un cifrado por sustitución. Después copié todo el texto cifrado y lo pegué en una herramienta de análisis de sustitución como quipqiup.com para resolverlo automáticamente por frecuencia de letras y patrones de palabras. La herramienta fue reconstruyendo el mensaje en inglés y permitió identificar el mapeo correcto de letras. Finalmente revisé la parte final del texto, donde aparecía la bandera descifrada, y la convertí al formato correcto de picoCTF, obteniendo `picoCTF{N6R4M_4N41Y515_15_73D10U5_42EA1770}`.
Notas adicionales
Referencias