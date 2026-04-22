Reto
flags
Descripción
What do the [flags](https://challenge-files.picoctf.net/c_fickle_tempest/214c9d918be75903d4183c35fa4b94ef60dba05fc4df37c97cf0868087067372/flag.png) mean?
Solución
```
#Usamos una IA para decifrar el mensaje

Para resolverlo, necesitas usar el **Código Internacional de Señales Marítimas** (las banderas que usan los barcos para comunicarse). Sin embargo, este reto tiene un pequeño "truco" que suele confundir a muchos: utiliza las letras del alfabeto internacional estándar, pero para los números utiliza las **banderas numéricas de la OTAN** en lugar de los gallardetes civiles tradicionales.

Como bien mencionas, la primera parte antes de las llaves deletrea `picoCTF`. Vamos a descifrar exactamente lo que está adentro de las llaves `{ }`, bandera por bandera de izquierda a derecha:

- **F**: Fondo blanco con un rombo rojo.
    
- **1**: Franjas horizontales (rojo, amarillo, rojo). _Esta es la bandera numérica "1" de la OTAN._
    
- **A**: Mitad blanca y mitad azul (vertical).
    
- **G**: Franjas verticales amarillas y azules.
    
- **5**: Fondo amarillo con una cruz o aspa azul. _Esta es la bandera numérica "5" de la OTAN._
    
- **A**: Mitad blanca y mitad azul.
    
- **N**: Cuadrícula o tablero de ajedrez azul y blanco.
    
- **D**: Franjas horizontales (amarillo, azul, amarillo).
    
- **5**: Fondo amarillo con una cruz azul. _(Se repite el "5" de la OTAN)._
    
- **T**: Franjas verticales (rojo, blanco, azul).
    
- **U**: Cuatro cuadrantes alternados rojos y blancos.
    
- **F**: Fondo blanco con un rombo rojo.
    
- **F**: Fondo blanco con un rombo rojo.
    

Si juntas todas las letras y números descifrados, el texto forma **`F1AG5AND5TUFF`** (que en jerga _leet_ se lee como _"Flags and stuff"_).

Por lo tanto, la bandera (flag) final y completa que debes ingresar para resolver el reto es:

**`picoCTF{F1AG5AND5TUFF}`**
```
Notas adicionales
Referencias