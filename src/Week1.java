import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Week1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //STRING PROBLEM - VALID PALINDROME
        System.out.println("STRING PROBLEM - VALID PALINDROME");
        System.out.println("Enter a phrase to check if it is a palindrome: ");
        String phrase = scanner.nextLine();
        if(palindromeCheck(phrase)) {
            System.out.println(phrase + " is a valid palindrome!");
        } else {
            System.out.println(phrase + " is not a valid palindrome!");
        }
        System.out.println("\n\n");


        //ARRAY PROBLEM - SPIRAL MATRIX
        System.out.println("ARRAY PROBLEM - SPIRAL MATRIX");


        String in = null;
        int num = 0;
        while (in == null) {
            System.out.println("Enter the size of the spiral matrix: ");
            in = scanner.nextLine();
            try {
                num = Integer.parseInt(in);
            } catch (Exception ex) {
                in = null;
            }
        }
        int ar [][] = spiralMatrix(num);
        for (int i = 0; i < ar[0].length; i++) {
            printRow(ar[i]);
        }

        System.out.println("\n\n");

        //HASHMAP PROBLEM - LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS
        String check = null;
        System.out.println("HASH MAP PROBLEM - LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS");
        System.out.println("Enter a phrase to determine the length of the longest substring w/o repeating characters: ");
        check = scanner.nextLine();
        System.out.println("The length of the longest substring is: " + lengthOfLongestSubstring(check));
    }

    public static int lengthOfLongestSubstring (String s) {
        HashMap<Character, Integer> map = new HashMap <Character,Integer> ();

        int minLetter = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {

                int length = i - minLetter;
                if (length > max) {
                    max = length;
                }

                int letter = map.get(s.charAt(i)) + 1;
                minLetter = letter;

                map.entrySet().removeIf(p -> p.getValue() < letter);
            }

            map.put(s.charAt(i), i);
        }

        if (max == 0 && minLetter == 0) {
            return s.length();
        }

        int length = s.length() - minLetter;
        if (length > max) {
            return length;
        }

        return max;
    }

    public static int [] [] spiralMatrix (int n) {
        int arr [] [] = new int [n][n];

        int rowMin = 0, colMin = 0;
        int rowMax = n - 1, colMax = n - 1;
        int count = 1;


        while (rowMin <= rowMax && colMin <= colMax) {
            for (int i = colMin; i <= colMax; i++) {
                arr [rowMin][i] = count;
                count ++;
            }
            rowMin++;

            for (int i = rowMin; i <= rowMax; i++) {
                arr[i][colMax] = count;
                count ++;
            }
            colMax--;

            for (int i = colMax; i >= colMin; i--) {
                arr[rowMax][i] = count;
                count ++;
            }
            rowMax--;

            for (int i = rowMax; i >= rowMin; i--) {
                arr[i][colMin] = count;
                count++;
            }
            colMin++;
        }

        return arr;
    }

    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    public static boolean palindromeCheck(String phrase) {
        phrase = phrase.replaceAll("[^a-zA-Z0-9]", "");
        phrase = phrase.toLowerCase();

        int j = phrase.length() - 1;
        for (int i = 0; i < j; i++, j--) {
            if (phrase.charAt(i) != phrase.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
