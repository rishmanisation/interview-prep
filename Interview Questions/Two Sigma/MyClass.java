/**
 * get() -> "a"
 * put(string, integer)
 * 
 * 
 * "a" -> 10   10/60
 * "b" -> 20   20/60
 * "c" -> 30   30/60
 * 
 **/

import java.util.*;

public class MyClass {
    Map<String, Integer> myMap;
    
    public MyClass() {
        myMap = new LinkedHashMap<String, Integer>();
    }
    
    public void put(String str, int weight) {
        if(myMap.containsKey(str)) {
            myMap.replace(str, weight);
        } else {
            myMap.put(str, weight);
        }
    }
    
    public int getTotalWeight() {
        int totalWeight = 0;
        for(String str : myMap.keySet()) {
            totalWeight += myMap.get(str);
        }

        return totalWeight;
    }

    public ArrayList<Integer> getCSums() {
        ArrayList<Integer> cSums = new ArrayList<Integer>();
        int total = 0;
        for(String str : myMap.keySet()) {
            total += myMap.get(str);
            cSums.add(total);
        }

        return cSums;
    }
    public String get() {
        if(myMap.isEmpty()) {
            return "Empty";
        }
        
        /*
        ArrayList<String> myList = new ArrayList<String>();
        for(String str : myMap.keySet()) {
            for(int i = 0; i < myMap.get(str); i++) {
                myList.add(str);
            }
        }
        */
        // This approach takes linear time and linear space
        Random rnd = new Random();
        int bound = getTotalWeight();
        int randNum = rnd.nextInt(bound);
        ArrayList<Integer> cumulativeSums = getCSums();
        ArrayList<String> keys = new ArrayList<String>();
        for(String str : myMap.keySet()) {
            keys.add(str);
        }

        for(int i = 0; i < keys.size(); i++) {
            if(cumulativeSums.get(i) > randNum) {
                return keys.get(i);
            }
        }

        return "No key found";
    }
    
    public String get2() {
        if(myMap.isEmpty()) {
            return "Empty";
        }
        
        // This approach takes logarithmic time and linear space
        Random rnd = new Random();
        int bound = getTotalWeight();
        int randNum = rnd.nextInt(bound);
        ArrayList<Integer> cumulativeSums = getCSums();
        ArrayList<String> keys = new ArrayList<String>();
        ArrayList<Integer> weights = new ArrayList<Integer>();
        for(String str : myMap.keySet()) {
            keys.add(str);
            weights.add(myMap.get(str));
        }

        int low = 0;
        int high = keys.size() - 1;
        while(low <= high) {
            int guess = (low + high)/2;
            if(cumulativeSums.get(guess) < randNum) {
                low = guess + 1;
            } else if(cumulativeSums.get(guess) - weights.get(guess) > randNum) {
                high = guess - 1;
            } else {
                return keys.get(guess);
            }
        }

        return "No key found";
    }
    
    public static void main(String[] args) {
        MyClass mc = new MyClass();

        if(mc.get().equals("Empty")) {
            System.out.println("PASS");
        }
        
        mc.put("a", 10);
        mc.put("b", 20);
        mc.put("c", 30);
        System.out.println("Run 2: " + mc.get2());
        
        mc.put("a", 40);
        System.out.println("Run 3: " + mc.get2());
    }
}