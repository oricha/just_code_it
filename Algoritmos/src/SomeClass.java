import java.util.LinkedList;
import java.util.Queue;

public class SomeClass {


    // Implement DFS
    public static void dfs(int[][] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        dfs(graph, start, visited);
    }
    public static void dfs(int[][] graph, int start, boolean[] visited) {
        visited[start] = true;
        System.out.println(start);
        for (int i = 0; i < graph[start].length; i++) {
            if (!visited[graph[start][i]]) {
                dfs(graph, graph[start][i], visited);
            }
        }
    }

    // Implement BFS
    public static void bfs(int[][] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.remove();
            System.out.println(current);
            for (int i = 0; i < graph[current].length; i++) {
                if (!visited[graph[current][i]]) {
                    visited[graph[current][i]] = true;
                    queue.add(graph[current][i]);
                }
            }
        }
    }
}
