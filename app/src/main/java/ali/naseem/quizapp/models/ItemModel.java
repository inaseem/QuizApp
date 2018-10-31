package ali.naseem.quizapp.models;

public class ItemModel {
    private String title;
    private int type;
    private int position=-1;

    public ItemModel(String title) {
        this.title = title;
        this.type = -1;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
