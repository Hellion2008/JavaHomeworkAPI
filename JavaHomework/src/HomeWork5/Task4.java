package HomeWork5;

public class Task4 {
    static final int COLUMN = 8;
    static int[] positions = new int[COLUMN];
    static int count = 0;


    public static void main(String[] args) {
        createBoard(0);
    }

    static void createBoard(int row) {
        if (row == COLUMN) {
            showBoard();
            return;
        }
        for (int col = 0; col < COLUMN; col++) {
            if (isHit(row, col)) {
                positions[row] = col;
                createBoard(row + 1);
            }
        }
    }

    static boolean isHit(int row, int col) {
        for (int i = 0; i < row; i++) {
            int position = positions[i];
            if (position == col || position - i == col - row || position + i == col + row) {
                return false;
            }
        }
        return true;
    }

    static void showBoard() {
        System.out.println(++count + ": ");
        for (int row = 0; row < COLUMN; row++) {
            for (int col = 0; col < COLUMN; col++) {
                System.out.print(positions[row] == col ? "* " : "- ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
