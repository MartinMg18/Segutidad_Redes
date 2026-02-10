Reto
Descripción
Our flag printing service has started glitching!
Additional details will be available after launching your challenge instance.
Solución
```
MartinMg-picoctf@webshell:~$ nc saturn.picoctf.net 58656
'picoCTF{gl17ch_m3_n07_' + chr(0x61) + chr(0x34) + chr(0x33) + chr(0x39) + chr(0x32) + chr(0x64) + chr(0x32) + chr(0x65) + '}'
```
Usando python:
```
>>> 'picoCTF{gl17ch_m3_n07_' + chr(0x61) + chr(0x34) + chr(0x33) + chr(0x39) + chr(0x32) + chr(0x64) + chr(0x32) + chr(0x65) + '}'
'picoCTF{gl17ch_m3_n07_a4392d2e}'
```
picoCTF{gl17ch_m3_n07_a4392d2e}
Notas adicionales
Usando el nc con un host y un puerto con la flag incompleta ue muestra algunas letras en hexadecimal pero con el comando de python las convierte a letra chr y solo copiamos la flag y la pegue en python para que automaticamente la convierta a caracter
Referencias