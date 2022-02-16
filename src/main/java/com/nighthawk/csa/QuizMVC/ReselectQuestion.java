package com.nighthawk.csa.QuizMVC;

public class ReselectQuestion extends QuizController {
    int questionId;
    int questionNumber;
    int numberOfQuestions;

    public ReselectQuestion(int questionId, int questionNumber, int numberOfQuestions) {
        this.questionId = questionId;
        this.questionNumber = questionNumber;
        this.numberOfQuestions = numberOfQuestions;
    }

    public int questionReselect() {
        // Chooses a random questionId, but if they choose the same question, reselect the questionId.
        while (this.questionId == this.questionNumber) {
            this.questionId = (int) (Math.floor(Math.random() * this.numberOfQuestions) + 1);
        }

        // Return new questionId
        return this.questionId;
    }

}
