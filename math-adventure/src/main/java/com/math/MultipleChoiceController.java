package com.math;

import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MultipleChoiceController {
    @FXML
    private Button button_a;

    @FXML
    private Button button_b;

    @FXML
    private Button button_c;

    @FXML
    private Button checkanswer;

    @FXML
    private Text text_soal;

    
    public void initialize(){
    }

    public void setSelected(boolean button_1,boolean button_2, boolean button_3){
        button_a.pseudoClassStateChanged(PseudoClass.getPseudoClass("selected"), button_1);
        button_b.pseudoClassStateChanged(PseudoClass.getPseudoClass("selected"), button_2);
        button_c.pseudoClassStateChanged(PseudoClass.getPseudoClass("selected"), button_3);
    }
    public void setData(Question soal){
        text_soal.setText(soal.getQuestionString());
        button_a.setText("A. "+soal.getOptionA());
        button_b.setText("B. "+soal.getOptionB());
        button_c.setText("C. "+soal.getOptionC());
    }
    public Button buttonPropertyA(){
        return button_a;
    }
    public Button buttonPropertyB(){
        return button_b;
    }
    public Button buttonPropertyC(){
        return button_c;
    }

    public Button answerButtonProperty(){
        return checkanswer;
    }
}
