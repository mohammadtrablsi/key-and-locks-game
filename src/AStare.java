import java.util.*;

public class AStare {


        int count=0;
        public List<Structure> visited = new LinkedList<>();

        private PriorityQueue<Structure> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Structure::getTotalCost));
        private int cost;
        Structure s;

        public AStare(Structure s) {
            this.s=s;
            priorityQueue.add(s);
            cost = 0;
            printAStar();
        }

        public int getCost() {
            return cost;
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
        public void printAStar() {
            visited.add(s);
            while (!priorityQueue.isEmpty()) {
                count++;
                Structure item = priorityQueue.poll();
                    item.print();
                    if (item.isFinal()) {
                        System.out.println("\u001B[32m"+"Astare count: " + count+"\u001B[0m");
                        System.out.println();
                        System.out.println();
                        priorityQueue.clear();
                        System.out.println("\u001B[34m"+"start the array of path"+"\u001B[0m");
                        List<Structure> path = getPath(item);
                        for (Structure step : path) {
                            step.print();
                        }
                        System.out.println("\u001B[34m"+"end the array of path"+"\u001B[0m");
                        System.out.println("\u001B[32m"+"done  Astare Count: " + count+"\u001B[0m");
                        System.out.println("\u001B[32m"+ "opened nodes:"+(path.size()-2)+"\u001B[0m");
                        System.out.println("\u001B[32m"+"done  hill Cost: " + item.getCost()+"\u001B[0m");
                        return;
                    } else {
                        for (Structure nextState : item.getNextState()) {
                            if (!forVisited(nextState)) {
                                int newCost = item.getCost() + nextState.cost;
                                nextState.cost = newCost;
                                priorityQueue.add(nextState);
                                visited.add(nextState);
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






