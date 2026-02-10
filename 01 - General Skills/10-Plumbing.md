Reto
Plumbing
Descripción
Sometimes you need to handle process data outside of a file. Can you find a way to keep the output from this program and search for the flag?
Additional details will be available after launching your challenge instance.
Solución
```
MartinMg-picoctf@webshell:~$ nc fickle-tempest.picoctf.net 64135 | grep picoCTF
picoCTF{digital_plumb3r_A01Bc3eC}
```
Notas adicionales
Este reto pone a prueba lo aprendido anteriormente, nos da un host y puerto para conectarnos pero tiene muchas salidas así que use al grep aprendido anteriormente para filtrar las salidas a una que tenga como coincidencia el inicio de la flag "picoCTF"
Referencias