import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<char[][]> levels;


    public Level() {
        levels = new ArrayList<>();


        char[][] board0 = {
                {'R','R','R','R','R','R','R','R','R','R','R','R','R'},
                {'R','.','.','.','.','.','.','L','R','.','.','.','R'},
                {'R','K','.','.','.','K','.','.','.','.','.','.','R'},
                {'R','L','.','.','R','.','.','.','R','.','.','.','R'},
                {'R','R','R','R','R','R','R','R','R','R','R','R','R'},
        };
        levels.add(board0);


        char[][] board1= {
                {'R','R','R','R','R','R','R','R','R','R','R','R','R'},
                {'R','.','.','.','.','.','.','.','R','.','.','.','R'},
                {'R','.','.','.','.','.','.','.','.','.','.','.','R'},
                {'R','.','.','.','R','.','.','.','R','.','.','.','R'},
                {'R','R','R','R','R','R','R','R','R','R','R','R','R'},
        };
        levels.add(board1);


        char[][] board2 = {
                {'R','R','R','R','R','R','R','R','R','R','R','R','R'},
                {'R','.','K','.','.','.','.','L','R','.','.','.','R'},
                {'R','.','.','.','.','.','.','.','.','.','.','.','R'},
                {'R','.','K','.','R','.','.','L','R','.','.','.','R'},
                {'R','R','R','R','R','R','R','R','R','R','R','R','R'},
        };
        levels.add(board2);

        char[][] board3 = {
                {'R','R','R','R','R','R','R','R','R','R','R','.','K'},
                {'R','.','.','.','.','.','.','L','R','.','.','.','.'},
                {'R','.','.','.','.','.','.','.','.','.','.','.','R'},
                {'R','.','.','.','R','.','.','L','R','.','.','.','R'},
                {'R','R','R','R','R','K','.','R','R','R','R','R','R'},
        };
        levels.add(board3);

        char[][] board4 = {
                {'.','.','K','.','.'},
                {'K','R','.','R','K'},
                {'R','.','.','.','.'},
                {'.','R','.','L','.'},
                {'L','.','.','.','.'},
                {'.','.','L','.','.'},
        };
        levels.add(board4);

        char[][] board5 = {
                {'.','.',' ','.','.'},
                {' ','R','.','R','K'},
                {'R','.','.','.','.'},
                {'.','R','.',' ','L'},
        };
        levels.add(board5);

        char[][] board6 = {
                {'K','R','L','.'},
                {'.','.','.','.'},
                {'R','R','.','L'},
                {'.','K','.','.'},
                {'.','.','.','.'},
        };
        levels.add(board6);
        char[][] board7 = {
                {'.','K','.','K','.','L','.'},
                {'.','.','.','.','.','R','K'},
                {'L','.','R','.','.','.','.'},
                {'.','.','.','.','K','R','.'},
                {'.','.','L','.','R','L','.'},
                {'.','.','R','.','.','.','.'},

        };
        levels.add(board7);
    }



    public List<char[][]> getLevels() {
        return levels;
    }
    public void printLevels(){
        System.out.println("there are alot of levels choose from there");
        for (int i=0;i<levels.size();i++){
            System.out.println("level" + (i + 1));
            printState(levels.get(i));
        }
    }
    void printState(char[][]board){
        System.out.println("------------------------------");
        for (int k=0;k< board.length;k++){
            for (int j=0;j<board[0].length;j++){
                System.out.print(" "+board[k][j]);
            }
            System.out.println();
        }
        System.out.println("------------------------------");

    }

}
