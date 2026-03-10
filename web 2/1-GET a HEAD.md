Reto
GET aHEAD
Descripción
Find the flag being held on this server to get ahead of the competitionhttp://wily-courier.picoctf.net:63871/
Solución
```
Usando el inspector de la página podemos hacer una solicitud en la pestaña de network a blue o red y ya desde ahí en el apartado de resend cambiar a una petición de HEAD dandonos la flag 

Connection
	Keep-Alive
Content-Type
	text/html; charset=UTF-8
Date
	Mon, 23 Feb 2026 21:55:46 GMT
flag
	picoCTF{r3j3ct_th3_du4l1ty_8b13f07}
Keep-Alive
	timeout=5, max=100
Server
	Apache/2.4.38 (Debian)
X-Powered-By
	PHP/7.2.34

```
Notas adicionales
Referencias