Reto
b00tl3gRSA3
Descripción
Why use p and q when I can use more?

Additional details will be available after launching your challenge instance.
Solución
```
#Código de python utilizado 

# Valores del reto

c = 65421964103318450065422855393288261428930238809267563336376896205926312000246243941127920016339541876420882629294048344606865153843552294721375727994459684712197243947434583256053473547175635838453980328868512630117540957988448966675700135603573087965086032171514837037381713256266854074719639071702981154473647995244682672243544338420080204356

n = 68748162528851301261078470992563399597778489973146030052026453598943634689230260386069360049343434374474297697761226598078366635679287689139345996340855266694391162276688167711676292309891160710781946126988408757903058676698612843772205901244826692663489708758816925930669318517648627111661617319167811864963032944741884515576999533004173590997

e = 65537

  

# Los 34 factores primos extraídos de Alpertron (sin espacios)

factores = [

8674424191, 8697493537, 8742161453, 9036669673, 9446140867,

9449980627, 10386595819, 10490594333, 10516801829, 10902145253,

11212887083, 11581312019, 11733994561, 12042806317, 12511016303,

13180910417, 14253709397, 14301044687, 14358338653, 14467077733,

14674770511, 14931599957, 15124592437, 15751126177, 15817683461,

16098886039, 16261534973, 16326015287, 16529482831, 16711092023,

16847065019, 16905151007, 16973223299, 17129795873

]

  

def long_to_bytes(val):

if val <= 0:

return b""

return val.to_bytes((val.bit_length() + 7) // 8, byteorder='big')

  

print("[*] Iniciando descifrado Multi-Prime RSA...")

  

# 1. Calcular la función Totient (phi) multiplicando (p-1) de todos los factores

phi = 1

for p in factores:

phi *= (p - 1)

print("[+] Función Totient (phi) calculada con éxito.")

  

# 2. Calcular la llave privada (d)

d = pow(e, -1, phi)

print("[+] Llave privada (d) calculada.")

  

# 3. Descifrar el mensaje

m = pow(c, d, n)

print("[+] Mensaje original descifrado matemáticamente.")

  

# 4. Convertir a texto legible

flag = long_to_bytes(m).decode('utf-8', errors='ignore')

  

print("\n[+] ¡Éxito! Tu flag es:")

print(flag)

  

# Comprobación de Little Endian por si acaso

if "picoCTF" not in flag and "FTCocip" in flag[::-1]:

print("\n[!] El texto está al revés. Aquí está corregido:")

print(flag[::-1])

¡Éxito! Tu flag es:
picoCTF{too_many_fact0rs_3023548}
```
Notas adicionales
Referencias