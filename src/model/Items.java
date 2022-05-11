package model;

public class Items {
    private String item;

    public Items(String item, Boolean selecionar) {
        this.item = item;
    }

    public Items(String it)
    {
        this.item = it;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}
