// Problem link: https://www.hackerrank.com/challenges/between-two-sets

/*
Algorithm used:

1. Compute the LCM of A.
2. Compute the GCD of B.
3. Find the number of multiples of the LCM that evenly divide the GCD.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int GCD(int[] a) {
        int result = a[0];
        for(int i = 1; i < a.length; i++) {
            result = GCD(result,a[i]);
        }
        return result;
    }

    static int GCD(int a, int b) {
        if(b == 0)
            return a;
        return GCD(b, a % b);
    }

    static int LCM(int[] a) {
        int result = a[0];
        for(int i = 1; i < a.length; i++) {
            result = LCM(result,a[i]);
        }
        return result;
    }

    static int LCM(int a, int b) {
        return Math.abs(a*b)/GCD(a,b);
    }

    static int getTotalX(int[] a, int[] b){
        int count = 0;
        int lcm = LCM(a);
        int gcd = GCD(b);
        for(int i = lcm; i <= gcd; i += lcm){
            if(gcd % i == 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
    }
}
