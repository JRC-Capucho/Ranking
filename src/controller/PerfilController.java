package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import viewii.CriarRanqueamento;
import viewii.Login;
import viewii.Perfil;
import viewii.VoteRanque;

public class PerfilController implements Initializable{

    @FXML
    private Button btCriarRanque;

    @FXML
    private Button btLogout;

    @FXML
    private Button btVotarRanque;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btCriarRanque.setOnMouseClicked((MouseEvent e)->{
            chamarCriarRanqueamento();
        });

        btCriarRanque.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                chamarCriarRanqueamento();
        });
    
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

    private void chamarVotarRanque()
    {
        VoteRanque voteRanque = new VoteRanque();
        fechar();
        try {
            voteRanque.start(new Stage());
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

}
