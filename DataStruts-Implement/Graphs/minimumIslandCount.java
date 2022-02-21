import java.util.*;

/**
 Time: O(n) n = Number of elements in the grid
 Space: O(n) n = Number of elements in the grid
 **/

public class Playground {

    public static void main(String[] args) {

        /**
         Problem Statement:

         minimum island

         Write a function, minimumIsland, that takes in a grid containing Ws and Ls. W represents water and
         L represents land. The function should return the size of the smallest island.
         An island is a vertically or horizontally connected region of land.

         You may assume that the grid contains at least one island.

         */

        char[][]grid = {
            {'W', 'L', 'W', 'W', 'W'},
            {'W', 'L', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'L', 'W'},
            {'W', 'W', 'L', 'L', 'W'},
            {'L', 'W', 'W', 'L', 'L'},
            {'L', 'L', 'W', 'W', 'W'}
        };

        int result = islandCount(grid);
        System.out.println(result);
      
      //Sizes: [2, 5, 3] Output = 2

    }

    public static int islandCount(char[][] grid){

        boolean [][] visited = new boolean[grid.length][grid[0].length];


        ArrayList<Integer> islandSizes = new ArrayList<>();

        for(int i =0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                } else if (grid[i][j] == 'W' && !visited[i][j]) {
                    visited[i][j] = true;
                    continue;
                } else if (grid[i][j] == 'L' && !visited[i][j]) {
                    int size = DFS(grid, i, j, visited, 0);
                    islandSizes.add(size);

                }
            }
        }

        int minCount = Integer.MAX_VALUE;

        for(int i = 0; i <islandSizes.size(); i++){
            int islandSize = islandSizes.get(i);
            minCount = Math.min(islandSize, minCount);
        }

        System.out.println(islandSizes);

        return minCount;
    }

    public static int DFS(char[][] grid, int row, int col, boolean[][] visited, int size) {

        Stack<Integer> stackRow = new Stack<>();
        Stack<Integer> stackCol = new Stack<>();

        stackRow.add(row);
        stackCol.add(col);
        visited[row][col] = true;

        while (!stackRow.empty() && !stackCol.empty()) {
            int tempRow = stackRow.pop();
            int tempCol = stackCol.pop();

            if(grid[tempRow][tempCol] == 'L') {
                size++;
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
        return size;
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
