package com.math;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class QuestionFormController {   
    @FXML
    private Button button_simpan;
    @FXML
    private Button exit_button;
    @FXML
    private ComboBox<Integer> combo_tipe;
    @FXML
    private TextField id_soal;
    @FXML
    private TextField jawabanessayForm;
    @FXML
    private TextField jawabanpgForm;
    @FXML
    private TextField optionaForm;
    @FXML
    private TextField optionbForm;
    @FXML
    private TextField optioncForm;
    @FXML
    private TextField questionForm;

    public void initialize(){
        combo_tipe.getItems().add(1);
        combo_tipe.getItems().add(2);
    }
    public Button exitButtonProperty(){
        return exit_button;
    }
    public Question getQuestion(){
        Question question = null;
        if(combo_tipe.getValue()==1){
            question = new Question(Integer.valueOf(id_soal.getText()),questionForm.getText(),optionaForm.getText(),optionbForm.getText(),optioncForm.getText(),jawabanpgForm.getText());
        }else if(combo_tipe.getValue()==2){
            question = new Question(Integer.valueOf(id_soal.getText()),questionForm.getText(), jawabanessayForm.getText());
        }
        return question;
    }
    public Button simpaButtonProperty(){
        return button_simpan;
    }
}
