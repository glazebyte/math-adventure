package com.math;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DashboardController {

    @FXML
    private TableView<Question> question_table;
    @FXML
    private TableColumn<Question, String> choice_answer_column;
    @FXML
    private TableColumn<Question, String> essay_answer_column;
    @FXML
    private TableColumn<Question, Integer> id_collumn;
    @FXML
    private TableColumn<Question, String> optionA_column;
    @FXML
    private TableColumn<Question, String> optionB_column;
    @FXML
    private TableColumn<Question, String> optionC_column;
    @FXML
    private TableColumn<Question, String> question_column;
    @FXML
    private TableColumn<Question, Integer> type_column;

    ObservableList <Question> questions = FXCollections.observableArrayList();

    @FXML
    private Button create_button;

    @FXML
    private Button logout_button;

    private UserHolder userHolder = UserHolder.getInstance();

    private Question questionInput = null;

    public void initialize(){
        setTable();
        create_button.setOnAction(event->showQuestionForm());
        logout_button.setOnAction(event->logout());
    }

    private void setTable(){
        AppData.getSoalList(questions);
        choice_answer_column.setCellValueFactory(new PropertyValueFactory<Question,String>("AnswerPg"));
        essay_answer_column.setCellValueFactory(new PropertyValueFactory<Question,String>("AnswerEssay"));
        id_collumn.setCellValueFactory(new PropertyValueFactory<Question,Integer>("QuestionId"));
        optionA_column.setCellValueFactory(new PropertyValueFactory<Question,String>("OptionA"));
        optionB_column.setCellValueFactory(new PropertyValueFactory<Question,String>("OptionB"));
        optionC_column.setCellValueFactory(new PropertyValueFactory<Question,String>("OptionC"));
        question_column.setCellValueFactory(new PropertyValueFactory<Question,String>("QuestionString"));
        type_column.setCellValueFactory(new PropertyValueFactory<Question,Integer>("QuestionType"));
        question_table.setItems(questions);
    }

    private void showQuestionForm(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("form.fxml"));
            AnchorPane form = fxmlLoader.load();
            QuestionFormController formController = fxmlLoader.getController();
            Scene scene = new Scene(form);
            Stage stage = new Stage();
            stage.setScene(scene); 
            stage.initStyle(StageStyle.UNDECORATED);
            formController.exitButtonProperty().setOnAction(event-> stage.close());
            formController.simpaButtonProperty().setOnAction(event-> {
                questionInput = formController.getQuestion();
                eventSave();
                stage.close();
            });
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void logout(){
        userHolder.clearLoggedInUser();
        try {
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void eventSave(){
        System.out.println(questionInput.getQuestionString());
        AppData.insertQuestion(questionInput);
        questionInput = null;
        refreshTable();
    }
    public void refreshTable(){
        AppData.getSoalList(questions);
        question_table.setItems(questions);
    }
}
