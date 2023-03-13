package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // store the position of rotten orange
    static class Position {

        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // 200. Number of Islands
    // Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands
    // An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically
    // You may assume all four edges of the grid are all surrounded by water

    // BFS: Best space complexity
    public int numIslandsBFS(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfsFill(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfsFill(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<>();
        int code = x * m + y;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int i = code / m;
            int j = code % m;
            if (i > 0 && grid[i - 1][j] == '1')    //search upward and mark adjacent '1's as '0'.
            {
                queue.offer((i - 1) * m + j);
                grid[i - 1][j] = '0';
            }
            if (i < n - 1 && grid[i + 1][j] == '1')  //down
            {
                queue.offer((i + 1) * m + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1')  //left
            {
                queue.offer(i * m + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < m - 1 && grid[i][j + 1] == '1')  //right
            {
                queue.offer(i * m + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }

    // DFS:
    protected int numIslandsDFS(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfsFill(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsFill(char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
        }
    }

    // 994. Rotting Oranges
    // You are given an m x n grid where each cell can have one of three values:
    // 0 representing an empty cell,
    // 1 representing a fresh orange, or
    // 2 representing a rotten orange.
    // Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten
    //
    // Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1

    // BFS:

    protected int orangesRottingBFS(int[][] grid) {
        Queue<Position> q = new LinkedList<>();
        int total = 0, rotten = 0, time = 0;

        // traverse the grid, offer position of rotten orange into queue, and count the total num of orange
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    total++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new Position(i, j));
                }
            }
        }

        // if there is no orange, return 0;
        if (total == 0) {
            return 0;
        }

        while (!q.isEmpty() && rotten < total) {
            // size is the num of rotten oranges of the last round
            int size = q.size();

            // count the num of rotten oranges, if it equals to total num, return time;
            rotten += size;
            if (rotten == total) {
                return time;
            }

            // every round, time ++
            time++;

            // Continue to dequeue until all rotten oranges of last round are removed from the queue
            for (int i = 0; i < size; i++) {
                Position p = q.peek();

                // check the cell in the left/right/top/down of the rotten orange, if it is a fresh orange, enqueue it.
                if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1) {
                    grid[p.x + 1][p.y] = 2;
                    q.offer(new Position(p.x + 1, p.y));
                }
                if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
                    grid[p.x - 1][p.y] = 2;
                    q.offer(new Position(p.x - 1, p.y));
                }
                if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1) {
                    grid[p.x][p.y + 1] = 2;
                    q.offer(new Position(p.x, p.y + 1));
                }
                if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1) {
                    grid[p.x][p.y - 1] = 2;
                    q.offer(new Position(p.x, p.y - 1));
                }
                q.poll();
            }
        }
        return -1;
    }

    // DFS:
    protected int orangesRottingDFS(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotAdjacent(grid, i, j, 2);
                }
            }
        }

        int minutes = 2;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    return -1;
                }
                minutes = Math.max(minutes, cell);
            }
        }

        return minutes - 2;
    }

    private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
        if (i < 0 || i >= grid.length /* out of bounds */
                || j < 0 || j >= grid[0].length /* out of bounds */
                || grid[i][j] == 0 /* empty cell */
                || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
        ) {
            return;
        } else {
            grid[i][j] = minutes;
            rotAdjacent(grid, i - 1, j, minutes + 1);
            rotAdjacent(grid, i + 1, j, minutes + 1);
            rotAdjacent(grid, i, j - 1, minutes + 1);
            rotAdjacent(grid, i, j + 1, minutes + 1);
        }
    }

    // 286 Walls and Gates
    // You are given a m x n 2D grid initialized with these three possible values.
    //
    //-1 - A wall or an obstacle.
    //0 - A gate.
    //INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
    //Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
    //
    //For example, given the 2D grid:
    //INF  -1  0  INF
    //INF INF INF  -1
    //INF  -1 INF  -1
    //  0  -1 INF INF
    //After running your function, the 2D grid should be:
    //  3  -1   0   1
    //  2   2   1  -1
    //  1  -1   2  -1
    //  0  -1   3   4

    protected void wallsAndGatesDFS(int[][] rooms) {
        for (int i = 0; i < rooms.length; i ++) {
            for (int j = 0; j < rooms[0].length; j ++) {
                if (rooms[i][j] == 0) {
                    visit(rooms, i, j, 0);
                }
            }
        }
    }
    private void visit(int[][] rooms, int i, int j, int step) {
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] < step) {
            return;
        }
        rooms[i][j] = step;
        visit(rooms, i - 1, j, step + 1);
        visit(rooms, i, j - 1, step + 1);
        visit(rooms, i + 1, j, step + 1);
        visit(rooms, i, j + 1, step + 1);
    }

    protected void wallsAndGatesBFS(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (rooms[i][j] == 0) {
                    q.add(i * n + j);
                }
            }
        }
        while (!q.isEmpty()) {
            int tmp = q.poll();
            int x = tmp / n;
            int y = tmp % n;
            if (x > 0 && rooms[x-1][y] ==Integer.MAX_VALUE) {
                rooms[x-1][y] = rooms[x][y] + 1;
                q.add((x-1) * n + y);
            }
            if (x < m - 1 && rooms[x+1][y] ==Integer.MAX_VALUE) {
                rooms[x+1][y] = rooms[x][y] + 1;
                q.add((x+1) * n + y);
            }
            if (y > 0 && rooms[x][y-1] ==Integer.MAX_VALUE) {
                rooms[x][y-1] = rooms[x][y] + 1;
                q.add(x * n + y - 1);
            }
            if (y < n - 1 && rooms[x][y+1] ==Integer.MAX_VALUE) {
                rooms[x][y+1] = rooms[x][y] + 1;
                q.add(x * n + y + 1);
            }
        }
    }

}
