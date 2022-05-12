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
    private static int indice = 0;
    private static int[] contVotos;
    private static String[] votos;
    private static String tituloaux;

    public Ranque(){}

    
    
    
    public void contagemVotos(int posicao)
    {
        contVotos[posicao]++;
        System.out.println("voto ["+posicao+"] = " + contVotos[posicao]);
    }
    public void criarVetor(int n)
    {
        id.add(indice);
        votos = new String[n];
        contVotos = new int[n];
        inicioDeVotacao();
    }

    private void inicioDeVotacao()
    {
        for (int i = 0; i < contVotos.length; i++) {
            contVotos[i] = 0;
        }
    }
    
    public void addEscolharDeVotos(ArrayList<String> n)
    {
        for (int i = 0; i < n.size(); i++) 
            votos[i] = n.get(i);
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
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String[] getVotos() {
        return votos;
    }

    public void setVotos(String[] votos) {
        Ranque.votos = votos;
    }
    public int[] getContVotos() {
        return contVotos;
    }
    
    public void setContVotos(int[] contVotos) {
        Ranque.contVotos = contVotos;
    }
    public String getTituloaux() {
        return tituloaux;
    }

    public void setTituloaux(String tituloaux) {
        Ranque.tituloaux = tituloaux;
    }
}