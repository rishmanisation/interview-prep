// Insertion sort

import java.util.*;

public class InsertionSort {
  // 1 2 4 5 3  temp = 3
  // 1 2 4 5 5
  // 1 2 4 4 5
  // 1 2 3 4 5
  public static void insertionSort(int[] array) {
    for(int i = 0; i < array.length; i++) {
      int temp = array[i];
      int j = i;
      while(j > 0 && temp < array[j-1]) {
        array[j] = array[j-1];
        j--;
      }
      array[j] = temp;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] array = new int[N];
    for(int i = 0; i < N; i++) {
      array[i] = in.nextInt();
    }
    insertionSort(array);
    for(int num : array) {
      System.out.print(num + " ");
    }
  }
}
