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

         * Problem Statement:
         Write a function, treeSum, that takes in a pointer to the root
         of a binary tree that contains number values.
         The function should return the total sum of all values in the tree.

                3
             /    \
            11     4
           / \      \
          4   -2     1

         */

        BST rootNode = new BST(3);
        rootNode.right = new BST(4);
        rootNode.left = new BST(11);
        rootNode.right.right = new BST(1);
        rootNode.left.right = new BST(-2);
        rootNode.left.left = new BST(4);

       int sum = treeSum(rootNode);
       System.out.println(sum);
       
       //output should be 21 
    }


    public static int treeSum(BST rootNode){

        int sum = 0;

        Queue<BST> treeQueue = new LinkedList<>();

        treeQueue.add(rootNode);

        while(treeQueue.size() > 0){

            BST currentNode = treeQueue.poll();

            sum += currentNode.value;

            if(currentNode.left != null){
                treeQueue.add(currentNode.left);
            }

            if(currentNode.right != null){
                treeQueue.add(currentNode.right);
            }
        }

        return sum;
    }
}
