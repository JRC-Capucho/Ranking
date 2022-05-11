package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import viewii.Login;
import viewii.Perfil;
import viewii.Ranking;

public class PerfilController {

    @FXML
    private Button btCriarRank;

    @FXML
    private Button btSair;

    @FXML
    private Button btVotarRanking;

    @FXML
    private Label lbUserName;

    private String nomeNoPerfil;

    public void setUsername(String n)
    {
        nomeNoPerfil = n;  
        System.out.println(nomeNoPerfil);
    }

    public void initialize()
    {
        lbUserName.setText("Johnny");

        btSair.setOnMouseClicked((MouseEvent e)->{
            voltar();
        });
        
        btSair.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER)
                voltar();
        });
    }

    // Voltar para a tela de login
    public void voltar()
    {
        Login login = new Login();
        fechar();
        try {
            login.start(new Stage());
        } catch (Exception e) {
        }
    }

    // Fechar a tela
    public void fechar()
    {
        Perfil.getStage().close();
    }

    public void chamarRank()
    {
        Ranking ranking = new Ranking();
        fechar();
        try {
            ranking.start(new Stage());
        } catch (Exception e) {
        }
    }


}
