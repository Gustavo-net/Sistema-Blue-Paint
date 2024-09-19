package package_controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import packageConnection.ConnectionDatabase;
import package_model.Fornecedor;

public class FornecedorDAO {

    // Cria um novo registro de fornecedor
    public void create(Fornecedor fornecedor) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "INSERT INTO Fornecedor (idFornecedor, Nome, CNPJ, Email, Telefone, Endereço) VALUES(?, ?, ?, ?, ?, ?)"
            );
            stmt.setString(1, fornecedor.getIdFornecedor());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getCNPJ());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getTelefone());
            stmt.setString(6, fornecedor.getEndereço());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    // Lê todos os registros de fornecedores
    public ArrayList<Fornecedor> read() {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Fornecedor");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getString(1));
                fornecedor.setNome(rs.getString(2));
                fornecedor.setCNPJ(rs.getString(3));
                fornecedor.setEmail(rs.getString(4));
                fornecedor.setTelefone(rs.getString(5));
                fornecedor.setEndereço(rs.getString(6));

                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return fornecedores;
    }

    // Atualiza um registro existente de fornecedor
    public void update(Fornecedor fornecedor) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "UPDATE Fornecedor SET Nome = ?, CNPJ = ?, Email = ?, Telefone = ?, Endereço = ? WHERE idFornecedor = ?"
            );
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCNPJ());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getEndereço());
            stmt.setString(6, fornecedor.getIdFornecedor());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    // Deleta um registro de fornecedor
    public void delete(String idFornecedor) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Fornecedor WHERE idFornecedor = ?");
            stmt.setString(1, idFornecedor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Fornecedor> search(String search) {
    	search = "%"+search+"%";
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Fornecedor where Nome like ? or CNPJ like ?");
            stmt.setString(1, search);
            stmt.setString(2, search);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getString("id_fornecedor"));
                fornecedor.setNome(rs.getString("Nome"));
                fornecedor.setCNPJ(rs.getString("CNPJ"));
                fornecedor.setEmail(rs.getString("Email"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedor.setEndereço(rs.getString("Endereço"));

                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return fornecedores;
    }
    
    public ObservableList<String> readnome() {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObservableList<String> fornecedor = FXCollections.observableArrayList();

        try {
            stmt = con.prepareStatement("SELECT Nome FROM Fornecedor");
            rs = stmt.executeQuery();

            while (rs.next()){
            		String f = rs.getString(1);
            		fornecedor.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return fornecedor;
    }
}
