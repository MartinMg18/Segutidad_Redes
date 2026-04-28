Reto
morse-code
Descripción
Morse code is well known. Can you decrypt this?Download the file [here](https://artifacts.picoctf.net/c/79/morse_chal.wav).Wrap your answer with picoCTF{}, put underscores in place of pauses, and use all lowercase.
Solución
```
1.-Descargamos el mensaje e instalamos la aplicacion recomendada
┌──(kali㉿kali)-[~/picoCTF/Crypto/Tarea-4/morsecode]
└─$ sudo apt update
sudo apt install audacity -y

2.-Observamos el espectograma (ctrl+1 para hacer los bloques mas grandes) y sacamos el codigo morse

.-- .... ....- --... / .... ....- --... .... / ----. ----- -.. / .-- ..--- ----- ..- ----. .... --...

3.-Pasamos el código a texto
WH47 H47H 90D W20U9H7

4.-Pasamos a formato de picoCTF
picoCTF{wh47_h47h_90d_w20u9h7}
```
Notas adicionales
Referencias