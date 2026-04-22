Reto
ReadMyCert
Descripción
How about we take you on an adventure on exploring certificate signing requestsTake a look at this CSR file [here](https://artifacts.picoctf.net/c/426/readmycert.csr).
Solución
Primero abrí el archivo `.csr`, que está codificado en base64, y lo inspeccioné usando una herramienta como openssl req -in readmycert.csr -text -noout para ver su contenido en texto legible; después revisé la sección del _Subject_ del certificado, específicamente el campo **Common Name (CN)**, ya que ahí suelen esconder información en este tipo de retos; finalmente identifiqué que dentro de ese campo venía incrustada la flag y simplemente la tomé y la escribí en el formato requerido de picoCTF.
Notas adicionales
Referencias