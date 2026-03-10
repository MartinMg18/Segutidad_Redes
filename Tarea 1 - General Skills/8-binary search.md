Reto
binary search
Descripción
Want to play a game? As you use more of the shell, you might be interested in how they work! Binary search is a classic algorithm used to quickly find an item in a sorted list. Can you find the flag? You'll have 1000 possibilities and only 10 guesses.Cyber security often has a huge amount of data to look through - from logs, vulnerability reports, and forensics. Practicing the fundamentals manually might help you in the future when you have to write your own tools!You can download the challenge files here:

- [challenge.zip](https://artifacts.picoctf.net/c_atlas/19/challenge.zip)

Additional details will be available after launching your challenge instance.
Solución
```
 ssh -p 61649 ctf-player@atlas.picoctf.net
The authenticity of host '[atlas.picoctf.net]:61649 ([18.217.83.136]:61649)' can't be established.
ED25519 key fingerprint is: SHA256:M8hXanE8l/Yzfs8iuxNsuFL4vCzCKEIlM/3hpO13tfQ
This host key is known by the following other names/addresses:
    ~/.ssh/known_hosts:8: [hashed name]
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[atlas.picoctf.net]:61649' (ED25519) to the list of known hosts.
** WARNING: connection is not using a post-quantum key exchange algorithm.
** This session may be vulnerable to "store now, decrypt later" attacks.
** The server may need to be upgraded. See https://openssh.com/pq.html
ctf-player@atlas.picoctf.net's password: 
Welcome to the Binary Search Game!
I'm thinking of a number between 1 and 1000.
Enter your guess: 500
Higher! Try again.
Enter your guess: 750
Lower! Try again.
Enter your guess: 600
Lower! Try again.
Enter your guess: 550
Higher! Try again.
Enter your guess: 575
Lower! Try again.
Enter your guess: 560
Higher! Try again.
Enter your guess: 570
Lower! Try again.
Enter your guess: 565
Lower! Try again.
Enter your guess: 563
Congratulations! You guessed the correct number: 563
Here's your flag: picoCTF{g00d_gu355_1597707f}
Connection to atlas.picoctf.net closed.
```
Notas adicionales
Prácticamente el juego se trata de reducir la cantidad de opciones a la mitad para que con los 10 intentos adivinar la flag
Referencias