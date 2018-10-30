package ali.naseem.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private RadioButton option1;
    private RadioButton option2;
    private RadioButton option3;
    private RadioButton option4;
    private RadioGroup radioGroup;
    private Button next;
    private ArrayList<Question> questions;
    private int qIndex = 0;
    private int answers[];
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        radioGroup = findViewById(R.id.radioGroup);
        next = findViewById(R.id.next);
        reset = findViewById(R.id.reset);
        questions = new ArrayList<>();
        Question question0 = new Question("Which of the following is necessary for burning (combustion)");
        question0.setOption1("Petrol");
        question0.setOption2("Nitrogen");
        question0.setOption3("Oxygen");
        question0.setOption4("Carbon");
        question0.setAnswer(3);
        Question question1 = new Question("Which gas evolves when charcoal is burnt?");
        question1.setOption1("Nitrogen");
        question1.setOption2("Carbon Dioxide");
        question1.setOption3("Ozone");
        question1.setOption4("Oxygen");
        question1.setAnswer(2);
        Question question2 = new Question("Who wrote the book \"The Origin of Species\"?");
        question2.setOption1("Sir Alexander Fleming");
        question2.setOption2("Stephen Hawking");
        question2.setOption3("Louis Pasteur");
        question2.setOption4("Charles Darwin");
        question2.setAnswer(4);
        Question question3 = new Question("The Earth is surrounded by an insulating blanket of gases which protects it from the light and heat of the Sun. This insulating layer is called the");
        question3.setOption1("Lithosphere");
        question3.setOption2("Atmosphere");
        question3.setOption3("Hydrosphere");
        question3.setOption4("Biosphere");
        question3.setAnswer(2);
        Question question4 = new Question("The atom is made of");
        question4.setOption1("Protons and Quarks");
        question4.setOption2("Protons, Neutrons and Electrons");
        question4.setOption3("Neutrinos, Gamma Rays and Positrons");
        question4.setOption4("Positrons, Neutrons and Electrons");
        question4.setAnswer(2);
        questions.add(question0);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        answers = new int[questions.size()];
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goNext();
            }
        });
        next.performClick();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }

    private void setQuestion(Question q) {
        question.setText("Q. ".concat(q.getQuestion()));
        option1.setText(q.getOption1());
        option2.setText(q.getOption2());
        option3.setText(q.getOption3());
        option4.setText(q.getOption4());
    }

    public void goNext() {
        if (qIndex < questions.size()) {
            --qIndex;
            if (option1.isChecked()) {
                answers[qIndex] = 1;
            }
            if (option2.isChecked()) {
                answers[qIndex] = 2;
            }
            if (option3.isChecked()) {
                answers[qIndex] = 3;
            }
            if (option4.isChecked()) {
                answers[qIndex] = 4;
            }
            ++qIndex;
            setQuestion(questions.get(qIndex));
            radioGroup.clearCheck();
            qIndex++;
        } else {
            if (qIndex > 0) {
                if (option1.isChecked()) {
                    answers[qIndex - 1] = 1;
                }
                if (option2.isChecked()) {
                    answers[qIndex - 1] = 2;
                }
                if (option3.isChecked()) {
                    answers[qIndex - 1] = 3;
                }
                if (option4.isChecked()) {
                    answers[qIndex - 1] = 4;
                }
                next.setText("View Score");
                showScore();
                reset.setVisibility(View.VISIBLE);
            }
        }
    }

    private void showScore() {
        StringBuilder sb = new StringBuilder();
        int score = 0;
        for (int i = 0; i < questions.size(); ++i) {
            System.out.println(answers[i] + " ==== " + questions.get(i).getAnswer());
            if (answers[i] == questions.get(i).getAnswer()) {
                sb.append("Question " + (i + 1) + ": " + "5 Points").append("\n");
                score += 5;
            } else {
                sb.append("Question " + (i + 1) + ": " + "0 Points").append("\n");
            }
        }
        Toast.makeText(this, sb.toString() + "Total Score = " + score, Toast.LENGTH_LONG).show();
    }

    private void resetGame() {
        qIndex = 1;
        for (int i = 0; i < answers.length; ++i) {
            answers[i] = 0;
        }
        setQuestion(questions.get(0));
        next.setText("Next");
        radioGroup.clearCheck();
        reset.setVisibility(View.GONE);
    }
}
