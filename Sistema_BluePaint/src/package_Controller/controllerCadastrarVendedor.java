package package_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import package_controle.VendedorDAO;
import package_model.Vendedor;

public class controllerCadastrarVendedor implements Initializable {

	@FXML
	private Button btnCadastrarVendedor;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnSalvar;

	@FXML
	private TextField txtCPF;

	@FXML
	private TextField txtDataCont;

	@FXML
	private TextField txtDataNasc;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtEndereco;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTelefone;

	@FXML
	void btnExcluir(ActionEvent event) {
		// Implementar lógica para excluir vendedor
	}

	@FXML
	void btnSalvar(ActionEvent event) {
		Vendedor vendedor = new Vendedor();
		vendedor.setNome(txtNome.getText());
		vendedor.setCPF(txtCPF.getText());
		vendedor.setDataCont(txtDataCont.getText());
		vendedor.setDataNasc(txtDataNasc.getText());
		vendedor.setEmail(txtEmail.getText());
		vendedor.setEndereço(txtEndereco.getText());
		vendedor.setTelefone(txtTelefone.getText());

		VendedorDAO vendedorDAO = new VendedorDAO();
		if (controllerVendedor.vendedorEditor == null) {
			vendedorDAO.create(vendedor);
		} else {
			vendedor.setCPF(controllerVendedor.vendedorEditor.getCPF());
			vendedorDAO.update(vendedor);
		}

		Stage stage = (Stage) btnSalvar.getScene().getWindow();
		stage.close();
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (controllerVendedor.vendedorEditor != null) {
			txtNome.setText(controllerVendedor.vendedorEditor.getNome());
			txtCPF.setText(controllerVendedor.vendedorEditor.getCPF());
			txtDataCont.setText(controllerVendedor.vendedorEditor.getDataCont());
			txtDataNasc.setText(controllerVendedor.vendedorEditor.getDataNasc());
			txtEmail.setText(controllerVendedor.vendedorEditor.getEmail());
			txtEndereco.setText(controllerVendedor.vendedorEditor.getEndereço());
			txtTelefone.setText(controllerVendedor.vendedorEditor.getTelefone());
		}
	}

	@FXML
	void btnCancelar(ActionEvent event) {
		txtNome.setText("");
		txtCPF.setText("");
		txtDataCont.setText("");
		txtDataNasc.setText("");
		txtEmail.setText("");
		txtEndereco.setText("");
		txtTelefone.setText("");
		controllerVendedor.vendedorEditor = null;

		Stage stage = (Stage) btnSalvar.getScene().getWindow();
		stage.close();
	}
	
	 @FXML
	 void btnCadastrarVendedor(ActionEvent event) {
		    Vendedor vendedor = new Vendedor();
		    VendedorDAO vendedorDAO = new VendedorDAO();

		    if (controllerVendedor.vendedorEditor == null) {
		        vendedor.setNome(txtNome.getText());
		        vendedor.setCPF(txtCPF.getText());
		        vendedor.setDataCont(txtDataCont.getText());
		        vendedor.setDataNasc(txtDataNasc.getText());
		        vendedor.setEmail(txtEmail.getText());
		        vendedor.setEndereço(txtEndereco.getText());
		        vendedor.setTelefone(txtTelefone.getText());

		        vendedorDAO.create(vendedor);

		    } else {
		        vendedor.setNome(txtNome.getText());
		        vendedor.setCPF(controllerVendedor.vendedorEditor.getCPF()); 
		        vendedor.setDataCont(txtDataCont.getText());
		        vendedor.setDataNasc(txtDataNasc.getText());
		        vendedor.setEmail(txtEmail.getText());
		        vendedor.setEndereço(txtEndereco.getText());
		        vendedor.setTelefone(txtTelefone.getText());

		        vendedorDAO.update(vendedor);
		    }

		    Stage stage = (Stage) btnCadastrarVendedor.getScene().getWindow();
		    stage.close();
		}
}
