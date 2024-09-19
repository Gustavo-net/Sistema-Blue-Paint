package package_controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import package_model.Produto;

public class ProdutoDAO {
    public void create(Produto p) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            // Alterei o nome da tabela e dos campos para se ajustar à tabela Produto
            stmt = con.prepareStatement("INSERT INTO Produto (nome, codigo, estoque, preco, tipo_unidade, data_fabricacao, data_validade) VALUES(?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCodigo());
            stmt.setString(3, p.getEstoque());
            stmt.setString(4, p.getPreco_un());
            stmt.setString(5, p.getTipo_un());
            stmt.setString(6, p.getData_fab());
            stmt.setString(7, p.getData_val());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public ArrayList<Produto> read() {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId_produto(rs.getString(1)); 
                p.setNome(rs.getString(2));
                p.setCodigo(rs.getString(3));
                p.setEstoque(rs.getString(4));
                p.setPreco_un(rs.getString(5));
                p.setTipo_un(rs.getString(6));
                p.setData_fab(rs.getString(7));
                p.setData_val(rs.getString(8));

                produtos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

    public void update(Produto p) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Produto SET nome = ?, codigo = ?, estoque = ?, Preco_un = ?, Tipo_un = ?, data_fab = ?, Date_val = ? WHERE codigo = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCodigo());
            stmt.setString(3, p.getEstoque());
            stmt.setString(4, p.getPreco_un());
            stmt.setString(5, p.getTipo_un());
            stmt.setString(6, p.getData_fab());
            stmt.setString(7, p.getData_val());
            stmt.setString(8, p.getCodigo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public void delete(String codigo) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Produto WHERE codigo = ?");
            stmt.setString(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar! Produto não pôde ser removido.");
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Produto> search(String search) {
    	search = "%"+search+"%";
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Produto where nome like ? or codigo like ?");   
            stmt.setString(1, search);
            stmt.setString(2, search);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId_produto(rs.getString(1)); 
                p.setNome(rs.getString(2));
                p.setCodigo(rs.getString(3));
                p.setEstoque(rs.getString(4));
                p.setPreco_un(rs.getString(5));
                p.setTipo_un(rs.getString(6));
                p.setData_fab(rs.getString(7));
                p.setData_val(rs.getString(8));

                produtos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

}
