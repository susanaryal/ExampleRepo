import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    // Function maxSum to calculate the maximum sum almong all hour glasses in the
    // given 2D array.
    public static int maxSum(int[][] arr) {
        int maxSumValue = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i < 4 && j < 4) {
                    int sum = 0;
                    sum += arr[i][j] + arr[i][j + 1] + arr[i][j + 2]; // Three items in first row.
                    sum += arr[i + 1][j + 1]; // The middle item in second row.
                    sum += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]; // Three items in third row.
                    if (sum > maxSumValue) {
                        maxSumValue = sum;
                    }
                }
            }
        }
        return maxSumValue;
    }

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        // Reading from the input file into a 2D array.
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();

        // Calling the function maxSum to find the maximun sum and displaying it.
        System.out.println(maxSum(arr));
    }
}