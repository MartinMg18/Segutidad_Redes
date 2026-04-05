Reto
SQL Direct
Descripción
Connect to this PostgreSQL server and find the flag!`psql -h saturn.picoctf.net -p 55106 -U postgres pico`Password is `postgres`
Solución
```
pico=# SELECT * FROM flags;
 id | firstname | lastname  |                address                 
----+-----------+-----------+----------------------------------------
  1 | Luke      | Skywalker | picoCTF{L3arN_S0m3_5qL_t0d4Y_73b0678f}
  2 | Leia      | Organa    | Alderaan
  3 | Han       | Solo      | Corellia

```
Notas adicionales
Referencias