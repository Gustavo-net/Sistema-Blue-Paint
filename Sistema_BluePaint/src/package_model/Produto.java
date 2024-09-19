package package_model;

public class Produto {
	private String id_produto;
	private String nome;
	private String codigo;
	private String estoque;
	private String Preco_un;
	private String data_fab;
	private String data_val;
	private String Tipo_un;
	
	public Produto() {
		super();
	}

	

	public Produto(String id_produto, String nome, String codigo, String estoque, String preco_un, String data_fab,
			String data_val, String tipo_un) {
		super();
		this.id_produto = id_produto;
		this.nome = nome;
		this.codigo = codigo;
		this.estoque = estoque;
		Preco_un = preco_un;
		this.data_fab = data_fab;
		this.data_val = data_val;
		Tipo_un = tipo_un;
	}



	public String getId_produto() {
		return id_produto;
	}



	public void setId_produto(String id_produto) {
		this.id_produto = id_produto;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getEstoque() {
		return estoque;
	}



	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}



	public String getPreco_un() {
		return Preco_un;
	}



	public void setPreco_un(String preco_un) {
		Preco_un = preco_un;
	}



	public String getData_fab() {
		return data_fab;
	}



	public void setData_fab(String data_fab) {
		this.data_fab = data_fab;
	}



	public String getData_val() {
		return data_val;
	}



	public void setData_val(String data_val) {
		this.data_val = data_val;
	}



	public String getTipo_un() {
		return Tipo_un;
	}



	public void setTipo_un(String tipo_un) {
		Tipo_un = tipo_un;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}



	
}
