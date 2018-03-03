/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkpackage;

/**
 *
 * @author abdo
 */
public class Player {
    int playerIcon ;
    String userName;
    
    public Player(int iconCode , String name ){
        playerIcon = iconCode;
        userName = name;
    }
    
    public void setPlayerIcon(int iconCode){
        playerIcon = iconCode;
    }
    
    public int getPlayerIcon(){
        return playerIcon;
    }
    
    public void setPlayerName(String name){
        userName = name;
    }
    
    public String getPlayerNmae(){
        return userName;
    }
    
}
