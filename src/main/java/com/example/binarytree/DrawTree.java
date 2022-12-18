package com.example.binarytree;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DrawTree {
    Pane pane = new Pane();
    //this function recursively defines tree nodes and their lines, then adds them to the pane
    public void drawTree(int x1, int y1, int x, int y, int pixel, int radius, int fontSize,  Node node){

        if(node.left != null) {
            drawTree(x, y, x - pixel, y + 100, pixel / 2,
                    (int) (radius / 1.25), (int) (fontSize / 1.25),  node.left);
        }
        if(node.right != null) {
            drawTree(x, y, x + pixel, y + 100, pixel / 2,
                    (int) (radius / 1.25), (int) (fontSize / 1.25),  node.right);
        }

        Line line = new Line(x1, y1, x, y);
        line.setStyle("-fx-stroke: #FFBDBDBD; -fx-stroke-width: 3;");

        Circle circle = new Circle(x, y, radius);
        circle.setStyle("-fx-fill: #6B66FF; -fx-stroke: #FFBDBDBD; -fx-stroke-width: 3;");

        Text value = new Text(x - 10, y + 8, String.valueOf(node.data));
        value.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, fontSize));

        pane.getChildren().addAll(line, circle, value);
    }

    //this function highlights the path of the target search process
    public int altDrawTree(int x1, int y1, int x, int y, int pixel, int radius, int fontSize,  Node node, Node target){

        int temp = 0;
        int colorNode = 0;

        if(node == target) {
            temp = 1;
            colorNode = 1;
        }
        if(node.left != null) {
            if(temp == 1)
                altDrawTree(x, y, x - pixel, y + 100, pixel / 2,
                        (int) (radius / 1.25), (int) (fontSize / 1.25),  node.left, target);
            else
                temp = altDrawTree(x, y, x - pixel, y + 100, pixel / 2,
                    (int) (radius / 1.25), (int) (fontSize / 1.25),  node.left, target);
        }

        if(node.right != null) {
            if(temp == 1)
                altDrawTree(x, y, x + pixel, y + 100, pixel / 2,
                        (int) (radius / 1.25), (int) (fontSize / 1.25),  node.right, target);
            else
                temp = altDrawTree(x, y, x + pixel, y + 100, pixel / 2,
                    (int) (radius / 1.25), (int) (fontSize / 1.25),  node.right, target);
        }

        //sets yellow color for the stroke and the line of the node
        //highlights the target node
        if(temp == 1){
            Line line = new Line(x1, y1, x, y);
            line.setStyle("-fx-stroke: #FEDD53; -fx-stroke-width: 3;");

            Circle circle = new Circle(x, y, radius);
            if(colorNode == 1)
                circle.setStyle("-fx-fill: #FEDD53; -fx-stroke: #FEDD53; -fx-stroke-width: 3;");
            else
                circle.setStyle("-fx-fill: #6B66FF; -fx-stroke: #FEDD53; -fx-stroke-width: 3;");


            Text value = new Text(x - 10, y + 8, String.valueOf(node.data));
            value.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, fontSize));

            pane.getChildren().addAll(line, circle, value);

            return 1;
        }

        //sets grey(default) color for the stroke and line of the node
        Line line = new Line(x1, y1, x, y);
        line.setStyle("-fx-stroke: #FFBDBDBD; -fx-stroke-width: 3;");

        Circle circle = new Circle(x, y, radius);
        circle.setStyle("-fx-fill: #6B66FF; -fx-stroke: #FFBDBDBD; -fx-stroke-width: 3;");

        Text value = new Text(x - 10, y + 8, String.valueOf(node.data));
        value.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, fontSize));

        pane.getChildren().addAll(line, circle, value);

        return 0;
    }

    //this function removes the shape of the tree
    //clears elements from the pane
    public void removeTree(){
        pane.getChildren().clear();
    }
}
