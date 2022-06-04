package model;

import javafx.scene.control.Button;

public class Items {

    private String item;
    private Integer posicaoItem;
    private Button botao;
    
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

    public Items(String it, Button n)
    {
        this.item = it;
        this.botao = new Button("Enviar");
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

    public Button getBotao() {
        return botao;
    }
    
    public void setBotao(Button botao) {
        this.botao = botao;
    }
}
