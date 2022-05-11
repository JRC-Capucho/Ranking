package model;

import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;


public class Ranque {


    private static ArrayList<String> ranqueamento = new ArrayList<>();
    private static ArrayList<Integer> id = new ArrayList();
    private int[] contagemDeVotos;
    private String[] votos;

    public Ranque(){}

    
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
    public void msgConfirmarExclusao()
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
            System.out.println("Excluido com sucesso!!");
        }
        else
        {
            System.out.println("Mantém item");
        }
    }

    

    /**
     * @return int[] return the contagemDeVotos
     */
    public int[] getContagemDeVotos() {
        return contagemDeVotos;
    }

    /**
     * @param contagemDeVotos the contagemDeVotos to set
     */
    public void setContagemDeVotos(int[] contagemDeVotos) {
        this.contagemDeVotos = contagemDeVotos;
    }

    /**
     * @return String[] return the votos
     */
    public String[] getVotos() {
        return votos;
    }

    /**
     * @param votos the votos to set
     */
    public void setVotos(String[] votos) {
        this.votos = votos;
    }

}
