Reto
Nice netcat
Descripción
There is a nice program that you can talk to by using this command in a shell:
$ nc wily-courier.picoctf.net 61581, but it doesn't speak English...
Solución
```
MartinMg-picoctf@webshell:~$ nc wily-courier.picoctf.net 61581
112 
105 
99 
111 
67 
84 
70 
123 
103 
48 
48 
100 
95 
107 
49 
116 
116 
121 
33 
95 
110 
49 
99 
51 
95 
107 
49 
116 
116 
121 
33 
95 
97 
57 
52 
101 
55 
125 
10 

```
Con python
```
>>> numeros = [112, 105, 99, 111, 67, 84, 70, 123, 103, 48, 48, 100, 95, 107, 49, 116, 116, 121, 33, 95, 110, 
49, 99, 51, 95, 107, 49, 116, 116, 121, 33, 95, 97, 57, 52, 101, 55, 125, 10]
>>> mensaje = "".join(chr(n) for n in numeros)
>>> print(mensaje)
```
picoCTF{g00d_k1tty!_n1c3_k1tty!_a94e7}
Notas adicionales
En este reto use lo aprendido de "nc- Netcat" y lo aprendido de ASCII en Python hice uso de netcat use el host y puerto que nos da, en las pistas dicen casi directamente que tengo que convertir ASCII por lo que tengo intuir que nos dan números en base10 y que solo tengo que pasar a ASCII, por lo que python por defecto tiene el comando "chr()" para transformar en ASCII así que solo hacemos un ciclo rápido para convertir y sacar la flag
Referencias