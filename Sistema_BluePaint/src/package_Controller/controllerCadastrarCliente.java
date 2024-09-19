package package_Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import package_controle.ClienteDAO;
import package_model.Cliente;

public class controllerCadastrarCliente implements Initializable {

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnEditar;

    @FXML
    private TextField txtCPF;

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
    private TextField txtTipo;

    @FXML
    void btnExcluir(ActionEvent event) {
        if (controllerCliente.clienteEditor != null) {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.delete(controllerCliente.clienteEditor.getCPF_CNPJ());

            Stage stage = (Stage) btnExcluir.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void btnSalvar(ActionEvent event) {
        Cliente cliente = new Cliente();
        cliente.setNome(txtNome.getText());
        cliente.setCPF_CNPJ(txtCPF.getText());
        cliente.setDataNasc(txtDataNasc.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setEndereço(txtEndereco.getText());
        cliente.setTelefone(txtTelefone.getText());
        cliente.setTipojurd(txtTipo.getText());

        ClienteDAO clienteDAO = new ClienteDAO();
        if (controllerCliente.clienteEditor == null) {
            clienteDAO.create(cliente);
        } else {
            cliente.setCPF_CNPJ(controllerCliente.clienteEditor.getCPF_CNPJ());
            clienteDAO.update(cliente);
        }

        Stage stage = (Stage) btnSalvar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnCancelar(ActionEvent event) {
        txtNome.setText("");
        txtCPF.setText("");
        txtDataNasc.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtTipo.setText("");
        controllerCliente.clienteEditor = null;

        Stage stage = (Stage) btnSalvar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnEditarCliente(ActionEvent event) {
    	
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if (controllerCliente.clienteEditor != null) {
            txtNome.setText(controllerCliente.clienteEditor.getNome());
            txtCPF.setText(controllerCliente.clienteEditor.getCPF_CNPJ());
            txtDataNasc.setText(controllerCliente.clienteEditor.getDataNasc());
            txtEmail.setText(controllerCliente.clienteEditor.getEmail());
            txtEndereco.setText(controllerCliente.clienteEditor.getEndereço());
            txtTelefone.setText(controllerCliente.clienteEditor.getTelefone());
            txtTipo.setText(controllerCliente.clienteEditor.getTipojurd());
        }
    }
}
