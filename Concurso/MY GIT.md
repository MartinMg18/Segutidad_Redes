## Descripción

I have built my own Git server with my own rules! You can clone the challenge repo using the command below. `git clone ssh://git@foggy-cliff.picoctf.net:61300/git/challenge.git` Here's the password: `921cd55c` Check the README to get your flag!
## Solución

```
┌──(flavio㉿kali)-[~/picoCTF/concurso/mygit]
└─$ git clone ssh://git@foggy-cliff.picoctf.net:61300/git/challenge.git
Clonando en 'challenge'...
** WARNING: connection is not using a post-quantum key exchange algorithm.
** This session may be vulnerable to "store now, decrypt later" attacks.
** The server may need to be upgraded. See https://openssh.com/pq.html
git@foggy-cliff.picoctf.net's password: 
remote: Enumerating objects: 3, done.
remote: Counting objects: 100% (3/3), done.
remote: Compressing objects: 100% (2/2), done.
remote: Total 3 (delta 0), reused 0 (delta 0)
Recibiendo objetos: 100% (3/3), listo.
                                                                                                                                                                                                                                           
┌──(flavio㉿kali)-[~/picoCTF/concurso/mygit]
└─$ ls
challenge
                                                                                                                                                                                                                                           
┌──(flavio㉿kali)-[~/picoCTF/concurso/mygit]
└─$ cd challenge 
                                                                                                                                                                                                                                           
┌──(flavio㉿kali)-[~/picoCTF/concurso/mygit/challenge]
└─$ ls
README.md
                                                                                                                                                                                                                                           
┌──(flavio㉿kali)-[~/picoCTF/concurso/mygit/challenge]
└─$ cat README.md 
# MyGit

### If you want the flag, make sure to push the flag!

Only flag.txt pushed by ```root:root@picoctf``` will be updated with the flag.

GOOD LUCK!
                                                                                                                                                                                                                                           
┌──(flavio㉿kali)-[~/picoCTF/concurso/mygit/challenge]
└─$ git config user.name "root"
git config user.email "root@picoctf"
                                                                                                                                                                                                                                           
┌──(flavio㉿kali)-[~/picoCTF/concurso/mygit/challenge]
└─$ touch flag.txt
                                                                                                                                                                                                                                           
┌──(flavio㉿kali)-[~/picoCTF/concurso/mygit/challenge]
└─$ git add flag.txt
git commit -m "Subiendo flag.txt"
[master fce4e1a] Subiendo flag.txt
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 flag.txt
                                                                                                                                                                                                                                           
┌──(flavio㉿kali)-[~/picoCTF/concurso/mygit/challenge]
└─$ git push
** WARNING: connection is not using a post-quantum key exchange algorithm.
** This session may be vulnerable to "store now, decrypt later" attacks.
** The server may need to be upgraded. See https://openssh.com/pq.html
git@foggy-cliff.picoctf.net's password: 
Enumerando objetos: 4, listo.
Contando objetos: 100% (4/4), listo.
Compresión delta usando hasta 5 hilos
Comprimiendo objetos: 100% (2/2), listo.
Escribiendo objetos: 100% (3/3), 269 bytes | 269.00 KiB/s, listo.
Total 3 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Author matched and flag.txt found in commit...
remote: Congratulations! You have successfully impersonated the root user
remote: Here's your flag: picoCTF{1mp3rs0n4t4_g17_345y_cd8540cd}
To ssh://foggy-cliff.picoctf.net:61300/git/challenge.git
   aa44ed9..fce4e1a  master -> master
```

picoCTF{1mp3rs0n4t4_g17_345y_cd8540cd}
## Notas adicionales

Hacemos uso de git y con las instrucciones que nos dan creamos un usuario temporal y obtenemos la flag por medio de un mensaje de push de confirmación