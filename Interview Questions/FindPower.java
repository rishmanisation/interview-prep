/** Problem: Function to calculate x ^ y without using any inbuilt power
* functions.
* @author Rishabh Ananthan
* @version 1.0
*/

import java.util.*;
import java.io.*;

public class FindPower {

  /** Function that takes two integers as arguments and returns the first
  * integer raised to the second.
  * @author Rishabh Ananthan
  * @param x number
  * @param y exponent
  * @return x^y
  */

  static double getPower(int x, int y) {
    if(y == 0)
      return 1.0;
    if(y == 1)
      return 1.0*x;
    double temp = getPower(x,y/2);
    if(y % 2 == 0)
      return temp*temp;
    else
      return (y > 0) ? temp*temp*x : temp*temp/x;
  }

  public static void main(String[] args) {
    System.out.println(getPower(2,2) + " " + getPower(2,-2) + " " + getPower(55,0) + " " + getPower(55,1));
  }
}
