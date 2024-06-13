package com.math;

import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class EssayController {
    
    @FXML
    private Button checkanswer;

    @FXML
    private Text text_soal1;

    @FXML
    private TextField answer_text;

    
    public void initialize(){
    }

    public void setData(Question soal){
        text_soal1.setText(soal.getQuestionString());

    }

    public Button answerButtonProperty(){
        return checkanswer;
    }
    public TextField textfieldProperty(){
        return answer_text;
    }
}
