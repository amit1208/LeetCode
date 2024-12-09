import java.util.HashMap;

public class max_repeated {
    public static int findMaxRepeated(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxElement = -1;

        // Populate the frequency map
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxElement = entry.getKey();
            }
        }

        return maxElement;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 5, 3, 2, 1, 1, 1};

        int result = findMaxRepeated(arr);
        System.out.println("Maximum repeated element: " + result);
    }
}
