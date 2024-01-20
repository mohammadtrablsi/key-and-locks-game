import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Structure structure=new Structure(0);
        structure.print();

        System.out.println("Enter the algorithm (f for Dfs, b for Bfs, u for Ucs,i for user play,h Hill ,aStare g): ");

        while (true) {

            String input = scanner.next();


            switch (input.toUpperCase()) {
                case "F":
                    Dfs dfs=new Dfs(structure);
                    break;

                case "B":
                    Bfs bfs=new Bfs(structure);
                    break;

                case "U":
                    structure.setTypeOFCompareTo(0);//0 for ucs
                    Ucs ucs = new Ucs(structure);
                    ucs.printUcs();
                    int cost = ucs.getCost();
                    break;

                case "I":
                    User user=new User(structure);
                    user.makeMoves();
                    break;

                case "H":
                    structure.setTypeOFCompareTo(1);//1 for hill climbing
                    hillClimbing hill=new hillClimbing(structure);
                    break;

                case "G":
                    structure.setTypeOFCompareTo(2);//2 for a stare
                    AStare aStare=new AStare(structure);
                    break;

                default:
                    System.out.println("Invalid value. Try again.");
                    break;
            }
        }
    }
}