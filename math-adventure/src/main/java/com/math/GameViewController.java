package com.math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class GameViewController {

    @FXML
    private ScrollPane center_pane;
    
    private List<Question> questions = new ArrayList<Question>();
    private int soalStage=1;
    private Question currentQuestion;
    private String currentAnswer;

    public void initialize(){
        AppData.getSoalList(questions);
        showSoal(soalStage);
    }

    private void showSoal(int soalStage){
        FXMLLoader fxmlLoader = new FXMLLoader();
        currentQuestion = questions.get(soalStage);
        if(currentQuestion.getTypeSoal()==1){
            try {
                fxmlLoader.setLocation(getClass().getResource("multiple_choice.fxml"));
                AnchorPane multiChoicePane = fxmlLoader.load();
                MultipleChoiceController soalController = fxmlLoader.getController();
                soalController.setData(currentQuestion);
                soalController.buttonPropertyA().setOnAction(event->{
                    currentAnswer = "a";
                    soalController.setSelected(true, false, false);
                });
                soalController.buttonPropertyB().setOnAction(event->{
                    currentAnswer = "b";
                    soalController.setSelected(false, true, false);
                });
                soalController.buttonPropertyC().setOnAction(event->{
                    currentAnswer = "c";
                    soalController.setSelected(false, false, true);
                });
                soalController.answerButtonProperty().setOnAction(event->checkAnswer());
                center_pane.setContent(multiChoicePane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(currentQuestion.getTypeSoal()==2){
            try {
                fxmlLoader.setLocation(getClass().getResource("multiple_choice.fxml"));
                AnchorPane isiangandapPane = fxmlLoader.load();
                MultipleChoiceController soalController = fxmlLoader.getController();
                soalController.setData(currentQuestion);
                center_pane.setContent(isiangandapPane);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private boolean checkAnswer(){
        boolean correct = false;
        if(currentQuestion.getTypeSoal()==1)
            correct = currentQuestion.getAnswerPg().equals(currentAnswer);
        else if(currentQuestion.getTypeSoal() == 2)
            correct = currentQuestion.getAnswerEssay().equals(currentAnswer);

        if(correct)
            System.out.println("benar");
        else
            System.out.println("salah");
        return correct;
    }
}