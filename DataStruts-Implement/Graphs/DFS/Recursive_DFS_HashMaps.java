/**
Time Complexity: O(V+E) V = vertices || E = edges on the graph

Space: O(V) V = Vertices on the graph 

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

        DFS(graph, 'a');

    }


    public static void DFS(HashMap<Character, List<Character>> graph, char start){

            System.out.println(start);
                List<Character> values = graph.get(start);
                for(int i =0; i< values.size(); i++) {
                    DFS(graph, values.get(i));
                }
    }
}
