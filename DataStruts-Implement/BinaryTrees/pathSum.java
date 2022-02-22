import java.util.*;

/**
 Time: O(n): n is the nodes in the tree
 Space: o(n): n is elements stored in our queue

 **/

public class Playground {

    static class BST{
        int value;
        BST left = null;
        BST right = null;

        //Constructor for BST
        BST(int value){
            this.value= value;
        }
    }

    public static void main(String[] args) {

        /**

         Write a function, maxPathSum, that takes in a pointer to the root of a binary
         tree that contains number values.
         The function should return the maximum sum of any root to leaf path within the tree.

         You may assume that the input tree is non-empty.

                3
             /    \
            11     4
           / \      \
          10   5     1

         */

        BST rootNode = new BST(3);
        rootNode.right = new BST(4);
        rootNode.left = new BST(11);
        rootNode.right.right = new BST(1);
        rootNode.left.right = new BST(5);
        rootNode.left.left = new BST(10);

        int result = treePathSum(rootNode);
        System.out.println(result); // output should be 24


    }


    public static int treePathSum(BST rootNode){

        int pathSum = rootNode.value;
        int left = 0;
        int right = 0;
        int maxPath = Integer.MIN_VALUE;

        Stack<BST> treePath = new Stack<>();

        treePath.add(rootNode);

        while(treePath.size() > 0) {

            int stackSize = treePath.size();

            for (int i = 0; i < stackSize; i++) {

                BST currentNode = treePath.pop();

                if (currentNode.left != null) {
                    treePath.add(currentNode.left);
                    left += currentNode.left.value;
                }

                if (currentNode.right != null) {
                    treePath.add(currentNode.right);
                    right += currentNode.right.value;
                }

            }

            maxPath = pathSum + Math.max(left, right);
        }
        return maxPath;
    }
}
