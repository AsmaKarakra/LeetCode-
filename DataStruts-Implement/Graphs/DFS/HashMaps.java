
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

        //Create a stack for DFS

        Stack<Character> stack = new Stack<>();

        System.out.println("DFS of graph is: ");
        stack.add(start);
        while(!stack.isEmpty()){
            char current = stack.pop();

            //Process Node after it leaves the stack
            System.out.println(current);
                List<Character> values = graph.get(current);
                for(int i =0; i< values.size(); i++){
                    stack.add(values.get(i));
                }
            }

        //Output: a c e b d f -- Note graph can have many DFS traversals
        
        System.out.println("DFS of graph is Complete");
    }
}
