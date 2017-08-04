import java.util.*;
import java.io.*;
import java.lang.*;

public class Stocks {

  public static int getMaxProfit(int[] stockPrices) {
    if(stockPrices.length < 2) {
      throw new IllegalArgumentException("At least 2 prices needed");
    }

    int minPrice = stockPrices[0];
    int maxProfit = stockPrices[1] - stockPrices[0];

    for(int i = 1; i < stockPrices.length; i++) {
      int currPrice = stockPrices[i];
      int currProfit = currPrice - minPrice;
      maxProfit = Math.max(currProfit,maxProfit);
      minPrice = Math.min(currPrice,minPrice);
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    int[] stockPrices = {1,2,7,4,5,6,2};
    System.out.println(getMaxProfit(stockPrices));
  }
  
}
