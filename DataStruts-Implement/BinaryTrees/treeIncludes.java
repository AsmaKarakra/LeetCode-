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
         Write a function,, that takes in a pointer to the root
         of a binary tree that contains number values and a target
         The function should return a boolean if target is in tree

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

       int target = 4;
       boolean result = treeInlcudes(rootNode, target);
       System.out.println(result); //true


    }


    public static boolean treeInlcudes(BST rootNode, int target){

        Queue<BST> treeQueue = new LinkedList<>();

        treeQueue.add(rootNode);

        while(treeQueue.size() > 0){

            BST currentNode = treeQueue.poll();

            if(currentNode.value == target){
                return true;
            }

            if(currentNode.left != null){
                treeQueue.add(currentNode.left);
            }

            if(currentNode.right != null){
                treeQueue.add(currentNode.right);
            }
        }

        return false;
    }
}
