/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;

import java.awt.Font;
import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Dialog;
import javafx.scene.effect.DropShadow;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;

/**
 *
 * @author rania
 */
public class TicTacToeGui extends Application {

    String lastmove = "x";//
    //String playerOne = new String("X");
    //String playerTwo = new String("O");
    String[] allMoves = new String[9];
    Alert Msg = new Alert(AlertType.INFORMATION);

    boolean completed = false;
    static boolean win = false;
    boolean[] pressed = new boolean[9];
    boolean sound = true;
    final java.net.URL resource = getClass().getResource("music/soundbg.mp3");
    final Media media = new Media(resource.toString());
    final MediaPlayer mediaplayer = new MediaPlayer(media);

    @Override
    public void start(Stage primaryStage) throws MalformedURLException {
        FXMLplayer1Base player1page = new FXMLplayer1Base();
        FXMLsymbolBase symbolpage = new FXMLsymbolBase();
        FXMLmodeBase modepage = new FXMLmodeBase();
        FXMLplayerBase playerpage = new FXMLplayerBase();
        FXMLgameBase g = new FXMLgameBase();
        Scene player1scene = new Scene(player1page, 700, 600);
        Scene symbolscene = new Scene(symbolpage, 700, 600);
        Scene modescene = new Scene(modepage, 700, 600);
        Scene playerscene = new Scene(playerpage, 700, 600);
        Scene gamescene = new Scene(g, 700, 600);
        g.gridPane.setEffect(new DropShadow(15, 0, 15, Color.GREY));
        symbolpage.label.setGraphic(logo());
        player1page.label.setGraphic(logo());
        modepage.label0.setGraphic(logo());
        playerpage.label0.setGraphic(logo());
        //x button in symbolscene
        symbolpage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            clickOrSound(0);
            lastmove = "o";
            primaryStage.setScene(modescene);
        });
        //x button in symbolscene
        symbolpage.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            clickOrSound(0);
            lastmove = "x";
            primaryStage.setScene(modescene);
        });

        //next buton in  player1page
        player1page.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            clickOrSound(0);
            primaryStage.setScene(symbolscene);
        });

        //singlebutton
        modepage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            clickOrSound(0);
            g.text2.setText("Computer");
            primaryStage.setScene(gamescene);
        });
        //2 player button
        modepage.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            clickOrSound(0);
            primaryStage.setScene(playerscene);
        });

        //nextbutton playerpage
        playerpage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (playerpage.textField.getText().isEmpty()) {
            } else {
                g.text2.setText(playerpage.textField.getText());
                primaryStage.setScene(gamescene);
            }
            clickOrSound(0);
        });

        //menubutton gamepage
        g.button8.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            clickOrSound(0);
            primaryStage.setScene(modescene);
        });
        g.text0.setText("rania");
        initializeMovesArr();
        initializePressedArr();
        Msg.setTitle("Winner Message");
        Msg.setHeaderText(null);
        clickOrSound(1);

        putEvent(g);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(player1scene);
        primaryStage.show();
    }

    private void clickOrSound(int num) {
        if (num == 0) {
            final java.net.URL resource = getClass().getResource("music/Click2.mp3");
            final Media media = new Media(resource.toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        } else if (num == 1) {
            mediaplayer.setOnEndOfMedia(() -> {
                mediaplayer.seek(Duration.ZERO);
            });
            mediaplayer.play();
        }
    }

    private void playSound() {
        if (sound == true) {
            mediaplayer.play();
        } else {
            mediaplayer.pause();
        }
    }

    private ImageView drawSoundLogo(String name) {
        Image sound = new Image(getClass().getResourceAsStream(name));
        ImageView view = new ImageView(sound);
        view.setFitHeight(50);
        view.setFitWidth(50);
        return view;
    }

    private ImageView logo() {
        Image logo = new Image(getClass().getResourceAsStream("image/logo3.png"));
        ImageView view = new ImageView(logo);
        view.setFitHeight(110);
        view.setFitWidth(600);
        return view;
    }

//        private ImageView ChoosePattern(){
//        ImageView view = null;
//            if("X".equals(playerOne))
//            {
//                playerTwo = "O";
//                view =Drawo();
//            }
//            else if("O".equals(playerOne))
//            {
//                playerTwo = "X";
//                view =Drawx();
//            }
//        return view;
//    }
    private ImageView Casexoro() {
        ImageView view;
        if ("x".equals(lastmove)) {
            lastmove = "o";
            view = Drawo();
        } else {
            lastmove = "x";
            view = Drawx();
        }
        return view;
    }

    private ImageView Drawx() {
        Image imgx = new Image(getClass().getResourceAsStream("image/x.png"));
        ImageView viewx = new ImageView(imgx);
        viewx.setFitHeight(110);
        viewx.setFitWidth(90);
        return viewx;
    }

    private ImageView Drawo() {
        Image imgo = new Image(getClass().getResourceAsStream("image/o.png"));
        ImageView viewo = new ImageView(imgo);
        viewo.setFitHeight(110);
        viewo.setFitWidth(90);
        return viewo;
    }
// initialize allMoves array which contains all x and o characters 
    private void initializeMovesArr() {
        for (int i = 0; i < 9; i++) {
            allMoves[i] = new String("");
        }
    }
// initialize pressed array which defines if the button is pressed or not
    private void initializePressedArr() {
        for (int i = 0; i < 9; i++) {
            pressed[i] = false;
        }
    }
//convert the moves in 2D array
    private String[][] getXOBoard() {
        String[][] xo = new String[3][3];
        int counter = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                // loop on them 
                xo[j][k] = allMoves[counter + j + k];
            }
           //counter+2 because i used the next 2 elements which were in string ( 3 elements the irst one which i placed on 
           // second and third next to me
            counter += 2;
        }
        return xo;
    }
