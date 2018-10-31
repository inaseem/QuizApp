package ali.naseem.quizapp.views;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import ali.naseem.quizapp.R;
import ali.naseem.quizapp.models.CheckboxModel;
import ali.naseem.quizapp.models.submodels.Choice;


public class MultiChoice extends LinearLayout {

    public TextView title;
    public LinearLayout checkboxes;
    public View v;
    public CheckboxModel choiceModel;

    public MultiChoice(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_checkbox, this, true);
        this.v = v;
        title = v.findViewById(R.id.title);
        checkboxes = v.findViewById(R.id.checkBoxes);
    }

    public MultiChoice(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_checkbox, this, true);
        this.v = v;
        title = v.findViewById(R.id.title);
        checkboxes = v.findViewById(R.id.checkBoxes);
    }

    public MultiChoice(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_checkbox, this, true);
        this.v = v;
        title = v.findViewById(R.id.title);
        checkboxes = v.findViewById(R.id.checkBoxes);
    }

    public MultiChoice(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_checkbox, this, true);
        this.v = v;
        title = v.findViewById(R.id.title);
        checkboxes = v.findViewById(R.id.checkBoxes);
    }

    public CheckboxModel getChoiceModel() {
        choiceModel.getSelected().clear();
        for (int i = 0; i < checkboxes.getChildCount(); ++i) {
            CheckBox checkbox = (CheckBox) checkboxes.getChildAt(i);
            if (checkbox.isChecked()) {
                choiceModel.addSelected(Integer.parseInt(checkbox.getContentDescription().toString()));
            }
        }
        return choiceModel;
    }

    public void setChoiceModel(CheckboxModel choiceModel) {
        this.choiceModel = choiceModel;
        this.title.setText(choiceModel.getTitle());
        for (Choice choice : choiceModel.getChoices()) {
            CheckBox checkbox = new CheckBox(getContext());
            checkbox.setContentDescription(String.valueOf(choice.getNumber()));
            checkbox.setText(choice.getValue());
            checkbox.setGravity(Gravity.CENTER_VERTICAL);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
            );
            checkbox.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            checkbox.setTextColor(getResources().getColor(R.color.text_option));
            checkbox.setLayoutParams(param);
            for (int s : choiceModel.getSelected()) {
                if (choice.getNumber() == s) {
                    checkbox.setChecked(true);
                }
            }
            checkboxes.addView(checkbox);
        }
    }

    public void reset() {
        for (int i = 0; i < checkboxes.getChildCount(); ++i) {
            CheckBox checkbox = (CheckBox) checkboxes.getChildAt(i);
            checkbox.setChecked(false);
        }
    }
}

