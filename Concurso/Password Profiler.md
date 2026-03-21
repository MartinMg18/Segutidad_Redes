# Descricpcion

We intercepted a suspicious file from a system, but instead of the password itself, it only contains its SHA-1 hash. Using OSINT techniques, you are provided with personal details about the target. Your task is to leverage this information to generate a custom password list and recover the original password by matching its hash. Download the following files: [userinfo](https://challenge-files.picoctf.net/c_plain_mesa/3c16fb8e48ddae444f6840e81660a5a8cb2d30b69092b04f619d6ac34676a919/userinfo.txt): Contains the personal details. [hash](https://challenge-files.picoctf.net/c_plain_mesa/3c16fb8e48ddae444f6840e81660a5a8cb2d30b69092b04f619d6ac34676a919/hash.txt): Contains the SHA-1 hash of the password. [check_password](https://challenge-files.picoctf.net/c_plain_mesa/3c16fb8e48ddae444f6840e81660a5a8cb2d30b69092b04f619d6ac34676a919/check_password.py): Script to test passwords against the hash.

# Hints
[CUPP](https://github.com/Mebus/cupp) is a Python tool for generating custom wordlists from personal data.

# Solucion

Primero descargo todos los archivos que se me solicitan
Veo el hash y ya decodificandolo me da una frase y la calo en el archivo de python pero no me da
Despues veo la pista y me dice que utilice cupp, por lo que busco documentacion al respecto
Luego leo que cupp es para generar una lista de contraseñas utilizando ciertos datos, por lo que utilizo el comando "--interactive"
Pongo los datos que se me dan en userinfo.txt
Luego cambio el archivo "passwords.txt" a "alice.txt"
Ejecuto el archivo check_password.py y me da la siguiente flag:


picoCTF{Aj_15901990}
