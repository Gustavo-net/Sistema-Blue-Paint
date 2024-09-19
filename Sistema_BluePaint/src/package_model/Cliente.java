package package_model;

public class Cliente {
	
	private String id_cliente;
	private String nome;
	private String CPF_CNPJ;
	private String Email;
	private String Telefone;
	private String DataNasc;
	private String DataPrimCom;
	private String Endereço;
	private String Tipojurd;
	
	
	
	
	public Cliente() {
		super();
	}


	public Cliente(String id_cliente, String nome, String cPF_CNPJ, String email, String telefone, String dataNasc,
			String dataPrimCom, String endereço, String tipojurd) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		CPF_CNPJ = cPF_CNPJ;
		Email = email;
		Telefone = telefone;
		DataNasc = dataNasc;
		DataPrimCom = dataPrimCom;
		Endereço = endereço;
		Tipojurd = tipojurd;
	}


	public String getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCPF_CNPJ() {
		return CPF_CNPJ;
	}


	public void setCPF_CNPJ(String cPF_CNPJ) {
		CPF_CNPJ = cPF_CNPJ;
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


	public String getDataNasc() {
		return DataNasc;
	}


	public void setDataNasc(String dataNasc) {
		DataNasc = dataNasc;
	}


	public String getDataPrimCom() {
		return DataPrimCom;
	}


	public void setDataPrimCom(String dataPrimCom) {
		DataPrimCom = dataPrimCom;
	}


	public String getEndereço() {
		return Endereço;
	}


	public void setEndereço(String endereço) {
		Endereço = endereço;
	}


	public String getTipojurd() {
		return Tipojurd;
	}


	public void setTipojurd(String tipojurd) {
		Tipojurd = tipojurd;
	}
	
	

}
