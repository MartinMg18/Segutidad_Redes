Reto
Descripción
My team has been working very hard on new features for our flag printing program! I wonder how they'll work together?You can download the challenge files here:
- [challenge.zip](https://artifacts.picoctf.net/c_titan/177/challenge.zip)
Solución
```
┌──(kali㉿kali)-[~/drop-in]
└─$ git config --global user.name "Martin"~  
                                                                             
┌──(kali㉿kali)-[~/drop-in]
└─$ git config --global user.email "martin@picoctf.com"
                                                                             
┌──(kali㉿kali)-[~/drop-in]
└─$ git merge feature/part-1                           
Already up to date.
                                                                             
┌──(kali㉿kali)-[~/drop-in]
└─$ nano flag.py
┌──(kali㉿kali)-[~/drop-in]
└─$ python3 flag.py
Printing the flag...
picoCTF{t3@mw0rk_m@k3s_th3_dr3@m_w0rk_7ae8dd33}

```
Notas adicionales
Se identificaron las ramas disponibles con `git branch -a` y se fueron fusionando en `main` usando `git merge`. Cuando aparecieron conflictos en `flag.py`, se resolvieron editando el archivo para combinar correctamente las partes de la flag y luego se confirmaron los cambios con `git add` y `git commit`.
Referencias