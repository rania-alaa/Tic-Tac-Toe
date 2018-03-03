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
import networkpackage.CLintHandler;

//

import networkpackage.Game;

/**
 *
 * @author rania
 */
public class TicTacToeGui extends Application {
    
    String lastmove= new String("x");//
    Game game = new Game();
    int iconToSet = 1;
    CLintHandler clintHandler;
    
    @Override
    public void start(Stage primaryStage) throws MalformedURLException {  
        FXMLgameBase g = new FXMLgameBase(); 
        Scene scene = new Scene(g, 700, 600);
        g.text0.setText("rania");
     
        putEvent(g);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
        clintHandler = new CLintHandler();
    }
//    private ImageView Casexoro (){
//        ImageView view;
//         if("x".equals(lastmove))
//            { 
//                lastmove="o";
//                 view=Drawo();
//            }
//            else {
//                lastmove="x";
//                view=Drawx();
//            }
//        return view;
//    }
    
    void setCellinGridArr(int x, int y, int icon){
        if(iconToSet == 1){
            game.setCellValue(x, y, 1);
            iconToSet = 2;
        }
        else{
            game.setCellValue(x, y, 2);
            iconToSet = 1;
        }
            
    }
    private ImageView Casexoro (int x , int y){
        ImageView view = null;
        int [][] gridArr = game.getGridArr();
 
        switch (gridArr[x][y]) {
            case 1:
                view =  Drawx();
                break;
            case 2:
                view =  Drawo();
                break;
            default:
                break;
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
    
    public void sendMovetoServer(int x, int y , int icon){
        if(clintHandler.isMyTurn){
           clintHandler.ps.println("PAT_"+x+"_"+y+"_"+icon); 
           clintHandler.isMyTurn = false;
        }
        
    }
    
    private void putEvent(FXMLgameBase g){
        g.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            setCellinGridArr(0, 0, 1);
            g.button.setGraphic(Casexoro(0,0));
           // g.button.setDisable(true);
            
        });
        
        g.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                setCellinGridArr(0, 1, 1);
                g.button0.setGraphic(Casexoro(0,1));
                //g.button.setDisable(true);
                //add function to send to server
                sendMovetoServer(0,1,clintHandler.player.getPlayerIcon());
        });
        
        g.button1.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            setCellinGridArr(0, 2, 1);
            g.button1.setGraphic(Casexoro(0,2));
        });
        
        g.button2.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            setCellinGridArr(1,0, 1);
            g.button2.setGraphic(Casexoro(1,0));
        });
        
        g.button3.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                setCellinGridArr(1,1, 1);
                g.button3.setGraphic(Casexoro(1,1));
        });
        
        g.button4.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            setCellinGridArr(1,2, 1);
                g.button4.setGraphic(Casexoro(1,2));
        });
        
        g.button5.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            setCellinGridArr(2, 0, 1);
            g.button5.setGraphic(Casexoro(2,0));
        });
        
        g.button6.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            setCellinGridArr(2,1, 1);
            g.button6.setGraphic(Casexoro(2,1));
        });
         
        g.button7.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            setCellinGridArr(2,2, 1);
            g.button7.setGraphic(Casexoro(2,2));
        });
        
        //save 
        g.button10.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            game.saveGame();
        });
        
        //restore
        g.button8.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            Game game2 =  Game.loadGame();
             System.out.println(" the values of the array =  ");
            for(int i =0 ; i<3 ;i++){
                for(int j=0 ;j<3 ; j++){
                    System.out.print("  "+game2.getCellValue(i, j));
                }
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
