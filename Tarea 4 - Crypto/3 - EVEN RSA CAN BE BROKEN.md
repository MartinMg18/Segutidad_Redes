Reto
EVEN RSA CAN BE BROKEN???
Descripción
This service provides you an encrypted flag. Can you decrypt it with just N & e?

Additional details will be available after launching your challenge instance.
Solución
me conecte con nc para obtener N, e y el cyphertext, vi que N era par y tome p=2 y q=N//2, calcule phi como q-1, luego saque d con el inverso modular de e respecto a phi usando pow(e,-1,phi), despues descifre con m=pow(c,d,N) y converti el resultado a texto con long_to_bytes para obtener la bandera picoCTF{...}
Notas adicionales
Referencias