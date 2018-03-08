package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLplayorwatchBase extends AnchorPane {

    protected final Label label;
    protected final Button button;
    protected final Button button0;

    public FXMLplayorwatchBase() {

        label = new Label();
        button = new Button();
        button0 = new Button();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        label.setLayoutX(45.0);
        label.setLayoutY(6.0);
        label.setPrefHeight(200.0);
        label.setPrefWidth(655.0);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        button.setLayoutX(216.0);
        button.setLayoutY(271.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(59.0);
        button.setPrefWidth(224.0);
        button.getStyleClass().add("rich-blue");
        button.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button.setText("Play");
        button.setFont(new Font("System Bold", 24.0));

        button0.setLayoutX(216.0);
        button0.setLayoutY(372.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(59.0);
        button0.setPrefWidth(224.0);
        button0.getStyleClass().add("rich-blue");
        button0.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button0.setText("Games Video");
        button0.setFont(new Font("System Bold", 24.0));

        getChildren().add(label);
        getChildren().add(button);
        getChildren().add(button0);

    }
}
