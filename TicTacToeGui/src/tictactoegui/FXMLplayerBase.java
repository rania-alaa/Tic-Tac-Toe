package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLplayerBase extends AnchorPane {

    protected final Label label;
    protected final Button button;
    protected final TextField textField;
    protected final Label label0;

    public FXMLplayerBase() {

        label = new Label();
        button = new Button();
        textField = new TextField();
        label0 = new Label();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        label.setLayoutX(94.0);
        label.setLayoutY(239.0);
        label.setText("Player 2 name :");
        label.setFont(new Font(30.0));

        button.setDefaultButton(true);
        button.setLayoutX(275.0);
        button.setLayoutY(511.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(52.0);
        button.setPrefWidth(150.0);
        button.setText("Next");
        button.setFont(new Font(18.0));

        textField.setLayoutX(300.0);
        textField.setLayoutY(249.0);

        label0.setLayoutX(44.0);
        label0.setPrefHeight(200.0);
        label0.setPrefWidth(655.0);
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        getChildren().add(label);
        getChildren().add(button);
        getChildren().add(textField);
        getChildren().add(label0);

    }
}
