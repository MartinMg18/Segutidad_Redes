Reto
Rust fixme 1
Descripción
Have you heard of Rust? Fix the syntax errors in this Rust file to print the flag!Download the Rust code [here](https://challenge-files.picoctf.net/c_verbal_sleep/3f0e13f541928f420d9c8c96b06d4dbf7b2fa18b15adbd457108e8c80a1f5883/fixme1.tar.gz).
Solución
Se descargó el archivo del reto, se descomprimió el proyecto Rust y se abrió `src/main.rs` para corregir tres errores de sintaxis: agregar el `;` al final de `let key = String::from("CSUCKS");`, cambiar `ret` por `return` dentro de la validación `if res.is_err() { return; }`, y arreglar la impresión final con `println!("{:?}", String::from_utf8_lossy(&decrypted_buffer));`; después se compiló y ejecutó el programa con `cargo run`, y al correr correctamente se mostró la bandera `picoCTF{4r3_y0u_4_ru$t4c30n_n0w?}`.
Notas adicionales
Referencias