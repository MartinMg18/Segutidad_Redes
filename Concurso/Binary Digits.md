# Descripcion

This file doesn't look like much... just a bunch of 1s and 0s. But maybe it's not just random noise. Can you recover anything meaningful from this? Download the file [here](https://challenge-files.picoctf.net/c_plain_mesa/c443005e8024af39085323276b34da0e92f968746547f8e7f8b650ab37e668d1/digits.bin).

# Hint

Ninguna
# Solución

Se me da un archivo en binario, y para poderlo examinar utilizo el siguiente comando:


hexyl digits.bin


Se ve que solo es binario y no tiene estructura de un codigo, por lo que solo convierto todo el archivo a string para poder ver que significan en cyber chef y me da como resultado la siguiente flag:


picoCTF{h1dd3n_1n_th3_b1n4ry_cc2099d3}

# Referencias
https://gchq.github.io/CyberChef/#recipe=From_Binary('Space',8)