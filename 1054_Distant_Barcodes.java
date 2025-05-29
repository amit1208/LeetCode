import java.util.*;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int code : barcodes) {
            countMap.put(code, countMap.getOrDefault(code, 0) + 1);
        }

        // Max-heap based on frequency
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] result = new int[barcodes.length];
        int i = 0;

        while (!maxHeap.isEmpty()) {
            List<int[]> temp = new ArrayList<>();
            int count = Math.min(2, barcodes.length - i); // Fill up to 2 elements at a time

            for (int j = 0; j < count && !maxHeap.isEmpty(); j++) {
                int[] current = maxHeap.poll();
                result[i++] = current[0];
                current[1]--;

                if (current[1] > 0) {
                    temp.add(current);
                }
            }

            for (int[] pair : temp) {
                maxHeap.offer(pair);
            }
        }

        return result;
    }
}
