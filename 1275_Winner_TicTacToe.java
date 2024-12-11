public class Solution {
    public String tictactoe(int[][] moves) {

        char[][] grid = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }

        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            grid[row][col] = (i % 2 == 0) ? 'X' : 'O'; // 'X' for A, 'O' for B
        }

        // Check rows for a winner
        for (int h = 0; h < 3; h++) {
            if (grid[h][0] != ' ' && grid[h][0] == grid[h][1] && grid[h][1] == grid[h][2]) {
                return (grid[h][0] == 'X') ? "A" : "B";
            }
        }

        // Check columns for a winner
        for (int v = 0; v < 3; v++) {
            if (grid[0][v] != ' ' && grid[0][v] == grid[1][v] && grid[1][v] == grid[2][v]) {
                return (grid[0][v] == 'X') ? "A" : "B";
            }
        }

        // Check diagonals for a winner
        if (grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return (grid[0][0] == 'X') ? "A" : "B";
        }
        if (grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return (grid[0][2] == 'X') ? "A" : "B";
        }

        // Check if the game is a draw or still pending
        return (moves.length == 9) ? "Draw" : "Pending";
    }
}
