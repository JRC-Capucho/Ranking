package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Usuario;
import viewii.Cadastrar;
import viewii.Login;

public class CadastrarController 
{

    Usuario user = new Usuario();

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btVoltar;

    @FXML
    private PasswordField pfConfirmarSenha;

    @FXML
    private PasswordField pfSenha;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNome;

    @FXML
    public void initialize() 
    {

        btCadastrar.setOnMouseClicked((MouseEvent e)->{
            enviarInformacoesDeCadastro();
            user.verificarSenha();
        });
        
        btCadastrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                enviarInformacoesDeCadastro();
                user.verificarSenha();
            }
        });

        btVoltar.setOnMouseClicked((MouseEvent e)->{
            voltar();
        });

        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                voltar();
            
            }
        });

        pfConfirmarSenha.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                enviarInformacoesDeCadastro();
                user.verificarSenha();
            }
        });

    }
    
    public void enviarInformacoesDeCadastro()
    {
        user.setNome(tfNome.getText());
        user.setSenha(pfSenha.getText());
        user.setConfirmarSenha(pfConfirmarSenha.getText());
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
        Cadastrar.getStage().close();
    }
}


