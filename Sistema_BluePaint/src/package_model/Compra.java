package package_model;

public class Compra {
	private String IdCompra;
	private String IdCliente;
	private String idVendedor;
	private String IdProduto;
	private String quantidade;
	private String Preço_Total;
	
	
	
	public Compra() {
		super();
	}

	public Compra(String idCliente, String idVendedor, String idProduto, String quantidade, String preço_Total) {
		super();
		IdCliente = idCliente;
		this.idVendedor = idVendedor;
		IdProduto = idProduto;
		this.quantidade = quantidade;
		Preço_Total = preço_Total;
	}

	public String getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}

	public String getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(String idProduto) {
		IdProduto = idProduto;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getPreço_Total() {
		return Preço_Total;
	}

	public void setPreço_Total(String preço_Total) {
		Preço_Total = preço_Total;
	}

	public String getIdCompra() {
		return IdCompra;
	}

	public void setIdCompra(String idCompra) {
		IdCompra = idCompra;
	}

	
	
}
