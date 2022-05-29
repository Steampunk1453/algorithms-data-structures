package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Graph {

    protected Vertex root;

    static class Vertex {

        String value;
        List<Vertex> vertices;

        public Vertex(String value) {
            this.value = value;
            vertices = new ArrayList<>();
        }

        protected void addVertex(Vertex vertex) {
            if (!vertices.contains(vertex)) {
                vertices.add(vertex);
                vertex.addVertex(this);
            }
        }

        protected void removeVertex(Vertex vertex) {
            if (vertices.contains(vertex)) {
                vertices.remove(vertex);
                vertex.removeVertex(this);
            }
        }

    }

    protected void dfsTraverseRecursive(Vertex vertex, Map<String, Boolean> visited) {
        visited.put(vertex.value, true);

        System.out.println(vertex.value);

        for (Vertex ver :vertex.vertices) {
            if (!visited.getOrDefault(ver.value, false)) {
                dfsTraverseRecursive(ver ,visited);
            }
        }
    }

}