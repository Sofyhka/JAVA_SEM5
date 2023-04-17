public class task3 {
    // На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8
    Integer n = 8;
    int[][] board = new int[n][n];
    public static void main(String[] args) {
        task3 chessboard = new task3();
        chessboard.placeQueen(0, 0);
        chessboard.PrintBoard();
    }
    public void PrintBoard(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean Safe(int row, int col) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 1 || board[i][col] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean placeQueen(int row, int col) {
        if (col >= n) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (Safe(i, col)) {
                board[i][col] = 1;
                if (placeQueen(0, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }
}