//the same row with different columns 
    private boolean checkHorizontal() {
        String[][] xoBoard = getXOBoard();
        int k = 0;
        for (int j = 0; j < 3; j++) {
            if (xoBoard[j][k].equals(xoBoard[j][k + 1]) && xoBoard[j][k + 1].equals(xoBoard[j][k + 2]) && !xoBoard[j][k].equals("")) {
                return true;
            }
        }
        return false;
    }
// the same column with different rows
    private boolean checkVertical() {
        String[][] xoBoard = getXOBoard();
        int j = 0;
        for (int k = 0; k < 3; k++) {
            if (xoBoard[j][k].equals(xoBoard[j + 1][k]) && xoBoard[j + 1][k].equals(xoBoard[j + 2][k]) && !xoBoard[j][k].equals("")) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal() {
        
        String[][] xoBoard = getXOBoard();
        String[] tmp = new String[3];
       
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (j == k) {
                    tmp[j] = xoBoard[j][k];
                }
            }
        }
        int j = 0;
         // in case row = column
        if (tmp[j].equals(tmp[j + 1]) && tmp[j + 1].equals(tmp[j + 2]) && !tmp[j].equals("")) {
            return true;
        }
        //in case row !=column
        else if (xoBoard[0][2].equals(xoBoard[2][0]) && xoBoard[0][2].equals(xoBoard[1][1]) && !xoBoard[0][2].equals("")) {
            return true;
        }
        return false;
    }
