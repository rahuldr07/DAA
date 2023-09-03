import java.util.Scanner;

class Greedyknapsack {

    
    public static void sort(double[] arr, int i, int j){
        double temp=arr[i];
        arr[i]=arr[j];     
        arr[j]= temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, m;
        System.out.println("Enter the Total Objects");
        n = sc.nextInt();
        double w[] = new double[n];
        double p[] = new double[n];

        System.out.println("Enter the Profit");
        for (i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        System.out.println("Enter the weight");
        for (i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        System.out.println("Enter the Knapsack capacity");
        m = sc.nextInt();
        double p_w[] = new double[n];
        for (i = 0; i < n; i++) {
            p_w[i] =  p[i] /  w[i];
        }
        System.out.println("");
        System.out.println("-------------------");
        System.out.println("ITEM NO\t\t PROFIT \t\t WEIGHT\t\t xi");
        for (i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + p[i] + "\t\t" + w[i] + "\t\t" + p_w[i]);
        }

        for (i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (p_w[i] < p_w[j]) {
                    sort(p_w,i,j);
                    sort(p,i,j);
                    sort(w,i,j);
                }
            }
        }
        System.out.println("");
        System.out.println("-------------------");
        System.out.println("--After Arranging--");
        System.out.println("ITEM NO\t\t PROFIT \t\t WEIGHT\t\t xi");
        for (i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + p[i] + "\t\t" + w[i] + "\t\t" + p_w[i]);
        }
        double x[] = new double[n];
        for (i = 0; i < n; i++) {
            x[i] = 0.0;
        }
       
        double u = m;
        for (i = 0; i < n; i++) {
            if (w[i] > u) {
                break;
            }
            x[i] = 1.0;
            u = u - w[i];        
        }
        if (i <= n) {
                x[i] =  u / w[i];
               
            }
        System.out.println("");
       
        double sum=0;
        for( i=0;i<n;i++){
           
            sum= sum+ (double)p[i]*x[i];
        }
        System.out.println("final profit is:"+sum);
    }
}