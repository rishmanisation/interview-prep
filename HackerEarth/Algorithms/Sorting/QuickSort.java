import java.util.*;

public class QuickSort {

  public static int partition(int[] array, int start, int end) {
    int i = start + 1;
    int pivot = array[start];
    for(int j = start + 1; j <= end; j++) {
      if(array[j] < pivot) {
        int temp1 = array[i];
        array[i] = array[j];
        array[j] = temp1;
        i++;
      }
    }
    int temp2 = array[start];
    array[start] = array[i-1];
    array[i-1] = temp2;
    return i-1;
  }

  public static void quickSort(int[] array, int start, int end) {
    if(start < end) {
      int pivot = partition(array,start,end); // find pivot
      quickSort(array,start,pivot-1); // sort to left of pivot
      quickSort(array,pivot+1,end); // sort to right of pivot
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] array = new int[N];
    for(int i = 0; i < N; i++) {
      array[i] = in.nextInt();
    }
    int start = 0;
    int end = N - 1;
    quickSort(array, start, end);
    for(int num : array) {
      System.out.print(num + " ");
    }
  }
}
