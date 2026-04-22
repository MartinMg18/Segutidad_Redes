Reto
basic-mod1
Descripción
We found this weird message being passed around on the servers, we think we have a working decryption scheme.Download the message [here](https://artifacts.picoctf.net/c/128/message.txt).Take each number mod 37 and map it to the following character set: 0-25 is the alphabet (uppercase), 26-35 are the decimal digits, and 36 is an underscore.Wrap your decrypted message in the picoCTF flag format (i.e. `picoCTF{decrypted_message}`)
Solución
Primero tomé los números del archivo y a cada uno le apliqué la operación módulo 37 para obtener su residuo; después usé el mapeo indicado donde los valores de 0 a 25 corresponden a letras mayúsculas (A–Z), del 26 al 35 a dígitos (0–9) y el 36 a un guion bajo, con lo cual fui convirtiendo cada número ya reducido en su carácter correspondiente; finalmente uní todos los caracteres en orden para formar el mensaje decodificado y lo envolví en el formato requerido de picoCTF, obteniendo la flag completa.
Notas adicionales
Referencias
