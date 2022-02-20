/**

Time: O(e) = e is the edges -- in the worst case we can have (nodes)^2 = edges so we just take edges as the time complexity 

Space: O(n) n is the nodes in the graph on the stack 

**/ 



public class Playground {

    public static HashMap<Character, List<Character>> graph = new HashMap<>();

    public static void main(String[] args){

        //graph using chars

        /**
         *
         * Problem: Directed Acyclic Graph
         * Determine if path exists from f to k
         *
         */

        graph.put('f', Arrays.asList('g','i'));
        graph.put('g', Arrays.asList('h'));
        graph.put('h', Arrays.asList());
        graph.put('i', Arrays.asList('g', 'k'));
        graph.put('j', Arrays.asList('i'));
        graph.put('k', Arrays.asList());

        boolean result = findPath(graph, 'f', 'k');
        System.out.println(result);


    }

    public static boolean findPath(HashMap<Character, List<Character>> graph, char src, char dest){

        //Implemented using recursion: Time: O(e) e = edges on the graph || Space = o(n) n = nodes on the graph


        //If i found my destination - return true
        if(src == dest){
            return true;
        }

        List<Character> neighors = graph.get(src);
        for (Character nodes: neighors){


            // if there is a path between my neighbor and dest - check if recursive call has path  
            if ((findPath(graph, nodes, dest)== true)){
                return true;
            }
        }
        return false;
    }
}
