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
import java.util.Optional;
import java.util.Vector;
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
import javafx.scene.control.ButtonType;
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
    public static Alert Msg=new Alert(AlertType.INFORMATION);
    public static boolean singlemode=false;
   public static boolean playermode = false;
   public static boolean completed=false;
   public static boolean win = false;
   protected static boolean[] pressed = new boolean[9];
   protected static boolean[] comppressed = new boolean[9];
   public static boolean sound=true;
    final java.net.URL resource = getClass().getResource("music/soundbg.mp3");
    final Media media = new Media(resource.toString());
    final MediaPlayer mediaplayer = new MediaPlayer(media);
    Vector<String> playerlist=new Vector<String>(10,1);
    @Override
    public void start(Stage primaryStage) throws MalformedURLException {
        FXMLvideoBase videopage = new FXMLvideoBase();
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
        Scene videoscene = new Scene(videopage,700,600);
        Button b[] = {g.button,g.button0,g.button1,g.button2,g.button3,g.button4,g.button5,g.button6,g.button7};
        g.gridPane.setEffect(new DropShadow(15, 0, 15, Color.GREY));
        symbolpage.label.setGraphic(ViewSound.logo());
        player1page.label.setGraphic(ViewSound.logo());
        modepage.label0.setGraphic(ViewSound.logo());
        playerpage.label0.setGraphic(ViewSound.logo());
        
        playerlist.add("Abd El-Rahman");
        playerlist.add("Enas");
        playerlist.add("Nourhan");
        playerlist.add("Rania");
        String newplayer = new String("Add new Player");
        player1page.choiceBox.getItems().add(newplayer);
        player1page.choiceBox.getItems().addAll(playerlist);
        player1page.choiceBox.setValue(newplayer);
        
         //x button in symbolscene
        symbolpage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
             ViewSound.clickOrSound(0);
            lastmove ="o";
            primaryStage.setScene(modescene);
        });
        //o button in symbolscene
        symbolpage.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
             ViewSound.clickOrSound(0);
            lastmove ="x";
            primaryStage.setScene(modescene);
        });
        
        //next buton in  player1page
        player1page.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
             ViewSound.clickOrSound(0);
             String player1 = player1page.choiceBox.getValue().toString();
            System.out.println(player1);
            if(player1==newplayer){
                PopUp pop = new PopUp();
                String name = pop.display("addplayer");
               player1page.choiceBox.getItems().add(name);
               player1page.choiceBox.setValue(name);
               playerlist.add(name);
            }
            else{
                g.text0.setText(player1);
                 ViewSound.clickOrSound(0);
                primaryStage.setScene(symbolscene);
            }
        });
        
        //singlebutton
        modepage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            ViewSound.clickOrSound(0);
            g.text2.setText("Computer");
            singlemode=true;
            playermode=false;
            primaryStage.setScene(gamescene);
        });
        //2 player button
        modepage.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            ViewSound.clickOrSound(0);
            singlemode=false;
            playermode=true;
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
           Msg.setContentText("Are you sure you want to exit the game ? you will lose ithe game ");
            Msg.setAlertType(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> result = Msg.showAndWait();
            if(result.get() == ButtonType.OK){
                if(sound==false){
                    sound=true;
                    ViewSound.clickOrSound(1);
                }
                singlemode=false;
                playermode=false;
                initGui(b);
                primaryStage.setScene(modescene);
            }
        }); 
        //resetbutton gamepage
        g.button9.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            ViewSound.clickOrSound(0);
            Msg.setContentText("Are you sure you want to reset the game ? ");
            Msg.setAlertType(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> result = Msg.showAndWait();
            if(result.get() == ButtonType.OK){
               initGui(b);
            }
        }); 
       DrawPattern.initializeMovesArr();
       DrawPattern.initializePressedArr();
       DrawPattern.initializeCompPressedArr();
        Msg.setTitle("Winner Message");
        Msg.setHeaderText(null);
        ViewSound.clickOrSound(1);
        CheckEvent.putEvent(g);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(player1scene);
        primaryStage.show();
    }
    private void initGui(Button b[]){
        if(lastmove=="x"){
            lastmove="o";
        }
        else{
            lastmove="x";
        }
       for(int i=0;i<9;i++)
                {
                    b[i].setGraphic(ViewSound.reset());
                    pressed[i]=false;
                }
                DrawPattern.initializeMovesArr();
                DrawPattern.initializePressedArr(); 
                DrawPattern.initializeCompPressedArr();
                completed=false;
                win = false;
   }
     
   
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
      
    }
}