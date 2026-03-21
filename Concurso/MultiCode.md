## Descripción

We intercepted a suspiciously encoded message, but it’s clearly hiding a flag. No encryption, just multiple layers of obfuscation. Can you peel back the layers and reveal the truth? Download the [message](https://challenge-files.picoctf.net/c_plain_mesa/b3a8655f3bca197c0226d40b8482562895c5cb27913567e76f87f0c78743ede2/message.txt).
## Solución

```
┌──(flavio㉿kali)-[~/picoCTF/concurso/multicode]
└─$ cat message.txt 
NjM3NjcwNjI1MDQ3NTMyNTM3NDI2MTcyNjY2NzcyNzE1ZjcyNjE3MDMwNzE3NjYxNzQ1ZjM0MzgzMTczMzAzNjM0NzAyNTM3NDQ=
                                                                                                                                                                                                                

#Pasamos por base64 y hexadecimal
                            
┌──(flavio㉿kali)-[~/picoCTF/concurso/multicode]
└─$ echo "cvpbPGS{arfgrq_rap0qvat_481s064p}" | tr 'A-Za-z' 'N-ZA-Mn-za-m'
picoCTF{nested_enc0ding_481f064c}
```

picoCTF{nested_enc0ding_481f064c}
## Notas adicionales

Des-ofuscamos la cadena que esta cifrada en diferentes bases.