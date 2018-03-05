package tictactoegui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
    protected final Pane pane;
    protected final Button button;
    protected final Pane pane0;
    protected final Button button0;
    protected final Pane pane1;
    protected final Button button1;
    protected final Pane pane2;
    protected final Button button2;
    protected final Pane pane3;
    protected final Button button3;
    protected final Pane pane4;
    protected final Button button4;
    protected final Pane pane5;
    protected final Button button5;
    protected final Pane pane6;
    protected final Button button6;
    protected final Pane pane7;
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
        pane = new Pane();
        button = new Button();
        pane0 = new Pane();
        button0 = new Button();
        pane1 = new Pane();
        button1 = new Button();
        pane2 = new Pane();
        button2 = new Button();
        pane3 = new Pane();
        button3 = new Button();
        pane4 = new Pane();
        button4 = new Button();
        pane5 = new Pane();
        button5 = new Button();
        pane6 = new Pane();
        button6 = new Button();
        pane7 = new Pane();
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

        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);

        button.setLayoutX(1.0);
        button.setLayoutY(-1.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(176.0);
        button.setPrefWidth(164.0);
        button.getStyleClass().add("grid");
        button.setFont(new Font(81.0));

        GridPane.setColumnIndex(pane0, 1);
        pane0.setPrefHeight(200.0);
        pane0.setPrefWidth(200.0);

        button0.setLayoutX(1.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(176.0);
        button0.setPrefWidth(164.0);
        button0.getStyleClass().add("grid");
        button0.setFont(new Font(81.0));

        GridPane.setColumnIndex(pane1, 2);
        pane1.setPrefHeight(200.0);
        pane1.setPrefWidth(200.0);

        button1.setLayoutY(-1.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(176.0);
        button1.setPrefWidth(164.0);
        button1.getStyleClass().add("grid");
        button1.setFont(new Font(81.0));

        GridPane.setRowIndex(pane2, 1);
        pane2.setPrefHeight(200.0);
        pane2.setPrefWidth(200.0);

        button2.setLayoutY(-1.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(176.0);
        button2.setPrefWidth(165.0);
        button2.getStyleClass().add("grid");
        button2.setFont(new Font(81.0));

        GridPane.setColumnIndex(pane3, 1);
        GridPane.setRowIndex(pane3, 1);
        pane3.setPrefHeight(200.0);
        pane3.setPrefWidth(200.0);

        button3.setLayoutX(1.0);
        button3.setLayoutY(-1.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(176.0);
        button3.setPrefWidth(164.0);
        button3.getStyleClass().add("grid");
        button3.setFont(new Font(81.0));

        GridPane.setColumnIndex(pane4, 2);
        GridPane.setRowIndex(pane4, 1);
        pane4.setPrefHeight(200.0);
        pane4.setPrefWidth(200.0);

        button4.setMnemonicParsing(false);
        button4.setPrefHeight(176.0);
        button4.setPrefWidth(164.0);
        button4.getStyleClass().add("grid");
        button4.setFont(new Font(81.0));

        GridPane.setRowIndex(pane5, 2);
        pane5.setPrefHeight(200.0);
        pane5.setPrefWidth(200.0);

        button5.setLayoutY(-1.0);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(166.0);
        button5.setPrefWidth(165.0);
        button5.getStyleClass().add("grid");
        button5.setFont(new Font(81.0));

        GridPane.setColumnIndex(pane6, 1);
        GridPane.setRowIndex(pane6, 2);
        pane6.setPrefHeight(200.0);
        pane6.setPrefWidth(200.0);

        button6.setLayoutX(1.0);
        button6.setLayoutY(-1.0);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(176.0);
        button6.setPrefWidth(164.0);
        button6.getStyleClass().add("grid");
        button6.setFont(new Font(81.0));

        GridPane.setColumnIndex(pane7, 2);
        GridPane.setRowIndex(pane7, 2);
        pane7.setPrefHeight(200.0);
        pane7.setPrefWidth(200.0);

        button7.setLayoutY(-1.0);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(176.0);
        button7.setPrefWidth(164.0);
        button7.getStyleClass().add("grid");
        button7.setFont(new Font(81.0));

        text.setFill(javafx.scene.paint.Color.valueOf("#cc0808"));
        text.setLayoutX(14.0);
        text.setLayoutY(563.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Player1:");
        text.setWrappingWidth(92.13671875);
        text.setFont(new Font(24.0));

        text0.setFill(javafx.scene.paint.Color.valueOf("#5178da"));
        text0.setLayoutX(106.0);
        text0.setLayoutY(566.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Text");
        text0.setWrappingWidth(137.9999876022339);
        text0.setFont(new Font("System Bold", 30.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#cc0808"));
        text1.setLayoutX(250.0);
        text1.setLayoutY(562.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Player2:");
        text1.setFont(new Font(24.0));

        text2.setFill(javafx.scene.paint.Color.valueOf("#5178da"));
        text2.setLayoutX(340.0);
        text2.setLayoutY(564.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Text");
        text2.setWrappingWidth(145.1367230154574);
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
        pane.getChildren().add(button);
        gridPane.getChildren().add(pane);
        pane0.getChildren().add(button0);
        gridPane.getChildren().add(pane0);
        pane1.getChildren().add(button1);
        gridPane.getChildren().add(pane1);
        pane2.getChildren().add(button2);
        gridPane.getChildren().add(pane2);
        pane3.getChildren().add(button3);
        gridPane.getChildren().add(pane3);
        pane4.getChildren().add(button4);
        gridPane.getChildren().add(pane4);
        pane5.getChildren().add(button5);
        gridPane.getChildren().add(pane5);
        pane6.getChildren().add(button6);
        gridPane.getChildren().add(pane6);
        pane7.getChildren().add(button7);
        gridPane.getChildren().add(pane7);
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
