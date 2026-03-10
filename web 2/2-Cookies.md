Reto
Cookies
Descripción
Who doesn't love cookies? Try to figure out the best one.
Additional details will be available after launching your challenge instance.
Solución
```
┌──(Kali㉿kali)-[~/Escritorio]
└─$ for i in {0..20}; do curl -s http://wily-courier.picoctf.net:52810/check -H "Cookie: name=$i"; done | grep picoCTF
            <p style="text-align:center; font-size:30px;"><b>Flag</b>: <code>picoCTF{3v3ry1_l0v3s_c00k135_a4dadb49}
```
Notas adicionales
Usando la terminal, filtrando las diferentes cookies hasta que la cookie correcta nos da la flag
Referencias