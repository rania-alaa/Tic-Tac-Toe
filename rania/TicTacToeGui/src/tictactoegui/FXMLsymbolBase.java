package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLsymbolBase extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final Lighting lighting;
    protected final Button button;
    protected final Button button0;

    public FXMLsymbolBase() {

        label = new Label();
        label0 = new Label();
        lighting = new Lighting();
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

        label0.setLayoutX(225.0);
        label0.setLayoutY(240.0);
        label0.setText("Choose Symbol");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#e10202"));
        label0.setFont(new Font("System Bold", 30.0));

        label0.setEffect(lighting);

        button.setLayoutX(123.0);
        button.setLayoutY(359.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(59.0);
        button.setPrefWidth(116.0);
        button.getStyleClass().add("rich-blue");
        button.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button.setText("X");
        button.setFont(new Font("System Bold", 24.0));

        button0.setLayoutX(440.0);
        button0.setLayoutY(359.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(59.0);
        button0.setPrefWidth(116.0);
        button0.getStyleClass().add("rich-blue");
        button0.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button0.setText("O");
        button0.setFont(new Font("System Bold", 24.0));

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(button);
        getChildren().add(button0);

    }
}
