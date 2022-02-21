public class Playground{
        
public static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

public static int countConnectedComponents(){

        int currentCount = Integer.MIN_VALUE;
        int maxCount = Integer.MIN_VALUE;

        HashSet<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer, HashSet<Integer>> entry: graph.entrySet()) {

            boolean newComp = DFS(visited, entry.getKey(), currentCount);

            //If new component was explored, incremenet count
            if (newComp == true) {
                maxCount = Math.max(currentCount, maxCount);
            }
        }
        return maxCount;

        //Output should be 4
    }

    public static boolean  DFS(HashSet<Integer> visited, int key, int count){

        //If already explored a component return false
        if(visited.contains(key)){
            return false;
        }

        visited.add(key);
        HashSet<Integer> nodes = graph.get(key);
        for(int node: nodes){
            count++;
            DFS(visited, node, count);
        }
    return true;

    }
