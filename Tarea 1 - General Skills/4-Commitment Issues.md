Reto
Commitment Issues
Descripción
I accidentally wrote the flag down. Good thing I deleted it!You download the challenge files here:
- [challenge.zip](https://artifacts.picoctf.net/c_titan/75/challenge.zip)
Solución
```
 wget https://artifacts.picoctf.net/c_titan/75/challenge.zip
 unzip challenge.zip
 cd drop-in
 ls message.txt  
message.txt
cat message.txt 
TOP SECRET
└─$ git show
commit 3899edb7f3110d613c72ad40083fd8feeef703d0 (HEAD -> master)
Author: picoCTF <ops@picoctf.com>
Date:   Sat Mar 9 21:09:58 2024 +0000

    remove sensitive info

diff --git a/message.txt b/message.txt
index ed59373..d552d1e 100644
--- a/message.txt
+++ b/message.txt
@@ -1 +1 @@
```
Notas adicionales
Utilice el git show para mostrar el ultimo commit que es donde aparece la flag
Referencias