import java.util.*;

public class HeapSort {

  public static void heapSort(int[] array) {
    int heapSize = array.length;
    build_maxheap(array);
    for(int i = array.length; i >= 2; i--) {
      int temp = array[1];
      array[1] = array[i];
      array[i] = temp;
      heapSize--;
      max_heapify(array,1,heapSize);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] array = new int[N];
    for(int i = 0; i < N; i++) {
      array[i] = in.nextInt();
    }
    heapSort(array);
    for(int num : array) {
      System.out.print(num + " ");
    }
  }
}
