package package_controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import package_model.Compra;

public class CompraDAO {

    public void create(Compra compra) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "INSERT INTO Compra (IdCliente, idVendedor, IdProduto, quantidade, Preço_Total) VALUES(?, ?, ?, ?, ?)"
            );
            stmt.setString(1, compra.getIdCliente());
            stmt.setString(2, compra.getIdVendedor());
            stmt.setString(3, compra.getIdProduto());
            stmt.setString(4, compra.getQuantidade());
            stmt.setString(5, compra.getPreço_Total());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public ArrayList<Compra> read() {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Compra> compras = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select cp.Id_Compra AS id_compra, v.Nome AS vendedor_nome, cl.Nome AS cliente_nome, p.Nome AS produto_nome, cp.Quantidade, cp.Preço_Total FROM Compra cp INNER JOIN Cliente cl ON cl.Id_cliente = cp.Id_Cliente INNER JOIN Produto p ON cp.Id_produto = p.Id_produto INNER JOIN Vendedor v ON cp.Id_Vendedor = v.Id_vendedor");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getString(1));
                compra.setIdCliente(rs.getString(2));
                compra.setIdVendedor(rs.getString(3));
                compra.setIdProduto(rs.getString(4));
                compra.setQuantidade(rs.getString(5));
                compra.setPreço_Total(rs.getString(6));

                compras.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return compras;
    }

    public void update(Compra compra) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "UPDATE Compra SET IdCliente = ?, idVendedor = ?, IdProduto = ?, quantidade = ?, Preço_Total = ? WHERE IdCliente = ? AND IdProduto = ?"
            );
            stmt.setString(1, compra.getIdCliente());
            stmt.setString(2, compra.getIdVendedor());
            stmt.setString(3, compra.getIdProduto());
            stmt.setString(4, compra.getQuantidade());
            stmt.setString(5, compra.getPreço_Total());
            stmt.setString(6, compra.getIdCliente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public void delete(String idCliente, String idProduto) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Compra WHERE IdCliente = ? AND IdProduto = ?");
            stmt.setString(1, idCliente);
            stmt.setString(2, idProduto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }
}
