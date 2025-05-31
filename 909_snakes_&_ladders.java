import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flat = new int[n * n + 1];  // 1-indexed
        int idx = 1;
        boolean leftToRight = true;

        // Flatten the 2D board to 1D with boustrophedon order
        for (int row = n - 1; row >= 0; row--) {
            if (leftToRight) {
                for (int col = 0; col < n; col++) {
                    flat[idx++] = board[row][col];
                }
            } else {
                for (int col = n - 1; col >= 0; col--) {
                    flat[idx++] = board[row][col];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        q.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int curr = q.poll();
                if (curr == n * n) return moves;
                for (int i = 1; i <= 6 && curr + i <= n * n; i++) {
                    int next = curr + i;
                    if (flat[next] != -1) {
                        next = flat[next];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}
