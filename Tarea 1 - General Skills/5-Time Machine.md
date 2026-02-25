Reto
Time Machine
Descripción
What was I last working on? I remember writing a note to help me remember...You can download the challenge files here:
- [challenge.zip](https://artifacts.picoctf.net/c_titan/162/challenge.zip)
Solución
```
wget https://artifacts.picoctf.net/c_titan/162/challenge.zip
unzip challenge.zip
MartinMg-picoctf@webshell:~/drop-in$ cat message.txt
This is what I was working on, but I'd need to look at my commit history to know why...MartinMg-picoctf@webshell:~/drop-in$ git show
git reflog
```
Notas adicionales
Use git reflog para ver los comentarios
Referencias