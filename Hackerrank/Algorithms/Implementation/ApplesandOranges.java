// Problem link: https://www.hackerrank.com/challenges/apple-and-orange

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ApplesandOranges {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }

        //My code below
        int appleCount = 0;
        int orangeCount = 0;
        for(int apl : apple) {
            if(apl + a >= s && apl + a <= t)
                appleCount++;
        }
        for(int orng : orange) {
            if(orng + b >= s && orng + b <= t)
                orangeCount++;
        }
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }
}
