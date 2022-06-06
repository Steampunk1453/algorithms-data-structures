package graph;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GraphTest {

    @Test
    void addVertex() {
        // Given
        Graph graph = new Graph();
        buildGraph(graph);
        // Then
        assertEquals("Alice", graph.root.value);
    }

    @Test
    void dfsTraverse() {
        // Given
        Graph graph = new Graph();
        buildGraph(graph);
        Map<String, Boolean> visited = new HashMap<>();
        // When
        graph.dfsTraverse(graph.root, visited);
    }

    @Test
    void dfsTraverseSearch() {
        // Given
        Graph graph = new Graph();
        buildGraph(graph);
        Map<String, Boolean> visited = new HashMap<>();
        // When
        Graph.Vertex vertex = graph.dfsTraverseSearch(graph.root, "Helen", visited);
        // Then
        assertEquals("Helen", vertex.value);
    }

    @Test
    void dfsTraverseSearchReturnNull() {
        // Given
        Graph graph = new Graph();
        buildGraph(graph);
        Map<String, Boolean> visited = new HashMap<>();
        // When
        Graph.Vertex vertex = graph.dfsTraverseSearch(graph.root, "James", visited);
        // Then
        assertNull(vertex);
    }

    @Test
    void dfsTraverseIterative() {
        // Given
        Graph graph = new Graph();
        buildGraph(graph);
        // When
        graph.dfsTraverseIterative(graph.root);
    }

    @Test
    void bfsTraverse() {
        // Given
        Graph graph = new Graph();
        buildGraph(graph);
        // When
        graph.bfsTraverse(graph.root);
    }

    @Test
    void bfsTraverseSearch() {
        // Given
        Graph graph = new Graph();
        buildGraph(graph);
        // When
        Graph.Vertex vertex = graph.bfsTraverseSearch(graph.root, "Helen");
        // Then
        assertEquals("Helen", vertex.value);
    }

    @Test
    void bfsTraverseReturnNull() {
        // Given
        Graph graph = new Graph();
        buildGraph(graph);
        // When
        Graph.Vertex vertex = graph.bfsTraverseSearch(graph.root, "James");
        // Then
        assertNull(vertex);
    }

    private void buildGraph(Graph graph) {
        graph.root = new Graph.Vertex("Alice");
        Graph.Vertex bob = new Graph.Vertex("Bob");
        Graph.Vertex candy = new Graph.Vertex("Candy");
        Graph.Vertex derek = new Graph.Vertex("Derek");
        Graph.Vertex elaine = new Graph.Vertex("Elaine");
        Graph.Vertex fred = new Graph.Vertex("Fred");
        Graph.Vertex gina = new Graph.Vertex("Gina");
        Graph.Vertex helen = new Graph.Vertex("Helen");
        Graph.Vertex irena = new Graph.Vertex("Irena");
        // When
        graph.root.addVertex(bob);
        graph.root.addVertex(candy);
        graph.root.addVertex(derek);
        graph.root.addVertex(elaine);
        bob.addVertex(fred);
        fred.addVertex(helen);
        helen.addVertex(candy);
        derek.addVertex(elaine);
        derek.addVertex(gina);
        gina.addVertex(irena);
    }

}