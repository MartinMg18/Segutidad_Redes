Reto
rail-fence
Descripción
A type of transposition cipher is the rail fence cipher, which is described [here](https://en.wikipedia.org/wiki/Rail_fence_cipher). Here is one such cipher encrypted using the rail fence with 4 rails. Can you decrypt it? Download the message [here](https://artifacts.picoctf.net/c/189/message.txt). Put the decoded message in the picoCTF flag format, `picoCTF{decoded_message}`.
Solución
```
1.-Descargamos y vemos le mensaje
┌──(kali㉿kali)-[~/picoCTF/Crypto/Tarea-4/railfence]
└─$ cat message.txt  
Ta _7N6D8Dhlg:W3D_H3C31N__387ef sHR053F38N43DFD i33___N6

2.-Usamos cyberchef para decifrarlo (link en referencias)
Ta _7N6D49hlg:W3D_H3C31N__A97ef sHR053F38N43D7B i33___N6

3.-Pasamos al formato de picoCTF
picoCTF{WH3R3_D035_7H3_F3NC3_8361N_4ND_3ND_4A76B997}
```
Notas adicionales
Referencias