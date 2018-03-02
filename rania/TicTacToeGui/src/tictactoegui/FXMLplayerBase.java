package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLplayerBase extends AnchorPane {

    protected final Label label;
    protected final Lighting lighting;
    protected final Button button;
    protected final TextField textField;
    protected final Label label0;

    public FXMLplayerBase() {

        label = new Label();
        lighting = new Lighting();
        button = new Button();
        textField = new TextField();
        label0 = new Label();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        label.setLayoutX(94.0);
        label.setLayoutY(239.0);
        label.setText("Player 2 name :");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e10202"));
        label.setFont(new Font("System Bold", 30.0));

        label.setEffect(lighting);

        button.setDefaultButton(true);
        button.setLayoutX(275.0);
        button.setLayoutY(511.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(52.0);
        button.setPrefWidth(150.0);
        button.getStyleClass().add("rich-blue");
        button.getStylesheets().add("/tictactoegui/css/modepagecss.css");
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
