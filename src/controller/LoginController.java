package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import viewii.Cadastrar;
import viewii.Login;
import viewii.Perfil;
import model.Usuario;

public class LoginController {
    Usuario user = new Usuario();

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btEntrar;

    @FXML
    private Button btSair;

    @FXML
    private PasswordField pfSenha;

    @FXML
    private TextField tfUserName;

    public void initialize()
    {
        
        btEntrar.setOnMouseClicked((MouseEvent e)->{

            if(user.validarLogin(tfUserName.getText(),pfSenha.getText()))
            {
                chamarPerfil();
            }
            else
            {
                user.msgLoginErro();
            }
        });

        btEntrar.setOnKeyPressed((KeyEvent e)->{
            
            if(e.getCode() == KeyCode.ENTER)
            {
                if(user.validarLogin(tfUserName.getText(),pfSenha.getText()))
                {
                    chamarPerfil();
                }
                else
                    user.msgLoginErro();

            }

        });

        tfUserName.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER)
            {

                if(user.validarLogin(tfUserName.getText(),pfSenha.getText()))
                    chamarPerfil();
                else
                    user.msgLoginErro();
            }
        });

        pfSenha.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
            {
                
                if(user.validarLogin(tfUserName.getText(),pfSenha.getText()))
                    chamarPerfil();
                else
                    user.msgLoginErro();
            }
        });

        
        btSair.setOnMouseClicked((MouseEvent e)->{
            fechar();
        });
        
        btSair.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                fechar();
        });
    
        btCadastrar.setOnMouseClicked((MouseEvent e)->{
            abreCadastrar();
        });
        btCadastrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                abreCadastrar();
        });
    

    }

    public void abreCadastrar()
    {
        Cadastrar cadastrar = new Cadastrar();
        fechar();

        try {
            cadastrar.start(new Stage());
        } catch (Exception e) {
        }
    }

    public void chamarPerfil()
    {
           Perfil perfil = new Perfil();
            fechar();
            try {
                perfil.start(new Stage());
            } catch (Exception e) {
            }
    }
    
    public void fechar()
    {
        Login.getStage().close();
    }

}
