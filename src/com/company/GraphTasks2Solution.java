package com.company;

import java.util.ArrayDeque;
import java.util.HashMap;

public class GraphTasks2Solution implements GraphTasks2 {
    @Override
    public HashMap<Integer, Integer> dijkstraSearch(int[][] adjacencyMatrix, int startIndex) {
        int adjacencyMatrixLength = adjacencyMatrix.length;
        ArrayDeque<Integer> vertexDeque = new ArrayDeque<>();
        HashMap<Integer, Integer> table1 = new HashMap<>();
        HashMap<Integer, Integer> table2 = new HashMap<>();
        vertexDeque.add(startIndex);
        table1.put(startIndex, 0);
        for (int i = 1; i < adjacencyMatrixLength + 1; i++) {
            int vertexDequeSize = vertexDeque.size();
            for (int j = 0; j < vertexDequeSize; j++) {
                table2.put(vertexDeque.getFirst(), table1.get(vertexDeque.getFirst()));
                vertexDeque.removeFirst();
            }
            for (int j = 0; j < vertexDequeSize; j++) {
                vertexDeque.push(table2.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey());
                table2.remove(vertexDeque.getFirst());
            }
            startIndex = vertexDeque.getFirst();
            for (int j = 1; j < adjacencyMatrixLength + 1; j++) {
                if (adjacencyMatrix[startIndex - 1][j - 1] > 0) {
                    if (!table1.containsKey(j)) {
                        vertexDeque.add(j);
                        table1.put(j, table1.get(startIndex) + adjacencyMatrix[startIndex - 1][j - 1]);
                    }
                    if (table1.containsKey(j) && table1.get(j) > table1.get(startIndex) + adjacencyMatrix[startIndex - 1][j - 1]) {
                        table1.put(j, table1.get(startIndex) + adjacencyMatrix[startIndex - 1][j - 1]);
                    }
                }
            }
            vertexDeque.removeFirst();
        }
        return table1;
    }

    @Override
    public Integer primaAlgorithm(int[][] adjacencyMatrix) {
        return null;
    }

    @Override
    public Integer kraskalAlgorithm(int[][] adjacencyMatrix) {
        return null;
    }
}


