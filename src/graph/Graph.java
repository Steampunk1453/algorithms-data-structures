package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

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

    }

    protected void dfsTraverse(Vertex vertex, Map<String, Boolean> visited) {
        visited.put(vertex.value, true);
        System.out.println(vertex.value);

        for (Vertex ver : vertex.vertices) {
            if (!visited.getOrDefault(ver.value, false)) {
                dfsTraverse(ver, visited);
            }
        }
    }

    protected Vertex dfsTraverseSearch(Vertex vertex, String searchValue, Map<String, Boolean> visited) {
        if (searchValue.equals(vertex.value)) {
            return vertex;
        }

        visited.put(vertex.value, true);

        for (Vertex ver : vertex.vertices) {
            if (!visited.getOrDefault(ver.value, false)) {
                if (searchValue.equals(ver.value)) {
                    return ver;
                }
                Vertex vertexSearch = dfsTraverseSearch(ver, searchValue, visited);
                if (vertexSearch != null && searchValue.equals(vertexSearch.value)) {
                    return vertexSearch;
                }
            }
        }

        return null;
    }

    // TODO check
    protected void dfsTraverseIterative(Vertex vertex) {
        Stack<Vertex> stack = new Stack<>();
        Map<String, Boolean> visited = new HashMap<>();

        visited.put(vertex.value, true);
        System.out.println(vertex.value);
        stack.push(vertex);

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();
            for (Vertex ver : currentVertex.vertices) {
                if (!visited.getOrDefault(ver.value, false)) {
                    System.out.println(ver.value);
                    visited.put(ver.value, true);
                    stack.push(ver);
                }
            }
        }
    }

    protected void bfsTraverse(Vertex vertex) {
        Queue<Vertex> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();

        visited.put(vertex.value, true);
        queue.add(vertex);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            System.out.println(currentVertex.value);
            for (Vertex ver : currentVertex.vertices) {
                if (!visited.getOrDefault(ver.value, false)) {
                    visited.put(ver.value, true);
                    queue.add(ver);
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

            for (Vertex ver : currentVertex.vertices) {
                if (searchValue.equals(ver.value)) {
                    return ver;
                }
                if (!visited.getOrDefault(ver.value, false)) {
                    visited.put(ver.value, true);
                    queue.add(ver);
                }
            }
        }
        return null;
    }

}