/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;
import java.util.Random;
import tictactoegui.TicTacToeGui;
import javafx.event.ActionEvent;
import static tictactoegui.TicTacToeGui.pressed;
import static tictactoegui.TicTacToeGui.win;
import tictactoegui.ViewSound;
/**
 *
 * @author Norhan
 */
public class CheckEvent {
    //computer turn algorithm
     public static int computerTurn() {
        Random r = new Random();
        int counterPressed = 0;
        // no pressed buttons indices in one array
        int freeIndices[] = new int[6];
        //generate random number with in range 0-8
        int randomNum = (int) (Math.random() * Math.random() * Math.random() * Math.random() * 9);
        int j = 0;
        // the winning cases need at least 3 buttons to be pressed to can predict the step which the other player may win by it
        for (int i = 0; i < 9; i++) {

            if (pressed[i] == true) {
                counterPressed++;
            }

        }
        // collect the indcies of buttonns which not pressed
        if (counterPressed >= 3) {

            for (int i = 0; i < 9; i++) {
                if (pressed[i] == false) {
                    freeIndices[j] = i;
                    j++;
                }
            }

        }

        for (int k = 0; k < j; k++) {
            System.out.println("free" + freeIndices[k]);
        }
        System.out.println("j" + j);
        if (counterPressed < 3) {
            // generate number not pressed and no one won before
            while (pressed[randomNum] == true && CheckWin.checkWinner() != true) {
                randomNum = (int) (Math.random() * Math.random() * Math.random() * Math.random() * 9);
                System.out.println(randomNum);
            }
        } else {
            //check on the cases which allow x or o to be won 
            for (int k = 0; k < j; k++) {
                System.out.println("freeIndex " + freeIndices[k]);
                TicTacToeGui.allMoves[freeIndices[k]] = "x";
                if (CheckWin.checkWinner() == true) {
                    randomNum = freeIndices[k];
                    System.out.println("randomx " + randomNum);
                    return randomNum;
                } else {
                    TicTacToeGui.allMoves[freeIndices[k]] = "o";
                    if (CheckWin.checkWinner() == true) {
                        randomNum = freeIndices[k];

                        System.out.println("randomo " + randomNum);
                        return randomNum;
                    } else {
                        TicTacToeGui.allMoves[freeIndices[k]] = "";
                        while (pressed[randomNum] == true && CheckWin.checkWinner() != true) {
                            randomNum = (int) (Math.random() * Math.random() * Math.random() * Math.random() * 9);
                            System.out.println(randomNum);
                        }
                    }
                }
            }
        }

        return randomNum;
    }

