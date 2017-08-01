// Problem link: https://www.hackerrank.com/challenges/mini-max-sum/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MiniMaxSum {
    public static long[] minMaxSum(int[] a) {
        long sum = 0;
        long max = Long.valueOf(Arrays.stream(a).max().getAsInt());
        long min = Long.valueOf(Arrays.stream(a).min().getAsInt());
        for(int num : a)
            sum += Long.valueOf(num);
        return new long[]{sum-max, sum-min};
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long[] result = new long[2];
        result = minMaxSum(arr);
        for(long num : result) {
            System.out.print(num + " ");
        }
    }
}
