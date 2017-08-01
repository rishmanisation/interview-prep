// Problem link: https://www.hackerrank.com/challenges/a-very-big-sum

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AVeryBigSum {

    static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for(long num : ar)
            sum += num;
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextLong();
        }
        long result = aVeryBigSum(ar);
        System.out.println(result);
    }
}
