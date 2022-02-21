
public class Playground {

    public static HashMap<Character, HashSet<Character>> graph = new HashMap<>();

    public static void main(String[] args) {

        //graph using chars

        /**
         *
         * Problem: Undirected path between edge list
         *
         * for undirected graphs - used visited array

         edges: [

         [i,j],
         [k, i],
         [m, k],
         [k,l],
         [o,n],


         -- We want to convert edge list to adjacency list for better traversal algos



         */


        char[][] edges = {
                {'i', 'j'},
                {'k', 'i'},
                {'m', 'k'},
                {'k', 'l'},
                {'o', 'n'}
        };

        //Construct graph same size as out edges
        for (int i = 0; i < edges.length; i++) {
            graph.put(edges[i][0], new HashSet<Character>());
            graph.put(edges[i][1], new HashSet<Character>());
        }

        //Add edges within graph
        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        boolean result_1 =  findPath('k', 'o');
        boolean result_2 =  findPath('i', 'l');



        System.out.println(result_1);
        System.out.println(result_2);



    }

    public static boolean findPath(char src, char dest){

        //BFS Implementation -- Time: O(E) E = edges in the graph || Space: O(N) N is the nodes in the graph

        Set<Character> visited = new HashSet<>();

        //Queue for BFS
        Queue<Character> BFS_queue = new LinkedList<>();

        //Add src node to Queue
        BFS_queue.offer(src);


        while(!BFS_queue.isEmpty()){

            //Pop current element from queue and mark as visited
            char currentNode = BFS_queue.poll();
            visited.add(currentNode);

            //If current node is our dest, we have a path
            if(currentNode == dest){
                return true;
            }

            //Traverse neighbors of current Node
            HashSet<Character> neighbors = graph.get(currentNode);


            for(Character node: neighbors){

                //If node already visited, dont add to queue
                if(visited.contains(node)){
                    continue;
                }

                BFS_queue.offer(node);
            }
        }
        return false;
    }
}
