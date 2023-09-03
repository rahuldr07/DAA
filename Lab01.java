
import java.util.Random;
import java.util.Scanner;

public class Lab01 {

    void selectionsort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[index]) {
                    index = j; //searching for lowest index 
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void main(String[] args) {
        Lab01 s = new Lab01();
        int array[] = new int[10000];
        int i;
        System.out.println("Enter the array size");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random generator = new Random();
        for (i = 0; i < n; i++) {
            array[i] = generator.nextInt(5000);
        }
        System.out.println("Array before sorting");
        for (i = 0; i < n; i++) {
            System.out.println(array[i] + " ");
        }
        long startTime = System.nanoTime();
        s.selectionsort(array, n);
        long stopTime = System.nanoTime();
        long elapseTime = (stopTime - startTime);
        
        System.out.println("Sorted array is");
        for (i = 0; i < n; i++) {
            System.out.println(array[i]);
        }
        System.out.println("Time taken to sort array is:" + elapseTime + "nanoseconds");
    }
}
