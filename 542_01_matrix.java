class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int max = m + n;
        int[][] arr=new int[m][n];

        for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(mat[i][j]==0){arr[i][j]=0;}

            else{
                    int top = i > 0 ? arr[i - 1][j] : max;
                    int left = j > 0 ? arr[i][j - 1] : max;
                    arr[i][j] = Math.min(top, left) + 1;            }
        }
        }
               for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int bottom = i < m - 1 ? arr[i + 1][j] : max;
                    int right = j < n - 1 ? arr[i][j + 1] : max;
                    arr[i][j] = Math.min(arr[i][j], Math.min(bottom, right) + 1);
                }
            }
        }
        return arr;
    }
}



// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;

//         int[][] dist = new int[m][n];
//         boolean[][] visited = new boolean[m][n];
//         Queue<int[]> q = new LinkedList<>();

//         // Add all 0s to queue initially
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (mat[i][j] == 0) {
//                     q.add(new int[]{i, j});
//                     visited[i][j] = true;
//                 }
//             }
//         }

//         // Directions for moving: up, right, down, left
//         int[] dx = {-1, 0, 1, 0};
//         int[] dy = {0, 1, 0, -1};

//         // Start BFS
//         while (!q.isEmpty()) {
//             int[] cell = q.poll();
//             int row = cell[0];
//             int col = cell[1];

//             for (int k = 0; k < 4; k++) {
//                 int newRow = row + dx[k];
//                 int newCol = col + dy[k];

//                 if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
//                     dist[newRow][newCol] = dist[row][col] + 1;
//                     visited[newRow][newCol] = true;
//                     q.add(new int[]{newRow, newCol});
//                 }
//             }
//         }

//         return dist;
//     }
// }
