package com.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button suma;

    @FXML
    private Button resta;

    @FXML
    private Button multi;

    @FXML
    private Button div;

    @FXML
    private Button clear;

    @FXML
    private Text pantalla;

    @FXML
    private TextField num;

    private int opera = 0;

    private boolean checkNum(String num){
        try {
            Integer.valueOf(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @FXML
    private void actionSuma(ActionEvent event) {
        if(!checkNum(num.getText())){
            return;
        }

        opera+=Integer.valueOf(num.getText());
        pantalla.setText(String.valueOf(opera));
        num.setText("");
        
    }


    @FXML
    private void actionResta(ActionEvent event) {
        if(!checkNum(num.getText())){
            return;
        }

        opera-=Integer.valueOf(num.getText());
        pantalla.setText(String.valueOf(opera));
        num.setText("");
    }

    @FXML
    private void actionMulti(ActionEvent event) {
        if(!checkNum(num.getText())){
                    return;
                }

        opera*=Integer.valueOf(num.getText());
        pantalla.setText(String.valueOf(opera));
        num.setText("");
    }

    @FXML
    private void actionDiv(ActionEvent event) {

        if(!checkNum(num.getText())){
            return;
        }

        if(Integer.valueOf(num.getText())==0){
            pantalla.setText("Error");
        }else{
        opera/=Integer.valueOf(num.getText());
        pantalla.setText(String.valueOf(opera));
        num.setText("0");
        }
    }

    @FXML
    private void actionClear(ActionEvent event){
        num.setText("");
    }
}
