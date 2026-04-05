Reto
Java Code Analysis!?
Descripción
BookShelf Pico, my premium online book-reading service.I believe that my website is super secure. I challenge you to prove me wrong by reading the 'Flag' book!Here are the credentials to get you started:

- Username: "user"
- Password: "user"

Source code can be downloaded [here](https://artifacts.picoctf.net/c/479/bookshelf-pico.zip).Website can be accessed [here!](http://saturn.picoctf.net:52292/).
Solución
Descargué el código fuente y al revisarlo encontré la clave secreta del JWT. Inicié sesión con `user` y `user`, copié mi token de sesión, lo modifiqué en jwt.io para darme permisos de administrador (cambiando mi rol o ID), lo volví a firmar con la clave que descubrí y reemplacé el token en el navegador. Con eso ya me dejó abrir el libro "Flag" para que me diera la bandera.
picoCTF{w34k_jwt_n0t_g00d_ca4d9701}
Notas adicionales
Referencias