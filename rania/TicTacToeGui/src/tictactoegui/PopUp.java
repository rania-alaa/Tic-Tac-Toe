/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author rania
 */
public class PopUp {
     public static Stage init(Scene scene,String title){
        Stage popupwindow=new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle(title);
        popupwindow.setScene(scene);
        return popupwindow; 
    }
    public static String display(String title) 
    {
        FXMLpopupBase newplayerpage = new FXMLpopupBase();
        Scene newplayerscene= new Scene(newplayerpage, 375, 250);
        Stage popupwindow= init(newplayerscene,title);
        newplayerpage.button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            popupwindow.close();
        });
        popupwindow.showAndWait();
        System.out.println(newplayerpage.textField.getText());
        return newplayerpage.textField.getText();
    }   
}
