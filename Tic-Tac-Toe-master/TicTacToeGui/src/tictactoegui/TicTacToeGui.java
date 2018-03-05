/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;
//import tictactoegui.DrawPattern;

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
/**
 *
 * @author rania
 */
public class TicTacToeGui extends Application {
//    DrawPattern drawpattern = new DrawPattern();
   protected static String lastmove= "x";//
    //String playerOne = new String("X");
    //String playerTwo = new String("O");
    protected static String[] allMoves=new String[9];
    public Alert Msg=new Alert(AlertType.INFORMATION);
    
    boolean completed=false;
   protected static boolean[] pressed = new boolean[9];
    boolean sound=true;
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
        Scene symbolscene = new Scene(symbolpage,700,600);
        Scene modescene = new Scene(modepage, 700, 600);
        Scene playerscene = new Scene(playerpage, 700, 600);
        Scene gamescene = new Scene(g, 700, 600);
        g.gridPane.setEffect(new DropShadow(15, 0, 15, Color.GREY));
        symbolpage.label.setGraphic(ViewSound.logo());
        player1page.label.setGraphic(ViewSound.logo());
        modepage.label0.setGraphic(ViewSound.logo());
        playerpage.label0.setGraphic(ViewSound.logo());
         //x button in symbolscene
        symbolpage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
             ViewSound.clickOrSound(0);
            lastmove ="o";
            primaryStage.setScene(modescene);
        });
        //x button in symbolscene
        symbolpage.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
             ViewSound.clickOrSound(0);
            lastmove ="x";
            primaryStage.setScene(modescene);
        });
        
        //next buton in  player1page
        player1page.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
             ViewSound.clickOrSound(0);
            primaryStage.setScene(symbolscene);
        });
        
        //singlebutton
        modepage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            ViewSound.clickOrSound(0);
            g.text2.setText("Computer");
            primaryStage.setScene(gamescene);
        });
        //2 player button
        modepage.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            ViewSound.clickOrSound(0);
            primaryStage.setScene(playerscene);
        });
        
        //nextbutton playerpage
        playerpage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(playerpage.textField.getText().isEmpty())
            {}
            else{
                g.text2.setText(playerpage.textField.getText());
                primaryStage.setScene(gamescene);
            }
            ViewSound.clickOrSound(0);
        }); 
        
        //menubutton gamepage
        g.button8.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            ViewSound.clickOrSound(0);
            primaryStage.setScene(modescene);
        }); 
        g.text0.setText("rania");
       DrawPattern.initializeMovesArr();
       DrawPattern.initializePressedArr();
        Msg.setTitle("Winner Message");
        Msg.setHeaderText(null);
        ViewSound.clickOrSound(1);
        putEvent(g);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(player1scene);
        primaryStage.show();
    }
     
   
    private void putEvent(FXMLgameBase g){    
        g.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[0]==false)
            {
                g.button.setGraphic(DrawPattern.Casexoro());
                allMoves[0]=lastmove; 
                CheckWin.check();
            }
            pressed[0]=true;
        });
       
        g.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[1]==false)
            {
               g.button0.setGraphic(DrawPattern.Casexoro());
                allMoves[1]=lastmove;
             	CheckWin.check();
            }
            pressed[1]=true;
        });
        g.button1.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[2]==false)
            {
                g.button1.setGraphic(DrawPattern.Casexoro());            
                allMoves[2]=lastmove;   
                CheckWin.check();
            }
            pressed[2]=true;
        });
        g.button2.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[3]==false)
            {
                g.button2.setGraphic(DrawPattern.Casexoro());         
                allMoves[3]=lastmove; 
               	CheckWin.check();
            }
            pressed[3]=true;
        });
        g.button3.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[4]==false)
            {
                g.button3.setGraphic(DrawPattern.Casexoro());            
                allMoves[4]=lastmove;  
				CheckWin.check();               
            }
            pressed[4]=true;
        });
        g.button4.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[5]==false)
            {
                g.button4.setGraphic(DrawPattern.Casexoro());
                allMoves[5]=lastmove; 
              	CheckWin.check();
            }
            pressed[5]=true;
        });
        g.button5.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[6]==false)
            {
                g.button5.setGraphic(DrawPattern.Casexoro());
                allMoves[6]=lastmove; 
              	CheckWin.check();
            }
            pressed[6]=true;
        });
         g.button6.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[7]==false)
            {
                g.button6.setGraphic(DrawPattern.Casexoro());
                allMoves[7]=lastmove;  
                CheckWin.check();
            }
            pressed[7]=true;
        });
        g.button7.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[8]==false)
            {
                g.button7.setGraphic(DrawPattern.Casexoro());
                allMoves[8]=lastmove;
                CheckWin.check();
            }
            pressed[8]=true;
        });
        g.button11.setGraphic(ViewSound.drawSoundLogo("image/sound.png"));
        g.button11.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
           if(sound==true){
               ViewSound.clickOrSound(0);
               g.button11.setGraphic(ViewSound.drawSoundLogo("image/nosound.png"));
               sound=false;
               ViewSound.playSound();
           }
           else{
               ViewSound.clickOrSound(0);
               g.button11.setGraphic(ViewSound.drawSoundLogo("image/sound.png"));
               sound=true;
               ViewSound.playSound();
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