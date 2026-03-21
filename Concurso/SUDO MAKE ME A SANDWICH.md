# Sudo make me a sandwich
# Descripción
El reto presenta un servidor al que te conectas por `nc`. Al solicitar el "sandwich", el sistema responde que solo el usuario **root** (o mediante `sudo`) puede realizar esa acción. El objetivo es encontrar una forma de elevar privilegios o engañar al script para que ejecute el comando como superusuario.

# Solución
- Conectarse al servidor: `nc saturn.picoctf.net [PORT]`.
    
- Intentar el comando sugerido por el nombre del reto: `sudo make me a sandwich`.
    
- Si el sistema pide contraseña, se explotan vulnerabilidades comunes de configuración de sudoers (como el famoso CVE-2019-14287 usando el ID -1 o 4294967295) o simplemente se aprovecha que el usuario actual tiene permisos de sudo sin password para ese binario específico.

# Notas Adicionales 
- Sin notas adicionales 

# Referencias 
- Sin referencias 