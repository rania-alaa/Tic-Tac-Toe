/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;
import tictactoegui.TicTacToeGui;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author Norhan
 */
public class ViewSound extends TicTacToeGui{
    static public void clickOrSound (int num){
        ViewSound v = new ViewSound();
        v.soundtwo(num);
    }
    
    static public void playSound(){
        ViewSound v2 = new ViewSound();
        v2.playSoundtwo();
    }    

   

      public void soundtwo(int num){
        if(num == 0){
           // 
            final java.net.URL resource = getClass().getResource("music/Click2.mp3"); 
            final Media media = new Media(resource.toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        }
        else if(num == 1){
            ViewSound v = new ViewSound();
            mediaplayer.setOnEndOfMedia(() -> {
                mediaplayer.seek(Duration.ZERO);
            });
            mediaplayer.play(); 
        }
    }    
      public void playSoundtwo(){
        if(sound==true){
            mediaplayer.play();
        }
        else{
            mediaplayer.pause();
        }
    }
     static public ImageView drawSoundLogo(String name){
        Image sound = new Image(ViewSound.class.getResourceAsStream(name));
        ImageView view = new ImageView(sound);
        view.setFitHeight(50);
        view.setFitWidth(50);
        return view;
    }
     static public ImageView logo(){
        Image logo = new Image(ViewSound.class.getResourceAsStream("image/logo3.png"));
        ImageView view = new ImageView(logo);
        view.setFitHeight(110);
        view.setFitWidth(600);
        return view;
    }

}
