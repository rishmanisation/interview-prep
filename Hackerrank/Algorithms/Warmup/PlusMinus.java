// Problem link: https://www.hackerrank.com/challenges/plus-minus

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int N = 0;
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        int number = 0;
        double pos = 0, neg = 0, zero = 0;
        for (int i = 0; i < N; i++)
        {
            number = in.nextInt();
            if (number > 0)
            {
                pos++;
            }
            else if (number == 0)
            {
                zero++;
            }
            else
            {
                neg++;
            }
        }
        System.out.printf("%.6f",pos/N);
        System.out.println();
        System.out.printf("%.6f",neg/N);
        System.out.println();
        System.out.printf("%.6f",zero/N);
        System.out.println();
    }
}
