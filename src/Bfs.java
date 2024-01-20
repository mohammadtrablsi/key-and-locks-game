



import java.util.*;


public class Bfs {
    Queue<Structure> queue = new LinkedList<>();

    public List<Structure> visited=new LinkedList<>();
    int count=0;
    Structure s;

    public Bfs(Structure s) {
        this.s=s;
        queue.add(s);
        printBfs();
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

    public void printBfs() {
        visited.add(s);
        while (!queue.isEmpty()) {
            count++;
            Structure item = queue.poll();
            item.print();
            if (item.isFinal()) {
                System.out.println("\u001B[32m"+"success bfs"+"\u001B[0m");
                System.out.println();
                System.out.println();
                System.out.println("\u001B[34m"+"start the array of path"+"\u001B[0m");
                List<Structure> path = getPath(item);
                for (Structure step : path) {
                    step.print();
                }
                System.out.println("\u001B[34m"+"end the array of path"+"\u001B[0m");
                System.out.println("\u001B[32m"+"done bfs"+"\u001B[0m");
                System.out.println("\u001B[32m"+count+"\u001B[0m");
                return;
            } else {
                for (int i=0;i<item.getNextState().size();i++){
                    if (!forVisited(item.getNextState().get(i))) {
                        queue.add(item.getNextState().get(i));
                        visited.add(item.getNextState().get(i));
                    }
                }
            }
        }
    }

    public boolean isEqual(Structure item1,Structure item2){
        for (int j=0;j<item1.board.length;j++){
            for (int k=0;k<item1.board[0].length;k++){
                if(item2.board[j][k]!=item1.board[j][k]){
                    return false;
                }
            }
        }
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





