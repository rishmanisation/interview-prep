import java.util.*;

/*
 * This class contains implementations for all problems in Chapter 1: Arrays and Strings
 * except Problem 1.2, which has been implemented separately in C++. 
 */

public class Chapter1 {

    /*
     * 1.1 Function to determine if a string has all unique characters.
     * Assumption: String is an (extended) ASCII string.
     */
    static boolean hasAllUniqueChars(String str) {
        boolean[] charTracker = new boolean[256]; //ASCII char set has 256 characters
        
        /*
        * Since there are only 256 ASCII characters, there has to be repeated characters in a string
        * that is longer than 256 characters.
        */
        if(str.length() > 256) {
            return false;
        }

        for(int i = 0; i < str.length(); i++) {
            int charVal = str.charAt(i);

            /*
            * If the index corresponding to the ASCII value of the current character is 'true',
            * the character has already occurred in the string.  
            */
            if(charTracker[charVal]) {
                return false;
            }

            charTracker[charVal] = true;
        }

        return true;
    }

    /* 
     * 1.3 Check if one string is a permutation of the other.
     * Assumptions: 
     * 1. Case doesn't matter (e.g. "God" is a permutation of "Dog").
     * 2. Spaces etc. do matter (e.g. "god   " is not a permutation of "dog") 
     * Implementation 1: By sorting the strings.
    */
    static boolean isPermutation1(String s1, String s2) {

        /*
        * If the strings are not of the same length, then they cannot be permutations.
        */
        if(s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        c1.sort();
        c2.sort();

        /*
        * If the arrays are exactly the same, then the strings are permutations.
        */
        for(int i = 0; i < c1.length; i++) {
            if(c1[i] != c2[i]) {
                return false;
            }
        }

        return true;
    }

    /*
    * 1.3 Implementation 2: By checking if the strings have identical character counts.
    * Assumptions: 
    * 1. String has only ASCII characters.
    * 2. All assumptions for implementation 1.
    */
    static boolean isPermutation2(String s1, String s2) {

        /*
        * If the strings are of different lengths, they cannot be permutations.
        */
        if(s1.length() != s2.length()) {
            return false;
        }

        /*
        * Obtain the counts of all characters in the first string.
        */
        int[] counts = new int[256];
        for(int i = 0; i < s1.length(); i++) {
            int charVal1 = s1.charAt(i);
            counts[charVal1]++;
        }
        
        /*
        * Iterate through the second string and decrement the counts for each occurrence
        * of the corresponding character. If any count drops below zero during the iteration,
        * then the second string cannot be a permutation of the first.
        */
        for(int i = 0; i < s2.length(); i++) {
            int charVal2 = s2.charAt(i);
            if(--counts[charVal2] < 0) {
                return false;
            }
        }

        return true;
    }

    /*
     * 1.4 Implementation 1: 
     * Function to replace all occurences of spaces within a string with "%20".  
     * Example: "Mr John Smith" becomes "Mr%20John%20Smith".
     * Assumptions: 
     * 1. The string has sufficient space at the end to accomodate extra characters.
     * 2. The true length of the string (i.e. the length of the original string) is 
     * given. In the case of "Mr John Smith", this is 13.
     * 3. String is given as a char array in order to perform the operation in-place.
     * A second implementation will focus on an out-of-place implementation.
     */
    static void replaceSpaces1(char[] str, int trueLength) {
        /*
         * First, iterate through the string and count how many spaces are present. 
         */
        int spaceCount = 0;
        for (char c : str) {
            if(c == ' ') {
                spaceCount++;
            }
        }

        /*
         * Since we are going to be adding two new characters per space, the length
         * of the new string is the true length + 2 * number of spaces. Once we have 
         * done this, iterate through the string again in reverse order.
         * 
         * 1. If the character is a space, then we use three characters to replace it 
         * with '%20' and decrement newLength by 3.
         * 2. Otherwise, we add the character to its new position and decrement 
         * newLength by 1.
         */
        int newLength = trueLength + 2*spaceCount;
        str[newLength] = '\0';
        for(int i = trueLength - 1; i <= 0; i--) {
            if(str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                str[newLength - 1] = str[i];
                newLength--;
            }
        }
    }

    /*
     * 1.4 Implementation 2: Out-of-place implementation. Note that we are returning
     * a new string (since Java strings are immutable) and we don't actually need the
     * true length of the string (or any string length for that matter).
     */
    static String replaceSpaces2(String str) {
        /*
         * Split the original string using spaces, and then add each word followed by "%20"
         * to a new string. Then, add the last word to the new string and return it.
         */
        String result = "";
        String[] content = str.split(" ");
        for(int i = 0; i < content.length - 1; i++) {
            result += content[i] + "%20";
        }
        result = result + content[content.length - 1];
        return result;
    }

    /*
     * The below function is a helper function , which finds the size of 
     * the compressed string. 
     */
    int getCompressedStringSize(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        char lastChar = str.charAt(0);
        int count = 1;
        int size = 0;
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == lastChar) {
                count++;
            } else {
                size += 1 + String.valueOf(count).length();
                lastChar = str.charAt(i);
                count = 1;
            }
        }

