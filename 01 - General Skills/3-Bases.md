Reto
Bases
Descripción
What does this bDNhcm5fdGgzX3IwcDM1 mean? I think it has something to do with bases.
Solución
Usando python:
```
>>> import base64
>>> resultado = base64.b64decode("bDNhcm5fdGgzX3IwcDM1").decode()
>>> print(resultado)
l3arn_th3_r0p35
```
picoCTF{l3arn_th3_r0p35}
Notas adicionales
Importe base64 para poder convertir a bytes "b64decode()" y posteriormente a un string con "decode()
Referencias