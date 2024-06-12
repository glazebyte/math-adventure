package com.math;

public class Question {
    private int type_soal;
    private String questionString;
    private String option_a;
    private String option_b;
    private String option_c;
    private String answer_pg;
    private String answer_essay;

    public Question(String soalString,String option_a,String option_b,String option_c,String answer_pg){
        this.questionString = soalString;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.answer_pg = answer_pg;
        this.type_soal = 1;
    }
    public Question(String soalString,String answer_essay){
        this.questionString = soalString;
        this.answer_essay = answer_essay;
        this.type_soal =2;
    }

    public int getTypeSoal() {
        return type_soal;
    }

    public String getQuesionString() {
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

}
