package ali.naseem.quizapp.models;

import java.util.ArrayList;

import ali.naseem.quizapp.Constants;
import ali.naseem.quizapp.models.submodels.Choice;

public class CheckboxModel extends ItemModel {
    private ArrayList<Choice> choices;
    private ArrayList<Integer> selected = new ArrayList<>();
    private ArrayList<Integer> corrects = new ArrayList<>();

    public CheckboxModel(String title) {
        super(title);
        choices = new ArrayList<>();
        setType(Constants.TYPE_MULTI_CHOICE);
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

    public void addSelected(int position) {
        selected.add(position);
    }

    public ArrayList<Integer> getSelected() {
        return selected;
    }

    public ArrayList<Integer> getCorrects() {
        return corrects;
    }

    public void addCorrect(int correct) {
        this.corrects.add(correct);
    }
}
