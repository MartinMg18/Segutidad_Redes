Reto
PW Crack 3
Descripción
Can you crack the password to get the flag?Download the password checker [here](https://artifacts.picoctf.net/c/17/level3.py) and you'll need the encrypted [flag](https://artifacts.picoctf.net/c/17/level3.flag.txt.enc) and the [hash](https://artifacts.picoctf.net/c/17/level3.hash.bin) in the same directory too.There are 7 potential passwords with 1 being correct. You can find these by examining the password checker script.
Solución
```
MartinMg-picoctf@webshell:~$ python level3.py
Please enter correct password for flag: hola 
That password is incorrect
MartinMg-picoctf@webshell:~$ nano level3.py
MartinMg-picoctf@webshell:~$ python level3.py
Please enter correct password for flag: f09e
That password is incorrect
MartinMg-picoctf@webshell:~$ python level3.py
Please enter correct password for flag: 4dcf
That password is incorrect
MartinMg-picoctf@webshell:~$ nano level3.py
MartinMg-picoctf@webshell:~$ python level3.py
Please enter correct password for flag: 87ab
Welcome back... your flag, user:
picoCTF{m45h_fl1ng1ng_cd6ed2eb}
```
Notas adicionales
Para resolver este reto tuve que ir probando con las contraseñas que nos dio el .py hasta que me dejara entrar
Referencias