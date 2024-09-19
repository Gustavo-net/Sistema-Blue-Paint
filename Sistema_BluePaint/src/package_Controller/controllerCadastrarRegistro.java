package package_Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import package_model.Produto;

public class controllerCadastrarRegistro implements Initializable {

    @FXML
    private Button btnCadastrarVendedor;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnPesquisar;

    @FXML
    private TableColumn<Produto, String> columnId;

    @FXML
    private TableColumn<Produto, String> columnNome;

    @FXML
    private TableColumn<Produto, String> columnPreço;

    @FXML
    private TableView<Produto> tabelaViewProduto;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtDataNasc;

    @FXML
    private TextField txtDesconto;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    private TextField txtNomeProduto;

    @FXML
    private TextField txtPreço;

    @FXML
    private TextField txtPreçoTotal;

    @FXML
    private TextField txtQuantidade;

    @FXML
    void btnCancelar(ActionEvent event) {

    }

    @FXML
    void btnPesquisarProduto(ActionEvent event) {

    }

    @FXML
    void btnSalvar(ActionEvent event) {

    }

    @FXML
    void definirCliente(KeyEvent event) {

    }

    @FXML
    void definirPrecoTotal(KeyEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
