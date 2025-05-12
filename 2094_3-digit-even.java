import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        Set<Integer> resultSet = new TreeSet<>(); // auto-sorted and unique

        for (int i = 100; i <= 999; i += 2) { // check only even numbers
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;

            // temporarily decrement
            count[a]--; count[b]--; count[c]--;
            if (count[a] >= 0 && count[b] >= 0 && count[c] >= 0) {
                resultSet.add(i);
            }
            // restore counts
            count[a]++; count[b]++; count[c]++;
        }

        // Convert Set to int[]
        int[] res = new int[resultSet.size()];
        int idx = 0;
        for (int num : resultSet) {
            res[idx++] = num;
        }

        return res;
    }
}

// class Solution {
//     public int[] findEvenNumbers(int[] digits) {

//         Set<Integer> result = new HashSet<>();

//         int n = digits.length;

//         // Try all combinations of i, j, k as different indices
//         for (int i = 0; i < n; i++) {
//             if (digits[i] == 0) continue; // Skip if first digit is 0 (leading 0 invalid)

//             for (int j = 0; j < n; j++) {
//                 if (i == j) continue;

//                 for (int k = 0; k < n; k++) {
//                     if (k == i || k == j) continue;

//                     int num = digits[i] * 100 + digits[j] * 10 + digits[k];

//                     // Check if number ends with an even digit
//                     if (num % 2 == 0) {
//                         result.add(num);
//                     }
//                 }
//             }
//         }

//         // Convert set to list and sort it
//         List<Integer> sortedResult = new ArrayList<>(result);
//         Collections.sort(sortedResult);

//         int[] arr = new int[sortedResult.size()];
// for (int i = 0; i < sortedResult.size(); i++) {
//     arr[i] = sortedResult.get(i);
// }


//         return arr;
//     }
// }
