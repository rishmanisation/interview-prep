// Problem link: https://www.hackerrank.com/challenges/breaking-best-and-worst-records

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BreakingtheRecords {

    static int[] getRecord(int[] s){
        int maxScore = s[0];
        int minScore = s[0];
        int maxCount = 0;
        int minCount = 0;
        for(int i = 1; i < s.length; i++) {
            if(s[i] > maxScore) {
                maxScore = s[i];
                maxCount++;
            }

            if(s[i] < minScore) {
                minScore = s[i];
                minCount++;
            }
        }
        return new int[]{maxCount,minCount};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}