        size += 1 + String.valueOf(count).length();
        return size;
    }

    /*
     * 1.5 Implementation 1 (Sub-optimal): 
     * Function to compress a string using the counts of repeated characters.
     * Example: "aaabbcccccdaa" -> "a3b2c4d1a2"
     * If the compressed string is not smaller than the original string (i.e. longer
     * or of the same length), return the original string.
     */
    static String countCompress1(String str) {
        
        /*
         * If string is null/empty, shorter or of equal length to the compressed string,
         * return it as is. 
         */
        if(str == null || str.isEmpty() || str.length() <= getCompressedStringSize(str)) {
            return str;
        }

        /*
         * lastChar -> last character visited
         * count -> frequency of lastChar
         * Iterate through the string and append the lastChar and its count when we encounter
         * a different character. The reason this algorithm is sub-optimal is because appending
         * to a string happens in quadratic time. 
         */
        String result = "";
        char lastChar = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == lastChar) {
                count++;
            } else {
                result += lastChar + count;
                lastChar = str.charAt(i);
                count = 1;
            }
        }

        /*
         * We need to account for the last character(s) in the string as well.
         */
        return result + lastChar + count;
    }

    /*
     * 1.5 Implementation 2: Optimal using StringBuffer
     */
    static String countCompress2(String str) {
       
        int size = getCompressedStringSize(str);
        if(str == null || str.isEmpty() || str.length() <= size) {
            return str;
        }

        /* 
         * Same as implementation 1, except we are appending to a StringBuffer. 
        */
        StringBuffer myStr = new StringBuffer();
        char lastChar = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == lastChar) {
                count++;
            } else {
                myStr.append(lastChar);
                myStr.append(count);
                lastChar = str.charAt(i);
                count = 1;
            }
        }

        myStr.append(lastChar);
        myStr.append(count);
        return myStr.toString();
    }

    /*
     * 1.5 Implementation 3: Optimal without StringBuffer (coming soon)
     */

    /*
     * 1.6 Function to rotate an N x N matrix by 90 degrees (clockwise).
     * Implementation 1: Out-of-place 
     * 1 2 3         7 4 1     
     * 4 5 6   -->   8 5 2  
     * 7 8 9         9 6 3
     */
    static int[][] rotate1(int[][] image) {
        int N = image.length;
        int[][] rotatedImage = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                rotatedImage[i][j] = image[N - i - 1][j];
            }
        }
        return rotatedImage;
    }

    /*
     * 1.6 Implementation 2: In-place rotation. 
     */
    static void rotate2(int[][] image) {
        int N = image.length;
        for(int i = 0; i < N/2; i++) {
            int first = i;
            int last = N - i - 1;
            for(int j = first; j <= last; j++) {
                int temp = i - first;
                int top = image[first][j];
                image[first][j] = image[last - temp][first];
                image[last - temp][first] = image[last][last - temp];
                image[last][last - temp] = image[j][last];
                image[j][last] = top;
            }
        }
    }

}
