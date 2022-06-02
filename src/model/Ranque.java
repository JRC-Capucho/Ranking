package model;

import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;


public class Ranque {


    private static ArrayList<String> tituloDoRanque = new ArrayList<>();
    private static ArrayList<Integer> id = new ArrayList();
    private static ArrayList<Integer> contVotos = new ArrayList<>();
    private static ArrayList<String> votos = new ArrayList<>();
    
    
    
    public Ranque(){}

    
    public void criarRanque(String n)
    {
        votos.add(n);
        contVotos.add(0);
    }

    public void contagemVotos(int posicao)
    {
        contVotos.set(posicao,(contVotos.get(posicao)+1));
    }

    public String adicionarOpcoesDeEscolha()
    {
        TextInputDialog item = new TextInputDialog();
        item.setTitle("Itens");
        item.setHeaderText("Adicionar novos itens");
        item.setContentText("Digite o novo item: ");
        
        Optional<String> aux = item.showAndWait();
        
        if(aux.isPresent() && aux.get().length() > 0)
        {
            return aux.get();
        }
        return null;
        
    }
    
    public Boolean msgConfirmarExclusao()
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Excluir");
        alert.setHeaderText("Deseja realmente excluir esse item");
        alert.setContentText("Escolha uma opção abaixo");
        
        ButtonType botaoSim = new ButtonType("Sim");
        ButtonType botaoNao = new ButtonType("Não");

        alert.getButtonTypes().setAll(botaoSim, botaoNao);

        Optional<ButtonType> aux = alert.showAndWait();
        
        if(aux.get() == botaoSim)
            return true;
        else
            return false;
    }
    
    public void adicionarNomeDoRanque(String n)
    {
        tituloDoRanque.add(n);
    }
    
    public String retornaNomeDoRanque()
    {
        return tituloDoRanque.get(0);
    }

    public String getVotos(int posicao)
    {
        return this.votos.get(posicao);
    }

    public int tamanhoDoVetor()
    {
        return this.contVotos.size();
    }

    public int getContVotos(int posicao)
    {
        return this.contVotos.get(posicao);
    }

}    
