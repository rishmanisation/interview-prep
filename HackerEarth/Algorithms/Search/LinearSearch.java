//To find the last occurrence of an item in an array

import java.util.*;
import java.io.*;

public class LinearSearch {
    
    public static int findLastOccurrence(int[] array, int M) {
        for(int i = array.length - 1; i >= 0; i--) {
            if(array[i] == M)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(findLastOccurrence(array,M));
    }
}
