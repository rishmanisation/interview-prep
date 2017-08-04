/* Print the number of swaps required to sort an array in ascending order
using Bubble Sort. This modified version also displays the sorted array.
*/

import java.util.*;
import java.io.*;

public class BubbleSort {

  public static void bubbleSort(int[] array) {
    int swaps = 0;
    for(int i = 0; i < array.length; i++) {
      for(int j = 0; j < array.length - i - 1; j++) {
        if(array[j] > array[j+1]) {
          swaps++;
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
    }
    System.out.println(swaps + "swaps performed.");
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] array = new int[N];
    for(int i = 0; i < N; i++) {
      array[i] = in.nextInt();
    }
    bubbleSort(array);
    for(int i = 0; i < N; i++) {
      System.out.print(array[i] + " ");
    }
  }
}
