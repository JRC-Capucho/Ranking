package controller;

import java.net.URL;
import java.util.ArrayList;
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
import model.Usuario;
import viewii.CriarRanqueamento;
import viewii.Login;
import viewii.Perfil;
import viewii.Ranques;
import viewii.RanquesResultados;
import viewii.VotarResultado;
import viewii.VoteRanque;

public class PerfilController implements Initializable{

    private static Boolean restrigirAcesso = true;

    private static Boolean existeRanque = true;
    private static Button botao;

    private Usuario user = new Usuario();

    @FXML
    private Button btResultadoRanqueado;

    @FXML
    private Button btCriarRanque;

    @FXML
    private Button btLogout;

    @FXML
    private Button btVotarRanque;

    @FXML
    private TextField tfBuscar;

    @FXML
    private TableView<Items> tbBuscarUsuario;

    @FXML
    private TableView<Items> tbAmigosUsuario;

    @FXML
    private TableColumn<Items, Button> tcBotao;

    @FXML
    private TableColumn<Items, String> tcUsuario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tcUsuario.setCellValueFactory(new PropertyValueFactory<Items, String>("item"));
        tcBotao.setCellValueFactory(new PropertyValueFactory<Items, Button>("botao"));

        btResultadoRanqueado.setDisable(existeRanque);

        btResultadoRanqueado.setOnMouseClicked((MouseEvent e)->{
            chamarResultado();
        });

        
        btCriarRanque.setOnMouseClicked((MouseEvent e)->{
            chamarCriarRanqueamento();
        });

        btCriarRanque.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                chamarCriarRanqueamento();
        });
    
        btVotarRanque.setDisable(restrigirAcesso);

        btVotarRanque.setOnMouseClicked((MouseEvent e)->{
              chamarVotarRanque();
        });
    
        btVotarRanque.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                chamarVotarRanque();
        });

        btLogout.setOnMouseClicked((MouseEvent e)->{
            voltarLogin();
        });
        
        btLogout.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
            voltarLogin();
        });

        tfBuscar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                buscarAmigos();
        });

    }

    private void chamarCriarRanqueamento()
    {
        CriarRanqueamento criarRanqueamento = new CriarRanqueamento();
        fechar();
        try {
            criarRanqueamento.start(new Stage());
        } catch (Exception e) {
        }
    }

    private void buscarAmigos()
    {
        int i = 0;
        String amigo;
        ArrayList<String> aux = user.getApelido();

        while(aux != null)
        {
            amigo = aux.get(i);
            if(amigo.equals(tfBuscar.getText()))
            {
                Items ite = new Items(amigo,botao);
                ObservableList<Items> lista = tbBuscarUsuario.getItems();
                
                lista.add(ite);
                tbBuscarUsuario.setItems(lista);
                break;
            }
            i++;
        }
    }

    private void chamarResultado()
    {
        RanquesResultados rr = new RanquesResultados();
        fechar();
        try {
            rr.start(new Stage());
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    private void chamarVotarRanque()
    {
        Ranques ranques = new Ranques();
        fechar();
        try {
            ranques.start(new Stage());
        } catch (Exception e) {
        }
    }
    

    private void voltarLogin()
    {
        Login login = new Login();
        fechar();
        try {
            login.start(new Stage());
        } catch (Exception e) {
        }
    }

    private void fechar()
    {
        Perfil.getStage().close();
    }

    public void setExisteRanque(Boolean existeRanque) {
        this.existeRanque = existeRanque;
    }

    public void setRestrigirAcesso(Boolean restrigirAcesso) {
        this.restrigirAcesso = restrigirAcesso;
    }
}
