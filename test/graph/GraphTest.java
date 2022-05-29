package graph;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    @Test
    void addAdjacentVertex() {
        // Given
        Graph graph = new Graph();
        buildGraph(graph);
        // Then
        assertEquals("Alice", graph.root.value);
    }

    @Test
    void dfsTraverseRecursive() {
        // Given
        Graph graph = new Graph();
        buildGraph(graph);
        Map<String, Boolean> visited = new HashMap<>();
        Set<String> list = new LinkedHashSet<>();
        // When
        graph.dfsTraverseRecursive(graph.root, visited);
    }

    @Test
    void dfsTraverse() {
        // Given
        Graph graph = new Graph();
        buildGraph(graph);
        Map<String, Boolean> visited = new HashMap<>();
        // When
//        Map<String, Boolean> result = graph.dfsTraverseRecursive(graph.root, visited);
        // Then
//        assertEquals("[Alice, Bob, Fred, Helen, Candy, Derek, Elaine, Gina, Irena]", result.keySet().toString());
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