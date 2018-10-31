package ali.naseem.quizapp.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import ali.naseem.quizapp.R;
import ali.naseem.quizapp.models.TextModel;

public class SimpleText extends LinearLayout {
    private TextModel textModel;
    public TextView title;
    public EditText value;

    public SimpleText(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_text, this, true);
        title = v.findViewById(R.id.title);
        value = v.findViewById(R.id.value);
    }

    public SimpleText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_text, this, true);
        title = v.findViewById(R.id.title);
        value = v.findViewById(R.id.value);
    }

    public SimpleText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_text, this, true);
        title = v.findViewById(R.id.title);
        value = v.findViewById(R.id.value);
    }

    public void setTextModel(TextModel textModel) {
        this.textModel = textModel;
        this.title.setText(this.textModel.getTitle());
        this.value.setText(this.textModel.getValue());
    }

    public TextModel getTextModel() {
        textModel.setValue(this.value.getText().toString().trim());
        return textModel;
    }

    public void reset() {
        this.value.setText("");
    }
}
