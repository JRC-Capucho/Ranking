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

public class PerfilController {
    
    private String nomeNoPerfil;
    @FXML
    private Button btNovo;

    @FXML
    private Button btSair;

    @FXML
    private Label lbUserName;

    public void setUsername(String n)
    {
      nomeNoPerfil = n;  
<<<<<<< HEAD
=======
        System.out.println(nomeNoPerfil);
>>>>>>> 16178e907e9c78636e0bd60a46e5f9120e6fc09e
    }

     public void initialize()
    {
<<<<<<< HEAD
=======
        lbUserName.setText(" " + nomeNoPerfil);
>>>>>>> 16178e907e9c78636e0bd60a46e5f9120e6fc09e

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


}
