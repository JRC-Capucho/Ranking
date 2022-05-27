package controller;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    Ranque ranque = new Ranque();

    @FXML
    private Button btEnviar;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btVoltar1;

    @FXML
    private TableColumn<Items, String> itemCol;

    @FXML
    private TableColumn<Items, Integer> itemColocacaoCol;

    @FXML
    private TableView<Items> tbRanqueDeVotos;

    @FXML
    private TableView<Items> tbRanqueResultado;

    @FXML
    private TextField tfNomeRanque;

    @FXML
    private TextField tfNomeRanqueResultado;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemCol.setCellValueFactory(new PropertyValueFactory<Items, String>("item"));
        itemColocacaoCol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("posicaoItem"));
        
        tfNomeRanque.setText(ranque.getTituloaux());

        tabelaVotos();

        btEnviar.setOnMouseClicked((MouseEvent e)->{
            votarNaEscolha();
        });

        btVoltar.setOnMouseClicked((MouseEvent e)->{
            voltarPerfil();
        });

        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                voltarPerfil();
        });

        btVoltar1.setOnMouseClicked((MouseEvent e)->{
            voltarPerfil();
        });

        btVoltar1.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                voltarPerfil();
        });
        
    }

    private void tabelaVotos()
    {
        String[] aux = ranque.getVotos();
        for (int i = 0; i < aux.length; i++) {
           
            Items ite = new Items(aux[i]);
            ObservableList<Items> lista = tbRanqueDeVotos.getItems();
            
            lista.add(ite);
            tbRanqueDeVotos.setItems(lista);
        } 
    }
    
    private void votarNaEscolha()
    {
        int posicao = tbRanqueDeVotos.getSelectionModel().getSelectedIndex();
        ranque.contagemVotos(posicao);
        maisvotado();
    }

    private void maisvotado()
    {
        int[] aux = ranque.getContVotos();
        Arrays.sort(aux);
        for (int i = 0; i < aux.length; i++) 
        {
            Items ite = new Items(aux[i]);
            ObservableList<Items> lista = tbRanqueResultado.getItems();
            
            lista.add(ite);
            tbRanqueResultado.setItems(lista);
        }
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
