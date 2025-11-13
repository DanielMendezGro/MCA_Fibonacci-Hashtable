"""
- Implementación de los dos códigos a replicar junto a las mejoras requeridas en el apartado V. 2/2.
- Actividad 2.

*By: Méndez Guerrero Daniel Iván || Ciencias de la Computación - UNAM
*Noviembre 12, 2025
*Referencia: https://github.com/RobertoMendezM/MCA1_2026-1/blob/main/Sucesiones/fibonacci_haciaAdelanteGenerator1.py
*Nota: Este código fue modificado de su fuente original para cumplir con los requerimentos solicitados de la actividad.
*Compilador online utilizado: https://www.onlinegdb.com/online_java_compiler

Código 2: fibonacci_haciaAdelanteGenerator1.py
"""

from typing import Generator

def fibGen(n: int) -> Generator[int, None, None]:
    yield 0
    if n > 0:
        yield 1
    fib_anterior_2: int = 0
    fib_anterior_1: int = 1
    for _ in range(1, n):
        fib_anterior_2, fib_anterior_1 = fib_anterior_1, fib_anterior_2 + fib_anterior_1
        yield fib_anterior_1

if __name__ == "__main__":
    while True:
        try:
            n = int(input("¿Fibonacci hasta la posición?: "))
            if n < 0:
                print("El número debe ser mayor o igual a 0")
                continue
            break
        except ValueError:
            print("Por favor, ingrese un número válido")
    print(f"Calculando hasta la posición {n}: ")
    for i in fibGen(n):    
        print(i)
