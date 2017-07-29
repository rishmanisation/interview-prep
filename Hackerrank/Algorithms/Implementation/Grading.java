/**
* Class: Grading
* Function to round grades based on the following criteria:
* 1. If the result of subtracting grade from the next multiple of 5 is less than
* 3, round grade up to the next multiple of 5. Example, 73 and 74 get rounded up
* to 75.
* 2. If the grade is less than 38, leave it as is.
*
* @author Rishabh Ananthan
* @version 1.0
*
* Link to problem: https://www.hackerrank.com/challenges/grading
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Grading {
  /**
  * Round grades based on the criteria mentioned in intro blurb.
  * @author Rishabh Ananthan
  * @version 1.0
  * @param grades Array of un-rounded grades.
  * @return Array of rounded grades.
  */

  static int[] solve(int[] grades){
    int[] result = new int[grades.length];
    int index = 0;
    for(int grade : grades) {
      if(grade >= 38 && grade % 5 >= 3)
        grade = grade + 5 - (grade % 5);
      result[index] = grade;
      index++;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the number of students: ");
    int n = in.nextInt();
    System.out.println("Enter all the grades: ");
    int[] grades = new int[n];
    for(int grades_i=0; grades_i < n; grades_i++){
      grades[grades_i] = in.nextInt();
    }
    int[] result = solve(grades);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");
  }
}
