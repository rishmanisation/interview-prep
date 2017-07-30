/**
* This is the famous two-sum problem. You are given an integer array and
* asked to find all the pairs of integers that sum up to a given number. A
* variant of the problem asks you to return the indices of the numbers that
* constitute the pairs.
* @author Rishabh Ananthan
* @version 1.0
*/

import java.util.*;
import java.io.*;

public class TwoSum {

  /**
  * Function that returns all pairs of integers from an array that sum up to
  * a given target.
  * @author Rishabh Ananthan
  * @param a The input array
  * @param sum The target sum
  * @return List of all pairs of integers in 'a' that sum up to 'sum'
  */
  public static List<int[]> twoSum(int[] a, int sum) {
    List<int[]> result = new ArrayList<int[]>();
    HashMap<Integer,Integer> myMap = new HashMap<>();
    int index = 0;
    for(int num : a) {
      if(myMap.containsValue(sum-num)) {
        int[] res = new int[]{num,sum-num};
        result.add(res);
      }
      myMap.put(index,num);
      index++;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter the size of the array: ");
    int n = in.nextInt();
    int[] a = new int[n];
    System.out.println("");
    System.out.print("Enter the elements in the array: ");
    for(int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    System.out.println("");
    System.out.print("Enter the target sum: ");
    int sum = in.nextInt();
    System.out.println("");
    List<int[]> result = new ArrayList<int[]>();
    result = twoSum(a,sum);
    for(int i = 0; i < result.size(); i++) {
      for(int num : result.get(i)) {
        System.out.print(num + " ");
      }
      System.out.println("");
    }
  }
}