       public static void putEvent(FXMLgameBase g){    
        g.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[0]==false)
            {
                g.button.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[0]=TicTacToeGui.lastmove; 
                TicTacToeGui.win =CheckWin.check();
            pressed[0] = true;
                
            }
            if(TicTacToeGui.singlemode==true)
            {
            // if the other player wasn't win allow computer to play 
                if (TicTacToeGui.comppressed[0] == false)
                {
                    if (!TicTacToeGui.win) {
                    int cmpTurn = computerTurn();
                    if (cmpTurn == 1) {
                        g.button0.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[1] = TicTacToeGui.lastmove;
                        pressed[1] = true;
                        TicTacToeGui.comppressed[1]=true;
                    } else if (cmpTurn == 2) {
                        g.button1.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[2] = TicTacToeGui.lastmove;
                        pressed[2] = true;
                        TicTacToeGui.comppressed[2]=true;
                    } else if (cmpTurn == 3) {
                        g.button2.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[3] = TicTacToeGui.lastmove;
                        pressed[3] = true;
                        TicTacToeGui.comppressed[3]=true;
                    } else if (cmpTurn == 4) {
                        g.button3.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[4] = TicTacToeGui.lastmove;
                        pressed[4] = true;
                        TicTacToeGui.comppressed[4]=true;
                    } else if (cmpTurn == 5) {
                        g.button4.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[5] = TicTacToeGui.lastmove;
                        pressed[5] = true;
                        TicTacToeGui.comppressed[5]=true;
                    } else if (cmpTurn == 6) {
                        g.button5.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[6] = TicTacToeGui.lastmove;
                        pressed[6] = true;
                        TicTacToeGui.comppressed[6]=true;
                    } else if (cmpTurn == 7) {
                        g.button6.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[7] = TicTacToeGui.lastmove;
                        pressed[7] = true;
                        TicTacToeGui.comppressed[7]=true;

                    } else if (cmpTurn == 8) {
                        g.button7.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[8] = TicTacToeGui.lastmove;
                        pressed[8] = true;
                        TicTacToeGui.comppressed[8]=true;
                    }

                    TicTacToeGui.win = CheckWin.check();

                }
                    TicTacToeGui.comppressed[0]= true;
                }
            }
        });
       
        g.button0.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[1]==false)
            {
               g.button0.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[1]=TicTacToeGui.lastmove;
             	 TicTacToeGui.win=CheckWin.check();
                pressed[1] = true;
            }
            if(TicTacToeGui.singlemode==true)
            {
                if (TicTacToeGui.comppressed[1] == false)
                {
                if (!TicTacToeGui.win) {
                    int cmpTurn = computerTurn();

                    if (cmpTurn == 0) {
                        g.button.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[0] = TicTacToeGui.lastmove;
                        pressed[0] = true;
                        TicTacToeGui.comppressed[0]=true;
                    } else if (cmpTurn == 2) {
                        g.button1.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[2] = TicTacToeGui.lastmove;
                        pressed[2] = true;
                        TicTacToeGui.comppressed[2]=true;
                    } else if (cmpTurn == 3) {
                        g.button2.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[3] = TicTacToeGui.lastmove;
                        pressed[3] = true;
                        TicTacToeGui.comppressed[3]=true;
                    } else if (cmpTurn == 4) {
                        g.button3.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[4] = TicTacToeGui.lastmove;
                        pressed[4] = true;
                        TicTacToeGui.comppressed[4]=true;
                    } else if (cmpTurn == 5) {
                        g.button4.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[5] = TicTacToeGui.lastmove;
                        pressed[5] = true;
                        TicTacToeGui.comppressed[5]=true;
                    } else if (cmpTurn == 6) {
                        g.button5.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[6] = TicTacToeGui.lastmove;
                        pressed[6] = true;
                        TicTacToeGui.comppressed[6]=true;
                    } else if (cmpTurn == 7) {
                        g.button6.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[7] = TicTacToeGui.lastmove;
                        pressed[7] = true;
                        TicTacToeGui.comppressed[7]=true;

                    } else if (cmpTurn == 8) {
                        g.button7.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[8] = TicTacToeGui.lastmove;
                        pressed[8] = true;
                        TicTacToeGui.comppressed[8]=true;
                    }
                    TicTacToeGui.win = CheckWin.check();

                }
                    TicTacToeGui.comppressed[1]= true;
                }
            }
        });
        g.button1.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[2]==false)
            {
                g.button1.setGraphic(DrawPattern.Casexoro());            
                TicTacToeGui.allMoves[2]=TicTacToeGui.lastmove;   
                TicTacToeGui.win=CheckWin.check();
                pressed[2] = true;
            }
            if(TicTacToeGui.singlemode==true)
            {
                if (TicTacToeGui.comppressed[2] == false)
                {
                if (!TicTacToeGui.win) {

                    int cmpTurn = computerTurn();
                    System.out.print(cmpTurn);
                    if (cmpTurn == 0) {

                        g.button.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[0] = TicTacToeGui.lastmove;
                        pressed[0] = true;
                        TicTacToeGui.comppressed[0]=true;
                    } else if (cmpTurn == 1) {
                        g.button1.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[1] = TicTacToeGui.lastmove;
                        pressed[1] = true;
                        TicTacToeGui.comppressed[1]=true;
                    } else if (cmpTurn == 3) {
                        g.button2.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[3] = TicTacToeGui.lastmove;
                        pressed[3] = true;
                        TicTacToeGui.comppressed[3]=true;
                    } else if (cmpTurn == 4) {
                        g.button3.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[4] = TicTacToeGui.lastmove;
                        pressed[4] = true;
                        TicTacToeGui.comppressed[4]=true;
                    } else if (cmpTurn == 5) {
                        g.button4.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[5] = TicTacToeGui.lastmove;
                        pressed[5] = true;
                        TicTacToeGui.comppressed[5]=true;
                    } else if (cmpTurn == 6) {
                        g.button5.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[6] = TicTacToeGui.lastmove;
                        pressed[6] = true;
                       TicTacToeGui.comppressed[6]=true;
                    } else if (cmpTurn == 7) {
                        g.button6.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[7] = TicTacToeGui.lastmove;
                        pressed[7] = true;
                        TicTacToeGui.comppressed[7]=true;

                    } else if (cmpTurn == 8) {
                        g.button7.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[8] = TicTacToeGui.lastmove;
                        pressed[8] = true;
                        TicTacToeGui.comppressed[8]=true;
                    }
                    TicTacToeGui.win = CheckWin.check();

                }
                    TicTacToeGui.comppressed[2]= true;
                }
            }
        });
        g.button2.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[3]==false)
            {
                g.button2.setGraphic(DrawPattern.Casexoro());         
                TicTacToeGui.allMoves[3]=TicTacToeGui.lastmove; 
               	 TicTacToeGui.win=CheckWin.check();
            pressed[3] = true;
            }
            
            if(TicTacToeGui.singlemode==true)
            {
                if(TicTacToeGui.comppressed[3]==false){
                if (!TicTacToeGui.win) {
                    int cmpTurn = computerTurn();

                    if (cmpTurn == 0) {

                        g.button.setGraphic(DrawPattern.Casexoro());
                       TicTacToeGui.allMoves[0] = TicTacToeGui.lastmove;
                        pressed[0] = true;
                        TicTacToeGui.comppressed[0]=true;
                    } else if (cmpTurn == 1) {
                        g.button0.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[1] = TicTacToeGui.lastmove;
                        pressed[1] = true;
                        TicTacToeGui.comppressed[1]=true;
                    } else if (cmpTurn == 2) {
                        g.button1.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[2] = TicTacToeGui.lastmove;
                        pressed[2] = true;
                        TicTacToeGui.comppressed[2]=true;
                    } else if (cmpTurn == 4) {
                        g.button3.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[4] = TicTacToeGui.lastmove;
                        pressed[4] = true;
                        TicTacToeGui.comppressed[4]=true;
                    } else if (cmpTurn == 5) {
                        g.button4.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[5] = TicTacToeGui.lastmove;
                        pressed[5] = true;
                        TicTacToeGui.comppressed[5]=true;
                    } else if (cmpTurn == 6) {
                        g.button5.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[6] = TicTacToeGui.lastmove;
                        pressed[6] = true;
                        TicTacToeGui.comppressed[6]=true;
                    } else if (cmpTurn == 7) {
                        g.button6.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[7] = TicTacToeGui.lastmove;
                        pressed[7] = true;
                        TicTacToeGui.comppressed[7]=true;

                    } else if (cmpTurn == 8) {
                        g.button7.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[8] = TicTacToeGui.lastmove;
                        pressed[8] = true;
                        TicTacToeGui.comppressed[8]=true;
                    }
                    TicTacToeGui.win = CheckWin.check();

                }
                    TicTacToeGui.comppressed[3]= true;
                }
            }
        });
        g.button3.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[4]==false)
            {
                g.button3.setGraphic(DrawPattern.Casexoro());            
                TicTacToeGui.allMoves[4]=TicTacToeGui.lastmove;  
		TicTacToeGui.win=CheckWin.check();               
            pressed[4] = true;
            }
            
            if(TicTacToeGui.singlemode==true)
            {
                if(TicTacToeGui.comppressed[4]==false){
                if (!TicTacToeGui.win) {
                    int cmpTurn = computerTurn();
                    if (cmpTurn == 0) {

                        g.button.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[0] = TicTacToeGui.lastmove;
                        pressed[0] = true;
                        TicTacToeGui.comppressed[0]=true;
                    } else if (cmpTurn == 1) {
                        g.button0.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[1] = TicTacToeGui.lastmove;
                        pressed[1] = true;
                        TicTacToeGui.comppressed[1]=true;
                    } else if (cmpTurn == 2) {
                        g.button1.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[2] = TicTacToeGui.lastmove;
                        pressed[2] = true;
                        TicTacToeGui.comppressed[2]=true;
                    } else if (cmpTurn == 3) {
                        g.button2.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[3] = TicTacToeGui.lastmove;
                        pressed[3] = true;
                        TicTacToeGui.comppressed[3]=true;
                    } else if (cmpTurn == 5) {
                        g.button4.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[5] = TicTacToeGui.lastmove;
                        TicTacToeGui.pressed[5] = true;
                        TicTacToeGui.comppressed[5]=true;
                    } else if (cmpTurn == 6) {
                        g.button5.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[6] = TicTacToeGui.lastmove;
                        pressed[6] = true;
                        TicTacToeGui.comppressed[6]=true;
                    } else if (cmpTurn == 7) {
                        g.button6.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[7] = TicTacToeGui.lastmove;
                        pressed[7] = true;
                        TicTacToeGui.comppressed[7]=true;

                    } else if (cmpTurn == 8) {
                        g.button7.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[8] = TicTacToeGui.lastmove;
                        pressed[8] = true;
                       TicTacToeGui.comppressed[8]=true;
                    }
                    TicTacToeGui.win = CheckWin.check();

                }
                    TicTacToeGui.comppressed[4]= true;
                }
            }
        });
        g.button4.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[5]==false)
            {
                g.button4.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[5]=TicTacToeGui.lastmove; 
              	 TicTacToeGui.win=CheckWin.check();
             pressed[5] = true;  
             
            }
            
            if(TicTacToeGui.singlemode==true)
            {
                if(TicTacToeGui.comppressed[5]==false)
                if (!TicTacToeGui.win) {
                    int cmpTurn = computerTurn();
                    if (cmpTurn == 0) {
                        g.button.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[0] = TicTacToeGui.lastmove;
                        pressed[0] = true;
                        TicTacToeGui.comppressed[0]=true;
                    } else if (cmpTurn == 1) {
                        g.button0.setGraphic(DrawPattern.Casexoro());
                       TicTacToeGui.allMoves[1] = TicTacToeGui.lastmove;
                        pressed[1] = true;
                        TicTacToeGui.comppressed[1]=true;
                    } else if (cmpTurn == 2) {
                        g.button1.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[2] = TicTacToeGui.lastmove;
                        pressed[2] = true;
                        TicTacToeGui.comppressed[2]=true;
                    } else if (cmpTurn == 3) {
                        g.button2.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[3] = TicTacToeGui.lastmove;
                        pressed[3] = true;
                        TicTacToeGui.comppressed[3]=true;
                    } else if (cmpTurn == 4) {
                        g.button3.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[4] = TicTacToeGui.lastmove;
                        pressed[4] = true;
                        TicTacToeGui.comppressed[4]=true;
                    } else if (cmpTurn == 6) {
                        g.button5.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[6] = TicTacToeGui.lastmove;
                        pressed[6] = true;
                        TicTacToeGui.comppressed[6]=true;
                    } else if (cmpTurn == 7) {
                        g.button6.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[7] = TicTacToeGui.lastmove;
                        pressed[7] = true;
                        TicTacToeGui.comppressed[7]=true;

                    } else if (cmpTurn == 8) {
                        g.button7.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[8] = TicTacToeGui.lastmove;
                        pressed[8] = true;
                        TicTacToeGui.comppressed[8]=true;
                    }

                    TicTacToeGui.win = CheckWin.check();


                    TicTacToeGui.comppressed[5]= true;
                }
            }
        });
        g.button5.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[6]==false)
            {
                g.button5.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[6]=TicTacToeGui.lastmove; 
              	 TicTacToeGui.win=CheckWin.check();
            pressed[6] = true;
            }
            
            if(TicTacToeGui.singlemode==true)
            {
                if(TicTacToeGui.comppressed[6]==false){
                if (!TicTacToeGui.win) {
                    int cmpTurn = computerTurn();
                    if (cmpTurn == 0) {

                        g.button.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[0] = TicTacToeGui.lastmove;
                        pressed[0] = true;
                        TicTacToeGui.comppressed[0]=true;
                    } else if (cmpTurn == 1) {
                        g.button0.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[1] = TicTacToeGui.lastmove;
                        pressed[1] = true;
                        TicTacToeGui.comppressed[1]=true;
                    } else if (cmpTurn == 2) {
                        g.button1.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[2] = TicTacToeGui.lastmove;
                        pressed[2] = true;
                        TicTacToeGui.comppressed[2]=true;
                    } else if (cmpTurn == 3) {
                        g.button2.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[3] = TicTacToeGui.lastmove;
                        pressed[3] = true;
                        TicTacToeGui.comppressed[3]=true;
                    } else if (cmpTurn == 4) {
                        g.button3.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[4] = TicTacToeGui.lastmove;
                        pressed[4] = true;
                        TicTacToeGui.comppressed[4]=true;
                    } else if (cmpTurn == 5) {
                        g.button4.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[5] = TicTacToeGui.lastmove;
                        pressed[5] = true;
                        TicTacToeGui.comppressed[5]=true;
                    } else if (cmpTurn == 7) {
                        g.button6.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[7] = TicTacToeGui.lastmove;
                        pressed[7] = true;
                        TicTacToeGui.comppressed[7]=true;

                    } else if (cmpTurn == 8) {
                        g.button7.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[8] = TicTacToeGui.lastmove;

                        pressed[8] = true;
                        TicTacToeGui.comppressed[8]=true;
                    }
                    TicTacToeGui.win = CheckWin.check();

                }
                    TicTacToeGui.comppressed[6]= true;
                }
            }
        });
         g.button6.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[7]==false)
            {
                g.button6.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[7]=TicTacToeGui.lastmove;  
                 TicTacToeGui.win=CheckWin.check();
             pressed[7] = true;
            }
            if(TicTacToeGui.singlemode==true)
            {
                if(TicTacToeGui.comppressed[7]==false){
                if (!TicTacToeGui.win) {
                    int cmpTurn = computerTurn();

                    if (cmpTurn == 0) {

                        g.button.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[0] = TicTacToeGui.lastmove;
                        pressed[0] = true;
                        TicTacToeGui.comppressed[0]=true;
                    } else if (cmpTurn == 1) {
                        g.button0.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[1] = TicTacToeGui.lastmove;
                        pressed[1] = true;
                        TicTacToeGui.comppressed[1]=true;
                    } else if (cmpTurn == 2) {
                        g.button1.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[2] = TicTacToeGui.lastmove;
                        pressed[2] = true;
                        TicTacToeGui.comppressed[2]=true;
                    } else if (cmpTurn == 3) {
                        g.button2.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[3] = TicTacToeGui.lastmove;
                        pressed[3] = true;
                        TicTacToeGui.comppressed[3]=true;
                    } else if (cmpTurn == 4) {
                        g.button3.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[4] = TicTacToeGui.lastmove;
                        pressed[4] = true;
                        TicTacToeGui.comppressed[4]=true;
                    } else if (cmpTurn == 5) {
                        g.button4.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[5] = TicTacToeGui.lastmove;
                        pressed[5] = true;
                        TicTacToeGui.comppressed[5]=true;
                    } else if (cmpTurn == 6) {
                        g.button5.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[6] = TicTacToeGui.lastmove;
                        pressed[6] = true;
                        TicTacToeGui.comppressed[6]=true;
                    } else if (cmpTurn == 8) {
                        g.button7.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[8] = TicTacToeGui.lastmove;
                        pressed[8] = true;
                        TicTacToeGui.comppressed[8]=true;
                    }
                    TicTacToeGui.win = CheckWin.check();

                }
                    TicTacToeGui.comppressed[7]= true;
                }
            }
        });
        g.button7.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(pressed[8]==false)
            {
                g.button7.setGraphic(DrawPattern.Casexoro());
                TicTacToeGui.allMoves[8]=TicTacToeGui.lastmove;
                 TicTacToeGui.win=CheckWin.check();
                     pressed[8] = true;
            }
            if(TicTacToeGui.singlemode==true)
            {
                if(TicTacToeGui.comppressed[8]==false){
                if (!TicTacToeGui.win) {
                    int cmpTurn = computerTurn();
                    if (cmpTurn == 0) {

                        g.button.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[0] = TicTacToeGui.lastmove;
                        pressed[0] = true;
                        TicTacToeGui.comppressed[0]=true;
                    } else if (cmpTurn == 1) {
                        g.button0.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[1] = TicTacToeGui.lastmove;
                        pressed[1] = true;
                        TicTacToeGui.comppressed[1]=true;
                    } else if (cmpTurn == 2) {
                        g.button1.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[2] = TicTacToeGui.lastmove;
                        pressed[2] = true;
                       TicTacToeGui.comppressed[2]=true;
                    } else if (cmpTurn == 3) {
                        g.button2.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[3] = TicTacToeGui.lastmove;
                        pressed[3] = true;
                        TicTacToeGui.comppressed[3]=true;
                    } else if (cmpTurn == 4) {
                        g.button3.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[4] = TicTacToeGui.lastmove;
                        pressed[4] = true;
                        TicTacToeGui.comppressed[4]=true;
                    } else if (cmpTurn == 5) {
                        g.button4.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[5] = TicTacToeGui.lastmove;
                        pressed[5] = true;
                        TicTacToeGui.comppressed[5]=true;
                    } else if (cmpTurn == 6) {
                        g.button5.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[6] = TicTacToeGui.lastmove;
                        pressed[6] = true;
                        TicTacToeGui.comppressed[6]=true;
                    } else if (cmpTurn == 7) {
                        g.button6.setGraphic(DrawPattern.Casexoro());
                        TicTacToeGui.allMoves[7] = TicTacToeGui.lastmove;
                        pressed[7] = true;
                        TicTacToeGui.comppressed[7]=true;

                    }
                    TicTacToeGui.win = CheckWin.check();

                }
                    TicTacToeGui.comppressed[8]= true;
                }
            }
        });
        g.button11.setGraphic(ViewSound.drawSoundLogo("image/sound.png"));
        g.button11.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
           if(ViewSound.sound==true){
               TicTacToeGui.snd.clickOrSound(0);
               g.button11.setGraphic(ViewSound.drawSoundLogo("image/nosound.png"));
               ViewSound.sound=false;
              TicTacToeGui.snd.playSound();
           }
           else{
               TicTacToeGui.snd.clickOrSound(0);
               g.button11.setGraphic(ViewSound.drawSoundLogo("image/sound.png"));
               ViewSound.sound=true;
               TicTacToeGui.snd.playSound();
           }
        });
    }
}
