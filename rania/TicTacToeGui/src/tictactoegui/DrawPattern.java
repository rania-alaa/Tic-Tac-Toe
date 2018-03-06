/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;

import tictactoegui.TicTacToeGui;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Norhan
 */
    public class DrawPattern extends TicTacToeGui{
  
        static public ImageView Casexoro (){
        ImageView view;
         if("x".equals(TicTacToeGui.lastmove))
            { 
                TicTacToeGui.lastmove="o";
                DrawPattern d=new DrawPattern();
                view=d.Drawo();
            }
            else {
                TicTacToeGui.lastmove="x"; 
                DrawPattern d=new DrawPattern();
                view=d.Drawx();
            }
        return view;
    }
     public ImageView Drawx(){   
        Image imgx = new Image(getClass().getResourceAsStream("image/x.png"));
        ImageView viewx = new ImageView(imgx);
        viewx.setFitHeight(110);
        viewx.setFitWidth(90);
        return viewx;
    }
    public ImageView Drawo(){
        Image imgo = new Image(getClass().getResourceAsStream("image/o.png"));
        ImageView viewo = new ImageView(imgo);
        viewo.setFitHeight(110);
        viewo.setFitWidth(90);
        return viewo;
    }
    static public void initializeMovesArr()
    {
        for(int i=0;i<9;i++)
        {
            TicTacToeGui.allMoves[i]=new String("");
        }
    }
    static public void initializePressedArr() {
        for (int i = 0; i < 9; i++) {
            TicTacToeGui.pressed[i] = false;
        }
    }
    static public String[][] getXOBoard()
    {
        String [][] xo=new String [3][3];
        int counter=0;
	for(int j=0;j<3;j++)
	{
            for(int k=0;k<3;k++)
            {
		xo[j][k]=TicTacToeGui.allMoves[counter+j+k];
            }
            counter+=2;
	}
        return xo;
    }
    }