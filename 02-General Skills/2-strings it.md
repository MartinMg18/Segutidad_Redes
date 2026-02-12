Reto
strings it
Descripción
Can you find the flag in [file](https://challenge-files.picoctf.net/c_fickle_tempest/563d66bbed3925c75ed71efa974bfafab26460ae99938d699a8881cd173fca60/strings) without running it?
Solución
```
MartinMg-picoctf@webshell:~$ wget https://challenge-files.picoctf.net/c_fickle_tempest/563d66bbed3925c75ed71efa974bfafab26460ae99938d699a8881cd173fca60/strings
MartinMg-picoctf@webshell:~$ strings strings | grep pico
picoCTF{5tRIng5_1T_dB2CEA76}
```
Notas adicionales
Utilice la terminal de pico para resolver esto, primero descargue el archivo utilizando wget y con string strings | grep pico me mostro la bandera
Referencias