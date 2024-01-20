import java.util.Scanner;

public class User {
    private Structure structure;

    public User(Structure structure) {
        this.structure = structure;
    }

    public void makeMoves() {
        Scanner scanner = new Scanner(System.in);
        structure.print();
        System.out.println("Enter a move (S for DOWN, W for UP, A for LEFT, D for RIGHT): ");

        while (true) {

            String input = scanner.next();


            switch (input.toUpperCase()) {
                case "S":
                    printState(new Structure(structure.down(),2).board);
                    structure.setBoard(new Structure(structure.down(),2).board);
                    if (structure.isFinal()){
                        System.out.println("final");
                    }
                    break;

                case "W":
                    printState(new Structure(structure.up(),1).board);
                    structure.setBoard(new Structure(structure.up(),1).board);
                    if (structure.isFinal()){
                        System.out.println("final");
                    }
                    break;

                case "A":
                    printState(new Structure(structure.left(),2).board);
                    structure.setBoard(new Structure(structure.left(),2).board);
                    if (structure.isFinal()){
                        System.out.println("final");
                    }
                    break;

                case "D":
                    printState(new Structure(structure.right(),1).board);
                    structure.setBoard(new Structure(structure.right(),1).board);
                    if (structure.isFinal()){
                        System.out.println("final");
                    }
                    break;

                default:
                    System.out.println("Invalid move. Try again.");
                    break;
            }
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
