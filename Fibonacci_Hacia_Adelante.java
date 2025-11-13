// Implementación de los dos códigos a replicar junto a las mejoras requeridas en el apartado V.
// Actividad 2.

// Código 1: fibonacci_haciaAdelante1.py

def fibAdel(n: int) -> int:
    if n == 0: return n
    penultimo: int = 0
    ultimo:    int = 1
    for _ in range(1, n):
        penultimo, ultimo = ultimo, penultimo + ultimo
    return ultimo

if __name__ == "__main__":
    n = int(input("¿De qué posición quieres el valor de Fibonacci?: "))
    print(f"El  {n}-ésimo valor de Fibonacci es: {fibAdel(n)}") 

// Código 2: fibonacci_haciaAdelanteGenerator1.py

from typing import Generator
    
def fibGen(n: int) -> Generator[int, None, None]:
    yield 0
    if n > 0:
        yield 1
    penultimo: int = 0
    ultimo:    int = 1
    for _ in range(1, n):
        penultimo, ultimo = ultimo, penultimo + ultimo
        yield ultimo

if __name__ == "__main__":
    n = int(input("¿Fibonacci hasta la posición?: "))
    for i in fibGen(n):    
        print(i)

  /*
By: Méndez Guerrero Daniel Iván || Ciencias de la Computación - UNAM
Noviembre 12, 2025

Referencia: https://github.com/RobertoMendezM/MCA1_2026-1/blob/main/Sucesiones/fibonacci_haciaAdelanteGenerator1.py
            https://github.com/RobertoMendezM/MCA1_2026-1/blob/main/Sucesiones/fibonacci_haciaAdelnate1.py
            
Nota: Este código fue modificado de su fuente original para cumplir con los requerimentos solicitados de la actividad.
Compilador online utilizado: https://www.onlinegdb.com/online_java_compiler
  */
