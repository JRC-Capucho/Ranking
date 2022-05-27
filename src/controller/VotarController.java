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

    private Ranque ranque = new Ranque();

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
    private TableColumn<Items, String> itemMelhorRanqueadoCol;

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
        itemMelhorRanqueadoCol.setCellValueFactory(new PropertyValueFactory<Items, String>("item"));
        
        tfNomeRanque.setText(ranque.retornaNomeDoRanque());
        tfNomeRanqueResultado.setText(ranque.retornaNomeDoRanque());
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
        btEnviar.setDisable(true);
        int posicao = tbRanqueDeVotos.getSelectionModel().getSelectedIndex();
        ranque.contagemVotos(posicao);
        maisvotado();
    }

    private void maisvotado()
    {
        String[] stringAux = ranque.getVotos();
        int[] aux = ranque.getContVotos();
        int[] saux = new int[aux.length];
        int[] posicaoFinal = new int[aux.length];

        for (int i = 0; i < saux.length; i++)
            saux[i] = aux[i];
            
        Arrays.sort(saux);

        int limitieDePosicaoMinima = aux.length-1;
        int novaPosicao = 0;

        for (int i = 0; i < aux.length; i++) 
        {
            if(limitieDePosicaoMinima>=0)
            {
                if(aux[i] == saux[limitieDePosicaoMinima])
                {
                    posicaoFinal[novaPosicao] = i;
                    i = -1;
                    novaPosicao++;
                    limitieDePosicaoMinima--;
                }
            }
            else
            {
                break;
            }
        }

        for (int i = 0; i < aux.length; i++) 
        {
            System.out.println(posicaoFinal[i]);
            System.out.println(stringAux[posicaoFinal[i]]);
            
            Items ite = new Items(stringAux[posicaoFinal[i]],aux[posicaoFinal[i]]);
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
