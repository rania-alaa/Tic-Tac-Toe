/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkpackage;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author abdo
 */
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
                System.out.println("Recevied from server: " + responseFromServer + "I am " + player.getPlayerNmae());
                isMyTurn = true;
            }
            else if(responseFromServer.contains("O")){
                player = new Player(2,"OUser");
                System.out.println("Recevied from server: " + responseFromServer + "I am " + player.getPlayerNmae());
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
        
        //this.ps.println("PAT_2_2_1");
        
        while(true){
            try{
                //handle the game  
                responseFromServer= dis.readLine();
                
                if(responseFromServer.contains("GO")){
                    isMyTurn = true;
                    String[] parts = responseFromServer.split("_");
                    //GO_X_Y
                    
//                    Integer.parseInt(parts[1]);//X
//                    Integer.parseInt(parts[2]);//Y
//                    Integer.parseInt(parts[3]);//X or O
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
                showMessage(responseFromServer);
            }
        }
    }
    void showMessage(String msg) {
       // ta.append(msg+"\n");
       System.out.println("Recevied from server: " + msg);
    }
}

