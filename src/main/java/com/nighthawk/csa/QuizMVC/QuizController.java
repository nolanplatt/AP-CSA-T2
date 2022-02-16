package com.nighthawk.csa.QuizMVC;
/*
This project was made by altering "Greet" from the spring_portfolio
I changed variables to make them stand out and be more meaningful, instead of everything being called 'name'
Hopefully this code is easier to read!
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {

    /*
    Arch here
    If you wish to add a new question to the list of questions, follow these steps
    1) Increase final int numberOfQuestions by 1, or however many questions you want to add
    2) Next, copy-paste one of the else-if code blocks I made, changes I've listed below:
        a) else if (questionId == #) change to your question's ID number
        b) model.addAttribute("question", " [[ YOUR QUESTION HERE ]] ");
        c) if (UserInputJava.equals(" [[ YOUR ANSWER HERE ]] "))
        d) while (questionId == #) change to your question's ID number
    3) Success! You've added a question to the Nutrition Quiz!
     */

    private int questionId = 0;

    @GetMapping("/quiz")
    public String greeting(@RequestParam(name= "UserInput", required=false, defaultValue="...") String UserInputJava, Model model) {

        final int numberOfQuestions = 6;

        if (questionId == 0) {
            model.addAttribute("question", "To get started, press enter.");
            // Random integer from 1 to max
            questionId = (int) (Math.floor(Math.random() * numberOfQuestions) + 1);
        }

        else if (questionId == 1) {
            model.addAttribute("question", "What is the BMI of a 6 foot person that weighs 140 pounds? Answer to the nearest tenth.");

            // -------------------------- Answer (for demonstration) --------------------------
            model.addAttribute("answer", "19.0");
            // -------------------------- Answer (for demonstration) --------------------------

            if (UserInputJava.equals("19.0")) {
                model.addAttribute("output", "Correct! Press enter to continue.");
                // Chooses a random questionId, but if they choose the same question, reselect the questionId.
                do {
                    questionId = (int) (Math.floor(Math.random() * numberOfQuestions) + 1);
                }
                while (questionId == 1);
            }
            else {
                model.addAttribute("output", "Wrong!");
            }
        }

        else if (questionId == 2) {
            model.addAttribute("question", "What is the normal BMI for an adult?");

            // -------------------------- Answer (for demonstration) --------------------------
            model.addAttribute("answer", "18.5 to 24.9");
            // -------------------------- Answer (for demonstration) --------------------------

            if (UserInputJava.equals("18.5 to 24.9")) {
                model.addAttribute("output", "Correct! Press enter to continue.");
                // Chooses a random questionId, but if they choose the same question, reselect the questionId.
                do {
                    questionId = (int) (Math.floor(Math.random() * numberOfQuestions) + 1);
                }
                while (questionId == 2);
            }
            else {
                model.addAttribute("output", "Wrong!");
            }
        }

        else if (questionId == 3) {
            model.addAttribute("question", "What does BMI stand for?");

            // -------------------------- Answer (for demonstration) --------------------------
            model.addAttribute("answer", "Body Mass Index");
            // -------------------------- Answer (for demonstration) --------------------------

            if (UserInputJava.equals("Body Mass Index")) {
                model.addAttribute("output", "Correct! Press enter to continue.");
                // Chooses a random questionId, but if they choose the same question, reselect the questionId.
                do {
                    questionId = (int) (Math.floor(Math.random() * numberOfQuestions) + 1);
                }
                while (questionId == 3);
            }
            else {
                model.addAttribute("output", "Wrong!");
            }
        }

        else if (questionId == 4) {
            model.addAttribute("question", "What BMI range is considered overweight");

            // -------------------------- Answer (for demonstration) --------------------------
            model.addAttribute("answer", "25 to 29.9");
            // -------------------------- Answer (for demonstration) --------------------------

            if (UserInputJava.equals("25 to 29.9")) {
                model.addAttribute("output", "Correct! Press enter to continue.");
                // Chooses a random questionId, but if they choose the same question, reselect the questionId.
                do {
                    questionId = (int) (Math.floor(Math.random() * numberOfQuestions) + 1);
                }
                while (questionId == 4);
            }
            else {
                model.addAttribute("output", "Wrong!");
            }
        }

        else if (questionId == 5) {
            model.addAttribute("question", "What BMI range is considered obese");

            // -------------------------- Answer (for demonstration) --------------------------
            model.addAttribute("answer", "30 to 39.9");
            // -------------------------- Answer (for demonstration) --------------------------

            if (UserInputJava.equals("30 to 39.9")) {
                model.addAttribute("output", "Correct! Press enter to continue.");
                // Chooses a random questionId, but if they choose the same question, reselect the questionId.
                do {
                    questionId = (int) (Math.floor(Math.random() * numberOfQuestions) + 1);
                }
                while (questionId == 5);
            }
            else {
                model.addAttribute("output", "Wrong!");
            }
        }

        else if (questionId == 6) {
            model.addAttribute("question", "What converts food into energy?");

            // -------------------------- Answer (for demonstration) --------------------------
            model.addAttribute("answer", "cellular respiration");
            // -------------------------- Answer (for demonstration) --------------------------

            if (UserInputJava.equals("cellular respiration") || UserInputJava.equals("metabolism")) {
                model.addAttribute("output", "Correct! Press enter to continue.");
                // Chooses a random questionId, but if they choose the same question, reselect the questionId.
                do {
                    questionId = (int) (Math.floor(Math.random() * numberOfQuestions) + 1);
                }
                while (questionId == 6);
            }

            else {
                model.addAttribute("output", "Wrong!");
            }
        }

        // Returns ... if the user inputs ... which is the default value
        if (UserInputJava.equals("...")) {
            model.addAttribute("output", "...");
        }
        // Return all model attributes to html
        return "quiz";
    }
}