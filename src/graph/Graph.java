package graph;

import java.util.ArrayList;
import java.util.Arrays;
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

    // 1376. Time Needed to Inform All Employees
    // A company has n employees with a unique ID for each employee from 0 to n - 1.
    // The head of the company is the one with headID.
    //
    // Each employee has one direct manager given in the manager array where manager[i]
    // is the direct manager of the i-th employee, manager[headID] = -1.
    // Also, it is guaranteed that the subordination relationships have a tree structure.
    //
    // The head of the company wants to inform all the company employees of an urgent piece of news.
    // He will inform his direct subordinates, and they will inform their subordinates, and so on until
    // all employees know about the urgent news.
    //
    // The i-th employee needs informTime[i] minutes to inform all of his direct subordinates
    // (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).
    //
    // Return the number of minutes needed to inform all the employees about the urgent news.
    // TIme Complexity
    //O(n) - we traverse backwards on each employee at most once.
    //
    //Space Complexity
    //O(n) - we store the time it takes to inform each employee
    protected int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Integer> times = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i, manager, informTime, times));
        }

        return max;
    }

    private int dfs(int e_id, int[] manager, int[] informTime, Map<Integer, Integer> times) {
        if (manager[e_id] == -1) {
            return 0;
        }

        if (times.containsKey(e_id)) {
            return times.get(e_id);
        }

        times.put(e_id, informTime[manager[e_id]] + dfs(manager[e_id], manager, informTime, times));

        return times.get(e_id);
    }

    // 207. Course Schedule
    // There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
    // You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course
    // bi first if you want to take course ai.
    // For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    // Return true if you can finish all courses. Otherwise, return false.

    // BFS:
    protected boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[1]]++;
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int course = (int) queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int) graph[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                    count++;
                }
            }
        }
        return count == numCourses;
    }

    // DFS:
    protected boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }

    // 743. Network Delay Time
    // You are given a network of n nodes, labeled from 1 to n.
    // You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
    // vi is the target node, and wi is the time it takes for a signal to travel from source to target.
    //
    //We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
    // If it is impossible for all the n nodes to receive the signal, return -1.

    protected int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n][n];
        for(int i = 0; i < n ; i++) Arrays.fill(graph[i], Integer.MAX_VALUE);
        for( int[] rows : times) graph[rows[0] - 1][rows[1] - 1] =  rows[2];

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k - 1] = 0;

        boolean[] visited = new boolean[n];
        for(int i = 0; i < n ; i++){
            int v = minIndex(distance, visited);
            if(v == -1)continue;
            visited[v] = true;
            for(int j = 0; j < n; j++){
                if(graph[v][j] != Integer.MAX_VALUE){
                    int newDist = graph[v][j] + distance[v];
                    if(newDist < distance[j]) distance[j] = newDist;
                }
            }
        }
        int result = 0;
        for(int dist : distance){
            if(dist == Integer.MAX_VALUE) return -1;
            result = Math.max(result, dist);
        }
        return result;
    }

    private int minIndex(int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE, minIndex = -1;
        for(int i = 0; i < distance.length; i++){
            if(!visited[i] && distance[i] < min){
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}