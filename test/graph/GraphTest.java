package graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

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
    @Test
     void numOfMinutes() {
        // Given
        Graph graph = new Graph();
        int n = 6;
        int headID = 2;
        int[] manager = {2,2,-1,2,2,2};
        int[] informTime = {0,0,1,0,0,0};
        int expected = 1;
        // When
        int actual = graph.numOfMinutes(n, headID, manager, informTime);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void canFinishBFS() {
        Graph graph = new Graph();
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        assertTrue(graph.canFinishBFS(numCourses1, prerequisites1));

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1,0},{0,1}};
        assertFalse(graph.canFinishBFS(numCourses2, prerequisites2));

        int numCourses3 = 4;
        int[][] prerequisites3 = {{1,0},{2,1},{3,2}};
        assertTrue(graph.canFinishBFS(numCourses3, prerequisites3));
    }

    @Test
    public void canFinishDFS() {
        Graph graph = new Graph();
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        assertTrue(graph.canFinishDFS(numCourses, prerequisites));

        prerequisites = new int[][]{{1, 0}, {0, 1}};
        assertFalse(graph.canFinishDFS(numCourses, prerequisites));
    }

    @Test
    public void networkDelayTime() {
        // Given
        Graph graph = new Graph();
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        int expected = 2;
        // When & Then
        assertEquals(expected, graph.networkDelayTime(times, n, k));
    }

}