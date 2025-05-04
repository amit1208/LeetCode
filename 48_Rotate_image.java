class Solution {
    public void rotate(int[][] matrix) {

    int[][] copy = new int[matrix.length][];
    for (int i = 0; i < matrix.length; i++) {
        copy[i] = matrix[i].clone();
    }       


    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            matrix[j][matrix.length-i-1]=copy[i][j];
            }
        }
    }
}



class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
