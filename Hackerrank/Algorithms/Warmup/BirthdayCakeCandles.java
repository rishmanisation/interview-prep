// Problem link: https://www.hackerrank.com/challenges/birthday-cake-candles

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int[] ar) {
        int max = Arrays.stream(ar).max().getAsInt();
        int count = 0;
        for(int num : ar)
            count = (num == max) ? count + 1 : count;
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(ar);
        System.out.println(result);
    }
}
