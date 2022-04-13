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
import model.Usuario;
import viewii.Cadastrar;
import viewii.Login;
import java.util.List;
import java.util.ArrayList;

public class CadastrarController {

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
    public void initialize() {

        btCadastrar.setOnMouseClicked((MouseEvent e)->{
            cadastrar();         
        });
        
        btCadastrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                cadastrar();
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
                cadastrar();
            }
        });

    }
    

    public boolean verificarSenha(){
        

        if (pfSenha.getText().equals(pfConfirmarSenha.getText())){
            user.setNome(tfNome.getText());
            user.setEmail(tfEmail.getText());
            user.setSenha(pfSenha.getText());

            return true;
        }else
            return false;
    }

    // Mensagem de sucesso ou erro. 
    public void cadastrar()
    {
        if (verificarSenha()){
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Realizado com sucesso!");
            alert.setContentText("Conta criada com sucesso!");
            alert.show();
            
    }else{
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText("Erro ao realizar tarefa");
        alert.setContentText("Senhas diferentes!");
        alert.show();
    }
    }

   /* public void adicionaUsuarios()
    {
        fazer com arrayList      
    }
*/
    // Escrever no arquivo txt

    /* public void escrever()
    {
        ArqUsuario arqUsuario = new ArqUsuario();
        String dir = "usuario.txt";
        String text = user.getId()+";"+user.getNome()+";"+user.getEmail()+";"+user.getSenha()+";";

        arqUsuario.Write(dir, text);
    }

    */

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


