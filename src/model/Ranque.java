package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;

public class Ranque {


    private static ArrayList<ArrayList<String>> tittleRank = new ArrayList<>();
    private static ArrayList<String> tituloDoRanque;
    private static ArrayList<ArrayList<Integer>> countVote = new ArrayList<>();
    private static ArrayList<Integer> contVotos;
    private static ArrayList<ArrayList<String>> vote = new ArrayList<>();
    private static ArrayList<String> votos;
    private static ArrayList<ArrayList<Boolean>> typeRank = new ArrayList<>();
    private static ArrayList<Boolean> tipoRanque;

    private static ArrayList<ArrayList<LocalDate>> dateFinish = new ArrayList<>();
    private static ArrayList<ArrayList<LocalDate>> dateBegin = new ArrayList<>();

    private static ArrayList<LocalDate> dataDeTermino;
    private static ArrayList<LocalDate> dataDeInicio;

    public Ranque() {
    }

    public void criarRanque(int id, ArrayList<String> aux) {
        for (int i = 0; i < aux.size(); i++) {
            vote.get(id).add(aux.get(i));
            countVote.get(id).add(0);
        }
    }

    public void ranqueUser() {
        vote.add(votos = new ArrayList<>());
        countVote.add(contVotos = new ArrayList<>());
        tittleRank.add(tituloDoRanque = new ArrayList<>());
        dateFinish.add(dataDeTermino = new ArrayList<>());
        dateBegin.add(dataDeInicio = new ArrayList<>());
        typeRank.add(tipoRanque = new ArrayList<>());
    }

    public void contagemVotos(int id, int posicao) {
        countVote.get(id).set(posicao, (countVote.get(id).get(posicao) + 1));
    }

    public String adicionarOpcoesDeEscolha() {
        TextInputDialog item = new TextInputDialog();
        item.setTitle("Itens");
        item.setHeaderText("Adicionar novos itens");
        item.setContentText("Digite o novo item: ");

        Optional<String> aux = item.showAndWait();

        if (aux.isPresent() && aux.get().length() > 0) {
            return aux.get();
        }
        return null;

    }

    public Boolean msgConfirmarExclusao() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Excluir");
        alert.setHeaderText("Deseja realmente excluir esse item");
        alert.setContentText("Escolha uma opção abaixo");

        ButtonType botaoSim = new ButtonType("Sim");
        ButtonType botaoNao = new ButtonType("Não");

        alert.getButtonTypes().setAll(botaoSim, botaoNao);

        Optional<ButtonType> aux = alert.showAndWait();

        if (aux.get() == botaoSim)
            return true;
        else
            return false;
    }

    public void adicionarNomeDoRanque(int i, String n) {
        tittleRank.get(i).add(n);
    }

    public String retornaNomeDoRanque(int id, int posicao) {
        return tittleRank.get(id).get(posicao);
    }

    public String getVotos(int id, int posicao) {
        return vote.get(id).get(posicao);
    }

    public int tamanhoDoVetor(int id) {
        return countVote.get(id).size();
    }

    public int getContVotos(int id, int posicao) {
        return countVote.get(id).get(posicao);
    }

    public LocalDate getDataDeTermino(int id, int posicao) {
        return dateFinish.get(id).get(posicao);
    }

    public void setDataDeTermino(int id,LocalDate dataDeTermino) {
        this.dateFinish.get(id).add(dataDeTermino);
    }

    public LocalDate getDataDeInicio(int id, int posicao) {
        return dateBegin.get(id).get(posicao);
    }

    public void setDataDeInicio(int id, LocalDate dataDeInicio) {
        this.dateBegin.get(id).add(dataDeInicio);
    }

    public Boolean getTipoRanque(int id, int posicao) {
        return typeRank.get(id).get(posicao);
    }

    public void setTipoRanque(int id, Boolean tipoRanque) {
        this.typeRank.get(id).add(tipoRanque);
    }
}
