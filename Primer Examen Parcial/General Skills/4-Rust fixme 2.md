Reto
Rust fixme 2
Descripción
The Rust saga continues? I ask you, can I borrow that, pleeeeeaaaasseeeee?Download the Rust code [here](https://challenge-files.picoctf.net/c_verbal_sleep/babfbee79718a6363826ba86300173ffde6d81577e9dd07d4130c53a7eecf6c3/fixme2.tar.gz).
Solución
Se descargó el archivo del reto, se descomprimió el proyecto y se abrió `src/main.rs`, donde se corrigieron errores de ownership cambiando el paso de variables por valor a referencias, es decir, se modificaron las llamadas de funciones para usar `&` (por ejemplo `decrypt(&encrypted, &key)`) y también la firma de la función para recibir referencias (`fn decrypt(encrypted: &String, key: &String)`), evitando así mover los valores y permitiendo reutilizarlos sin error; después de estos cambios se compiló y ejecutó el programa con `cargo run`, lo que permitió que corriera correctamente y mostrara la bandera picoCTF{4r3_y0u_h4v1n5_fun_y31?}.
Notas adicionales
Referencias