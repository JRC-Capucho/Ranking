package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import viewii.CriarRanqueamento;
import viewii.Perfil;
import model.Ranque;
import model.Items;

public class CriarRanqueamentoController
{
    Ranque ranque = new Ranque();

    @FXML
    private Button btAdicionarItem;

    @FXML
    private Button btEnviar;
    
    @FXML
    private TableView<Items> tbItensRanqueados = new TableView<>();    
    
    //@FXML
    //private TableColumn<Items, ButtonType> Botao;
    
    @FXML
    private TableColumn<Items, String> Itens;
    
    @FXML
    private Button btVoltar;
    
    @FXML
    private TextField tfNomeDoRanque;
    
    public void initialize()
    {
        oi();

        btVoltar.setOnMouseClicked((MouseEvent e)->{
            voltar();
        });    
        
        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
            voltar();
        });        
        
        btAdicionarItem.setOnMouseClicked((MouseEvent e)->{
            ranque.adicionarOpcoesDeEscolha();
            adicionarItemNaTabela();
        });    
        
        
    }    
    
    public void adicionarItemNaTabela()
    {
        String msg = "Jhon";        
        // tbItensRanqueados.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbItensRanqueados.getItems().add(new Items(msg));
        
    }
    
    
    public void voltar()
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
        CriarRanqueamento.getStage().close();
    }
    
    public void oi(){

    Itens.setCellValueFactory(new PropertyValueFactory<Items, String>("Itens"));
    tbItensRanqueados.getColumns().add(Itens);

    ObservableList<Items> list = FXCollections.observableArrayList(
        new Items("nice"),
        new Items("hello"),
        new Items("turnaround")
        );
    
        tbItensRanqueados.getItems().add(new Items("Billie Eilish"));
        tbItensRanqueados.setItems(list);
            
    }
    
}

