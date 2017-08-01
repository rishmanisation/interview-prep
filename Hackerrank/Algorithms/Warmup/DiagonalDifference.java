// Problem link: https://www.hackerrank.com/challenges/diagonal-difference

import java.io.*;
import java.util.*;

public class DiagonalDifference {

    public static void main(String[] args)
    {
        int N = 0;
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        int pdiagsum = 0;
        int odiagsum = 0;
        int number = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                number = in.nextInt();
                if (i == j)
                {
                    pdiagsum = pdiagsum + number;
                }

                if (i == N-j-1)
                {
                    odiagsum = odiagsum + number;
                }
            }
        }
        System.out.println(Math.abs(odiagsum - pdiagsum));
    }
}
