Reto
blame game
Descripción
Someone's commits seems to be preventing the program from working. Who is it?You can download the challenge files here:
- [challenge.zip](https://artifacts.picoctf.net/c_titan/74/challenge.zip)
Solución
```
wget https://artifacts.picoctf.net/c_titan/74/challenge.zip 
wget https://artifacts.picoctf.net/c_titan/74/challenge.zip 
git log message.py
commit 0fe87f16cbd8129ed5f7cf2f6a06af6688665728
Author: picoCTF{@sk_th3_1nt3rn_ea346835} <ops@picoctf.com>
Date:   Sat Mar 9 21:09:25 2024 +0000

    optimize file size of prod code

commit 7e8a2415b6cca7d0d0002ff0293dd384b5cc900d
Author: picoCTF <ops@picoctf.com>
Date:   Sat Mar 9 21:09:25 2024 +0000

    create top secret project
```
Notas adicionales
Aqui en este reto la flag estaba en el autor del commit del .py asi qye solo hice un log a este archivo
Referencias