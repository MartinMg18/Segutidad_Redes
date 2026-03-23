Reto
JaWT Scratchpad
Descripción
Check the admin scratchpad!http://fickle-tempest.picoctf.net:51905
Solución
```
┌──(kali㉿kali)-[~/Escritorio]
└─$ nano hash                 
                                                                                                                                                                                                                                           
┌──(kali㉿kali)-[~/Escritorio]
└─$ cat hash       
eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoiZmxhdmlvIn0.V4RPEuXpyFU-lM1ZegQWmSfdO7j_X0UnTkLp6pbxOH0

┌──(kali㉿kali)-[~/Escritorio]
└─$ sudo gzip -d /usr/share/wordlists/rockyou.txt.gz

┌──(kali㉿kali)-[~/Escritorio]
└─$ john hash -w=/usr/share/wordlists/rockyou.txt
Using default input encoding: UTF-8
Loaded 1 password hash (HMAC-SHA256 [password is key, SHA256 256/256 AVX2 8x])
Will run 5 OpenMP threads
Press 'q' or Ctrl-C to abort, almost any other key for status

ilovepico        (?)     

1g 0:00:00:00 DONE (2026-03-01 19:54) 1.204g/s 8919Kp/s 8919Kc/s 8919KC/s iloverob4live345..ilovekelsy1
Use the "--show" option to display all of the cracked passwords reliably
Session completed.


```
Notas adicionales
Referencias