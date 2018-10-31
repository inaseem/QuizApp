package ali.naseem.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import ali.naseem.quizapp.models.CheckboxModel;
import ali.naseem.quizapp.models.ItemModel;
import ali.naseem.quizapp.models.RadioModel;
import ali.naseem.quizapp.models.TextModel;
import ali.naseem.quizapp.models.submodels.Choice;
import ali.naseem.quizapp.views.MultiChoice;
import ali.naseem.quizapp.views.SimpleText;
import ali.naseem.quizapp.views.SingleChoice;

public class QuizActivity extends AppCompatActivity {

    private ArrayList<ItemModel> models = new ArrayList<>();
    private LinearLayout linearLayout;
    private Button score;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        linearLayout = findViewById(R.id.linearLayout);
        score = findViewById(R.id.score);
        reset = findViewById(R.id.reset);
        RadioModel radioModel = new RadioModel("Which of the following is necessary for burning (combustion)");
        radioModel.addChoice(new Choice(0, "Petrol"));
        radioModel.addChoice(new Choice(1, "Nitrogen"));
        radioModel.addChoice(new Choice(2, "Oxygen"));
        radioModel.addChoice(new Choice(3, "Carbon"));
        radioModel.setCorrectAnswer(2);
        RadioModel radioModel1 = new RadioModel("Which gas evolves when charcoal is burnt?");
        radioModel1.addChoice(new Choice(0, "Nitrogen"));
        radioModel1.addChoice(new Choice(1, "Carbon Dioxide"));
        radioModel1.addChoice(new Choice(2, "Ozone"));
        radioModel1.addChoice(new Choice(3, "Oxygen"));
        radioModel1.setCorrectAnswer(1);
        RadioModel radioModel2 = new RadioModel("Who wrote the book \"The Origin of Species\"?");
        radioModel2.addChoice(new Choice(0, "Sir Alexander Fleming"));
        radioModel2.addChoice(new Choice(1, "Stephen Hawking"));
        radioModel2.addChoice(new Choice(2, "Louis Pasteur"));
        radioModel2.addChoice(new Choice(3, "Charles Darwin"));
        radioModel2.setCorrectAnswer(3);
        RadioModel radioModel3 = new RadioModel("The Earth is surrounded by an insulating blanket of gases which protects it from the light and heat of the Sun. This insulating layer is called the");
        radioModel3.addChoice(new Choice(0, "Lithosphere"));
        radioModel3.addChoice(new Choice(1, "Atmosphere"));
        radioModel3.addChoice(new Choice(2, "Hydrosphere"));
        radioModel3.addChoice(new Choice(3, "Biosphere"));
        radioModel3.setCorrectAnswer(1);
        CheckboxModel checkboxModel = new CheckboxModel("Select simple carbohydrates");
        checkboxModel.addChoice(new Choice(0, "Fructose"));
        checkboxModel.addChoice(new Choice(1, "Lactose"));
        checkboxModel.addChoice(new Choice(2, "Lactose"));
        checkboxModel.addChoice(new Choice(3, "Candy"));
        checkboxModel.addCorrect(0);
        checkboxModel.addCorrect(1);
        checkboxModel.addCorrect(2);
        TextModel textModel = new TextModel("How much budget was requested for Mars Program Plans in 2015?");
        models.add(radioModel);
        models.add(radioModel1);
        models.add(radioModel2);
        models.add(radioModel3);
        models.add(checkboxModel);
        models.add(textModel);
        Helper.setPositions(models);
        Helper.addToForm(models, linearLayout);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScore();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetQuiz();
            }
        });
    }

    private void showScore() {
        ArrayList<ItemModel> itemModels = Helper.getData(linearLayout);
        StringBuilder sb = new StringBuilder();
        int score = 0;
        int i = 0;
        for (ItemModel itemModel : itemModels) {
            switch (itemModel.getType()) {
                case Constants.TYPE_SINGLE_CHOICE:
                    RadioModel radioModel = (RadioModel) itemModel;
                    if (radioModel.getSelected() == radioModel.getCorrectAnswer()) {
                        score += 5;
                        sb.append("Question " + (i + 1) + ": " + "5 Points").append("\n");
                    } else {
                        sb.append("Question " + (i + 1) + ": " + "0 Points").append("\n");
                    }
                    break;
                case Constants.TYPE_MULTI_CHOICE:
                    CheckboxModel checkboxModel = (CheckboxModel) itemModel;
                    Collections.sort(checkboxModel.getCorrects());
                    Collections.sort(checkboxModel.getSelected());
                    System.out.println("Corrects = " + checkboxModel.getCorrects());
                    System.out.println("Selected = " + checkboxModel.getSelected());
                    if (checkboxModel.getCorrects().equals(checkboxModel.getSelected())) {
                        score += 5;
                        sb.append("Question " + (i + 1) + ": " + "5 Points").append("\n");
                    } else {
                        sb.append("Question " + (i + 1) + ": " + "0 Points").append("\n");
                    }
                    break;
                case Constants.TYPE_TEXT:
                    TextModel textModel = (TextModel) itemModel;
                    if (textModel.getValue().trim().length() > 0) {
                        score += 5;
                        sb.append("Question " + (i + 1) + ": " + "5 Points").append("\n");
                    } else {
                        sb.append("Question " + (i + 1) + ": " + "0 Points").append("\n");
                    }
            }
            i++;
        }
        Toast.makeText(this, sb.toString().concat("Total score = " + score), Toast.LENGTH_SHORT).show();
    }

    private void resetQuiz() {
        for (int i = 0; i < linearLayout.getChildCount(); ++i) {
            View view = linearLayout.getChildAt(i);
            if (view instanceof MultiChoice) {
                MultiChoice multiChoice = (MultiChoice) view;
                multiChoice.reset();
            }
            if (view instanceof SingleChoice) {
                SingleChoice singleChoice = (SingleChoice) view;
                singleChoice.reset();
            }
            if (view instanceof SimpleText) {
                SimpleText simpleText = (SimpleText) view;
                simpleText.reset();
            }
        }
    }
}
