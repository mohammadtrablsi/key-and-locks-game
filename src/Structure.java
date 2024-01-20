import java.lang.constant.DynamicCallSiteDesc;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Structure implements Comparable<Structure> {
    Structure parent;
    Level level;
    char[][] board;
    int cost;
    double costHeu;
    char typeOfHeu='m';

    double M=0.0;
    int typeOFCompareTo;

    public void setTypeOFCompareTo(int typeOFCompareTo) {
        this.typeOFCompareTo = typeOFCompareTo;
    }

    public void setTypeOfHeu(char typeOfHeu) {
        this.typeOfHeu = typeOfHeu;
    }

    public List visited=new LinkedList<>();

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public Structure(char[][] board, int cost) {
        this.board = board;
        this.cost=cost;
        this.costHeu=heurstic();
    }

    public Structure(int cost) {
        UserEnter userEnter=new UserEnter();
        if(userEnter.way==1){
            Scanner scanner = new Scanner(System.in);
            level=new Level();
            level.printLevels();
            System.out.print("Enter the number of level");
             int numberOfLevel = scanner.nextInt();
             board=level.getLevels().get(numberOfLevel - 1);
        }
       else if(userEnter.way==2){
            board=userEnter.getBoard();
//            print();
        }
        this.cost=cost;
        this.costHeu=heurstic();
    }





    public double heurstic(){
        List<Position> keys = new LinkedList<>();
        List<Position> locks = new LinkedList<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if ( board[row][col ]=='K'){

                    keys.add(new Position(row,col));

                }
                else if ( board[row][col ]=='L'){
                    locks.add(new Position(row,col));

                }

            }

        }
        for (int x = 0; x < keys.size(); x++) {
            if(typeOfHeu=='m'){// Calculate manhatin
               M = M + Math.abs(locks.get(x).y - keys.get(x).y) + Math.abs(locks.get(x).x - keys.get(x).x);
            }else if(typeOfHeu=='e'){//Euclidean Distance:
                double distance = Math.sqrt(Math.pow(locks.get(x).y - keys.get(x).y, 2) + Math.pow(locks.get(x).x - keys.get(x).x, 2));
                M = M + distance;
            }else if(typeOfHeu=='c') { //|x2 - x1| + |y2 - y1|  Chebyshev Distance:
                double distance=Math.max(Math.abs(locks.get(x).y - keys.get(x).y), Math.abs(locks.get(x).x - keys.get(x).x));
                 M = M + distance;
            }
        }
        return M;
    }


    public Structure getParent() {
        return parent;
    }


    @Override
    public int compareTo(Structure other) {
        if(typeOFCompareTo==0){//ucs
            if(this.cost>=other.cost)
                return 1;
            else return -1;
        }else if(typeOFCompareTo==1) {//hill
            if(this.costHeu>=other.costHeu)
                return 1;
            else return -1;
        }else  {//a stare
            if(this.costHeu+this.cost>=other.costHeu+other.cost)
                return 1;
            else return -1;
        }
    }

    public int getCost() {
        return cost;
    }
    public double getCostHeu() {
        return costHeu;
    }
    public double getTotalCost() {
        return getCost() + getCostHeu();
    }


    void print(){//function to print the board
        System.out.println("------------------------------");
        for (int i=0;i< board.length;i++){
            for (int j=0;j<board[0].length;j++){
                System.out.print(" "+board[i][j]);
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }


    public Boolean isFinal(){

        for (int row = 0; row < board.length; row++) {
            for (int col = board[0].length - 1; col >= 0; col--) {
                if ( board[row][col ]=='K' || board[row][col ]=='L'){
                    return false;
                }
            }
        }
        return true;
    }

    public  char[][] down() {
    char[][] newBoard=new char[board.length ][board[0].length ];

    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            newBoard[i][j] = board[i][j];
        }
    }
    for (int row = newBoard.length - 1; row >= 0; row--) {
        for (int col = 0; col < newBoard[0].length; col++) {
            if (row < newBoard.length - 1 && newBoard[row][col]=='K') {
                if (newBoard[row + 1][col]!='K' && newBoard[row][col]=='K') {
                    if (newBoard[row + 1][col]!='R') {
                        newBoard[row][col]='.';
                        if (newBoard[row + 1][col]!='L') {
                            newBoard[row + 1][col]='K';
                        } else {
                            newBoard[row + 1][col]='.';
                            newBoard[row][col]='.';
                        }
                    }
                }
            }
        }
    }
    return newBoard;
}


    public char[][]  up() {
        char[][] newBoard2=new char[board.length ][board[0].length ];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard2[i][j] = board[i][j];
            }
        }
        for (int row = 0; row < newBoard2.length; row++) {
            for (int col = 0; col < newBoard2[0].length; col++) {
                if (row > 0 && newBoard2[row][col]=='K') {
                    if (newBoard2[row - 1][col]!='K' && newBoard2[row][col]=='K') {
                        if (newBoard2[row - 1][col]!='R') {
                            newBoard2[row][col]='.';
                            if (newBoard2[row - 1][col]!='L') {
                                newBoard2[row - 1][col]='K';
                            } else {
                                newBoard2[row - 1][col]='.';
                                newBoard2[row][col]='.';
                            }
                        }
                    }
                }
            }
        }
        return newBoard2;
    }

    public char[][]  left() {
        char[][] newBoard3=new char[board.length ][board[0].length ];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard3[i][j] = board[i][j];
            }
        }
        for (int row = 0; row < newBoard3.length; row++) {
            for (int col = 0; col < newBoard3[0].length; col++) {
                if (col > 0 && newBoard3[row][col]=='K') {// edge /  just move for key
                    if (newBoard3[row][col - 1]!='K' && newBoard3[row][col]=='K') {// if have consceutive keys
                        if (newBoard3[row][col - 1]!='R') {//if the next rock for key dont get on rock
                            newBoard3[row][col]='.';
                            if (newBoard3[row][col - 1]!='L') { // to remove lock with key
                                newBoard3[row ][col - 1]='K';
                            } else {
                                newBoard3[row][col - 1]='.';
                                newBoard3[row][col]='.';
                            }

                        }
                    }
                }

            }
        }
        return newBoard3;
    }

    public char[][]  right() {
        char[][] newBoard4=new char[board.length ][board[0].length ];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard4[i][j] = board[i][j];
            }
        }
        for (int row = 0; row < newBoard4.length; row++) {
            for (int col = newBoard4[0].length - 1; col >= 0; col--) {
                if (col < newBoard4[0].length - 1 && newBoard4[row][col]=='K') {
                    // Toggle at the current position
                    if (newBoard4[row][col + 1]!='R') {//2
                        if (newBoard4[row][col + 1]!='K' && newBoard4[row][col]=='K') {
                            newBoard4[row][col]='.';
                            if (newBoard4[row][col + 1]!='L') {
                                newBoard4[row][col + 1]='K';
                            } else {
                                newBoard4[row][col + 1]='.';
                                newBoard4[row][col]='.';
                            }
                        }
                    }
                }
            }
        }
        return newBoard4;
    }

    public List<Structure> getNextState() {
        List<Structure> nextState = new LinkedList<>();

        Structure structure1 = new Structure(right(), 1);
        structure1.parent = this; // Set the parent
        nextState.add(structure1);

        Structure structure2 = new Structure(down(), 2);
        structure2.parent = this;
        nextState.add(structure2);

        Structure structure3 = new Structure(left(), 2);
        structure3.parent = this;
        nextState.add(structure3);

        Structure structure4 = new Structure(up(), 1);
        structure4.parent = this;
        nextState.add(structure4);

        return nextState;
    }


    void printNextState(){
        for (int i=0;i<getNextState().size();i++){
            System.out.println("------------------------------");
            for (int k=0;k< board.length;k++){
                for (int j=0;j<board[0].length;j++){
                    System.out.print(" "+getNextState().get(i).board[k][j]);
                }
                System.out.println();
            }
            System.out.println("------------------------------");

        }
    }



}
