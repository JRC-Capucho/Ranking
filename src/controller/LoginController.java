package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import viewii.Cadastrar;
import viewii.Login;
import viewii.Perfil;

public class LoginController {
    ArqUsuario arqUsuario = new ArqUsuario();

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btEntrar;

    @FXML
    private Button btSair;

    @FXML
    private PasswordField pfSenha;

    @FXML
    private TextField tfEmail;

    public void initialize()
    {
        
        btEntrar.setOnMouseClicked((MouseEvent e)->{
            validarLogin();
        });

        btEntrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                validarLogin();
            }

        });

        tfEmail.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER)
                validarLogin();
        });

        pfSenha.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                validarLogin();
        });

        
        btSair.setOnMouseClicked((MouseEvent e)->{
            fechar();
        });
        
        btSair.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                fechar();
        });
    
        btCadastrar.setOnMouseClicked((MouseEvent e)->{
            System.out.println("Proxima tela");
            abreCadastrar();
        });
        btCadastrar.setOnKeyPressed((KeyEvent e)->{
            abreCadastrar();
        });
    

    }

    public void fechar()
    {
        Login.getStage().close();
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

    public void validarLogin()
    {
        String dir = "usuario.txt";
        String info = arqUsuario.read(dir);
        String email = info.split(";")[2];
        String senha = info.split(";")[3];
        
        if(tfEmail.getText().equals(email) && pfSenha.getText().equals(senha)){
            chamarPerfil();            
        }
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText("Erro ao realizar tarefa!");
            alert.setContentText("Email ou senha invalida!");
            alert.show();
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
}
