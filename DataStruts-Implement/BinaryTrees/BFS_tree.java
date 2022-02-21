import java.util.*;

/**
 Time: O(n): n is the nodes in the tree
 Space: O(n): n is the nodes in the tree
        Stored in ArrayList
 **/

public class Playground {

    static class BST{
        String value;
        BST left = null;
        BST right = null;

        //Constructor for BST
        BST(String value){
            this.value= value;
        }
    }

    public static void main(String[] args) {

        /**
         *
         * Problem Statement:
         Write a function, depthFirstValues, that takes
         in a pointer to the root of a binary tree. The
         function should return a vector containing all
         values of the tree in depth-first order.

               a
             /   \
            b     c
           / \     \
          d   e     f
         */

        BST rootNode = new BST("a");
        rootNode.right = new BST("c");
        rootNode.left = new BST("b");
        rootNode.right.right = new BST("f");
        rootNode.left.right = new BST("e");
        rootNode.left.left = new BST("d");

        ArrayList<String> DFS = treeDFS(rootNode);

        System.out.println(DFS);
    }


    public static ArrayList<String> treeDFS(BST rootNode){

        ArrayList<String> traversal = new ArrayList<>();

        Queue<BST> treeQueue = new LinkedList<>();

        treeQueue.add(rootNode);

        while(treeQueue.size() > 0){

            BST currentNode = treeQueue.poll();

            traversal.add(currentNode.value);

            if(currentNode.left != null){
                treeQueue.add(currentNode.left);
            }

            if(currentNode.right != null){
                treeQueue.add(currentNode.right);
            }
        }

        return traversal;
    }

}
