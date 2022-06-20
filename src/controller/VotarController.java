package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Items;
import model.Ranque;
import viewii.Perfil;
import viewii.VoteRanque;

public class VotarController implements Initializable{

    private Ranque ranque = new Ranque();
    private PerfilController perfilController = new PerfilController();
    private static Boolean jaVotou = false;

    @FXML
    private Label lbNomeRanque;

    @FXML
    private Button btEnviar;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btVotarRanque;

    @FXML
    private TableColumn<Items, String> itemCol;

    @FXML
    private TableView<Items> tbRanqueDeVotos;

    @FXML
    private TextField tfNomeRanque;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemCol.setCellValueFactory(new PropertyValueFactory<Items, String>("item"));
        

        tabelaVotos();
        nomeDoRanque();

        btEnviar.setDisable(jaVotou);

        btEnviar.setOnMouseClicked((MouseEvent e)->{
            votarNaEscolha();
        });

        btEnviar.setOnKeyPressed((KeyEvent e) ->{
            if(e.getCode() == KeyCode.ENTER)
                votarNaEscolha();
        });

        btVoltar.setOnMouseClicked((MouseEvent e)->{
            voltarPerfil();
        });

        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                voltarPerfil();
        });
        
    }

    private void tabelaVotos()
    {
        String[] aux = new String[ranque.tamanhoDoVetor()];
        for (int i = 0; i < aux.length; i++) 
            aux[i] = ranque.getVotos(i);
        

        for (int i = 0; i < ranque.tamanhoDoVetor(); i++) {

            Items ite = new Items(aux[i]);
            ObservableList<Items> lista = tbRanqueDeVotos.getItems();
            
            lista.add(ite);
            tbRanqueDeVotos.setItems(lista);
        } 
    }
    
    private void votarNaEscolha()
    {
        btEnviar.setDisable(true);
        int posicao = tbRanqueDeVotos.getSelectionModel().getSelectedIndex();
        ranque.contagemVotos(posicao);
        perfilController.setRestrigirAcesso(true);

        if (ranque.getDataDeInicio(0).equals(LocalDate.now()) && ranque.getTipoRanque()) {
            System.out.println("entrou no if");
            perfilController.setExisteRanque(false);
        }
    }

    private void nomeDoRanque()
    {
        lbNomeRanque.setText(ranque.retornaNomeDoRanque());
    }
    

    private void voltarPerfil()
    {
        Perfil perfil = new Perfil();
        fechar();
        try {
            perfil.start(new Stage());
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    private void fechar()
    {
        VoteRanque.getStage().close();
    }

}
