import java.util.*;

class Solution {
    // Define the possible directions (up, right, down, left)
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        
        // Create a priority queue for BFS, ordering by time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        // Create a visited array to keep track of minimum time to reach each cell
        // Initialize with Integer.MAX_VALUE (infinity)
        int[][] minTime = new int[n][m];
        for (int[] row : minTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Start from (0,0) at time 0
        pq.offer(new int[]{0, 0, 0});
        minTime[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];
            
            // If we've reached the destination, return the time
            if (row == n - 1 && col == m - 1) {
                return time;
            }
            
            // If we've already found a better path to this cell, skip
            if (time > minTime[row][col]) {
                continue;
            }
            
            // Try all four directions
            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // Check if the new position is valid
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    // Calculate the new time (current time + 1 second for the move)
                    int newTime = time + 1;
                    
                    // We can only enter the room if the new time is at least moveTime[newRow][newCol]
                    newTime = Math.max(newTime, moveTime[newRow][newCol]);
                    
                    // If we found a better path to this cell, update and add to queue
                    if (newTime < minTime[newRow][newCol]) {
                        minTime[newRow][newCol] = newTime;
                        pq.offer(new int[]{newRow, newCol, newTime});
                    }
                }
            }
        }
        
        // If we can't reach the destination (shouldn't happen given the constraints)
        return -1;
    }
}