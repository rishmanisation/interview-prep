// Merge sort implementation

import java.util.*;
import java.io.*;

public class MergeSort {

  public static void merge(int[] array, int start, int mid, int end) {
    int[] temp = new int[end-start+1];
    int p = start; // first index of first part
    int q = mid + 1; // first index of second part
    int j = 0; // first index of temp array

    for(int i = start; i <= end; i++) {
      // If first part has ended
      if(p > mid) {
        temp[j++] = array[q++];
      }
      // If second part has ended
      else if(q > end) {
        temp[j++] = array[p++];
      }
      // If first part element is smaller than second part element
      else if(array[p] < array[q]) {
        temp[j++] = array[p++];
      }
      // If second part element is smaller than first part element
      else {
        temp[j++] = array[q++];
      }
    }

    // Copy everything back into original array
    for(int i = 0; i < j; i++) {
      array[start++] = temp[i];
    }
  }

  public static void mergeSort(int[] array, int start, int end) {
    if(start < end) {
      int mid = (start + end)/2;
      mergeSort(array,start,mid); // sort first part of array
      mergeSort(array,mid+1,end); // sort second part of array
      merge(array,start,mid,end); // merge parts back together
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int start = 0;
    int end = N - 1;
    int[] array = new int[N];
    for(int i = 0; i < N; i++) {
      array[i] = in.nextInt();
    }
    mergeSort(array,start,end);
    for(int num : array) {
      System.out.print(num + " ");
    }
  }
}
