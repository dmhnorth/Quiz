package models;

public interface Question {

    void setQuestion(String question);

    String getQuestion();

    void setAnswersChoices(String[] answersChoices);

    String[] getAnswersChoices();

    void setCorrectAns(int correctAns);

    int getCorrectAns();
}
