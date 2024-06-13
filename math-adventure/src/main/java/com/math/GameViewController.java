package com.math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.scene.Node;

public class GameViewController {

    @FXML
    private ScrollPane center_pane;
    
    private List<Question> questions = new ArrayList<Question>();
    private int soalStage=1;
    private Question currentQuestion;
    private String currentAnswer;

    public void initialize(){
        AppData.getRandomQuestion(questions);
        showSoal(soalStage);
    }

    private void showSoal(int soalStage){
        FXMLLoader fxmlLoader = new FXMLLoader();
        currentQuestion = questions.get(soalStage);
        if(currentQuestion.getQuestionType()==1){
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
                soalController.answerButtonProperty().setOnAction(event->{
                    if(checkAnswer()){
                        fade(multiChoicePane);
                        toNextQuestion();
                    }

                });
                center_pane.setContent(multiChoicePane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(currentQuestion.getQuestionType()==2){
            try {
                fxmlLoader.setLocation(getClass().getResource("essay.fxml"));
                AnchorPane essayPane = fxmlLoader.load();
                EssayController soalController = fxmlLoader.getController();
                soalController.setData(currentQuestion);
                soalController.answerButtonProperty().setOnAction(event->{
                    currentAnswer = soalController.textfieldProperty().getText();
                    if(checkAnswer()){
                        fade(essayPane);
                        toNextQuestion();
                    }

                });
                center_pane.setContent(essayPane);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private boolean checkAnswer(){
        boolean correct = false;
        if(currentQuestion.getQuestionType()==1)
            correct = currentQuestion.getAnswerPg().equals(currentAnswer);
        else if(currentQuestion.getQuestionType() == 2)
            correct = currentQuestion.getAnswerEssay().equals(currentAnswer);

        if(correct){
            System.out.println("benar");
        }
        else{
            System.out.println("salah");
        }
        return correct;
    }
    private void fade(Node node){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500));
        fadeTransition.setNode(node);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.1);
        fadeTransition.play();
    }
    private void toNextQuestion(){
        soalStage++;
        showSoal(soalStage);
    }
}