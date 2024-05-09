package com.example;

import java.util.*;

public class Dijkstra {
    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> grafo, String origen) {
        Map<String, Integer> distancias = new HashMap<>();
        Set<String> visitados = new HashSet<>();
        for (String nodo : grafo.keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);

        while (visitados.size() != grafo.size()) {
            String nodoActual = null;
            int distanciaMinima = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : distancias.entrySet()) {
                if (!visitados.contains(entry.getKey()) && entry.getValue() < distanciaMinima) {
                    nodoActual = entry.getKey();
                    distanciaMinima = entry.getValue();
                }
            }

            visitados.add(nodoActual);
            Map<String, Integer> vecinos = grafo.get(nodoActual);
            if (vecinos != null) {
                for (Map.Entry<String, Integer> vecino : vecinos.entrySet()) {
                    if (!visitados.contains(vecino.getKey())) {
                        int nuevaDistancia = distanciaMinima + vecino.getValue();
                        if (nuevaDistancia < distancias.get(vecino.getKey())) {
                            distancias.put(vecino.getKey(), nuevaDistancia);
                        }
                    }
                }
            }
        }

        return distancias;
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> grafo = CrearGrafo.crearGrafo();
        String estacionSalida = "Pueblo Paleta"; // Ingrese la estación de salida aquí
        Map<String, Integer> distancias = dijkstra(grafo, estacionSalida);
        System.out.println("Mejores rutas desde " + estacionSalida + ":");
        for (Map.Entry<String, Integer> entry : distancias.entrySet()) {
            if (!entry.getValue().equals(Integer.MAX_VALUE)) {
                System.out.println(entry.getKey() + " - Costo: " + entry.getValue());
            }
        }
    }
}
