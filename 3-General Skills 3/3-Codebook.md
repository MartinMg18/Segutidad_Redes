Reto
Codebook
Descripción
Run the Python script `code.py` in the same directory as `codebook.txt`.
- [Download code.py](https://artifacts.picoctf.net/c/3/code.py)
- [Download codebook.txt](https://artifacts.picoctf.net/c/3/codebook.txt)
Solución
```
MartinMg-picoctf@webshell:~$ wget -q https://artifacts.picoctf.net/c/3/code.py
MartinMg-picoctf@webshell:~$ wget -q https://artifacts.picoctf.net/c/3/codebook.txt
MartinMg-picoctf@webshell:~$ cat codebook.txt
azbycxdwevfugthsirjqkplomn
MartinMg-picoctf@webshell:~$ python code.py
picoCTF{c0d3b00k_455157_197a982c}
```
Notas adicionales
Agregando el -q despues de wget ya no aparece el avance de la descarga.
Referencias