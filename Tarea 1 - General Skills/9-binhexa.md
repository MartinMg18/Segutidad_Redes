Reto
binhexa
Descripción
How well can you perfom basic binary operations?
Additional details will be available after launching your challenge instance.
Solución
```
┌──(kali㉿kali)-[~]
└─$ nc titan.picoctf.net 55987

Welcome to the Binary Challenge!"
Your task is to perform the unique operations in the given order and find the final result in hexadecimal that yields the flag.

Binary Number 1: 10101011
Binary Number 2: 10011010


Question 1/6:
Operation 1: '>>'
Perform a right shift of Binary Number 2 by 1 bits .
Enter the binary result: 01001101
Correct!

Question 2/6:
Operation 2: '<<'
Perform a left shift of Binary Number 1 by 1 bits.
Enter the binary result: 101010110
Correct!

Question 3/6:
Operation 3: '&'
Perform the operation on Binary Number 1&2.
Enter the binary result: 10001010
Correct!

Question 4/6:
Operation 4: '*'
Perform the operation on Binary Number 1&2.
Enter the binary result: 110011011011110
Correct!

Question 5/6:
Operation 5: '|'
Perform the operation on Binary Number 1&2.
Enter the binary result: 10111011
Correct!

Question 6/6:
Operation 6: '+'
Perform the operation on Binary Number 1&2.
Enter the binary result: 101000101
Correct!
Enter the results of the last operation in hexadecimal: 145

Correct answer!
The flag is: picoCTF{b1tw^3se_0p3eR@tI0n_su33essFuL_6862762d}

```
Notas adicionales
Hacemos uso de una pagina convertidora de binarios para las operaciones que nos pide el programa.
Referencias