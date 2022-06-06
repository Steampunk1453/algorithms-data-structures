package graph.weight;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class WeightGraphTest {

    @Test
    void addVertex() {
        // Given
        WeightGraph graph = new WeightGraph();
        buildGraph(graph);
        // Then
        assertEquals("Alice", graph.root.value);
    }

    @Test
    void dfsTraverse() {
        // Given
        WeightGraph graph = new WeightGraph();
        buildGraph(graph);
        Map<String, Boolean> visited = new HashMap<>();
        // When
        graph.dfsTraverse(graph.root, visited);
    }

    @Test
    void dfsTraverseSearch() {
        // Given
        WeightGraph graph = new WeightGraph();
        buildGraph(graph);
        Map<String, Boolean> visited = new HashMap<>();
        // When
        WeightGraph.Vertex vertex = graph.dfsTraverseSearch(graph.root, "Helen", visited);
        // Then
        assertEquals("Helen", vertex.value);
    }

    @Test
    void dfsTraverseSearchReturnNull() {
        // Given
        WeightGraph graph = new WeightGraph();
        buildGraph(graph);
        Map<String, Boolean> visited = new HashMap<>();
        // When
        WeightGraph.Vertex vertex = graph.dfsTraverseSearch(graph.root, "James", visited);
        // Then
        assertNull(vertex);
    }

    @Test
    void bfsTraverse() {
        // Given
        WeightGraph graph = new WeightGraph();
        buildGraph(graph);
        // When
        graph.bfsTraverse(graph.root);
    }

    @Test
    void bfsTraverseSearch() {
        // Given
        WeightGraph graph = new WeightGraph();
        buildGraph(graph);
        // When
        WeightGraph.Vertex vertex = graph.bfsTraverseSearch(graph.root, "Helen");
        // Then
        assertEquals("Helen", vertex.value);
    }

    @Test
    void bfsTraverseSearchReturnNull() {
        // Given
        WeightGraph graph = new WeightGraph();
        buildGraph(graph);
        // When
        WeightGraph.Vertex vertex = graph.bfsTraverseSearch(graph.root, "James");
        // Then
        assertNull(vertex);
    }



    private void buildGraph(WeightGraph graph) {
        graph.root = new WeightGraph.Vertex("Alice");
        WeightGraph.Vertex bob = new WeightGraph.Vertex("Bob");
        WeightGraph.Vertex candy = new WeightGraph.Vertex("Candy");
        WeightGraph.Vertex derek = new WeightGraph.Vertex("Derek");
        WeightGraph.Vertex elaine = new WeightGraph.Vertex("Elaine");
        WeightGraph.Vertex fred = new WeightGraph.Vertex("Fred");
        WeightGraph.Vertex gina = new WeightGraph.Vertex("Gina");
        WeightGraph.Vertex helen = new WeightGraph.Vertex("Helen");
        WeightGraph.Vertex irena = new WeightGraph.Vertex("Irena");
        // When
        graph.root.addVertex(bob, 1);
        graph.root.addVertex(candy, 2);
        graph.root.addVertex(derek, 3);
        graph.root.addVertex(elaine, 4);
        bob.addVertex(fred, 1);
        fred.addVertex(helen, 3);
        helen.addVertex(candy, 5);
        derek.addVertex(elaine, 2);
        derek.addVertex(gina, 3);
        gina.addVertex(irena, 6);
    }

}