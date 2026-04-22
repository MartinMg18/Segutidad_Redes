Reto
Pixelated
Descripción
I have these 2 images, can you make a flag out of them?[scrambled1.png](https://challenge-files.picoctf.net/c_wily_courier/3dced65f7a857f7a28f538da0f98fdceca989646f69d4651133b5c04590b0b0d/scrambled1.png) [scrambled2.png](https://challenge-files.picoctf.net/c_wily_courier/3dced65f7a857f7a28f538da0f98fdceca989646f69d4651133b5c04590b0b0d/scrambled2.png)
Solución
```
#Usamos el siguiente código para unir las 2 imagenes

from PIL import Image # pip install Pillow

img1 = Image.open("scrambled1.png")

pixels1 = img1.load()

img2 = Image.open("scrambled2.png")

  

pixels2 = img2.load()

  

flag = Image.new("RGB" ,img1.size)

flagpix = flag.load()

for row in range(img1.size[1]):

for col in range(img1.size[0]):

flagpix[col,row]=(

(pixels1[col,row][0]+pixels2[col,row][0])%256,

(pixels1[col,row][1]+pixels2[col,row][1])%256,

(pixels1[col,row][2]+pixels2[col,row][2])%256)

flag.save("flag.png")

#Nos regresa una imagen con la flag

picoCTF{8cdf93c3}
```
Notas adicionales
Referencias