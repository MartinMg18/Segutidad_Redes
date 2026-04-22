Reto
Mind your Ps and Qs
Descripción
In RSA, a small e value can be problematic, but what about N? Can you decrypt this?[values](https://challenge-files.picoctf.net/c_wily_courier/278a798f2fc4d2f3945588f28acb6f9a629b3eb05179b526e1de1bd3125b3c1b/values)
Solución
```
#Usamos el siguiente código en python

import urllib.request

import json

  

# Valores de tu reto "Mind your Ps and Qs"

c = 15341890103764929939105506004034128738090325640037083301857608662849501626260517

n = 948406957756830799684818171639547165784816468744946013083947881743680617123566349

e = 65537

  

def long_to_bytes(val):

"""Convierte un número gigante a texto legible (ASCII)"""

if val <= 0:

return b""

return val.to_bytes((val.bit_length() + 7) // 8, byteorder='big')

  

print("[*] Iniciando el ataque a RSA (Mind your Ps and Qs)...")

print("[*] Conectando a la API de FactorDB para factorizar 'n'...")

  

try:

# Consulta a FactorDB

url = f"http://factordb.com/api?query={n}"

req = urllib.request.urlopen(url)

data = json.loads(req.read().decode('utf-8'))

# Verificamos si factorizó con éxito

if data.get('status') in ['FF', 'CF']:

factors = data.get('factors')

p = int(factors[0][0])

q = int(factors[1][0])

print(f"\n[+] ¡Factores obtenidos mágicamente de internet!")

print(f" p = {p}")

print(f" q = {q}")

print("\n[*] Calculando la función totient de Euler (phi)...")

phi = (p - 1) * (q - 1)

print("[*] Calculando la llave privada (d)...")

d = pow(e, -1, phi)

print("[*] Descifrando el mensaje (m = c^d mod n)...")

m = pow(c, d, n)

print("\n[+] ¡Éxito total! Aquí tienes tu flag:")

flag_bytes = long_to_bytes(m)

flag_texto = flag_bytes.decode('utf-8', errors='ignore')

# --- LA CORRECCIÓN ESTÁ AQUÍ ---

# Leemos el texto de atrás hacia adelante para arreglar el Little Endian

flag_correcta = flag_texto[::-1]

print(flag_correcta)

else:

print("\n[-] FactorDB no tiene este número en su base de datos. ¡Habrá que buscar otra forma!")

  

except Exception as ex:

print(f"\n[-] Ocurrió un error de red o de ejecución: {ex}")

[+] ¡Éxito total! Aquí tienes tu flag:
picoCTF{sma11_N_n0_g0od_1dc7ae91}
```
Notas adicionales
Referencias