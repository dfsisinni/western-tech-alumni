import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;

public class Week1 {

    public static void main(String[] args) {
        String phrase = "aaaa";
        System.out.println(palindromeCheck(phrase));

        //spiralMatrix(12);

        //int [] a = {3,4,5,6,3,3};
        //int [] b = {3,5,3,3, 5,5,5,4};

        //System.out.println(Arrays.toString(intersect(a, b)));
    }

    public int lengthOfLongestSubstring (String s) {
        HashMap <Character, Integer> map = new HashMap <Character, Integer>();

        int last = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put('s', i);
            }
        }
        return -1;
    }


    public static Integer [] intersect(int[] nums1, int[] nums2) {
        HashSet <Integer> nums = new HashSet<Integer>();
        HashSet <Integer> intersection = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            nums.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums.contains(nums2[i])) {
                intersection.add(nums2[i]);
            }
        }

        return intersection.toArray(new Integer[intersection.size()]);
    }

    public static int [] [] spiralMatrix (int n) {
        int arr [] [] = new int [n][n];

        int row = 0, col = 0;
        int rowMax = n - 1, colMax = n - 1;
        int count = 1;


        while (row <= rowMax && col <= colMax) {
            for (int i = col; i <= colMax; i++) {
                arr [row][i] = count;
                count ++;
            }
            row++;

            for (int i = row; i <= rowMax; i++) {
                arr[i][colMax] = count;
                count ++;
            }
            colMax--;

            for (int i = colMax; i >= col; i--) {
                arr[rowMax][i] = count;
                count ++;
            }
            rowMax--;

            for (int i = rowMax; i >= row; i--) {
                arr[i][col] = count;
                count++;
            }
            col++;
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
