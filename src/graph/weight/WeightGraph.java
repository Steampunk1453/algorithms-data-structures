package graph.weight;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WeightGraph {

    protected Vertex root;

    static class Vertex {

        String value;
        LinkedHashMap<Vertex, Integer> vertices;

        public Vertex(String value) {
            this.value = value;
            vertices = new LinkedHashMap<>();
        }

        protected void addVertex(Vertex vertex, int weight) {
            if (vertices.getOrDefault(vertex, 0) == 0) {
                this.vertices.put(vertex, weight);
                vertex.addVertex(this, weight);
            }
        }

    }
    protected void dfsTraverse(Vertex vertex, Map<String, Boolean> visited) {
        visited.put(vertex.value, true);
        System.out.println(vertex.value);

        for (var entry : vertex.vertices.entrySet()) {
            if (!visited.getOrDefault(entry.getKey().value, false)) {
                dfsTraverse(entry.getKey(), visited);
            }
        }
    }

    protected Vertex dfsTraverseSearch(Vertex vertex, String searchValue, Map<String, Boolean> visited) {
        if (searchValue.equals(vertex.value)) {
            return vertex;
        }

        visited.put(vertex.value, true);

        for (var entry : vertex.vertices.entrySet()) {
            if (!visited.getOrDefault(entry.getKey().value, false)) {
                if (searchValue.equals(entry.getKey().value)) {
                    return entry.getKey();
                }
                Vertex vertexSearch = dfsTraverseSearch(entry.getKey(), searchValue, visited);
                if (vertexSearch != null && searchValue.equals(vertexSearch.value)) {
                    return vertexSearch;
                }
            }
        }

        return null;
    }

    protected void bfsTraverse(Vertex vertex) {
        Queue<Vertex> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();

        visited.put(vertex.value, true);
        queue.add(vertex);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            System.out.println(currentVertex.value);
            for (var entry : currentVertex.vertices.entrySet()) {
                if (!visited.getOrDefault(entry.getKey().value, false)) {
                    visited.put(entry.getKey().value, true);
                    queue.add(entry.getKey());
                }
            }
        }
    }
    protected Vertex bfsTraverseSearch(Vertex vertex, String searchValue) {
        Queue<Vertex> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();

        if (searchValue.equals(vertex.value)) {
            return vertex;
        }

        visited.put(vertex.value, true);
        queue.add(vertex);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            System.out.println(currentVertex.value);
            for (var entry : currentVertex.vertices.entrySet()) {
                if (searchValue.equals(entry.getKey().value)) {
                    return entry.getKey();
                }
                if (!visited.getOrDefault(entry.getKey().value, false)) {
                    visited.put(entry.getKey().value, true);
                    queue.add(entry.getKey());
                }
            }
        }
        return null;
    }
}