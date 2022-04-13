package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import viewii.Perfil;

public class PerfilController {

    @FXML
    private ImageView Avatar;

    @FXML
    private Button btEditar;

    @FXML
    private Button btNovo;

    @FXML
    private Button btSair;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNome;

    public void initialize()
    {
        btSair.setOnMouseClicked((MouseEvent e)->{
            fechar();
        });
        
        btSair.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER)
                fechar();
        });
    }

    public void fechar()
    {
        Perfil.getStage().close();
    }
}
