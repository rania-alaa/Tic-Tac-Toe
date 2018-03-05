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
        Button b[] = {g.button ,g.button0,g.button1,g.button2,g.button3,g.button4,g.button5,g.button6,g.button7};
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

        putEvent(g,b);

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
    public ImageView Casexoro() {
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

    private void initializeMovesArr() {
        for (int i = 0; i < 9; i++) {
            allMoves[i] = new String("");
        }
    }

    private void initializePressedArr() {
        for (int i = 0; i < 9; i++) {
            pressed[i] = false;
        }
    }

    private String[][] getXOBoard() {
        String[][] xo = new String[3][3];
        int counter = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                xo[j][k] = allMoves[counter + j + k];
            }
            counter += 2;
        }
        return xo;
    }

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
        if (tmp[j].equals(tmp[j + 1]) && tmp[j + 1].equals(tmp[j + 2]) && !tmp[j].equals("")) {
            return true;
        } else if (xoBoard[0][2].equals(xoBoard[2][0]) && xoBoard[0][2].equals(xoBoard[1][1]) && !xoBoard[0][2].equals("")) {
            return true;
        }
        return false;
    }

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

    private void check() {
        boolean checkflag = true;
       if(checkflag == true){
        if (checkWinner()) {
            Msg.setContentText(lastmove + " Wins");
            Msg.showAndWait();
            for (int i = 0; i < 9; i++) {
                pressed[i] = true;
            }
            checkflag = false;
        } else {
            
            if (checkNoWinner()) {
                Msg.setContentText("NoWinner");
                Msg.showAndWait();
            }
            checkflag = false;
        }
}
       
    }

//    private int computerTurn() {
//        Random r = new Random();
//        int counterPressed = 0;
//        int freeIndices[] = new int[6];
//        int randomNum = (int) (Math.random() * Math.random() * Math.random() * Math.random() * 9);
//        int j = 0;
//        for (int i = 0; i < 9; i++) {
//
//            if (pressed[i] == true) {
//                counterPressed++;
//            }
//           
//        }
//if(counterPressed>=3)
//{
//    
//for(int i=0;i<9;i++)
//{
//                if (pressed[i] == false) {
//                    freeIndices[j] = i;
//                    j++;
//                }
//}
//
//}
//    
//for(int k=0;k<j;k++)
//{
//              System.out.println("free"+freeIndices[k]);
//}
// System.out.println("j"+j);
// if(counterPressed<3)
// {
//        while (pressed[randomNum] == true && checkWinner() != true) {
//            randomNum = (int) (Math.random() * Math.random() * Math.random() * Math.random() * 9);
//            System.out.println(randomNum);
//        }
// }
// else
// {
//for(int k=0;k<j;k++)
//{
//    System.out.println("freeIndex "+freeIndices[k]);
//    allMoves[freeIndices[k]]="x";
//    if(checkWinner()==true)
//    {
//        randomNum=freeIndices[k];
//         System.out.println("randomx "+randomNum);
//        return randomNum;
//    }
//    else
//    {
//    allMoves[freeIndices[k]]="o";
//    if(checkWinner()==true)
//    {
//        randomNum=freeIndices[k];
//        
//        System.out.println("randomo "+randomNum);
//        return randomNum;
//    }
//    else
//    {
//        allMoves[freeIndices[k]]="";
//         while (pressed[randomNum] == true && checkWinner() != true) {
//            randomNum = (int) (Math.random() * Math.random() * Math.random() * Math.random() * 9);
//            System.out.println(randomNum);
//        }
//    }
//  
//    }
//}
// }
//      }  if(randomNum==0)
//        {
//            g.button.setGraphic(Casexoro());
//            pressed[0]=true;
//        }
//        else   if(randomNum==1)
//        {
//            g.button0.setGraphic(Casexoro());
//            pressed[1]=true;
//        }
//        else   if(randomNum==2)
//        {
//            g.button1.setGraphic(Casexoro());
//            pressed[2]=true;
//        }
//        else   if(randomNum==3)
//        {
//            g.button2.setGraphic(Casexoro());
//            pressed[3]=true;
//        }
//        else  if(randomNum==4)
//        {
//            g.button3.setGraphic(Casexoro());
//            pressed[4]=true;
//        }
//        else if(randomNum==5)
//        {
//            g.button4.setGraphic(Casexoro());
//            pressed[5]=true;
//        }
//         else if(randomNum==6)
//        {
//            g.button5.setGraphic(Casexoro());
//            pressed[6]=true;
//        }
//         else if(randomNum==7)
//        {
//            g.button6.setGraphic(Casexoro());
//            pressed[7]=true;
//        }
//        else if(randomNum==8)
//        {
//            g.button7.setGraphic(Casexoro());
//            pressed[8]=true;
//        }
//     putEvent(g);
//        return randomNum;
//    }

    private void putEvent(FXMLgameBase g,Button b[]) {

        g.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[0] == false) {
                g.button.setGraphic(Casexoro());
                allMoves[0] = lastmove;
                check();

            }
            pressed[0] = true;
            rand(b);
            check();
      
        });

        g.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[1] == false) {
                g.button0.setGraphic(Casexoro());
                allMoves[1] = lastmove;
                check();
            }
            pressed[1] = true;
            rand(b);
            check();
        });
        g.button1.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[2] == false) {
                g.button1.setGraphic(Casexoro());
                allMoves[2] = lastmove;
                check();
            }
            pressed[2] = true;
            rand(b);
            check();
        });
        g.button2.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[3] == false) {
                g.button2.setGraphic(Casexoro());
                allMoves[3] = lastmove;
                check();
            }
            pressed[3] = true;
            rand(b);
             check();
    });
        g.button3.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[4] == false) {
                g.button3.setGraphic(Casexoro());
                allMoves[4] = lastmove;
                check();
            }
            pressed[4] = true;
            rand(b);
             check();
        });
        g.button4.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[5] == false) {
                g.button4.setGraphic(Casexoro());
                allMoves[5] = lastmove;
                check();
            }
            pressed[5] = true;
            rand(b);
             check();
        });
        g.button5.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[6] == false) {
                g.button5.setGraphic(Casexoro());
                allMoves[6] = lastmove;
                check();
            }
            pressed[6] = true;
            rand(b);
            check();
        });
        g.button6.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[7] == false) {
                g.button6.setGraphic(Casexoro());
                allMoves[7] = lastmove;
                check();
            }
            pressed[7] = true;
            rand(b);
             check();
        });
        g.button7.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if (pressed[8] == false) {
                g.button7.setGraphic(Casexoro());
                allMoves[8] = lastmove;
                check();
            }
            pressed[8] = true;
            rand(b);
            check();
        
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
    
     public void rand(Button b[]){
     String rando;
     int rand =(int)(Math.random() * 9);
     boolean x = false;
     do{ 
         rando =String.valueOf(rand);
         for ( String val : allMoves )
         { if (rando == val)
         {
             
             continue;
         }
         else
             x = true;
          }
        // casexoro();
     } while(!x);
     b[rand].setGraphic(Casexoro());
    // allMoves[rand] = rando;
           pressed[rand] = true;
 }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
}
