/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoegui.TicTacToeGui;
import static tictactoegui.TicTacToeGui.playermode;
import static tictactoegui.TicTacToeGui.singlemode;

/**
 *
 * @author rania
 */
   public class VideoEvent {
     String pattern = new String("158x");
     Stage videowindow=new Stage();
     int index;
     String move;
     int i=0;
     FXMLvideoBase videopage = new FXMLvideoBase();
     Scene videoscene = new Scene(videopage,700,600);
     Button b[]={videopage.button,videopage.button0,videopage.button1,videopage.button2,
            videopage.button3,videopage.button4,videopage.button5,videopage.button6,videopage.button7};
    public void Event(){
       // pattern = TicTacToeGui.pattern;
        pattern ="158x";
        move =pattern.substring(pattern.length() - 1);
        videowindow.initModality(Modality.APPLICATION_MODAL);
        videowindow.setTitle("game video");
        videowindow.setScene(videoscene);
        videowindow.show();
        videopage.button8.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            TicTacToeGui.snd.clickOrSound(0);
            //send pattern to data base
        });        
        videopage.button9.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            TicTacToeGui.snd.clickOrSound(0);              
            Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event1) -> {
                index=Integer.parseInt(pattern.substring(i, i+1));
                if( "x".equals(move)){
                    TicTacToeGui.lastmove="o";
                    move="o";
                }
                else{
                    TicTacToeGui.lastmove="x";
                    move="x";
                }
                b[index].setGraphic(DrawPattern.Casexoro());
                i++;
            }));
        fiveSecondsWonder.setCycleCount(pattern.length()-1);
        if(i<pattern.length()-2){
            fiveSecondsWonder.play();
            System.out.println("play");}
        else {
            fiveSecondsWonder.stop();
            System.out.println("stop");}
        });
         System.out.println("stopppp");
    } 
}
