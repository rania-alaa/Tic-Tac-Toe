/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;
import tictactoegui.TicTacToeGui;
import static tictactoegui.TicTacToeGui.allMoves;

/**
 *
 * @author Norhan
 */
public class CheckWin extends TicTacToeGui{
     static public boolean checkHorizontal()
    {
       String [][] xoBoard=DrawPattern.getXOBoard();
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
   static public boolean checkVertical()
   {
        String [][] xoBoard=DrawPattern.getXOBoard();
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
   static public boolean checkDiagonal()
   {
        String [][] xoBoard=DrawPattern.getXOBoard();
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
   static public boolean checkWinner()
   {
        if(checkHorizontal()|| checkVertical()||checkDiagonal())
           return true;
        else
           return false;
   }
   
   static public boolean checkNoWinner()
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
             TicTacToeGui.completed=true;
        }
        return completed;
   }
   static public void check() {
        System.out.println(checkWinner());
        if (checkWinner()) {
            Msg.setContentText(lastmove + " Wins");
            TicTacToeGui.Msg.showAndWait();
             for(int i=0;i<9;i++)
            {
                pressed[i]=true;
            }
        } else {
            if (checkNoWinner()) {
                TicTacToeGui.Msg.setContentText("NoWinner");
                TicTacToeGui.Msg.showAndWait();
            }
        }
    }
}
