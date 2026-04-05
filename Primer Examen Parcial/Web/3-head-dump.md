Reto
head-dump
Descripción
Welcome to the challenge! In this challenge, you will explore a web application and find an endpoint that exposes a file containing a hidden flag.The application is a simple blog website where you can read articles about various topics, including an article about API Documentation. Your goal is to explore the application and find the endpoint that generates files holding the server’s memory, where a secret flag is hidden.The website is running [picoCTF News](http://verbal-sleep.picoctf.net:62335/).
Solución
Primero inspeccioné la página web y encontré un endpoint expuesto relacionado con la descarga de un volcado de memoria (`/heapdump`), el cual descargué para analizarlo localmente; posteriormente utilicé comandos en la terminal de Kali para buscar dentro del archivo, específicamente `grep`, con el fin de localizar patrones de la bandera, y así logré encontrar directamente en el contenido la flag.
Notas adicionales
Referencias