package com.example.binarytree;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TreeApplication extends Application {
    BinaryTree tree = new BinaryTree();
    BinaryTree tree2 = new BinaryTree();
    BinaryTree currentTree = new BinaryTree();
    DrawTree drawTree = new DrawTree();

    @Override
    public void start(Stage stage) {
        currentTree = tree;
        tree.randomNode();
        tree2.randomNode();
        drawTree.drawTree(400, 100, 400, 100, 200, 36, 40, currentTree.root);

        //defining buttons and input field
        TextField inputField = new TextField();
        //<editor-fold desc="buttons">
        Button searchBtn = new Button("Search");
        Button preorderBtn = new Button("Preorder");
        Button postorderBtn = new Button("Postorder");
        Button inorderBtn = new Button("Inorder");
        Button insertBtn = new Button("Insert");
        Button levelorderBtn = new Button("Level order");
        Button maxBtn = new Button("Max");
        Button minBtn = new Button("Min");
        Button heightBtn = new Button("Height");
        Button nodeCountBtn = new Button("Node count");
        Button leafCountBtn = new Button("Leaf count");
        Button deleteTreeBtn = new Button("Delete tree");
        Button isCompleteBtn = new Button("Is complete");
        Button isFullBtn = new Button("Is full");
        Button isIdenticalBtn = new Button("Is identical");
        Button findDepthBtn = new Button("Find depth");
        Button treeBtn = new Button("Tree1");
        Button tree2Btn = new Button("Tree2");
        //</editor-fold>
        inputField.setMinWidth(268.0);
        VBox vBox1 = new VBox(20);
        vBox1.getChildren().addAll(searchBtn, findDepthBtn, preorderBtn,
                inorderBtn, minBtn, nodeCountBtn, deleteTreeBtn, isFullBtn);
        vBox1.setAlignment(Pos.CENTER_LEFT);
        VBox vBox2 = new VBox(20);
        vBox2.getChildren().addAll(insertBtn, heightBtn, levelorderBtn,
                postorderBtn, maxBtn, leafCountBtn, isCompleteBtn, isIdenticalBtn);
        vBox2.setAlignment(Pos.CENTER_RIGHT);
        VBox treeSelectorBox = new VBox(10);
        treeSelectorBox.getChildren().addAll(treeBtn, tree2Btn);

        //defining text area for traversals and additional info
        Text textArea = new Text();
        textArea.setText("BinaryTree");
        textArea.setWrappingWidth(230.0);
        textArea.setFill(Color.WHITE);
        textArea.setFont(Font.font("Helvetica", 20));
        VBox textBox = new VBox();
        textBox.setMinSize(268.0, 115.0);
        textBox.getChildren().add(textArea);
        textBox.setAlignment(Pos.CENTER);
        textBox.setStyle("-fx-background-color: #232323; -fx-background-radius: 5px");

        drawTree.pane.setMinSize(500.0, 600.0);
        Line separator = new Line(370.0, 0.0, 370.0, 700.0);
        separator.setStyle("-fx-stroke-width: 3");

        //adding elements to the app screen
        AnchorPane appScreen = new AnchorPane();
        appScreen.setStyle("-fx-background-color: #3F3F3F;");
        appScreen.getChildren().addAll(drawTree.pane, vBox1, vBox2, treeSelectorBox, inputField, textBox, separator);
        appScreen.setTopAnchor(drawTree.pane, 30.0);
        appScreen.setRightAnchor(drawTree.pane, 50.0);
        appScreen.setTopAnchor(vBox1, 80.0);
        appScreen.setLeftAnchor(vBox1, 50.0);
        appScreen.setTopAnchor(vBox2, 80.0);
        appScreen.setLeftAnchor(vBox2, 200.0);
        appScreen.setTopAnchor(inputField, 30.0);
        appScreen.setLeftAnchor(inputField, 50.0);
        appScreen.setBottomAnchor(textBox, 30.0);
        appScreen.setLeftAnchor(textBox, 50.0);
        appScreen.setTopAnchor(treeSelectorBox, 50.0);
        appScreen.setLeftAnchor(treeSelectorBox, 420.0);
        Scene treeScene = new Scene(appScreen, 1300, 700);
        treeScene.getStylesheets().add(TreeApplication.class.getResource("ButtonStyle.css").toExternalForm());

        //defining event handlers for buttons
        ButtonController controller = new ButtonController();
        //<editor-fold desc="event handlers">
        treeBtn.setOnMouseClicked(mouseEvent -> {
            currentTree = tree;
            controller.changeTree(textArea, currentTree, drawTree, 1);
        });

        tree2Btn.setOnMouseClicked(mouseEvent -> {
            currentTree = tree2;
            controller.changeTree(textArea, currentTree, drawTree, 2);
        });

        preorderBtn.setOnMouseClicked(mouseEvent -> {
            controller.preorderCtrl(textArea, currentTree);
        });

        postorderBtn.setOnMouseClicked(mouseEvent -> {
            controller.postorderCtrl(textArea, currentTree);
        });

        inorderBtn.setOnMouseClicked(mouseEvent -> {
            controller.inorderCtrl(textArea, currentTree);
        });

        levelorderBtn.setOnMouseClicked(mouseEvent -> {
            controller.levelorderCtrl(textArea, currentTree);
        });

        maxBtn.setOnMouseClicked(mouseEvent -> {
            controller.maxCtrl(textArea, currentTree);
        });

        minBtn.setOnMouseClicked(mouseEvent -> {
            controller.minCtrl(textArea, currentTree);
        });

        heightBtn.setOnMouseClicked(mouseEvent -> {
            controller.heightCtrl(textArea, currentTree);
        });

        findDepthBtn.setOnMouseClicked(mouseEvent -> {
            controller.findDepthCtrl(textArea, inputField, currentTree);
        });

        nodeCountBtn.setOnMouseClicked(mouseEvent -> {
            controller.nodeCountCtrl(textArea, currentTree);
        });

        leafCountBtn.setOnMouseClicked(mouseEvent -> {
            controller.leafCountCtrl(textArea, currentTree);
        });

        insertBtn.setOnMouseClicked(mouseEvent -> {
            controller.insertCtrl(textArea, inputField, currentTree, drawTree);
        });

        deleteTreeBtn.setOnMouseClicked(mouseEvent -> {
            controller.deleteTreeCtrl(textArea, currentTree, drawTree);
        });

        isCompleteBtn.setOnMouseClicked(mouseEvent -> {
            controller.isCompleteCtrl(textArea, currentTree);
        });

        searchBtn.setOnMouseClicked(mouseEvent -> {
            controller.searchCtrl(textArea, inputField, currentTree, drawTree);
        });

        isFullBtn.setOnMouseClicked(mouseEvent -> {
            controller.isFullCtrl(textArea, currentTree);
        });

        isIdenticalBtn.setOnMouseClicked(mouseEvent -> {
            controller.isIdenticalCtrl(textArea, tree, tree2);
        });
        //</editor-fold>

        //setting up stage
        Stage treeStage = new Stage();
        treeStage.setScene(treeScene);
        treeStage.setResizable(false);
        treeStage.setTitle("BinaryTree");
        treeStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}