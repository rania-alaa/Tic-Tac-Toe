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
import javafx.stage.Stage;

/**
 *
 * @author Norhan
 */
public class TicTacToeGui extends Application {
    
    String lastmove= new String("x");//
    //String playerOne = new String("X");
    //String playerTwo = new String("O");
    @Override
    public void start(Stage primaryStage) throws MalformedURLException {  
        FXMLgameBase g = new FXMLgameBase(); 
        Scene scene = new Scene(g, 700, 600);
        g.text0.setText("rania");
     
        putEvent(g);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
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
    private ImageView Casexoro (){
        ImageView view;
         if("x".equals(lastmove))
            { 
                lastmove="o";
                 view=Drawo();
            }
            else {
                lastmove="x";
                view=Drawx();
            }
        return view;
    }
    private ImageView Drawx(){
        
        Image imgx = new Image(getClass().getResourceAsStream("image/x.png"));
        ImageView viewx = new ImageView(imgx);
        viewx.setFitHeight(110);
        viewx.setFitWidth(90);
        return viewx;
    }
    private ImageView Drawo(){
        Image imgo = new Image(getClass().getResourceAsStream("image/o.png"));
        ImageView viewo = new ImageView(imgo);
        viewo.setFitHeight(110);
        viewo.setFitWidth(90);
        return viewo;
    }
 
    private void putEvent(FXMLgameBase g){
        int clicked[] = new int[9];
        
        g.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
           // if(clicked[0]==0)
           g.button.setGraphic(Casexoro());
           g.button.setDisable(true);
            
        });
        
        g.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                g.button0.setGraphic(Casexoro());
                g.button0.setDisable(true);
        });
        
        g.button1.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                g.button1.setGraphic(Casexoro());
                g.button1.setDisable(true);
        });
        
        g.button2.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                g.button2.setGraphic(Casexoro());
                g.button2.setDisable(true);
        });
        
        g.button3.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                g.button3.setGraphic(Casexoro());
                g.button3.setDisable(true);
        });
        
        g.button4.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                g.button4.setGraphic(Casexoro());
                g.button4.setDisable(true);
        });
        
        g.button5.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                g.button5.setGraphic(Casexoro());
                g.button5.setDisable(true);
        });
        
        g.button6.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                g.button6.setGraphic(Casexoro());
                g.button6.setDisable(true);
        });
        
        g.button7.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                g.button7.setGraphic(Casexoro());
                g.button7.setDisable(true);
        });
        
        g.button8.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                lastmove ="o";
                g.button9.setDisable(true);
        });
       
        g.button9.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
               lastmove="x";
               g.button8.setDisable(true);
        });
    }
    
//     public void  www(){  FXMLgameBase g = null;
//putEvent(g);}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
