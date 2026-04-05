Reto
findme
Descripción
Help us test the form by submiting the username as `test` and password as `test!`The website running [here](http://saturn.picoctf.net:63878/).
Solución
Activé "Conservar registro" en la pestaña de Red del navegador e inicié sesión con `test` y `test!`. Revisé las redirecciones ocultas en el tráfico, copié los dos parámetros "id" de las URLs, los decodifiqué de Base64 y los junté para que me diera la bandera: `picoCTF{proxies_all_the_way_df44c94c}`.
Notas adicionales
Referencias