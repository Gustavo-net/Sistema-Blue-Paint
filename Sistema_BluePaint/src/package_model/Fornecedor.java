package package_model;

public class Fornecedor {
	private String idFornecedor;
	private String Nome;
	private String CNPJ;
	private String Email;
	private String Telefone;
	private String Endereço;
	
	
	
	public Fornecedor() {
		super();
	}
	public Fornecedor(String idFornecedor, String nome, String cNPJ, String email, String telefone, String endereço) {
		super();
		this.idFornecedor = idFornecedor;
		Nome = nome;
		CNPJ = cNPJ;
		Email = email;
		Telefone = telefone;
		Endereço = endereço;
	}
	public String getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(String idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getEndereço() {
		return Endereço;
	}
	public void setEndereço(String endereço) {
		Endereço = endereço;
	}
	
	
	

}
