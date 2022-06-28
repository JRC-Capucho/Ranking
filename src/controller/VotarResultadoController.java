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
import viewii.VotarResultado;


public class VotarResultadoController implements Initializable{

    private Ranque ranque = new Ranque();
    private Usuario user = new Usuario();
    private RanquesController ranquesController = new RanquesController();
    private int id = user.getIdUser();
    private int idRanque = ranquesController.getIdRanque();

    @FXML
    private Button btVoltar1;

    @FXML
    private TableColumn<Items, Integer> itemColocacaoCol;

    @FXML
    private TableColumn<Items, String> itemMelhorRanqueadoCol;

    @FXML
    private Label lbNomeRanqueResultado;

    @FXML
    private TableView<Items> tbRanqueResultado;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemColocacaoCol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("posicaoItem"));
        itemMelhorRanqueadoCol.setCellValueFactory(new PropertyValueFactory<Items, String>("item"));

        nomeDoRanque();
        ordemVotos();

        btVoltar1.setOnMouseClicked((MouseEvent e)->{
            chamarPerfil();
        });

        btVoltar1.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                chamarPerfil();
        });
    }

    private void ordemVotos()
    {
        int[] aux = new int[ranque.tamanhoDoVetor(id, idRanque)];
        int[] ranqueamento = new int[ranque.tamanhoDoVetor(id, idRanque)];
        int maiorPosicao = 0;

        for (int i = 0; i < aux.length; i++) 
            aux[i] = ranque.getContVotos(id,idRanque, i);
        

        for (int i = 0; i < ranqueamento.length; i++) {
            maiorPosicao = 0;

            for (int j = 0; j < ranqueamento.length; j++)
                if(aux[j] > aux[maiorPosicao])
                    maiorPosicao = j;

            ranqueamento[i] = maiorPosicao;
            aux[maiorPosicao] = -1;
        }
        
        for (int i = 0; i < ranqueamento.length; i++) {

            Items ite = new Items(ranque.getVotos(id,idRanque,ranqueamento[i]),ranque.getContVotos(id, idRanque, ranqueamento[i]));
            ObservableList<Items> lista = tbRanqueResultado.getItems();

            lista.add(ite);
            tbRanqueResultado.setItems(lista);
        }
    }

    private void nomeDoRanque()
    {
        lbNomeRanqueResultado.setText(ranque.retornaNomeDoRanque(id,idRanque));
    }

    private void chamarPerfil()
    {
            Perfil perfil = new Perfil();
            fechar();
            try {
                perfil.start(new Stage());
            } catch (Exception e) {
            }
    }

    private void fechar()
    {
        VotarResultado.getStage().close();
    }

    public int getIdRanque() {
        return idRanque;
    }

    public void setIdRanque(int idRanque) {
        this.idRanque = idRanque;
    }
}
