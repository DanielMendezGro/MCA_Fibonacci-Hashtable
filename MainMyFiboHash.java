//Programa para notar el manejo básico de la clase Hashtable en Java aplicado a la sucesión de Fibonacci

import java.util.Hashtable;

class Main{

public static void main (String[] args){

    Hashtable<Integer, Integer> fiboSuc
            = new Hashtable<Integer, Integer>();
    fiboSuc.put(0, 0);
    fiboSuc.put(1, 1);
    fiboSuc.put(2, 1);

    for (int key : fiboSuc.keySet()) {
        int val = fiboSuc.get(key);
        System.out.printf("El valor de fibonacci en la posición %d es %d %n",
                           key, val);
    }

    fiboSuc.forEach((key, value) ->
            System.out.println("Key: " + key + ", Value: " + value));

    System.out.println("Soy fibonacci + 100");
    fiboSuc.forEach((k, v) -> {
        v = v + 100;
        fiboSuc.replace(k, v);
        System.out.println("Key: " + k + ", Value: " + v);
    });
  }
}

/*
By: Méndez Guerrero Daniel Iván || Ciencias de la Computación - UNAM
Noviembre 12, 2025

Referencia: https://github.com/RobertoMendezM/MCA1_2026-1/blob/main/Estructuras_de_Datos/Tabla_Hash/MainMiFiboHash.java
Nota: Este código fue modificado de su fuente original para que pudiera ser ejecutado en versiones más antiguas de Java.

Compilador online utilizado: https://www.onlinegdb.com/online_java_compiler
*/
