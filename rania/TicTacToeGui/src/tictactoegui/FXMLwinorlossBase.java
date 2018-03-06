package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLwinorlossBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button button;
    protected final Label label;

    public FXMLwinorlossBase() {

        imageView = new ImageView();
        button = new Button();
        label = new Label();

        setId("AnchorPane");
        setPrefHeight(250.0);
        setPrefWidth(375.0);

        imageView.setFitHeight(189.0);
        imageView.setFitWidth(375.0);
        imageView.setLayoutY(2.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        button.setDefaultButton(true);
        button.setLayoutX(140.0);
        button.setLayoutY(203.0);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("rich-blue");
        button.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button.setText("Next");

        label.setLayoutX(151.0);
        label.setLayoutY(86.0);
        label.setFont(new Font(30.0));

        getChildren().add(imageView);
        getChildren().add(button);
        getChildren().add(label);

    }
}
