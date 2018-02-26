package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class FXMLplayerBase extends AnchorPane {

    protected final StackPane stackPane;
    protected final Label label;
    protected final Button button;
    protected final TextField textField;

    public FXMLplayerBase() {

        stackPane = new StackPane();
        label = new Label();
        button = new Button();
        textField = new TextField();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        stackPane.setLayoutX(-1.0);
        stackPane.setLayoutY(-1.0);
        stackPane.setPrefHeight(177.0);
        stackPane.setPrefWidth(700.0);

        label.setLayoutX(94.0);
        label.setLayoutY(239.0);
        label.setText("Select Player :");
        label.setFont(new Font(30.0));

        button.setLayoutX(275.0);
        button.setLayoutY(511.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(52.0);
        button.setPrefWidth(150.0);
        button.setText("Next");
        button.setFont(new Font(18.0));

        textField.setLayoutX(300.0);
        textField.setLayoutY(249.0);

        getChildren().add(stackPane);
        getChildren().add(label);
        getChildren().add(button);
        getChildren().add(textField);

    }
}
