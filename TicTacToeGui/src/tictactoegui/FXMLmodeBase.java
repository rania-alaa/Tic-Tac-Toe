package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLmodeBase extends AnchorPane {

    protected final Label label;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Label label0;

    public FXMLmodeBase() {

        label = new Label();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        label0 = new Label();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        label.setLayoutX(257.0);
        label.setLayoutY(205.0);
        label.setText("Choose Mode:");
        label.setFont(new Font(30.0));

        button.setLayoutX(305.0);
        button.setLayoutY(288.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(39.0);
        button.setPrefWidth(95.0);
        button.setText("Single");
        button.setFont(new Font(18.0));

        button0.setLayoutX(307.0);
        button0.setLayoutY(350.0);
        button0.setMnemonicParsing(false);
        button0.setText("2 Players");
        button0.setFont(new Font(18.0));

        button1.setLayoutX(307.0);
        button1.setLayoutY(414.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(39.0);
        button1.setPrefWidth(95.0);
        button1.setText("OnLine");
        button1.setFont(new Font(18.0));

        label0.setLayoutX(45.0);
        label0.setLayoutY(-1.0);
        label0.setPrefHeight(200.0);
        label0.setPrefWidth(655.0);
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        getChildren().add(label);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);
        getChildren().add(label0);

    }
}
