# Timeline 0
## Descripción
Can you find the flag in this disk image? Wrap what you find in the picoCTF flag format.Download the disk image [here](https://challenge-files.picoctf.net/c_plain_mesa/aa1f8ba93409887e081435732d7037c45b30a8442853bf07c9e84fe4d0e0bc19/partition4.img.gz).
## Solución
picoCTF{71m311n3_0u7113r_h3r_43a2e7af}
## Notas
Se instaló la herramienta sleuthkit, para manipular la imagen de disco proporcionada, luego se generó el MAC time

fls -r -m / partition4.img > bodyfile.txt
mactime -b bodyfile.txt > timeline.txt

Se estuvo explorando entre los archivo contenidos, nos dieron una pista en la cual nos decían  que había una fecha modificada, de un archivo que parecía extremadamente viejo luego se inspeccionó los archivos más viejos
a@Camilas-MacBook-Pro downloads % head -20 timeline.txt


Tue Jan 01 1985 11:00:00       41 macb r/rrw-r--r-- 0        0        4945     /bin/bcab
Mon Oct 18 2021 12:54:17      451 ma.. r/rrw-r--r-- 0        0        64994    /usr/share/apk/keys/alpine-devel@lists.alpinelinux.org-4a6a0840.rsa.pub
                              451 ma.. r/rrw-r--r-- 0        0        64995    /usr/share/apk/keys/alpine-devel@lists.alpinelinux.org-5243ef4b.rsa.pub
                              451 ma.. r/rrw-r--r-- 0        0        64996    /usr/share/apk/keys/alpine-devel@lists.alpinelinux.org-524d27bb.rsa.pub
                              451 ma.. r/rrw-r--r-- 0        0        64997    /usr/share/apk/keys/alpine-devel@lists.alpinelinux.org-5261cecb.rsa.pub
                              451 ma.. r/rrw-r--r-- 0        0        64998    /usr/share/apk/keys/alpine-devel@lists.alpinelinux.org-58199dcc.rsa.pub
                              451 ma.. r/rrw-r--r-- 0        0        64999    /usr/share/apk/keys/alpine-devel@lists.alpinelinux.org-58cbb476.rsa.pub
                              451 ma.. r/rrw-r--r-- 0        0        65000    /usr/share/apk/keys/alpine-devel@lists.alpinelinux.org-58e4f17d.rsa.pub

Hay uno extrañamente antiguo el cual abriremos y el resultado se decodificará pues está en base 64

a@Camilas-MacBook-Pro downloads % icat partition4.img 4945
NzFtMzExbjNfMHU3MTEzcl9oM3JfNDNhMmU3YWYK
a@Camilas-MacBook-Pro downloads % echo NzFtMzExbjNfMHU3MTEzcl9oM3JfNDNhMmU3YWYK | base64 -d
71m311n3_0u7113r_h3r_43a2e7af

## Referencias