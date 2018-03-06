package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLpopupBase extends AnchorPane {

    protected final Label label;
    protected final Lighting lighting;
    protected final TextField textField;
    protected final Button button;

    public FXMLpopupBase() {

        label = new Label();
        lighting = new Lighting();
        textField = new TextField();
        button = new Button();

        setId("AnchorPane");
        setPrefHeight(250.0);
        setPrefWidth(375.0);

        label.setLayoutX(16.0);
        label.setLayoutY(72.0);
        label.setText("Please Enter your name :");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e10202"));
        label.setFont(new Font("Tahoma Bold", 28.0));

        label.setEffect(lighting);

        textField.setLayoutX(108.0);
        textField.setLayoutY(125.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(164.0);

        button.setDefaultButton(true);
        button.setLayoutX(150.0);
        button.setLayoutY(195.0);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("rich-blue");
        button.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button.setText("Ok");

        getChildren().add(label);
        getChildren().add(textField);
        getChildren().add(button);

    }
}
