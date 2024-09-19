package package_Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import package_controle.FornecedorDAO;
import package_model.Fornecedor;

public class controllerCadastrarFornecedor implements Initializable {

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;


    private FornecedorDAO fornecedorDAO = new FornecedorDAO();

    @FXML
    void btnExcluir(ActionEvent event) {
        if (controllerFornecedor.fornecedorEditor == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Nenhum fornecedor para excluir.");
            alert.show();
            return;
        }

        Fornecedor fornecedor = controllerFornecedor.fornecedorEditor;
        fornecedorDAO.delete(fornecedor.getIdFornecedor());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Fornecedor excluído com sucesso!");
        alert.show();

        // Fechar a tela atual
        Stage stage = (Stage) btnExcluir.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnSalvar(ActionEvent event) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(txtNome.getText());
        fornecedor.setCNPJ(txtCNPJ.getText());
        fornecedor.setEmail(txtEmail.getText());
        fornecedor.setEndereço(txtEndereco.getText());
        fornecedor.setTelefone(txtTelefone.getText());

        if (controllerFornecedor.fornecedorEditor == null) {
            // Cadastro de um novo fornecedor
            fornecedorDAO.create(fornecedor);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Fornecedor cadastrado com sucesso!");
            alert.show();
        } else {
            // Edição de um fornecedor existente
            fornecedor.setIdFornecedor(controllerFornecedor.fornecedorEditor.getIdFornecedor());
            fornecedorDAO.update(fornecedor);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Fornecedor atualizado com sucesso!");
            alert.show();
        }

        // Fechar a tela atual
        Stage stage = (Stage) btnSalvar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if (controllerFornecedor.fornecedorEditor != null) {
            txtNome.setText(controllerFornecedor.fornecedorEditor.getNome());
            txtCNPJ.setText(controllerFornecedor.fornecedorEditor.getCNPJ());
            txtEmail.setText(controllerFornecedor.fornecedorEditor.getEmail());
            txtEndereco.setText(controllerFornecedor.fornecedorEditor.getEndereço());
            txtTelefone.setText(controllerFornecedor.fornecedorEditor.getTelefone());
        }
    }

    @FXML
    void btnCancelar(ActionEvent event) {
        txtNome.setText("");
        txtCNPJ.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        controllerFornecedor.fornecedorEditor = null;

        Stage stage = (Stage) btnSalvar.getScene().getWindow();
        stage.close();
    }
}
