package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CrearGrafo {
    public static Map<String, Map<String, Integer>> crearGrafo() {
        Map<String, Map<String, Integer>> grafo = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("rutas.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String origen = parts[0].trim();
                String destino = parts[1].trim();
                int costo = Integer.parseInt(parts[2].trim());
                
                // Agregar ruta de origen a destino
                grafo.computeIfAbsent(origen, k -> new HashMap<>()).put(destino, costo);
                // Agregar ruta de destino a origen (simétrica)
                grafo.computeIfAbsent(destino, k -> new HashMap<>()).put(origen, costo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grafo;
    }

    public static void main(String[] args) {
        System.out.println("Grafo creado con éxito.");
    }
}
