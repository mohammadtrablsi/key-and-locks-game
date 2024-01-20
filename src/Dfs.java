



import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Dfs {
    Stack<Structure> stack = new Stack<>();

    public List<Structure> visited=new LinkedList<>();
    Structure s;
    int count=0;

    public Dfs(Structure s) {
        this.s=s;
        stack.push(s);
        printDfs();
    }
    public List<Structure> getPath(Structure goal) {
        List<Structure> path = new LinkedList<>();
        Structure current = goal;

        while (current != null) {
            path.add(current);
            current = current.getParent();
        }

        Collections.reverse(path); // Reverse the path to get it from start to end
        return path;
    }
    public void printDfs() {
        visited.add(s);
        while (!stack.isEmpty()) {
            count++;
            Structure item = stack.pop();
                item.print();
                if (item.isFinal()) {
                    System.out.println("\u001B[32m"+"success dfs"+"\u001B[0m");
                    System.out.println();
                    System.out.println();
                    System.out.println("\u001B[34m"+"start the array of path"+"\u001B[0m");
                    List<Structure> path = getPath(item);
                    for (Structure step : path) {
                        step.print();
                    }
                    System.out.println("\u001B[34m"+"end the array of path"+"\u001B[0m");
                    System.out.println("\u001B[32m"+"done dfs"+"\u001B[0m");
                    System.out.println("\u001B[32m"+count+"\u001B[0m");
                    return;
                } else {
                    for (int i=0;i<item.getNextState().size();i++){
                        if (!forVisited(item.getNextState().get(i))) {
                            stack.push(item.getNextState().get(i));
                            visited.add(item.getNextState().get(i));
                        }
                    }
                }
        }
    }

    public boolean isEqual(Structure item1,Structure item2){
//        for (int i=0;i<visited.size();i++){
            for (int j=0;j<item1.board.length;j++){
                for (int k=0;k<item1.board[0].length;k++){
                    if(item2.board[j][k]!=item1.board[j][k]){
                        return false;
                    }
                }
            }
//        }
        return true;
    }

    public boolean forVisited(Structure item){
        for (int i=0;i<visited.size();i++){
           if( isEqual(visited.get(i),item)){
               return true;
           }
        }
       return false;
    }
}





