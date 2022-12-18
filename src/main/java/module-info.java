module com.example.binarytree {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.binarytree to javafx.fxml;
    exports com.example.binarytree;
}