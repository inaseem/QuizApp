package ali.naseem.quizapp;

import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import ali.naseem.quizapp.models.CheckboxModel;
import ali.naseem.quizapp.models.ItemModel;
import ali.naseem.quizapp.models.RadioModel;
import ali.naseem.quizapp.views.MultiChoice;
import ali.naseem.quizapp.views.SingleChoice;

public class Helper {
    public static ArrayList<ItemModel> getData(LinearLayout linearLayout) {
        ArrayList<ItemModel> models = new ArrayList<>();
        for (int i = 0; i < linearLayout.getChildCount(); ++i) {
            View view = linearLayout.getChildAt(i);
            if (view instanceof MultiChoice) {
                MultiChoice multiChoice = (MultiChoice) view;
                models.add(multiChoice.getChoiceModel());
            }
            if (view instanceof SingleChoice) {
                SingleChoice singleChoice = (SingleChoice) view;
                models.add(singleChoice.getChoiceModel());
            }
        }
        return models;
    }

    public static void addToForm(ArrayList<ItemModel> models, LinearLayout linearLayout) {
        for (ItemModel itemModel : models) {
            switch (itemModel.getType()) {
                case Constants.TYPE_SINGLE_CHOICE:
                    SingleChoice singleChoice = new SingleChoice(linearLayout.getContext());
                    singleChoice.setChoiceModel((RadioModel) itemModel);
                    linearLayout.addView(singleChoice);
                    break;
                case Constants.TYPE_MULTI_CHOICE:
                    MultiChoice multiChoice = new MultiChoice(linearLayout.getContext());
                    multiChoice.setChoiceModel((CheckboxModel) itemModel);
                    linearLayout.addView(multiChoice);
                    break;
            }
        }
    }

    public static void setPositions(ArrayList<ItemModel> itemModels) {
        int i = 0;
        for (ItemModel itemModel : itemModels) {
            itemModel.setPosition(i++);
        }
    }
}
