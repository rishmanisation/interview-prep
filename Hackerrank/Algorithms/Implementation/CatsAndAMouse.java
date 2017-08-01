// Problem link: https://www.hackerrank.com/challenges/cats-and-a-mouse

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CatsAndAMouse {

    public static String catMouse(int x, int y, int z) {
        if(Math.abs(x-z) < Math.abs(y-z))
            return "Cat A";
        if(Math.abs(x-z) > Math.abs(y-z))
            return "Cat B";
        return "Mouse C";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            System.out.println(catMouse(x,y,z));
        }
    }
}
