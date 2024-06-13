package com.math;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    ObservableList <Question> questions =FXCollections.observableArrayList();

    public void initialize(){
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
}
