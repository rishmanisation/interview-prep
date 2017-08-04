// Selection sort program

import java.util.*;
import java.io.*;

public class SelectionSort {

  // Only till 'x' iterations. For purposes of submission.
  public static void selSortLtd(int[] array, int x) {
    int N = array.length;
    int min = 0;
    for(int i = 0; i < x; i++) {
      min = i;
      for(int j = i + 1; j < N; j++) {
        if(array[j] < array[min]) {
          min = j;
        }
      }
      int temp = array[min];
      array[min] = array[i];
      array[i] = temp;
    }
  }

  // Selection sort of full array
  public static void selSortFull(int[] array) {
    int N = array.length;
    int min = 0;
    for(int i = 0; i < N - 1; i++) {
      min = i;
      for(int j = i + 1; j < N; j++) {
        if(array[j] < array[min]) {
          min = j;
        }
      }
      int temp = array[min];
      array[min] = array[i];
      array[i] = temp;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int x = in.nextInt();
    int[] array1 = new int[N];
    for(int i = 0; i < N; i++) {
      array1[i] = in.nextInt();
    }
    int[] array2 = array1.clone();
    selSortLtd(array1,x);
    for(int num : array1) {
      System.out.print(num + " ");
    }
    System.out.println("");
    selSortFull(array2);
    for(int num : array2) {
      System.out.print(num + " ");
    }
    System.out.println("");
  }
}
