package com.math;

public class Question {
    private int question_id;
    private int question_type;
    private String questionString;
    private String option_a;
    private String option_b;
    private String option_c;
    private String answer_pg;
    private String answer_essay;

    public Question(int question_id,String questionString,String option_a,String option_b,String option_c,String answer_pg){
        this.question_id=question_id;
        this.questionString = questionString;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.answer_pg = answer_pg;
        this.question_type = 1;
    }
    public Question(int question_id,String soalString,String answer_essay){
        this.question_id=question_id;
        this.questionString = soalString;
        this.answer_essay = answer_essay;
        this.question_type =2;
    }

    public int getQuestionType() {
        return question_type;
    }

    public String getQuestionString() {
        return questionString;
    }

    public String getOptionA() {
        return option_a;
    }

    public String getOptionB() {
        return option_b;
    }

    public String getOptionC() {
        return option_c;
    }

    public String getAnswerPg() {
        return answer_pg;
    }

    public String getAnswerEssay() {
        return answer_essay;
    }

    public Integer getQuestionId(){
        return question_id;
    }

}
