package com.example.binarytree;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ButtonController {

    //changes the view based on the current tree
    public void changeTree(Text text, BinaryTree tree, DrawTree drawTree, int treePointer){
        if(tree.root == null){
            drawTree.removeTree();
            if(treePointer == 1)
                text.setText("Viewing Tree1");
            else
                text.setText("Viewing Tree2");
        }

        else{
            drawTree.removeTree();
            drawTree.drawTree(400, 100, 400, 100, 200, 36, 40, tree.root);
            if(treePointer == 1)
                text.setText("Viewing Tree1");
            else
                text.setText("Viewing Tree2");
        }
    }

    //defining controller functions for event handlers
    public void preorderCtrl(Text text, BinaryTree tree){
        if(tree.root == null)
            text.setText("The tree is empty");
        else{
            String string = tree.preOrder(tree.root, "");
            text.setText(string);
        }
    }

    public void postorderCtrl(Text text, BinaryTree tree){
        if(tree.root == null)
            text.setText("The tree is empty");
        else {
            String string = tree.postOrder(tree.root, "");
            text.setText(string);
        }
    }

    public void inorderCtrl(Text text, BinaryTree tree){
        if(tree.root == null)
            text.setText("The tree is empty");
        else {
            String string = tree.inOrder(tree.root, "");
            text.setText(string);
        }
    }

    public void levelorderCtrl(Text text, BinaryTree tree){
        if(tree.root == null)
            text.setText("The tree is empty");
        else {
            String string = tree.levelOrder(tree.root);
            text.setText(string);
        }
    }

    public void maxCtrl(Text text, BinaryTree tree){
        if(tree.root == null)
            text.setText("The tree is empty");
        else {
            int max = tree.max(tree.root);
            text.setText(String.valueOf(max));
        }
    }

    public void minCtrl(Text text, BinaryTree tree){
        if(tree.root == null)
            text.setText("The tree is empty");
        else {
            int min = tree.min(tree.root);
            text.setText(String.valueOf(min));
        }
    }

    public void heightCtrl(Text text, BinaryTree tree){
        if(tree.root == null)
            text.setText("The tree is empty");
        else {
            int height = tree.height(tree.root);
            text.setText(String.valueOf(height));
        }
    }

    public void findDepthCtrl(Text text, TextField input, BinaryTree tree){
        if(input.getText().isEmpty())
            text.setText("Enter a value");
        else {
            int x = Integer.parseInt(input.getText());
            int depth = tree.findDepth(tree.root, x);
            if(depth == -1)
                text.setText("Node with the entered value is not available");
            else
                text.setText(String.valueOf(depth));
        }
    }

    public void nodeCountCtrl(Text text, BinaryTree tree){
        if(tree.root == null)
            text.setText("The tree is empty");
        else {
            int count = tree.nodeCounter(tree.root);
            text.setText(String.valueOf(count));
        }
    }

    public void leafCountCtrl(Text text, BinaryTree tree){
        if(tree.root == null)
            text.setText("The tree is empty");
        else {
            int count = tree.leafCounter(tree.root);
            text.setText(String.valueOf(count));
        }
    }

    public void insertCtrl(Text text, TextField input, BinaryTree tree, DrawTree drawTree){
        if(input.getText().isEmpty())
            text.setText("Enter a value");
        else {
            int x = Integer.parseInt(input.getText());
            int insertCheck = tree.insert(x);
            if (insertCheck == 1) {
                drawTree.removeTree();
                drawTree.drawTree(400, 100, 400, 100, 200, 36, 40, tree.root);
                text.setText("New node inserted");
            } else
                text.setText("Can not insert an existing node");
        }
    }

    public void deleteTreeCtrl(Text text, BinaryTree tree, DrawTree drawTree){
        tree.deleteNodes();
        drawTree.removeTree();
        text.setText("Tree deleted");
    }

    public void isCompleteCtrl(Text text, BinaryTree tree){
        if(tree.root == null)
            text.setText("The tree is empty");
        else {
            int nodeCounter = tree.nodeCounter(tree.root);
            if (tree.isComplete(tree.root, 0, nodeCounter))
                text.setText("The tree is complete");
            else
                text.setText("The tree is not complete");
        }
    }

    public void isFullCtrl(Text text, BinaryTree tree){
        if(tree.root == null)
            text.setText("The tree is empty");
        else {
            if (tree.isFull(tree.root))
                text.setText("The tree is full");
            else
                text.setText("The tree is not full");
        }
    }

    public void isIdenticalCtrl(Text text, BinaryTree tree1, BinaryTree tree2){
        if(BinaryTree.identical(tree1.root, tree2.root))
            text.setText("Tree1 and Tree2 are identical");
        else
            text.setText("Tree1 and Tree2 are not identical");
    }

    public void searchCtrl(Text text, TextField input, BinaryTree tree, DrawTree drawTree){
        if(input.getText().isEmpty())
            text.setText("Enter a value");
        else {
            int x = Integer.parseInt(input.getText());
            Node target = tree.search(tree.root, x);
            if (target == null) {
                if(tree.root != null) {
                    drawTree.removeTree();
                    drawTree.drawTree(400, 100, 400, 100, 200, 36, 40, tree.root);
                }
                text.setText("Node with the entered value is not available");
            }
            else {
                drawTree.removeTree();
                drawTree.altDrawTree(400, 100, 400, 100, 200, 36, 40, tree.root, target);
                text.setText("Node is available");
            }
        }
    }
}
