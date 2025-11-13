// Implementación de los dos códigos a replicar junto a las mejoras requeridas en el apartado IV. 1/2.
// Actividad 4.

// By: Méndez Guerrero Daniel Iván || Ciencias de la Computación - UNAM
// Noviembre 12, 2025
// Referencia: https://github.com/RobertoMendezM/MCA1_2026-1/blob/main/Sucesiones/FibonacciThreads.java
// Nota: Este código fue modificado de su fuente original para cumplir con los requerimentos solicitados de la actividad.
// Compilador online utilizado: https://www.onlinegdb.com/online_java_compiler

// Código 1: FibonacciThreads.java

import java.util.concurrent.ConcurrentHashMap;
import java.lang.Math;

public class FibonacciThreads implements Runnable{

static ConcurrentHashMap<Long, Long> memo = new ConcurrentHashMap();

    static {
        memo.put(0L, 1L); 
        memo.put(1L, 1L);
    }
  
    int num;
    long f1; 

    public FibonacciThreads(int n, long f) {
        num = n;
        f1 = f;
    }

    @Override
    public void run() {
        System.out.println("Starte " + num);
        long res = fibonacci(f1);
        System.out.println("Abschlussverfahren: " + num + 
                           " - " + "Fibonacci(" + f1 + ") = " + res);
    }

    long fibonacci(long f) {
        
        if (memo.containsKey(f)) {
            return memo.get(f);
        }

        if (f < 2) {
            return 1;
        }

        long res = fibonacci(f - 1) + fibonacci(f - 2);
        
        memo.put(f, res); 
        
        return res;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new FibonacciThreads(i, (long) (Math.random() * 56) + 1));
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}

// Nota: Aunque este código no pide entrada, si fuese el caso, el máximo valor que podría calcular sería el que Java marca por defecto.
