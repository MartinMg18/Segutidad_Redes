Reto
Magikarp Ground Mission
Descripción
Do you know how to move between directories and read files in the shell? Start the container, `ssh` to it, and then `ls` once connected to begin.Login via `ssh` as `ctf-player` with the password, `8c606eb1` on the host `wily-courier.picoctf.net` and port `58668`.
Solución
```
MartinMg-picoctf@webshell:~$ ssh -p 58668 ctf-player@wily-courier.picoctf.net 
ctf-player@pico-chall$ cat 1of3.flag.txt
picoCTF{xxsh_
ctf-player@pico-chall$ cd /
ctf-player@pico-chall$ cat 2of3.flag.txt
0ut_0f_//4t3r_
ctf-player@pico-chall$ cd ~
ctf-player@pico-chall$ cat 3of3.flag.txt
0b24fc4f}
```
Notas adicionales
Referencias