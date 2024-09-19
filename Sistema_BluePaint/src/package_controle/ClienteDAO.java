package package_controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import package_model.Cliente;

public class ClienteDAO {
	public void create(Cliente c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		
		try {
			stmt = con.prepareStatement("INSERT INTO Cliente VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCPF_CNPJ());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getDataNasc());
			stmt.setString(6, c.getDataPrimCom());
			stmt.setString(7, c.getEndereço());
			stmt.setString(8, c.getTipojurd());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public ArrayList<Cliente> read(){
		Connection con = ConnectionDatabase.getConnection();
	    PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> cliente = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Cliente");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId_cliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataPrimCom(rs.getString(7));
				c.setEndereço(rs.getString(8));
				c.setTipojurd(rs.getString(9));
					
				cliente.add(c);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
			
		}

		return cliente;
	}
	
	public void update(Cliente c) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		
		
		try {
			stmt = con.prepareStatement("UPDATE Cliente SET Nome = ?, CPF_CNPJ = ?, Email = ?, telefone = ?, "
					+ "data_nasc = ?, data_primcompra = ?, Endereço = ?, Tipo_Juridico = ? WHERE CPF_CNPJ ?");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCPF_CNPJ());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getDataNasc());
			stmt.setString(6, c.getDataPrimCom());
			stmt.setString(7, c.getEndereço());
			stmt.setString(8, c.getTipojurd());
			stmt.setString(9, c.getCPF_CNPJ());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public void delete(String cpf_cnpj ) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
	    try {
			stmt = con.prepareStatement("DELETE FROM Cliente WHERE CPF_CNPJ");
			stmt.setString(0, cpf_cnpj);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao apagar! Cliente possui compras registradas no sistema");
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		
	}
	
	public ArrayList<Cliente> search(String search){
    	search = "%"+search+"%";
		Connection con = ConnectionDatabase.getConnection();
	    PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> cliente = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Cliente where Nome like ? or CPF_CNPJ like ?");
		    stmt.setString(1, search);
	        stmt.setString(2, search);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId_cliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataPrimCom(rs.getString(7));
				c.setEndereço(rs.getString(8));
				c.setTipojurd(rs.getString(9));
					
				cliente.add(c);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
			
		}

		return cliente;
	}
	

}
