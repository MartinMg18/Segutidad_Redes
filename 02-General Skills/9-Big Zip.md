Reto
Big Zip
Descripción
Unzip this archive and find the flag.
- [Download zip file](https://artifacts.picoctf.net/c/504/big-zip-files.zip)
Solución
```
MartinMg-picoctf@webshell:~$ wget https://artifacts.picoctf.net/c/504/big-zip-files.zip
MartinMg-picoctf@webshell:~$ grep -r "picoCTF{[^}]*}"
big-zip-files/folder_pmbymkjcya/folder_cawigcwvgv/folder_ltdayfmktr/folder_fnpfclfyee/whzxrpivpqld.txt:information on the record will last a billion years. Genes and brains and books encode picoCTF{gr3p_15_m4g1c_ef8790dc}
```
Notas adicionales
Use grep para buscar en carpetas con "-r".
Referencias