package package_Controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class controllerCompra {

    @FXML
    private Button btbSalvar;

    @FXML
    private Text btnButon;
    
    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnPesquisar;

    @FXML
    private TextField txtCPFC;

    @FXML
    private TextField txtCPFV;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDesconto;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    private TextField txtPrecoTotal;

    @FXML
    private TextField txtPrecoUn;

    @FXML
    private TextField txtProduto;

    @FXML
    private TextField txtQuantidade;

    @FXML
    void btnButtonTeste(MouseEvent event) {

    }
    

    @FXML
    void btnVoltarRegistrar(ActionEvent event) {
    	Main.changeScreen("main");	

    }

}
