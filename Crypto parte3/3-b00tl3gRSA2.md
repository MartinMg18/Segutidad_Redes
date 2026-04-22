Reto
b00tl3gRSA2
Descripción
In RSA d is a lot bigger than e, why don't we use d to encrypt instead of e?

Additional details will be available after launching your challenge instance.
Solución
```
#Código de python usado 

# Valores de b00tl3gRSA2

c = 45760215259008598381767594514179598387310236924529418872494077183195727319866676382458020333338604562582090888289155158215924923462009845827563361813755089319103679508114424040885641557797694312403195919054701495663299349642178018951375439447908534072761649375921857181260537934782293410198875315136142453719

n = 51401592203966620263236739588647608662924416126214167615224947842902115180176719377089917666603013495032036403468023031561664749095912516512451955089017668248950343685779056674314292705932785511037208703270312643690486119747132368322173011814309736157889705239462120844030996892338253895988100239254924889149

  

# En lugar del exponente gigante, usamos el valor por defecto estándar de RSA

e_real = 65537

  

def long_to_bytes(val):

if val <= 0:

return b""

return val.to_bytes((val.bit_length() + 7) // 8, byteorder='big')

  

print("[*] Descifrando b00tl3gRSA2...")

print("[*] Usando el exponente estándar (65537) para revertir el error de encriptación...")

  

# Matemáticas corregidas: m = c^65537 mod n

m = pow(c, e_real, n)

  

flag = long_to_bytes(m)

print("\n[+] Flag encontrada:")

print(flag.decode('utf-8', errors='ignore'))

[+] Flag encontrada:
picoCTF{bad_1d3a5_3801255}
```
Notas adicionales
Referencias