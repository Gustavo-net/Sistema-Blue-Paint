package package_Controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class controllerMain {

    @FXML
    private ImageView btnButton;

    @FXML
    private Button btnTelaCliente;

    @FXML
    private Button btnTelaFornecedor;

    @FXML
    private Button btnTelaLogout;

    @FXML
    private Button btnTelaProduto;

    @FXML
    private Button btnTelaRegistrar;

    @FXML
    private Button btnTelaRelatorio;

    @FXML
    private Button btnTelaVendedor;

	@FXML
	void btnButtonTeste(ActionEvent event) {

		Main.changeScreen("login");

	}

    @FXML
    void telaRegistrar(ActionEvent event) throws IOException {
		Main.telaCadastrarVenda();
	}

	@FXML
	void telaVendedor(ActionEvent event) {
		Main.changeScreen("vendedor");
	}

	@FXML
	void telaCliente(ActionEvent event) {
		Main.changeScreen("Cliente");
	}

	@FXML
	void telaFornecedor(ActionEvent event) {
		Main.changeScreen("Fornecedor");
	}

	@FXML
	void telaProduto(ActionEvent event) {
		Main.changeScreen("Produto");
	}

	@FXML
	void telaRelatorio(ActionEvent event) {
		Main.changeScreen("Relatorio");
	}

	@FXML
	void telaLogout(ActionEvent event) {
		Main.changeScreen("login");
	}
	
	
	

}
