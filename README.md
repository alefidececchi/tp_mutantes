# Trabajo práctico 

__Desarrollado para Laboratorio de Computación I de la Universidad Tecnológica Nacional - frm.__

<p>Consigna:</p> 
Magneto quiere reclutar la mayor cantidad de mutantes para poder lucharcontra los XMens.
Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es
mutante basándose en su secuencia de ADN.
Para eso te ha pedido crear un programa JAVA con un método o función con la siguiente
firma:

boolean isMutant(String[] dna);

En donde recibirás como parámetro un array de Strings que representan cada fila de
una tabla de (6x6) con la secuencia del ADN. Las letras de los Strings solo pueden ser:
(A,T,C,G), las cuales representa cada base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras MAS DE UNA SECUNCIA de cuatro
letras iguales, de forma oblicua, horizontal o vertical.

Ejemplo (Caso mutante):
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}. 
En este caso el llamado a la función isMutant(dna) devuelve “true”.
