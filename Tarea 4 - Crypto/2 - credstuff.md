Reto
credstuff
Descripción
We found a leak of a blackmarket website's login credentials. Can you find the password of the user `cultiris` and successfully decrypt it?Download the leak [here](https://artifacts.picoctf.net/c/151/leak.tar).The first user in `usernames.txt` corresponds to the first password in `passwords.txt`. The second user corresponds to the second password, and so on.
Solución
```
1.-Descargamos el archivo y verificamos su contenido
┌──(kali㉿kali)-[~/picoCTF/Crypto/Tarea-4/credstuff]
└─$ ls
leak.tar
                                                                                                                                                                                                                                           
┌──(kali㉿kali)-[~/picoCTF/Crypto/Tarea-4/credstuff]
└─$ tar -xvf leak.tar 
leak/
leak/passwords.txt
leak/usernames.txt
                                                                                                                                                                                                                                           
┌──(kali㉿kali)-[~/picoCTF/Crypto/Tarea-4/credstuff]
└─$ ls
leak  leak.tar
                                                                                                                                                                                                                                           
┌──(kali㉿kali)-[~/picoCTF/Crypto/Tarea-4/credstuff]
└─$ cd leak     
                                                                                                                                                                                                                                           
┌──(kali㉿kali)-[~/…/Crypto/Tarea-4/credstuff/leak]
└─$ ls
passwords.txt  usernames.txt

2.-Encontrar el usuario "cultiris" con su contraseña

-Si buscamos la palabra cultiris en el archivo usernames.txt, veremos que se encuentra exactamente en la línea 378

-Vamos a la misma línea 378 en el archivo passwords.txt, encontramos este texto: cvpbPGS{P7e1S_54I35_71Z3}

3.-Desciframos la flag (Usamos cyberchef)

-Tiene un cifrado clásico ROT13

-Al aplicar ROT13 a cvpbPGS{P7e1S_54I35_71Z3}, obtenemos la flag descifrada: picoCTF{C7r1F_54V35_71M3}
```
Notas adicionales
Referencias