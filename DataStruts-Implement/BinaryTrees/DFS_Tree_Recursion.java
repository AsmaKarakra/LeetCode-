import java.util.*;

/**
 Time: O(n): n is the nodes in the tree
 Space: O(d): d is the height of the tree on the stack 
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

        traverseUtill(rootNode, traversal);

        return traversal;
    }


    public static void traverseUtill(BST rootNode, ArrayList<String> nodesList){

        if(rootNode == null){
            return;
        }

        traverseUtill(rootNode.left, nodesList);
        nodesList.add(rootNode.value);
        traverseUtill(rootNode.right, nodesList);
    }
}
