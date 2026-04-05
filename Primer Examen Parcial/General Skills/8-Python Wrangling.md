Reto
Python Wrangling
Descripción
Python scripts are invoked kind of like programs in the Terminal...Can you run [ende.py](https://challenge-files.picoctf.net/c_wily_courier/0af80634c4b5f2dc40a20b1e0808ddef0fb3b730764a045e7cd2f94910ba0c09/ende.py) using [password.txt](https://challenge-files.picoctf.net/c_wily_courier/0af80634c4b5f2dc40a20b1e0808ddef0fb3b730764a045e7cd2f94910ba0c09/password.txt) to get [flag.txt.en](https://challenge-files.picoctf.net/c_wily_courier/0af80634c4b5f2dc40a20b1e0808ddef0fb3b730764a045e7cd2f94910ba0c09/flag.txt.en)?
Solución
Primero revisé el código de `ende.py` y entendí que la contraseña se codifica en base64 para generar la clave de desencriptación con Fernet, así que después ejecuté el script con `python3 ende.py -d flag.txt.en`, ingresé la contraseña que venía en el archivo (`pw.txt`) y el programa devolvió el contenido desencriptado, donde obtuve la bandera `picoCTF{4p0110_1n_7h3_h0us3_9c5f9bcf}`.
Notas adicionales
Referencias