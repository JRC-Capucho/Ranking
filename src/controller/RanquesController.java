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
import viewii.Ranques;
import viewii.VoteRanque;

public class RanquesController implements Initializable {

    private Ranque ranque = new Ranque();
    private Usuario user = new Usuario();
    private int id = user.getIdUser();
    private static int idRanque;


    @FXML
    private TableView<Items> tbRanques;

    @FXML
    private TableColumn<Items, String> tcItems;
    @FXML
    private Button btAcessar;

    @FXML
    private Button btVoltar;

    @FXML
    private Label lbNomeRanque;

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
        idRanque = tbRanques.getSelectionModel().getSelectedIndex();
        System.out.println(tbRanques.getSelectionModel().getSelectedIndex());
        chamarVotarRanque();
    }

    private void chamarVotarRanque() {

        VoteRanque vr = new VoteRanque();
        fechar();
        try {
            vr.start(new Stage());
        } catch (Exception e) {
        }
    }

    private void tabelaVotos() {

        for (int i = 0; i < ranque.tamanhoDoVetorTitulo(id); i++) {
            Items ite = new Items(ranque.retornaNomeDoRanque(id, i));
            ObservableList<Items> lista = tbRanques.getItems();

            lista.add(ite);
            tbRanques.setItems(lista);
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
        Ranques.getStage().close();
    }

    public int getIdRanque() {
        return idRanque;
    }

    public void setIdRanque(int idRanque) {
        this.idRanque = idRanque;
    }

}
