package package_Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import package_controle.FornecedorDAO;
import package_controle.ProdutoDAO;
import package_model.Produto;

public class controllerCadastrarProduto implements Initializable {

	@FXML
	private Button btnCadastrarProduto;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnSalvar;

	@FXML
	private TextField txtCodigo;

	@FXML
	private TextField txtDataFab;

	@FXML
	private TextField txtDataVal;

	@FXML
	private TextField txtEstoque;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtPreco;

	@FXML
	private TextField txtTipo;

	@FXML
	private ChoiceBox<String> txtFornecedorList;

	@FXML
	void btnExcluir(ActionEvent event) {

	}

	@FXML
	void txtFornecedor(MouseEvent event) {

	}

	@FXML
	void btnSalvar(ActionEvent event) {
		Produto produto = new Produto();
		produto.setNome(txtNome.getText());
		produto.setCodigo(txtCodigo.getText());
		produto.setTipo_un(txtTipo.getText());
		produto.setData_fab(txtDataFab.getText());
		produto.setData_val(txtDataVal.getText());
		produto.setPreco_un(txtPreco.getText());
		ProdutoDAO prod = new ProdutoDAO();
		prod.create(produto);

		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		FornecedorDAO fornecedor = new FornecedorDAO();

		txtFornecedorList.setItems(fornecedor.readnome());
		// TODO Auto-generated method stub
		if (controllerProduto.produtoEditor != null) {
			txtNome.setText(controllerProduto.produtoEditor.getNome());
			txtCodigo.setText(controllerProduto.produtoEditor.getCodigo());
			txtDataVal.setText(controllerProduto.produtoEditor.getData_val());
			txtDataFab.setText(controllerProduto.produtoEditor.getData_val());
			txtEstoque.setText(controllerProduto.produtoEditor.getEstoque());
			txtPreco.setText(controllerProduto.produtoEditor.getPreco_un());
			txtTipo.setText(controllerProduto.produtoEditor.getTipo_un());

		}
	}

	@FXML
	void btnCancelar(ActionEvent event) {
		txtNome.setText("");
		txtCodigo.setText("");
		txtDataFab.setText("");
		txtDataVal.setText("");
		txtEstoque.setText("");
		txtPreco.setText("");
		controllerProduto.produtoEditor = null;

		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();

	}

	@FXML
	void btnCadastrarProduto(ActionEvent event) {
		if (controllerProduto.produtoEditor == null) {
			Produto produto = new Produto();
			produto.setNome(txtNome.getText());
			produto.setCodigo(txtCodigo.getText());
			produto.setTipo_un(txtTipo.getText());
			produto.setData_fab(txtDataVal.getText());
			produto.setData_val(txtDataVal.getText());
			produto.setPreco_un(txtPreco.getText());
			produto.setEstoque(txtEstoque.getText());
			ProdutoDAO prod = new ProdutoDAO();

			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		} else {
			Produto produto = new Produto();
			produto.setNome(txtNome.getText());
			produto.setCodigo(txtCodigo.getText());
			produto.setTipo_un(txtTipo.getText());
			produto.setData_fab(txtDataFab.getText());
			produto.setData_fab(txtDataFab.getText());
			produto.setPreco_un(txtPreco.getText());
			produto.setEstoque(txtEstoque.getText());
			ProdutoDAO prod = new ProdutoDAO();
			prod.update(produto);

			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		}

	}
}
