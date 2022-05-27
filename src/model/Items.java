package model;

public class Items {
    private String item;
    private Integer posicaoItem;
    
    public Items(String it)
    {
        this.item = it;
    }
    
    public Items(int pi)
    {
        this.posicaoItem = pi;
    }

    public Items(String it, int pi)
    {
        this.item = it;
        this.posicaoItem = pi;
    }

    public Integer getPosicaoItem() {
        return posicaoItem;
    }


    public void setPosicaoItem(Integer posicaoItem) {
        this.posicaoItem = posicaoItem;
    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}
