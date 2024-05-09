package com.example;

import java.util.Map;

public class MostrarDestinos {
    public static void mostrarDestinos(Map<String, Map<String, Integer>> grafo, String estacionSalida) {
        if (!grafo.containsKey(estacionSalida)) {
            System.out.println("La estación de salida no existe en el grafo.");
            return;
        }

        Map<String, Integer> destinos = grafo.get(estacionSalida);
        if (destinos.isEmpty()) {
            System.out.println("No hay destinos disponibles desde esta estación.");
        } else {
            System.out.print("Posibles destinos desde " + estacionSalida + ": ");
            destinos.keySet().forEach(destino -> System.out.print(destino + ", "));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> grafo = CrearGrafo.crearGrafo();
        String estacionSalida = "Pueblo Paleta"; // Ingrese la estación de salida aquí
        mostrarDestinos(grafo, estacionSalida);
    }
}
    

