Reto
First grep
Descripción
Can you find the flag in the file? This would be really tedious to look through manually, something tells me there is a better way.
Solución
```
MartinMg-picoctf@webshell:~$ wget https://challenge-files.picoctf.net/c_fickle_tempest/b4b27010334d190b82728db534d40ba520fbcc0b90469bf7db1456c768476c17/file
MartinMg-picoctf@webshell:~$ grep "picoCTF" file
MartinMg-picoctf@webshell:~$ picoCTF{grep_is_good_to_find_things_cEDf1591}

```
picoCTF{grep_is_good_to_find_things_cEDf1591}
Notas adicionales
Para resolver este reto utilice la terminal de picoCTF donde descargo el archivo usando el comando wget y con el comando grep lo busque y muestra la bandera en rojo
Referencias