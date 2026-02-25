Reto
picobrowser
Descripción
This website can be rendered only by picobrowser, go and catch the flag!
Additional details will be available after launching your challenge instance.
Solución
```
└─$ curl -s http://fickle-tempest.picoctf.net:65133/flag -H "User-Agent: picobrowser" | grep picoCTF
            <p style="text-align:center; font-size:30px;"><b>Flag</b>: <code>picoCTF{p1c0_s3cr3t_ag3nt_fba5c48f}</code></p>

```
Notas adicionales
Utilice la terminal para lograr este reto porque la otra forma no pude
Referencias