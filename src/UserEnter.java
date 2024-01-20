import java.util.Scanner;

public class UserEnter {

    Scanner scanner = new Scanner(System.in);
    char[][] board;
    int way;


    UserEnter() {
        System.out.println("if you want to choose form levels Enter 1 or if you want to make your board enter 2");
          way = scanner.nextInt();

        if (way == 2) {
            System.out.print("Enter the number of rows: ");
            int numRows = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            int numCols = scanner.nextInt();
            board = new char[numRows][numCols];
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    board[row][col] = '.';
                }
            }


            System.out.print("Enter the number of Rocks: ");
            int numRock = scanner.nextInt();
            if (numRock > numCols * numRows) {
                System.out.println("warning: you should enter number of rocks between 0.." + numCols * numRows);
                System.out.print("Enter the number of Rocks: ");
                numRock = scanner.nextInt();
                for (int num = 0; num < numRock; num++) {
                    System.out.print("Enter the row number");
                    int userRow = scanner.nextInt();
                    System.out.print("Enter the column number");
                    int userCol = scanner.nextInt();
                    board[userRow][userCol] = 'R';
                }
            } else {
                for (int num = 0; num < numRock; num++) {
                    System.out.print("Enter the row number");
                    int userRow = scanner.nextInt();
                    System.out.print("Enter the column number");
                    int userCol = scanner.nextInt();
                    board[userRow][userCol] = 'R';

                }
            }


            System.out.print("Enter the number of keys: ");
            int numKey = scanner.nextInt();
            if (numKey > numCols * numRows - numRock) {
                System.out.println("warning: you should enter number of keys between 0.." + (numCols * numRows - numRock));
                System.out.print("Enter the number of keys: ");
                numKey = scanner.nextInt();
                for (int num = 0; num < numKey; num++) {
                    System.out.print("Enter the row number");
                    int userRow = scanner.nextInt();
                    System.out.print("Enter the column number");
                    int userCol = scanner.nextInt();
                    board[userRow][userCol] = 'K';
                }
            } else {
                for (int num = 0; num < numKey; num++) {
                    System.out.print("Enter the row number");
                    int userRow = scanner.nextInt();
                    System.out.print("Enter the column number");
                    int userCol = scanner.nextInt();
                    board[userRow][userCol] = 'K';

                }
            }


            System.out.print("Enter the number of Locks: ");
            int numLock = scanner.nextInt();
            if (numLock > (numCols * numRows) - (numRock + numKey)) {
                System.out.println("warning: you should enter number of locks between 0.." + ((numCols * numRows) - (numRock + numKey)));
                System.out.print("Enter the number of Locks: ");
                numLock = scanner.nextInt();
                for (int num = 0; num < numLock; num++) {
                    System.out.print("Enter the row number");
                    int userRow = scanner.nextInt();
                    System.out.print("Enter the column number");
                    int userCol = scanner.nextInt();
                    board[userRow][userCol] = 'L';
                }
            } else {
                for (int num = 0; num < numLock; num++) {
                    System.out.print("Enter the row number");
                    int userRow = scanner.nextInt();
                    System.out.print("Enter the column number");
                    int userCol = scanner.nextInt();
                    board[userRow][userCol] = 'L';
                }
            }
        }

    }

    public char[][] getBoard() {
        return board;
    }
}
