import java.util.Scanner;

public class Knapsackdp {

    public void solve(int[] wt, int[] val, int m, int n) {
        int[][] sol = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                
                if (wt[i] > j) {
                    sol[i][j] = sol[i - 1][j];
                } else {
                    sol[i][j] = Math.max(sol[i - 1][j], sol[i - 1][j - wt[i]] + val[i]);
                }
            }
        }
        System.out.println("Maximum Profit: " + sol[n][m]);

        System.out.print("Selected Items: ");
        for (int i = n, j = m; i > 0 && j > 0; i--) {
            if (sol[i][j] != sol[i - 1][j]) {
                System.out.print(i + " ");
                j -= wt[i];
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Knapsackdp ks = new Knapsackdp();
        System.out.print("Enter the number of items: ");
        int n = scan.nextInt();
        int[] weight = new int[n + 1];
        int[] profit = new int[n + 1];
        System.out.println("\nEnter weight and profit for " + n + " elements:");
        for (int i = 1; i <= n; i++) {
            weight[i] = scan.nextInt();
            profit[i] = scan.nextInt();
        }
        System.out.print("Enter knapsack weight: ");
        int m = scan.nextInt();
        ks.solve(weight, profit, m, n);
    }
}
