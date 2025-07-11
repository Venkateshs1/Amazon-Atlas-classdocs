import java.util.*;
public class Task006 {
    public static void main(String args[]) {
        int n = 5;
        int[] arr = {10, 20 ,5 , 46, 80};
        System.out.print("before Sort: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        for(int i = 0; i<n; i++) {
            int swaps = 0;
            for(int j = 0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps = 1;
                }
            }
            if(swaps == 0)
                break;
        }
        System.out.print("After Sort: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