// if any case of winning is true return true
    private boolean checkWinner() {
        if (checkHorizontal() || checkVertical() || checkDiagonal()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkNoWinner() {
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if (!allMoves[i].equals("")) {
                counter++;

            }
        }
        if (counter == 9) {
            completed = true;
        }
        return completed;
    }
//check ther is winner or no
    private boolean check() {

        if (checkWinner()) {
            Msg.setContentText(lastmove + " Wins");
            Msg.showAndWait();
            //make all pressed array is pressed to prevent another click on the same button
            for (int i = 0; i < 9; i++) {
                pressed[i] = true;
            }
            return true;
        } else {
            if (checkNoWinner()) {
                Msg.setContentText("NoWinner");
                Msg.showAndWait();
                return true;
            }
        }
        return false;
    }
//computer turn algorithm
    private int computerTurn() {
        Random r = new Random();
        int counterPressed = 0;
        // no pressed buttons indices in one array
        int freeIndices[] = new int[6];
        //generate random number with in range 0-8
        int randomNum = (int) (Math.random() * Math.random() * Math.random() * Math.random() * 9);
        int j = 0;
        // the winning cases need at least 3 buttons to be pressed to can predict the step which the other player may win by it
        for (int i = 0; i < 9; i++) {

            if (pressed[i] == true) {
                counterPressed++;
            }

        }
        // collect the indcies of buttonns which not pressed
        if (counterPressed >= 3) {

            for (int i = 0; i < 9; i++) {
                if (pressed[i] == false) {
                    freeIndices[j] = i;
                    j++;
                }
            }

        }

        for (int k = 0; k < j; k++) {
            System.out.println("free" + freeIndices[k]);
        }
        System.out.println("j" + j);
        if (counterPressed < 3) {
            // generate number not pressed and no one won before
            while (pressed[randomNum] == true && checkWinner() != true) {
                randomNum = (int) (Math.random() * Math.random() * Math.random() * Math.random() * 9);
                System.out.println(randomNum);
            }
        } else {
            //check on the cases which allow x or o to be won 
            for (int k = 0; k < j; k++) {
                System.out.println("freeIndex " + freeIndices[k]);
                allMoves[freeIndices[k]] = "x";
                if (checkWinner() == true) {
                    randomNum = freeIndices[k];
                    System.out.println("randomx " + randomNum);
                    return randomNum;
                } else {
                    allMoves[freeIndices[k]] = "o";
                    if (checkWinner() == true) {
                        randomNum = freeIndices[k];

                        System.out.println("randomo " + randomNum);
                        return randomNum;
                    } else {
                        allMoves[freeIndices[k]] = "";
                        while (pressed[randomNum] == true && checkWinner() != true) {
                            randomNum = (int) (Math.random() * Math.random() * Math.random() * Math.random() * 9);
                            System.out.println(randomNum);
                        }
                    }

                }
            }
        }

        return randomNum;
    }

    private void putEvent(FXMLgameBase g) {

        g.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[0] == false) {
                g.button.setGraphic(Casexoro());
                allMoves[0] = lastmove;
                win = check();

            }
            pressed[0] = true;
            // if the other player wasn't win allow computer to play 
            if (!win) {
                int cmpTurn = computerTurn();
                if (cmpTurn == 1) {
                    g.button0.setGraphic(Casexoro());
                    allMoves[1] = lastmove;
                    pressed[1] = true;
                } else if (cmpTurn == 2) {
                    g.button1.setGraphic(Casexoro());
                    allMoves[2] = lastmove;
                    pressed[2] = true;
                } else if (cmpTurn == 3) {
                    g.button2.setGraphic(Casexoro());
                    allMoves[3] = lastmove;
                    pressed[3] = true;
                } else if (cmpTurn == 4) {
                    g.button3.setGraphic(Casexoro());
                    allMoves[4] = lastmove;
                    pressed[4] = true;
                } else if (cmpTurn == 5) {
                    g.button4.setGraphic(Casexoro());
                    allMoves[5] = lastmove;
                    pressed[5] = true;
                } else if (cmpTurn == 6) {
                    g.button5.setGraphic(Casexoro());
                    allMoves[6] = lastmove;
                    pressed[6] = true;
                } else if (cmpTurn == 7) {
                    g.button6.setGraphic(Casexoro());
                    allMoves[7] = lastmove;
                    pressed[7] = true;

                } else if (cmpTurn == 8) {
                    g.button7.setGraphic(Casexoro());
                    allMoves[8] = lastmove;
                    pressed[8] = true;
                }
                win = check();
            }
        });

        g.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[1] == false) {
                g.button0.setGraphic(Casexoro());
                allMoves[1] = lastmove;
                win = check();

            }
            pressed[1] = true;
            if (!win) {
                int cmpTurn = computerTurn();

                if (cmpTurn == 0) {
                    g.button.setGraphic(Casexoro());
                    allMoves[0] = lastmove;
                    pressed[0] = true;
                } else if (cmpTurn == 2) {
                    g.button1.setGraphic(Casexoro());
                    allMoves[2] = lastmove;
                    pressed[2] = true;
                } else if (cmpTurn == 3) {
                    g.button2.setGraphic(Casexoro());
                    allMoves[3] = lastmove;
                    pressed[3] = true;
                } else if (cmpTurn == 4) {
                    g.button3.setGraphic(Casexoro());
                    allMoves[4] = lastmove;
                    pressed[4] = true;
                } else if (cmpTurn == 5) {
                    g.button4.setGraphic(Casexoro());
                    allMoves[5] = lastmove;
                    pressed[5] = true;
                } else if (cmpTurn == 6) {
                    g.button5.setGraphic(Casexoro());
                    allMoves[6] = lastmove;
                    pressed[6] = true;
                } else if (cmpTurn == 7) {
                    g.button6.setGraphic(Casexoro());
                    allMoves[7] = lastmove;
                    pressed[7] = true;

                } else if (cmpTurn == 8) {
                    g.button7.setGraphic(Casexoro());
                    allMoves[8] = lastmove;
                    pressed[8] = true;
                }
                win = check();
            }
        });
        g.button1.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[2] == false) {
                g.button1.setGraphic(Casexoro());
                allMoves[2] = lastmove;
                win = check();

            }
            pressed[2] = true;
            System.out.print("Button3");
            if (!win) {

                int cmpTurn = computerTurn();
                System.out.print(cmpTurn);
                if (cmpTurn == 0) {

                    g.button.setGraphic(Casexoro());
                    allMoves[0] = lastmove;
                    pressed[0] = true;
                } else if (cmpTurn == 1) {
                    g.button1.setGraphic(Casexoro());
                    allMoves[1] = lastmove;
                    pressed[1] = true;
                } else if (cmpTurn == 3) {
                    g.button2.setGraphic(Casexoro());
                    allMoves[3] = lastmove;
                    pressed[3] = true;
                } else if (cmpTurn == 4) {
                    g.button3.setGraphic(Casexoro());
                    allMoves[4] = lastmove;
                    pressed[4] = true;
                } else if (cmpTurn == 5) {
                    g.button4.setGraphic(Casexoro());
                    allMoves[5] = lastmove;
                    pressed[5] = true;
                } else if (cmpTurn == 6) {
                    g.button5.setGraphic(Casexoro());
                    allMoves[6] = lastmove;
                    pressed[6] = true;
                } else if (cmpTurn == 7) {
                    g.button6.setGraphic(Casexoro());
                    allMoves[7] = lastmove;
                    pressed[7] = true;

                } else if (cmpTurn == 8) {
                    g.button7.setGraphic(Casexoro());
                    allMoves[8] = lastmove;
                    pressed[8] = true;
                }
                win = check();
            }
        });
        g.button2.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[3] == false) {
                g.button2.setGraphic(Casexoro());
                allMoves[3] = lastmove;
                win = check();

            }
            pressed[3] = true;
            if (!win) {
                int cmpTurn = computerTurn();

                if (cmpTurn == 0) {

                    g.button.setGraphic(Casexoro());
                    allMoves[0] = lastmove;
                    pressed[0] = true;
                } else if (cmpTurn == 1) {
                    g.button0.setGraphic(Casexoro());
                    allMoves[1] = lastmove;
                    pressed[1] = true;
                } else if (cmpTurn == 2) {
                    g.button1.setGraphic(Casexoro());
                    allMoves[2] = lastmove;
                    pressed[2] = true;
                } else if (cmpTurn == 4) {
                    g.button3.setGraphic(Casexoro());
                    allMoves[4] = lastmove;
                    pressed[4] = true;
                } else if (cmpTurn == 5) {
                    g.button4.setGraphic(Casexoro());
                    allMoves[5] = lastmove;
                    pressed[5] = true;
                } else if (cmpTurn == 6) {
                    g.button5.setGraphic(Casexoro());
                    allMoves[6] = lastmove;
                    pressed[6] = true;
                } else if (cmpTurn == 7) {
                    g.button6.setGraphic(Casexoro());
                    allMoves[7] = lastmove;
                    pressed[7] = true;

                } else if (cmpTurn == 8) {
                    g.button7.setGraphic(Casexoro());
                    allMoves[8] = lastmove;
                    pressed[8] = true;
                }
                win = check();
            }
        });
        g.button3.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[4] == false) {
                g.button3.setGraphic(Casexoro());
                allMoves[4] = lastmove;
                win = check();
              
            }
            pressed[4] = true;
            if (!win) {
                int cmpTurn = computerTurn();
                if (cmpTurn == 0) {

                    g.button.setGraphic(Casexoro());
                    allMoves[0] = lastmove;
                    pressed[0] = true;
                } else if (cmpTurn == 1) {
                    g.button0.setGraphic(Casexoro());
                    allMoves[1] = lastmove;
                    pressed[1] = true;
                } else if (cmpTurn == 2) {
                    g.button1.setGraphic(Casexoro());
                    allMoves[2] = lastmove;
                    pressed[2] = true;
                } else if (cmpTurn == 3) {
                    g.button2.setGraphic(Casexoro());
                    allMoves[3] = lastmove;
                    pressed[3] = true;
                } else if (cmpTurn == 5) {
                    g.button4.setGraphic(Casexoro());
                    allMoves[5] = lastmove;
                    pressed[5] = true;
                } else if (cmpTurn == 6) {
                    g.button5.setGraphic(Casexoro());
                    allMoves[6] = lastmove;
                    pressed[6] = true;
                } else if (cmpTurn == 7) {
                    g.button6.setGraphic(Casexoro());
                    allMoves[7] = lastmove;
                    pressed[7] = true;

                } else if (cmpTurn == 8) {
                    g.button7.setGraphic(Casexoro());
                    allMoves[8] = lastmove;
                    pressed[8] = true;
                }
                win = check();
            }
        });
        g.button4.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[5] == false) {
                g.button4.setGraphic(Casexoro());
                allMoves[5] = lastmove;
                win = check();
               
            }
            pressed[5] = true;
            if (!win) {
                int cmpTurn = computerTurn();
                if (cmpTurn == 0) {
                    g.button.setGraphic(Casexoro());
                    allMoves[0] = lastmove;
                    pressed[0] = true;
                } else if (cmpTurn == 1) {
                    g.button0.setGraphic(Casexoro());
                    allMoves[1] = lastmove;
                    pressed[1] = true;
                } else if (cmpTurn == 2) {
                    g.button1.setGraphic(Casexoro());
                    allMoves[2] = lastmove;
                    pressed[2] = true;
                } else if (cmpTurn == 3) {
                    g.button2.setGraphic(Casexoro());
                    allMoves[3] = lastmove;
                    pressed[3] = true;
                } else if (cmpTurn == 4) {
                    g.button3.setGraphic(Casexoro());
                    allMoves[4] = lastmove;
                    pressed[4] = true;
                } else if (cmpTurn == 6) {
                    g.button5.setGraphic(Casexoro());
                    allMoves[6] = lastmove;
                    pressed[6] = true;
                } else if (cmpTurn == 7) {
                    g.button6.setGraphic(Casexoro());
                    allMoves[7] = lastmove;
                    pressed[7] = true;

                } else if (cmpTurn == 8) {
                    g.button7.setGraphic(Casexoro());
                    allMoves[8] = lastmove;
                    pressed[8] = true;
                }

                win = check();
            }
        });
        g.button5.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[6] == false) {
                g.button5.setGraphic(Casexoro());
                allMoves[6] = lastmove;
                win = check();
               
            }
            pressed[6] = true;
            if (!win) {
                int cmpTurn = computerTurn();
                if (cmpTurn == 0) {

                    g.button.setGraphic(Casexoro());
                    allMoves[0] = lastmove;
                    pressed[0] = true;
                } else if (cmpTurn == 1) {
                    g.button0.setGraphic(Casexoro());
                    allMoves[1] = lastmove;
                    pressed[1] = true;
                } else if (cmpTurn == 2) {
                    g.button1.setGraphic(Casexoro());
                    allMoves[2] = lastmove;
                    pressed[2] = true;
                } else if (cmpTurn == 3) {
                    g.button2.setGraphic(Casexoro());
                    allMoves[3] = lastmove;
                    pressed[3] = true;
                } else if (cmpTurn == 4) {
                    g.button3.setGraphic(Casexoro());
                    allMoves[4] = lastmove;
                    pressed[4] = true;
                } else if (cmpTurn == 5) {
                    g.button4.setGraphic(Casexoro());
                    allMoves[5] = lastmove;
                    pressed[5] = true;
                } else if (cmpTurn == 7) {
                    g.button6.setGraphic(Casexoro());
                    allMoves[7] = lastmove;
                    pressed[7] = true;

                } else if (cmpTurn == 8) {
                    g.button7.setGraphic(Casexoro());
                    allMoves[8] = lastmove;
                    
                    pressed[8] = true;
                }
                win = check();
            }
        });
        g.button6.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[7] == false) {
                g.button6.setGraphic(Casexoro());
                allMoves[7] = lastmove;
                win = check();
            }
            pressed[7] = true;
            if (!win) {
                int cmpTurn = computerTurn();

                if (cmpTurn == 0) {

                    g.button.setGraphic(Casexoro());
                    allMoves[0] = lastmove;
                    pressed[0] = true;
                } else if (cmpTurn == 1) {
                    g.button0.setGraphic(Casexoro());
                    allMoves[1] = lastmove;
                    pressed[1] = true;
                } else if (cmpTurn == 2) {
                    g.button1.setGraphic(Casexoro());
                    allMoves[2] = lastmove;
                    pressed[2] = true;
                } else if (cmpTurn == 3) {
                    g.button2.setGraphic(Casexoro());
                    allMoves[3] = lastmove;
                    pressed[3] = true;
                } else if (cmpTurn == 4) {
                    g.button3.setGraphic(Casexoro());
                    allMoves[4] = lastmove;
                    pressed[4] = true;
                } else if (cmpTurn == 5) {
                    g.button4.setGraphic(Casexoro());
                    allMoves[5] = lastmove;
                    pressed[5] = true;
                } else if (cmpTurn == 6) {
                    g.button5.setGraphic(Casexoro());
                    allMoves[6] = lastmove;
                    pressed[6] = true;
                } else if (cmpTurn == 8) {
                    g.button7.setGraphic(Casexoro());
                    allMoves[8] = lastmove;
                    pressed[8] = true;
                }
                win = check();
            }
        });
        g.button7.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[8] == false) {
                g.button7.setGraphic(Casexoro());
                allMoves[8] = lastmove;
                win = check();
            }
            pressed[8] = true;
            if (!win) {
                int cmpTurn = computerTurn();
                if (cmpTurn == 0) {

                    g.button.setGraphic(Casexoro());
                    allMoves[0] = lastmove;
                    pressed[0] = true;
                } else if (cmpTurn == 1) {
                    g.button0.setGraphic(Casexoro());
                    allMoves[1] = lastmove;
                    pressed[1] = true;
                } else if (cmpTurn == 2) {
                    g.button1.setGraphic(Casexoro());
                    allMoves[2] = lastmove;
                    pressed[2] = true;
                } else if (cmpTurn == 3) {
                    g.button2.setGraphic(Casexoro());
                    allMoves[3] = lastmove;
                    pressed[3] = true;
                } else if (cmpTurn == 4) {
                    g.button3.setGraphic(Casexoro());
                    allMoves[4] = lastmove;
                    pressed[4] = true;
                } else if (cmpTurn == 5) {
                    g.button4.setGraphic(Casexoro());
                    allMoves[5] = lastmove;
                    pressed[5] = true;
                } else if (cmpTurn == 6) {
                    g.button5.setGraphic(Casexoro());
                    allMoves[6] = lastmove;
                    pressed[6] = true;
                } else if (cmpTurn == 7) {
                    g.button6.setGraphic(Casexoro());
                    allMoves[7] = lastmove;
                    pressed[7] = true;

                }
                win = check();
            }
        });
        g.button11.setGraphic(drawSoundLogo("image/sound.png"));
        g.button11.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (sound == true) {
                clickOrSound(0);
                g.button11.setGraphic(drawSoundLogo("image/nosound.png"));
                sound = false;
                playSound();
            } else {
                clickOrSound(0);
                g.button11.setGraphic(drawSoundLogo("image/sound.png"));
                sound = true;
                playSound();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
}
