package package_controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import package_model.Vendedor;

public class VendedorDAO {

    public void create(Vendedor v) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Vendedor (Nome, CPF, Email, Telefone, DataNasc, DataCont, Total_Vendas, Endereço) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, v.getId_Vendedor());
            stmt.setString(2, v.getNome());
            stmt.setString(3, v.getCPF());
            stmt.setString(4, v.getEmail());
            stmt.setString(5, v.getTelefone());
            stmt.setString(6, v.getDataNasc());
            stmt.setString(7, v.getDataCont());
            stmt.setString(8, v.getTotal_Vend());
            stmt.setString(9, v.getEndereço());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public ArrayList<Vendedor> read() {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Vendedor> vendedores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Vendedor");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setId_Vendedor(rs.getString(1));
                v.setNome(rs.getString(2));
                v.setCPF(rs.getString(3));
                v.setEmail(rs.getString(4));
                v.setTelefone(rs.getString(5));
                v.setDataNasc(rs.getString(6));
                v.setDataCont(rs.getString(7));
                v.setTotal_Vend(rs.getString(8));
                v.setEndereço(rs.getString(9));

                vendedores.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return vendedores;
    }

    public void update(Vendedor v) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
        	 stmt = con.prepareStatement("UPDATE Vendedor SET nome = ?, email = ?, telefone = ?, data_nasc = ?, data_prim_compra = ?, endereco = ?, tipo_juridico = ? WHERE cpf_cnpj = ?");
             stmt.setString(1, v.getNome());
             stmt.setString(2, v.getEmail());
             stmt.setString(3, v.getTelefone());
             stmt.setString(4, v.getDataNasc());
             stmt.setString(5, v.getDataCont());
             stmt.setString(6, v.getTotal_Vend());  
             stmt.setString(7, v.getEndereço());
             stmt.setString(8, v.getCPF());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public void delete(String cpfCnpj) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Vendedor WHERE cpf_cnpj = ?");
            stmt.setString(1, cpfCnpj);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar! Vendedor não pôde ser removido.");
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }
    
    public Vendedor autenticarUser(String user, String password) {
    	Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vendedor vendedor = null;

        try {
            String sql = "SELECT * FROM Vendedor WHERE Password = ? AND (CPF = ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, password);
            stmt.setString(2, user);

            rs = stmt.executeQuery();

            if (rs.next()) {
                vendedor = new Vendedor();
                vendedor.setId_Vendedor(rs.getString(1));
                vendedor.setNome(rs.getString(2));
                vendedor.setCPF(rs.getString(3));
                vendedor.setEmail(rs.getString(4));
                vendedor.setTelefone(rs.getString(5));
                vendedor.setDataNasc(rs.getString(6));
                vendedor.setDataCont(rs.getString(7));
                vendedor.setTotal_Vend(rs.getString(8));
                vendedor.setEndereço(rs.getString(9));
                vendedor.setPassword(rs.getString(10));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

          return vendedor;
    	
    	
    }
    
    public ArrayList<Vendedor> search(String search) {
    	search = "%"+search+"%";
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Vendedor> vendedores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Vendedor where Nome like ? or CPF like ?");
            stmt.setString(1, search);
            stmt.setString(2, search);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setId_Vendedor(rs.getString(1));
                v.setNome(rs.getString(2));
                v.setCPF(rs.getString(3));
                v.setEmail(rs.getString(4));
                v.setTelefone(rs.getString(5));
                v.setDataNasc(rs.getString(6));
                v.setDataCont(rs.getString(7));
                v.setTotal_Vend(rs.getString(8));
                v.setEndereço(rs.getString(9));

                vendedores.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return vendedores;
    }
}
