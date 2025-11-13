// Implementación de los dos códigos a replicar junto a las mejoras requeridas en el apartado IV. 2/2.
// Actividad 4.

// By: Méndez Guerrero Daniel Iván || Ciencias de la Computación - UNAM
// Noviembre 12, 2025
// Referencia: https://github.com/RobertoMendezM/MCA1_2026-1/blob/main/Sucesiones/FibonacciThreadsBigInteger.java
// Nota: Este código fue modificado de su fuente original para cumplir con los requerimentos solicitados de la actividad.
// Compilador online utilizado: https://www.onlinegdb.com/online_java_compiler

// Código 2: FibonacciThreadsBigInteger.java

import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.Math;

public class FibonacciThreadsBigInteger implements Runnable {

    static ConcurrentHashMap<BigInteger, BigInteger> memo = new ConcurrentHashMap<>();
  
    static {
        memo.put(BigInteger.ZERO, BigInteger.ZERO);
        memo.put(BigInteger.ONE, BigInteger.ONE);
    }
    
    BigInteger f1;
    int num;

    public FibonacciThreadsBigInteger(int n, BigInteger f) {
        num = n;
        f1 = f;
    }

    @Override
    public void run() {
        System.out.println("Starte #" + num);
        BigInteger res = fibonacci(f1);
        System.out.println("Abschlussverfahren: " + num + 
                           " - " + "Fibonacci(" + f1 + ") = " + res);
    }

    public BigInteger fibonacci(BigInteger f) {

        if (memo.containsKey(f)) {
            return memo.get(f);
        }

        if (f.compareTo(BigInteger.ONE) <= 0) {
            return f; 
        }

        BigInteger res = fibonacci(f.subtract(BigInteger.ONE))
            .add(fibonacci(f.subtract(BigInteger.TWO)));

        memo.put(f, res);
        
        return res;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            long algo = (long) (Math.random() * 56) + 1;
            
            threads[i] = new Thread(new FibonacciThreadsBigInteger(
                i, 
                BigInteger.valueOf(algo)
            ));
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}

// Nota: Aunque este código no pide entrada, si fuese el caso, el máximo valor que podría calcular sería aquel que nuestro dispositivo tenga como tope.
