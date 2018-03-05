package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLmodeBase extends AnchorPane {

    protected final Label label;
    protected final Lighting lighting;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Label label0;

    public FXMLmodeBase() {

        label = new Label();
        lighting = new Lighting();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        label0 = new Label();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        label.setLayoutX(244.0);
        label.setLayoutY(199.0);
        label.getStyleClass().add("headtext");
        label.setText("Choose Mode:");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e10202"));
        label.setFont(new Font("Tahoma Bold", 30.0));

        label.setEffect(lighting);

        button.setLayoutX(302.0);
        button.setLayoutY(275.0);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("rich-blue");
        button.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button.setText("Single");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#cc0808"));
        button.setFont(new Font("System Bold", 24.0));

        button0.setLayoutX(288.0);
        button0.setLayoutY(359.0);
        button0.setMnemonicParsing(false);
        button0.getStyleClass().add("rich-blue");
        button0.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button0.setText("2 Players");
        button0.setTextFill(javafx.scene.paint.Color.valueOf("#cc0808"));
        button0.setFont(new Font("System Bold", 24.0));

        button1.setLayoutX(297.0);
        button1.setLayoutY(447.0);
        button1.setMnemonicParsing(false);
        button1.getStyleClass().add("rich-blue");
        button1.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button1.setText("OnLine");
        button1.setTextFill(javafx.scene.paint.Color.valueOf("#cc0808"));
        button1.setFont(new Font("System Bold", 24.0));

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
