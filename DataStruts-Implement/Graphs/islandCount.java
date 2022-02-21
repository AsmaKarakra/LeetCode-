import java.util.*;

/**
 Time: O(n) n = elements in the graph 
 Space: O(n) n = elements in the graph
 **/

public class Playground {
    public static void main(String[] args) {
        /**
         Write a function, islandCount, that takes in a grid containing Ws and Ls.
         W represents water and L represents land.

         The function should return the number of islands on the grid.
         An island is a vertically or horizontally connected region of land.
         *
         */

        char[][] grid ={
            {'W', 'L', 'W', 'W', 'W'},
            {'W', 'L', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'L', 'W'},
            {'W', 'W', 'L', 'L', 'W'},
            {'L', 'W', 'W', 'L', 'L'},
            {'L', 'L', 'W', 'W', 'W'}
        };

        int result = islandCount(grid);
        System.out.println(result);
    }


    public static int islandCount(char[][] grid){

        boolean [][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;

        for(int i =0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                } else if (grid[i][j] == 'W' && !visited[i][j]) {
                    visited[i][j] = true;
                    continue;
                } else if (grid[i][j] == 'L' && !visited[i][j]) {
                    count++;
                    DFS(grid, i, j, visited);
                }
            }
        }

        return count;
    }

    public static void DFS(char[][] grid, int row, int col, boolean[][] visited ) {

        Stack<Integer> stackRow = new Stack<>();
        Stack<Integer> stackCol = new Stack<>();

        stackRow.add(row);
        stackCol.add(col);
        visited[row][col] = true;

        while (!stackRow.empty() && !stackCol.empty()) {
            int tempRow = stackRow.pop();
            int tempCol = stackCol.pop();

            if(grid[tempRow][tempCol] == 'L') {
                ArrayList<Integer[]> nodes = getNeighbors(grid, tempRow, tempCol);

                for (int i = 0; i < nodes.size(); i++) {
                    Integer[] indices = nodes.get(i);
                    int newRow = indices[0];
                    int newCol = indices[1];

                    if (visited[newRow][newCol]) {
                        continue;
                    }
                    stackRow.add(newRow);
                    stackCol.add(newCol);
                    visited[newRow][newCol] = true;
                }
            }

            else {
                visited[tempRow][tempCol] = true;
            }

        }
    }

    public static ArrayList<Integer[]> getNeighbors(char[][] grid, int row, int col){

        ArrayList<Integer[]> nodes = new ArrayList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        int up = row - 1;
        int down = row + 1;
        int right = col + 1;
        int left = col - 1;


        if(up >= 0){
            nodes.add(new Integer[] {up, col});
        }

        if(down <= rows - 1){
            nodes.add(new Integer[]{down, col});
        }

        if(right <= cols - 1){
            nodes.add(new Integer[] {row, right});
        }

        if(left >= 0){
            nodes.add(new Integer[]{row, left});
        }
        return nodes;
    }
}
