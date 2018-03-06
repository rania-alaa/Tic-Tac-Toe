/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.Socket;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

//

import networkpackage.Game;
import networkpackage.Player;

/**
 *
 * @author rania
 */
public class TicTacToeGui extends Application {
    
    String lastmove= new String("x");//
    Game game = new Game();
    int iconToSet = 1;
    CLintHandler clintHandler;
    FXMLgameBase g;
    
    @Override
    public void start(Stage primaryStage) throws MalformedURLException {  
        g = new FXMLgameBase(); 
        Scene scene = new Scene(g, 700, 600);
        g.text0.setText("rania");
     
       // putEvent(g);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
        clintHandler = new CLintHandler();
        putIdandActionEvent();
    }
    
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
    
    private ImageView drawX(){
        Image imgx = new Image(getClass().getResourceAsStream("image/x.png"));
        ImageView viewx = new ImageView(imgx);
        viewx.setFitHeight(110);
        viewx.setFitWidth(90);
        return viewx;
    }
    
    private ImageView drawO(){
        Image imgo = new Image(getClass().getResourceAsStream("image/o.png"));
        ImageView viewo = new ImageView(imgo);
        viewo.setFitHeight(110);
        viewo.setFitWidth(90);
        return viewo;
    }
   
    
    public void sendMovetoServer(int x, int y , int icon){
        if(clintHandler.isMyTurn){
           clintHandler.ps.println("PAT_"+x+"_"+y+"_"+icon); 
           this.clintHandler.isMyTurn = false;
           System.out.println("after set to false: isMyturn  = " + clintHandler.isMyTurn);
        }
    }
    
    public void putIdandActionEvent(){
        for(int i =0 ; i<3 ; i++){
            for(int j =0 ; j<3 ; j++){
                g.btnArr[i][j].setId(""+i+"_"+j);
                g.btnArr[i][j].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Button btn;
                        btn = (Button) event.getTarget();
                        int dim1 = Integer.parseInt(String.valueOf(btn.getId().charAt(0)));
                        int dim2 = Integer.parseInt(String.valueOf(btn.getId().charAt(2)));
                        if( clintHandler.isMyTurn ){
                            System.out.println("handle: isMyturn  = " + clintHandler.isMyTurn); 
                            sendMovetoServer(dim1,dim2,clintHandler.player.getPlayerIcon());
                            //clintHandler.isMyTurn = false;
                        }
                    }
                });
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public class CLintHandler extends Thread {
        
        DataInputStream dis;
        public PrintStream ps;
        Socket mySocket = null;
        public Player player;

        public boolean isMyTurn;

        public CLintHandler(){
            try{
                mySocket = new Socket("127.0.0.1" ,5005);
            }catch (Exception e) {
                if(mySocket == null){
                    JOptionPane.showMessageDialog(null ,
                    "Server is down! ", "Server is down",
                    JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                e.printStackTrace();
            }
            try{

                dis = new DataInputStream(mySocket.getInputStream());
                ps = new PrintStream(mySocket.getOutputStream());

            }catch (IOException e) {
                e.printStackTrace();
            }
            start();
        }

        public void run(){

            String responseFromServer  = "" ;
            //Intiate connection an
            this.ps.println("Hi");

            try{
                responseFromServer= dis.readLine();

                if(responseFromServer.contains("X")){
                    player = new Player(1,"xUser");
                    System.out.println("Recevied from server: " + 
                            responseFromServer + "I am " + player.getPlayerNmae());
                    isMyTurn = true;
                }
                else if(responseFromServer.contains("O")){
                    player = new Player(2,"OUser");
                    System.out.println("Recevied from server: " + 
                            responseFromServer + "I am " + player.getPlayerNmae());
                    isMyTurn = false;
                }
                }catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null ,
                        "Server is down", "server offline",
                        JOptionPane.ERROR_MESSAGE
                    );
                    System.exit(0);
                }
            while(true){
                try{
                    //handle the game  
                    responseFromServer= dis.readLine();
                    if(responseFromServer.contains("GO")){
                        //isMyTurn = true;
                        String[] parts = responseFromServer.split("_");
                        //GO_X_Y
                        int x = Integer.parseInt(parts[1]);//X
                        int y = Integer.parseInt(parts[2]);//Y
                        int icon = Integer.parseInt(parts[3]);//X or O

                        Platform.runLater(new Runnable(){
                            @Override
                            public void run(){
                                if(icon == 1){
                                    g.btnArr[x][y].setGraphic(drawX()); 
                                    if(player.getPlayerIcon() == 2){
                                        isMyTurn = true;
                                    }
                                    else if(player.getPlayerIcon() == 1){
                                        isMyTurn = false;
                                    }
                                }

                                else if(icon == 2){
                                    g.btnArr[x][y].setGraphic(drawO());
                                    if(player.getPlayerIcon() == 1){
                                        isMyTurn = true;
                                    }
                                    else if(player.getPlayerIcon() == 2){
                                        isMyTurn = false;
                                    }
                                }
                            }
                        });
                    }

                }catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null ,
                        "Server is down", "server offline",
                        JOptionPane.ERROR_MESSAGE
                    );
                    System.exit(0);
                }

                if(responseFromServer == null){
                    JOptionPane.showMessageDialog(null ,
                        "Server is down", "server offline",
                        JOptionPane.ERROR_MESSAGE
                    );
                    System.exit(0);
                }
                else{
                    //showMessage(responseFromServer);
                }
            }
        }
    }  
}
