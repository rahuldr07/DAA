import java.util.Scanner;

public class Kruskal {
    static int parent[], cost[][], mincost, n, i, j, k, a, b, min, u, v;

    static void kruskal(int n, int[][] cost) {
        k = 1;
        System.out.println("Edge\tVertices\tCost");
        while (k < n) {
            min = Integer.MAX_VALUE; // or 999
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++)
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
            }
            u = find(u);
            v = find(v);
            if (v != u) {
                System.out.printf("%d\t(%d,%d)\t\t%d%n", k, a, b, min);
                k = k + 1;
                mincost = mincost + min;
                union(u, v);
            }
            cost[a][b] = cost[b][a] = Integer.MAX_VALUE; // or 999
        }
        System.out.println("The minimum cost of spanning tree is " + mincost);
    }

    static int find(int i) {
        while (parent[i] != 0)
            i = parent[i];
        return i;
    }

    static void union(int i, int j) {
        parent[j] = i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        n = sc.nextInt();
        int cost[][] = new int[n ][n];
        parent = new int[n + 1];
        System.out.println("Enter the cost matrix:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        kruskal(n, cost);
    }
}
