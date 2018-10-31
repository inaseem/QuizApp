package ali.naseem.quizapp.models;

import java.util.ArrayList;

import ali.naseem.quizapp.Constants;
import ali.naseem.quizapp.models.submodels.Choice;

public class RadioModel extends ItemModel {
    private ArrayList<Choice> choices;
    private int selected = -1;
    private int correctAnswer = -1;

    public RadioModel(String title) {
        super(title);
        choices = new ArrayList<>();
        setType(Constants.TYPE_SINGLE_CHOICE);
    }

    public void addChoice(Choice choice) {
        choices.add(choice);
    }

    public void removeChoice(Choice choice) {

    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<Choice> choices) {
        this.choices = choices;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public int getSelected() {
        return selected;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
