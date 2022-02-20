/**

Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.


**/ 


public class Playground {

    public static HashMap<Character, List<Character>> graph = new HashMap<>();

    public static void main(String[] args){

        //graph using chars

        char[][] input = {
                {'b', 'c'},
                {'d'},
                {'e'},
                {'f'},
                {},
                {}
        };


        graph.put('a', Arrays.asList('b','c'));
        graph.put('b', Arrays.asList('d'));
        graph.put('c', Arrays.asList('e'));
        graph.put('d', Arrays.asList('f'));
        graph.put('e', Arrays.asList());
        graph.put('f', Arrays.asList());

        //DFS(graph, 'a');

        BFS(graph, 'a');
    }



    public static void BFS(HashMap<Character, List<Character>> graph, char start){

        //Create a queue for BFS

        Queue<Character> queue = new LinkedList<>();

        System.out.println("BFS of graph is: ");
        queue.add(start);
        while(!queue.isEmpty()){
            char current = queue.poll();

            //Process Node after it leaves the queue
            System.out.println(current);
            List<Character> values = graph.get(current);
            for(int i =0; i< values.size(); i++){
                queue.add(values.get(i));
            }
        }

        //Output: a b c d e f -- Note graph can have many BFS traversals

        System.out.println("BFS of graph is Complete");
    }
}
