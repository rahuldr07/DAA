import java.util.Scanner;

public class Dijkstra {

    static int d[] = new int[10], u, i, j;

    public void djikstr(int[][] a, int s, int n) {
        int min;
        int visited[] = new int[10];
        int p[] = new int[10]; // Stores previous nodes for path reconstruction
        
        // Initialize arrays for visited nodes, shortest distances, and previous nodes
        for (i = 0; i < n; i++) {
            visited[i] = 0;
            d[i] = a[s][i];
            p[i] = s; // Initialize p array with source vertex
        }
        
        d[s] = 0;
        visited[s] = 1;
        
        // Dijkstra's algorithm
        for (i = 0; i < n; i++) {
            if (i == s) {
                continue;
            }
            min = 99;
            for (j = 0; j < n; j++) {
                if (d[j] < min && visited[j] == 0) {
                    min = d[j];
                    u = j;
                }
            }

            visited[u] = 1;
            for (j = 0; j < n; j++) {
                if (visited[j] == 0 && a[u][j] > 0 && d[j] > d[u] + a[u][j]) {
                    d[j] = d[u] + a[u][j];
                    p[j] = u; // Update previous node
                }
            }
        }

        // Print the results in a tabular form
        System.out.println("\nSource | Cost | Path");
        System.out.println("----------------------");
        for (i = 0; i < n; i++) {
            
            System.out.printf("%3d    | %3d  | %s\n", s, d[i], getPath(p, s, i));
        }
    }

    public String getPath(int[] p, int s, int v) {
        StringBuilder path = new StringBuilder();
        if (v != s) {
            path.append(getPath(p, s, p[v]));
            path.append(" -> ");
        }
        path.append(v);
        return path.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = sc.nextInt();
        System.out.println("Enter the weighted matrix");
        int a[][] = new int[10][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the source vertex");
        int s = sc.nextInt();
        Dijkstra dr = new Dijkstra();
        dr.djikstr(a, s, n);

    }
}
