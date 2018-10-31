package ali.naseem.quizapp.models;

import ali.naseem.quizapp.Constants;

public class TextModel extends ItemModel {
    private String value;

    public TextModel(String title) {
        super(title);
        super.setType(Constants.TYPE_TEXT);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
