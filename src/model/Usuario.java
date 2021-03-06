package model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import viewii.Cadastrar;
import viewii.Login;

import java.util.ArrayList;
import java.util.Optional;

public class Usuario {

    private Ranque ranque = new Ranque();

    private static ArrayList<Integer> id = new ArrayList<>();
    private static int autoEncrement = 0;
    private static int idUser;
    private static ArrayList<String> apelido = new ArrayList<>();
    private static ArrayList<String> senha = new ArrayList<>();

    public Usuario() {
    }

    public boolean validarLogin(String username, String pass) {
        for(int index = 0; index < id.size(); index++){
            if (apelido.get(index).equals(username) && senha.get(index).equals(pass)){
                idUser = index;
                ranque.setContagem(0);
                return true;
            }
        }
        msgLoginErro();
        return false;
    }

    public void verificarDados(String pass, String confPass, String username) {
        boolean aux = false;

        if (username.length() > 0 && pass.length() > 0 && confPass.length() > 0) {
            if (!confPass.equals(pass)) {
                msgErroSenhas();
                aux = true;
            } else {
                for (int index = 0; index < apelido.size(); index++) {
                    if (apelido.get(index).equals(username)) {
                        msgCadastroExistente();
                        aux = true;
                    }
                }
            }
        } else {
            msgErroVazio();
            aux = true;
        }
        if (!aux)
            cadastrar(pass, username);
    }

    public void cadastrar(String pass, String username) {
        id.add(autoEncrement);
        autoEncrement++;
        apelido.add(username);
        senha.add(pass);
        ranque.ranqueUser();
        msgSucesso();
    }

    private void chamarLogin() {
        Login login = new Login();
        try {
            login.start(new Stage());
        } catch (Exception e) {

        } finally {
            Cadastrar.getStage().close();
        }

    }

    private void msgSucesso() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Realizado com sucesso!");
        alert.setContentText("Conta criada com sucesso!");

        ButtonType botaoOk = new ButtonType("OK");
        ButtonType botaoCancel = new ButtonType("Cancelar");

        alert.getButtonTypes().setAll(botaoOk, botaoCancel);

        Optional<ButtonType> aux = alert.showAndWait();

        if (aux.get() == botaoOk)
            chamarLogin();
    }

    private void msgErroSenhas() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText("Login invalido!");
        alert.setContentText("Senhas diferentes!");
        alert.show();
    }

    private void msgLoginErro() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText("Erro ao realizar tarefa!");
        alert.setContentText("Nome de usu??rio ou senha invalidas!");
        alert.show();
    }

    private void msgCadastroExistente() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informa????o");
        alert.setHeaderText("Nome de usu??rio j?? existe");
        alert.setContentText("Esse nome de usu??rio j?? esta cadastrado");
        alert.show();
    }

    private void msgErroVazio() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Campos vazios");
        alert.setHeaderText("Nome de usu??rio e senha vazios");
        alert.setContentText("Por favor preencher os campos");
        alert.show();
    }


    public void setApelido(String apelido) {
        this.apelido.add(apelido);
    }

    public int getId(int posicao) {
        return id.get(posicao);
    }

    public String getSenha(int posicao) {
        return senha.get(posicao);
    }

    public void setSenha(String senha) {
        this.senha.add(senha);
    }

    public static ArrayList<String> getApelido() {
        return apelido;
    }

    public int getIdUser() {
        return idUser;
    }

    public  void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}