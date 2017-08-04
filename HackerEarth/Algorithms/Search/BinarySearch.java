/*
You have been given an array A consisting of N integers.
All the elements in this array A are unique.
You have to answer some queries based on the elements of this array.
Each query will consist of a single integer x.
You need to print the rank based position of this element in this array
considering that the array is 1 indexed.
The rank based position of an element in an array is its position in the array
when the array has been sorted in ascending order.
*/

import java.util.*;
import java.io.*;

public class BinarySearch {

  public static int findNumber(int[] array, int number) {
    int low = 0;
    int high = array.length - 1;
    while(low <= high) {
      int mid = (low + high)/2;
      if(array[mid] < number)
        low = mid + 1;
      else if(array[mid] > number)
        high = mid - 1;
      else
        return mid + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] array = new int[N];
    for(int i = 0; i < N; i++) {
      array[i] = in.nextInt();
    }
    Arrays.sort(array);
    int q = in.nextInt();
    for(int i = 0; i < q; i++) {
      int x = in.nextInt();
      System.out.println(findNumber(array,x));
    }
  }
}
