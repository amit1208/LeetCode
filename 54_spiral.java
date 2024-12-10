class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> al = new ArrayList<>();
        int top = 0;
        int right = n - 1;
        int bottom = m - 1;
        int left = 0;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                al.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                al.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    al.add(matrix[bottom][i]);
                }
            }
            bottom--;

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    al.add(matrix[i][left]);
                }
            }
            left++;
        }
        return al;
    }
}