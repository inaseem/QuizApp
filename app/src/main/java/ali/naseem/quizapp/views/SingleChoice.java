package ali.naseem.quizapp.views;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import ali.naseem.quizapp.R;
import ali.naseem.quizapp.models.RadioModel;
import ali.naseem.quizapp.models.submodels.Choice;


public class SingleChoice extends LinearLayout {

    public TextView title;
    public RadioGroup radioGroup;
    public View v;
    public RadioModel choiceModel;

    public SingleChoice(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_radio, this, true);
        this.v = v;
        title = v.findViewById(R.id.title);
        radioGroup = v.findViewById(R.id.radioGroup);
    }

    public SingleChoice(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_radio, this, true);
        this.v = v;
        title = v.findViewById(R.id.title);
        radioGroup = v.findViewById(R.id.radioGroup);
    }

    public SingleChoice(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_radio, this, true);
        this.v = v;
        title = v.findViewById(R.id.title);
        radioGroup = v.findViewById(R.id.radioGroup);
    }

    public SingleChoice(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_radio, this, true);
        this.v = v;
        title = v.findViewById(R.id.title);
        radioGroup = v.findViewById(R.id.radioGroup);
    }

    public RadioModel getChoiceModel() {
        choiceModel.setSelected(-1);
        for (int i = 0; i < radioGroup.getChildCount(); ++i) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            if (radioButton.isChecked()) {
                choiceModel.setSelected(Integer.parseInt(radioButton.getContentDescription().toString()));
                break;
            }
        }
        return choiceModel;
    }

    public void setChoiceModel(RadioModel choiceModel) {
        this.choiceModel = choiceModel;
        this.title.setText(choiceModel.getTitle());
        for (Choice choice : choiceModel.getChoices()) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setContentDescription(String.valueOf(choice.getNumber()));
            radioButton.setText(choice.getValue());
            radioButton.setGravity(Gravity.CENTER_VERTICAL);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
            );
            radioButton.setLayoutParams(param);
            radioButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            radioButton.setTextColor(getResources().getColor(R.color.text_option));
            radioGroup.addView(radioButton);
            if (choice.getNumber() == choiceModel.getSelected()) {
                radioButton.setChecked(true);
            }
        }
    }

    public void reset() {
        radioGroup.clearCheck();
    }
}

