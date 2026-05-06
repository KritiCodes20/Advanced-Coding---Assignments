import java.util.*;

public class Assignment2 {
   
    public static long minimumOperations(int[] arr, int k) {
        int n = arr.length;

        int rem = arr[0] % k;

        for (int num : arr) {
            if (num % k != rem) {
                return -1;
            }
        }

        Arrays.sort(arr);

        int target = arr[n / 2];

        long operations = 0;

        for (int num : arr) {
            operations += Math.abs(num - target) / k;
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(minimumOperations(arr, k));
  
    }
}

