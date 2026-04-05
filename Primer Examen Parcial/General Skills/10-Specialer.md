Reto
Specialer
Descripción
Reception of Special has been cool to say the least. That's why we made an exclusive version of Special, called Secure Comprehensive Interface for Affecting Linux Empirically Rad, or just 'Specialer'. With Specialer, we really tried to remove the distractions from using a shell. Yes, we took out spell checker because of everybody's complaining. But we think you will be excited about our new, reduced feature set for keeping you focused on what needs it the most. Please start an instance to test your very own copy of Specialer.`ssh -p 55975 ctf-player@saturn.picoctf.net`. The password is `d137d16e`
Solución
Me conecté por SSH con las credenciales del reto y noté que la shell estaba restringida y no permitía usar comandos normales como `ls` o `cat`, así que utilicé funcionalidades internas de bash para evadir la restricción; después de explorar los archivos, encontré uno llamado `kazam.txt` dentro de la carpeta `ala`, y usando sustitución de comandos con `echo "$(ala/kazam.txt)"` logré leer su contenido, donde se mostraba directamente la bandera `picoCTF{y0u_d0n7_4ppr3c1473_wh47_w3r3_d01ng_h3r3_811ae7e9}`.
Notas adicionales
Referencias