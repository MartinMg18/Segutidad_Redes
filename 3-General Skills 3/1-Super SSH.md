Reto
Super SSH
Descripción
Using a Secure Shell (SSH) is going to be pretty important.
Additional details will be available after launching your challenge instance.
Solución
```
MartinMg-picoctf@webshell:~$ ssh ctf-player@titan.picoctf.net -p 55349 
The authenticity of host '[titan.picoctf.net]:55349 ([3.139.174.234]:55349)' can't be established.
ED25519 key fingerprint is SHA256:4S9EbTSSRZm32I+cdM5TyzthpQryv5kudRP9PIKT7XQ.
This key is not known by any other names
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[titan.picoctf.net]:55349' (ED25519) to the list of known hosts.
ctf-player@titan.picoctf.net's password: 
Welcome ctf-player, here's your flag: picoCTF{s3cur3_c0nn3ct10n_45a48857}
Connection to titan.picoctf.net closed.
```
Notas adicionales
En este reto solo debiamos conectarnos a ssh para darnos la bandera.
Referencias