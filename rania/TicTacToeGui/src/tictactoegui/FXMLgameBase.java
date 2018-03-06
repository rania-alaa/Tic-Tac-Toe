package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXMLgameBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final Text text2;
    protected final Button button8;
    protected final Button button9;
    protected final Button button10;
    protected final Label label;
    protected final Button button11;

    public FXMLgameBase() {

        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        button8 = new Button();
        button9 = new Button();
        button10 = new Button();
        label = new Label();
        button11 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        anchorPane.setLayoutX(200.0);
        anchorPane.setPrefHeight(600.0);
        anchorPane.setPrefWidth(500.0);

        anchorPane0.setLayoutY(8.0);
        anchorPane0.setPrefHeight(521.0);
        anchorPane0.setPrefWidth(500.0);

        gridPane.setGridLinesVisible(true);
        gridPane.setLayoutX(-1.0);
        gridPane.setLayoutY(-1.0);
        gridPane.setPrefHeight(521.0);
        gridPane.setPrefWidth(500.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        button.setMnemonicParsing(false);
        button.setPrefHeight(173.0);
        button.setPrefWidth(167.0);

        GridPane.setColumnIndex(button0, 1);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(173.0);
        button0.setPrefWidth(167.0);

        GridPane.setColumnIndex(button1, 2);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(173.0);
        button1.setPrefWidth(167.0);

        GridPane.setRowIndex(button2, 1);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(173.0);
        button2.setPrefWidth(167.0);

        GridPane.setColumnIndex(button3, 1);
        GridPane.setRowIndex(button3, 1);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(173.0);
        button3.setPrefWidth(167.0);

        GridPane.setColumnIndex(button4, 2);
        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(173.0);
        button4.setPrefWidth(167.0);

        GridPane.setRowIndex(button5, 2);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(173.0);
        button5.setPrefWidth(167.0);

        GridPane.setColumnIndex(button6, 1);
        GridPane.setRowIndex(button6, 2);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(173.0);
        button6.setPrefWidth(167.0);

        GridPane.setColumnIndex(button7, 2);
        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(173.0);
        button7.setPrefWidth(167.0);

        text.setFill(javafx.scene.paint.Color.valueOf("#cc0808"));
        text.setLayoutX(-188.0);
        text.setLayoutY(563.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Player1:");
        text.setWrappingWidth(92.13671875);
        text.setFont(new Font(24.0));

        text0.setFill(javafx.scene.paint.Color.valueOf("#5178da"));
        text0.setLayoutX(-107.0);
        text0.setLayoutY(569.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Text");
        text0.setWrappingWidth(271.9999876022339);
        text0.setFont(new Font("System Bold", 30.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#cc0808"));
        text1.setLayoutX(169.0);
        text1.setLayoutY(562.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Player2:");
        text1.setFont(new Font(24.0));

        text2.setFill(javafx.scene.paint.Color.valueOf("#5178da"));
        text2.setLayoutX(254.0);
        text2.setLayoutY(568.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Text");
        text2.setWrappingWidth(233.1367230154574);
        text2.setFont(new Font("System Bold", 30.0));

        button8.setLayoutX(14.0);
        button8.setLayoutY(117.0);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(25.0);
        button8.setPrefWidth(138.0);
        button8.getStyleClass().add("rich-blue");
        button8.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button8.setText("Menu");
        button8.setTextFill(javafx.scene.paint.Color.valueOf("#cc0808"));
        button8.setFont(new Font("System Bold", 24.0));

        button9.setLayoutX(14.0);
        button9.setLayoutY(226.0);
        button9.setMnemonicParsing(false);
        button9.setPrefHeight(25.0);
        button9.setPrefWidth(138.0);
        button9.getStyleClass().add("rich-blue");
        button9.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button9.setText("Reset");
        button9.setTextFill(javafx.scene.paint.Color.valueOf("#cc0808"));
        button9.setFont(new Font("System Bold", 24.0));

        button10.setLayoutX(14.0);
        button10.setLayoutY(337.0);
        button10.setMnemonicParsing(false);
        button10.setPrefHeight(25.0);
        button10.setPrefWidth(138.0);
        button10.getStyleClass().add("rich-blue");
        button10.getStylesheets().add("/tictactoegui/css/modepagecss.css");
        button10.setText("Save");
        button10.setTextFill(javafx.scene.paint.Color.valueOf("#cc0808"));
        button10.setFont(new Font("System Bold", 24.0));

        label.setLayoutX(28.0);
        label.setLayoutY(36.0);

        button11.setLayoutX(20.0);
        button11.setLayoutY(14.0);
        button11.setMnemonicParsing(false);
        button11.getStyleClass().add("grid");
        button11.getStylesheets().add("/tictactoegui/css/gridbgcss.css");

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(button);
        gridPane.getChildren().add(button0);
        gridPane.getChildren().add(button1);
        gridPane.getChildren().add(button2);
        gridPane.getChildren().add(button3);
        gridPane.getChildren().add(button4);
        gridPane.getChildren().add(button5);
        gridPane.getChildren().add(button6);
        gridPane.getChildren().add(button7);
        anchorPane0.getChildren().add(gridPane);
        anchorPane.getChildren().add(anchorPane0);
        anchorPane.getChildren().add(text);
        anchorPane.getChildren().add(text0);
        anchorPane.getChildren().add(text1);
        anchorPane.getChildren().add(text2);
        getChildren().add(anchorPane);
        getChildren().add(button8);
        getChildren().add(button9);
        getChildren().add(button10);
        getChildren().add(label);
        getChildren().add(button11);

    }
}
