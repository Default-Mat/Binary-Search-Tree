package com.example.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTree {
    Node root;

    public BinaryTree(int key) { root = new Node(key); }
    public BinaryTree() { root = null; }

    //creates random nodes for the tree
    public void randomNode(){
        Random randomNum = new Random();
        for (int i = 0; i < 7; i++)
            insert(1 + randomNum.nextInt(20));
    }

    //the four following functions are defined for tree traversals
    //these functions return string based on the traversal
    public String inOrder(Node node, String string){
        if(node == null)
            return string;
        string = inOrder(node.left, string);
        string += node.data + " ";
        string = inOrder(node.right, string);
        return string;
    }

    public String preOrder(Node node, String string){
        if(node == null)
            return string;
        string += node.data + " ";
        string = preOrder(node.left, string);
        string = preOrder(node.right, string);
        return string;
    }

    public String postOrder(Node node, String string){
        if(node == null)
            return string;
        string = postOrder(node.left, string);
        string = postOrder(node.right, string);
        string += node.data + " ";
        return string;
    }

    public String levelOrder(Node node){
        String string = "";
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            string += temp.data + " ";
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        return string;
    }

    //returns the height of the tree
    public int height(Node node)
    {
        if (node == null)
            return 0;
        else {
            int lHeight = height(node.left);
            int rHeight = height(node.right);
            if (lHeight > rHeight)
                return (lHeight + 1);
            else
                return (rHeight + 1);
        }
    }

    //returns the number of nodes in the tree
    //based on level order traversal
    public int nodeCounter(Node node){
        int counter = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            counter++;
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        return counter;
    }

    //returns the number of leaves
    //based on level order traversal
    public int leafCounter(Node node){
        int counter = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left == null && temp.right == null) {
                counter++;
                continue;
            }
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        return counter;
    }

    //returns the max value of the nodes
    public int max(Node node){
        int max = 0;
        if(node.right == null)
            return node.data;

        max = max(node.right);
        return max;
    }

    //returns the min value of the nodes
    public int min(Node node){
        int min = 0;
        if(node.left == null)
            return node.data;

        min = min(node.left);
        return min;
    }

    //compares two separated trees node by node
    //returns true if they are identical
    public static boolean identical(Node node1, Node node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;

        if(identical(node1.left, node2.left) &&
                identical(node1.right, node2.right) &&
                node1.data == node2.data)
            return true;
        return false;
    }

    //adds a node to the tree based on the value
    //we later need the returned value to check whether the node already exists or not
    public int insert(int value){
        if(root == null){
            root = new Node(value);
            return 1;
        }

        Node newNode = new Node(value);
        Node ptr, prePtr = new Node();
        ptr = root;

        while(ptr != null){
            prePtr = ptr;
            if(ptr.data == value)
                return 0;
            if(ptr.data < value)
                ptr = ptr.right;
            else
                ptr = ptr.left;
        }

        if(prePtr.data < value)
            prePtr.right = newNode;
        else
            prePtr.left = newNode;

        return 1;
    }

    //deletes the entire tree by making the root null
    public void deleteNodes(){
        root = null;
    }

    //checks if the tree is complete or not
    public boolean isComplete(Node node, int index, int nodeCount){
        if(node == null)
            return true;
        if(index >= nodeCount)
            return false;
        return (isComplete(node.left, 2 * index + 1, nodeCount) &&
                isComplete(node.right, 2 * index + 2, nodeCount));
    }

    //checks if the tree is full or not
    public boolean isFull(Node node){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left == null && temp.right == null) {
                continue;
            }
            else if(temp.left != null && temp.right != null){
                queue.add(temp.left);
                queue.add(temp.right);
            }
            else
                return false;
        }
        return true;
    }

    //finds the depth of a node
    public int findDepth(Node root, int x){
        if(root == null)
            return -1;

        int depth = -1;

        if(root.data == x ||
                (depth = findDepth(root.left, x)) >= 0 ||
                (depth = findDepth(root.right, x)) >= 0)
            return depth + 1;

        return depth;
    }

    //searches the node and returns it
    //returns null if the node is not available
    public Node search(Node root, int x){
        if(root == null)
            return null;
        if(root.data == x)
            return root;
        if(x > root.data)
            return search(root.right, x);
        if(x < root.data)
            return search(root.left, x);
        return null;
    }
}
