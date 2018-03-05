/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;
import tictactoegui.TicTacToeGui;
import javafx.event.ActionEvent;
import static tictactoegui.TicTacToeGui.pressed;
import tictactoegui.ViewSound;
/**
 *
 * @author Norhan
 */
public class CheckEvent {
       static public void putEvent(FXMLgameBase g){    
        g.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[0]==false)
            {
                g.button.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[0]=TicTacToeGui.lastmove; 
                CheckWin.check();
            }
            pressed[0]=true;
        });
       
        g.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[1]==false)
            {
               g.button0.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[1]=TicTacToeGui.lastmove;
             	CheckWin.check();
            }
            pressed[1]=true;
        });
        g.button1.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[2]==false)
            {
                g.button1.setGraphic(DrawPattern.Casexoro());            
                TicTacToeGui.allMoves[2]=TicTacToeGui.lastmove;   
                CheckWin.check();
            }
            pressed[2]=true;
        });
        g.button2.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[3]==false)
            {
                g.button2.setGraphic(DrawPattern.Casexoro());         
                TicTacToeGui.allMoves[3]=TicTacToeGui.lastmove; 
               	CheckWin.check();
            }
            pressed[3]=true;
        });
        g.button3.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[4]==false)
            {
                g.button3.setGraphic(DrawPattern.Casexoro());            
                TicTacToeGui.allMoves[4]=TicTacToeGui.lastmove;  
				CheckWin.check();               
            }
            pressed[4]=true;
        });
        g.button4.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[5]==false)
            {
                g.button4.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[5]=TicTacToeGui.lastmove; 
              	CheckWin.check();
            }
            pressed[5]=true;
        });
        g.button5.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[6]==false)
            {
                g.button5.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[6]=TicTacToeGui.lastmove; 
              	CheckWin.check();
            }
            pressed[6]=true;
        });
         g.button6.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[7]==false)
            {
                g.button6.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[7]=TicTacToeGui.lastmove;  
                CheckWin.check();
            }
            pressed[7]=true;
        });
        g.button7.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[8]==false)
            {
                g.button7.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[8]=TicTacToeGui.lastmove;
                CheckWin.check();
            }
            pressed[8]=true;
        });
        g.button11.setGraphic(ViewSound.drawSoundLogo("image/sound.png"));
        g.button11.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
           if(ViewSound.sound==true){
               ViewSound.clickOrSound(0);
               g.button11.setGraphic(ViewSound.drawSoundLogo("image/nosound.png"));
               ViewSound.sound=false;
               ViewSound.playSound();
           }
           else{
               ViewSound.clickOrSound(0);
               g.button11.setGraphic(ViewSound.drawSoundLogo("image/sound.png"));
               ViewSound.sound=true;
               ViewSound.playSound();
           }
        });
    }
}
