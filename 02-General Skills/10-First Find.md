Reto
First Find
Descripción
Unzip this archive and find the file named 'uber-secret.txt'
- [Download zip file](https://artifacts.picoctf.net/c/502/files.zip)
Solución
```
MartinMg-picoctf@webshell:~$ wget https://artifacts.picoctf.net/c/502/files.zip
MartinMg-picoctf@webshell:~$ grep -r "picoCTF{[^}]*}"
grep: files.zip: binary file matches
files/adequate_books/more_books/.secret/deeper_secrets/deepest_secrets/uber-secret.txt:picoCTF{f1nd_15_f457_ab443fd1}
```
Notas adicionales
Referencias