package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLplayer1Base extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final Lighting lighting;
    protected final ChoiceBox choiceBox;
    protected final Button button;

    public FXMLplayer1Base() {

        label = new Label();
        label0 = new Label();
        lighting = new Lighting();
        choiceBox = new ChoiceBox();
        button = new Button();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        label.setLayoutX(45.0);
        label.setLayoutY(8.0);
        label.setPrefHeight(200.0);
        label.setPrefWidth(655.0);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        label0.setLayoutX(73.0);
        label0.setLayoutY(255.0);
        label0.setText("Select Your name :");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#e10202"));
        label0.setFont(new Font("System Bold", 30.0));

        label0.setEffect(lighting);

        choiceBox.setLayoutX(361.0);
        choiceBox.setLayoutY(265.0);
        choiceBox.setPrefHeight(25.0);
        choiceBox.setPrefWidth(179.0);

        button.setDefaultButton(true);
        button.setLayoutX(275.0);
        button.setLayoutY(534.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(52.0);
        button.setPrefWidth(150.0);
        button.getStyleClass().add("rich-blue");
        button.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button.setText("Next");
        button.setFont(new Font(18.0));

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(choiceBox);
        getChildren().add(button);

    }
}
