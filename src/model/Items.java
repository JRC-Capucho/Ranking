package model;

public class Items {
    private String item;

    public Items(String it)
    {
        this.item = it;
    }

    /**
     * @return String return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

}
