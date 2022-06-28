package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Items;
import model.Ranque;
import model.Usuario;
import viewii.Perfil;
import viewii.RanquesResultados;
import viewii.VotarResultado;
import viewii.VoteRanque;

public class RanquesResultadosController implements Initializable{

    private Ranque ranque = new Ranque();
    private Usuario user = new Usuario();
    private RanquesController ranquesController = new RanquesController();
    private int id = user.getIdUser();
    private int idRanque;

    @FXML
    private Label ranquesResultados;

    @FXML
    private Button btAcessar;

    @FXML
    private Button btVoltar;

    @FXML
    private TableView<Items> tbRanquesResultados;

    @FXML
    private TableColumn<Items, String> tcItems;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcItems.setCellValueFactory(new PropertyValueFactory<Items, String>("item"));

        tabelaVotos();

        btAcessar.setOnMouseClicked((MouseEvent e) -> {
            votarNoRanque();
        });

        btAcessar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER)
                votarNoRanque();
        });

        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            chamarPerfil();
        });

        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER)
                chamarPerfil();
        });
    }

    private void votarNoRanque() {
        idRanque = tbRanquesResultados.getSelectionModel().getSelectedIndex();
        chamarVotarResultado();
    }


    private void chamarVotarResultado() {
        VotarResultado vr = new VotarResultado();
        fechar();
        try {
            vr.start(new Stage());
        } catch (Exception e) {
        }
    }

    private void tabelaVotos() {

        for (int i = 0; i < ranque.tamanhoDoVetorTitulo(id); i++) {
            Items ite = new Items(ranque.retornaNomeDoRanque(id, i));
            ObservableList<Items> lista = tbRanquesResultados.getItems();

            lista.add(ite);
            tbRanquesResultados.setItems(lista);
        }
    }

 private void chamarPerfil() {
        Perfil perfil = new Perfil();
        fechar();
        try {
            perfil.start(new Stage());
        } catch (Exception e) {
        }
    }

    private void fechar() {
        RanquesResultados.getStage().close();
    }

}
