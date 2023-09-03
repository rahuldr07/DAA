
import java.util.Random;
import java .util.Scanner;

public class Lab02 {
    public static void quicksort(int[] a,int low,int high){
        if (low<high){
            int q=partition(a,low,high);
            quicksort(a,low,q-1);
            quicksort(a,q+1,high);
        }
    }
    public static int partition(int[] a,int low,int high){
        int pivot=a[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if (a[j]<=pivot)
            {
                i++;
                swap(a,i,j);
            }
        }
        swap(a,i+1,high);
        return i+1;
    }
    public static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void main(String[] args) {
        int a[] = new int[10000];
        int i;
        System.out.println("Enter the a size");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random generator = new Random();
        for (i = 0; i < n; i++) {
            a[i] = generator.nextInt(5000);
        }
        System.out.println("Array before sorting");
        for (i = 0; i < n; i++) {
            System.out.println(a[i] + " ");
        }
        long startTime = System.nanoTime();
        quicksort(a,0,n-1);
        long stopTime = System.nanoTime();
        long elapseTime = (stopTime - startTime);
        
        System.out.println("Sorted a is");
        for (i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
        System.out.println("Time taken to sort a is:" + elapseTime + "nanoseconds");
        
    }
}
