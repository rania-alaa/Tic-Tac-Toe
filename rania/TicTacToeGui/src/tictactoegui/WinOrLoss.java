/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author rania
 */
public class WinOrLoss extends PopUp {
    public static void display(String imagename,String condition) 
    {
        FXMLwinorlossBase winorlosspage = new FXMLwinorlossBase();
        
        Scene winorlossscene= new Scene(winorlosspage, 375, 250);
        Stage popupwindow=new Stage();
        Image img = new Image(WinOrLoss.class.getResourceAsStream(imagename));
        winorlosspage.imageView.setImage(img);
        //winorlosspage.label.setText(condition);
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle(condition);
        
        popupwindow.setScene(winorlossscene);
        winorlosspage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            popupwindow.close();
            
       // open video window         
        });
        popupwindow.showAndWait();
    }  
}
