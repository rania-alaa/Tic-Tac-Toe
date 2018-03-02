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
import javafx.scene.control.Alert;
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
 * @author rania
 */
public class TicTacToeGui extends Application {
    
    String lastmove= "x";
    String[] allMoves=new String[9];
    Alert Msg=new Alert(Alert.AlertType.INFORMATION);
    boolean pressed[] = {false,false,false,false,false,false,false,false,false};
    boolean completed=false;

    @Override
    public void start(Stage primaryStage) throws MalformedURLException {  
        FXMLplayer1Base player1page = new FXMLplayer1Base();
        FXMLmodeBase modepage = new FXMLmodeBase();
        FXMLplayerBase playerpage = new FXMLplayerBase();
        FXMLgameBase g = new FXMLgameBase();
        Scene player1scene = new Scene(player1page, 700, 600);
        Scene modescene = new Scene(modepage, 700, 600);
        Scene playerscene = new Scene(playerpage, 700, 600);
        Scene scene = new Scene(g, 700, 600);
         Scene gamescene = new Scene(g, 700, 600);
        g.gridPane.setEffect(new DropShadow(15, 0, 15, Color.GREY));
        player1page.label.setGraphic(logo());
        modepage.label0.setGraphic(logo());
        playerpage.label0.setGraphic(logo());
        //next buton in  player1page
        player1page.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            primaryStage.setScene(modescene);
        });
        //singlebutton
        modepage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            g.text2.setText("Computer");
            primaryStage.setScene(gamescene);
        });
        //2 player button
        modepage.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            primaryStage.setScene(playerscene);
        });
        //nextbutton
        playerpage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(playerpage.textField.getText().isEmpty())
            {}
            else{
                g.text2.setText(playerpage.textField.getText());
                primaryStage.setScene(gamescene);
            }
        }); 
        g.button8.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            primaryStage.setScene(modescene);
        }); 
        g.text0.setText("rania");
        initializeMovesArr();
       
        Msg.setTitle("Winner Message");
        Msg.setHeaderText(null);
     
        putEvent(g);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private ImageView logo(){
        Image logo = new Image(getClass().getResourceAsStream("image/logo3.png"));
        ImageView view = new ImageView(logo);
        view.setFitHeight(110);
        view.setFitWidth(600);
        return view;
    }
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
    private void initializeMovesArr()
    {
        for(int i=0;i<9;i++)
        {
            allMoves[i]=new String("");
        }
    }
    private String[][] getXOBoard()
    {
        String [][] xo=new String [3][3];
        int counter=0;
    for(int j=0;j<3;j++)
    {
            for(int k=0;k<3;k++)
            {
        xo[j][k]=allMoves[counter+j+k];
            }
            counter+=2;
    }
        return xo;
    }
    private boolean checkHorizontal()
    {
        String [][] xoBoard=getXOBoard();
        int k=0;
    for(int j=0;j<3;j++)
    {
            if(xoBoard[j][k].equals(xoBoard[j][k+1])&& xoBoard[j][k+1].equals(xoBoard[j][k+2]) && !xoBoard[j][k].equals(""))        
            {
        return true;
            }   
    }
            return false;
   }
   private boolean checkVertical()
   {
        String [][] xoBoard=getXOBoard();
        int j=0;
    for(int k=0;k<3;k++)
    {
            if(xoBoard[j][k].equals(xoBoard[j+1][k])&& xoBoard[j+1][k].equals(xoBoard[j+2][k]) && !xoBoard[j][k].equals(""))        
            {
        return true;
            }       
    }
            return false;
   }
   private boolean checkDiagonal()
   {
        String [][] xoBoard=getXOBoard();
        String [] tmp=new String[3];
        for(int j=0;j<3;j++)
        {
            for(int k=0;k<3;k++)
            {
                if(j==k)
                {
                    tmp[j]=xoBoard[j][k];
                }
            }
        }
    int j=0;
    if(tmp[j].equals(tmp[j+1]) && tmp[j+1].equals(tmp[j+2]) && !tmp[j].equals(""))
    {
            return true;
    }
        else if(xoBoard[0][2].equals(xoBoard[2][0]) && xoBoard[0][2].equals(xoBoard[1][1]) &&!xoBoard[0][2].equals("") )
    {
            return true;
    }
        return false;
   }
   private boolean checkWinner()
   {
        if(checkHorizontal()|| checkVertical()||checkDiagonal())
           return true;
        else
           return false;
   }
   
   private boolean checkNoWinner()
   {
        int counter=0;
        for(int i=0;i<9;i++)
        {
            if(!allMoves[i].equals(""))
            {
              counter++;
              System.out.println(counter);
            }
        }
        if(counter==9)
        {
             completed=true;
        }
        return completed;
   }
   private void check(){
        if(checkWinner())
        {
            Msg.setContentText(lastmove+" Wins");
            if(lastmove=="x") Msg.setGraphic(Drawx());
            else Msg.setGraphic(Drawo());
            Msg.showAndWait();
            
        }
        else
        {
            if(checkNoWinner())
            {
                Msg.setContentText("NoWinner");
                Msg.showAndWait();
            }
        }
   }
    private void putEvent(FXMLgameBase g){
         g.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[0]==false)
            {
                g.button.setGraphic(Casexoro());
                allMoves[0]=lastmove; 
                System.out.println(checkWinner());
                check();
            }
            pressed[0]=true;
        });
       
        g.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[1]==false)
            {
                g.button0.setGraphic(Casexoro());
                allMoves[1]=lastmove;
                System.out.println(checkWinner());
                check();
            }
            pressed[1]=true;
        });
        g.button1.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[2]==false)
            {
                g.button1.setGraphic(Casexoro());            
                allMoves[2]=lastmove;   
                System.out.println(checkWinner());
                check();
            }
            pressed[2]=true;
        });
        g.button2.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[3]==false)
            {
                g.button2.setGraphic(Casexoro());         
                allMoves[3]=lastmove; 
                System.out.println(checkWinner());
                check();
            }
            pressed[3]=true;
        });
        g.button3.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[4]==false)
            {
                g.button3.setGraphic(Casexoro());            
                allMoves[4]=lastmove;  
                System.out.println( checkWinner());
                check();
            }
            pressed[4]=true;
        });
        g.button4.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[5]==false)
            {
                g.button4.setGraphic(Casexoro());
                allMoves[5]=lastmove; 
                System.out.println(checkWinner());
                check();
            }
            pressed[5]=true;
        });
        g.button5.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[6]==false)
            {
                g.button5.setGraphic(Casexoro());
                allMoves[6]=lastmove; 
                System.out.println(checkWinner());
                check();
            }
            pressed[6]=true;
        });
         g.button6.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[7]==false)
            {
                g.button6.setGraphic(Casexoro());
                allMoves[7]=lastmove;  
                System.out.println( checkWinner());
                check();
            }
            pressed[7]=true;
        });
          g.button7.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
              if(pressed[8]==false)
              {
                g.button7.setGraphic(Casexoro());
                allMoves[8]=lastmove;
                System.out.println(checkWinner());
                check();
              }
              pressed[8]=true;
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
