/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkpackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdo
 */
public class Game implements Serializable {
    int[][] gridArr;
    boolean [][] isEmptyCell;
    
    public Game(){
        gridArr = new int[][] {
            {0,0,0}, 
            {0,0,0},
            {0,0,0} 
        };
         isEmptyCell = new boolean [][] {
            {true,true,true},
            {true,true,true},
            {true,true,true} 
        };
    }
    
    public int [][] getGridArr(){
        return gridArr;
    }
    
    public int  getCellValue(int x,int y){
        return gridArr[x][y];
    }
    
    public void setCellValue(int x, int y, int val){
        if( isEmptyCell[x][y]){
            gridArr[x][y] = val ;
            isEmptyCell[x][y] = false;
        }
        else{
            
        }
    }
    
    public void saveGame(){
        try {
         FileOutputStream fileOut =
         new FileOutputStream("../gameObj.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(this);
         out.close();
         fileOut.close();
         System.out.printf("save Done");
      } catch (IOException i) {
         i.printStackTrace();
      }
    }
    
    static public  Game loadGame(){
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        try {
            fileIn = new FileInputStream("../gameObj.ser");
            in = new ObjectInputStream(fileIn);
            return (Game) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Gsme class not found");
            c.printStackTrace();
            
        } finally{
            try {
                in.close();
                fileIn.close();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }  
        } 
        return null;
    }
}
