package com.example.binarytree;

public class Node {
    int data = 0;
    Node right, left;

    public Node(){
      right = left = null;
    }
    public Node(int data){
        this();
        this.data = data;
    }
}
