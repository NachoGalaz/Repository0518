package com.generation.f20220523;

public class CalculoPromedio {
    public static void main(String[] args) {
        //Software de calificacion que calcule entre 0 y 100
        // >= 50 aprobado, <=49 reprobado

        int cantidadNotas = 12;
        //Arreglo o array
        Integer[] notas = {20,50,67,99,10,0,88,77,58,79,33,50};

        //Promedio -> suma todas las notas/cantidad de notas;
        int sumaNotas = 0;

        //Como recorrer el arreglo de notas
        for (int i = 0; i < notas.length; i++) { // al principio i vale 0, es decir =20
            sumaNotas = sumaNotas + notas[i];   //
        }
        System.out.println("Suma de notas: " + sumaNotas);
        float promedio = sumaNotas / notas.length;
        System.out.println("Promedio "+ promedio);

        /*TODO validar el orden >= */
        if (promedio >= 50){
            System.out.println("Aprobado");
        }else{
            System.out.println("Reprobado");
        }

    }
}
