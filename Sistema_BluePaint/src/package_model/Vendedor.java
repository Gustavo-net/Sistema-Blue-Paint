package package_model;

public class Vendedor {
	private String Id_Vendedor;
	private String Nome;
	private String CPF;
	private String email;
	private String Telefone;
	private String DataNasc;
	private String DataCont;
	private String Total_Vend;
	private String Endereço;
	private String Password;
	
	
	
	public Vendedor() {
		super();
	}

	public Vendedor(String id_Vendedor, String nome, String cPF, String email, String telefone, String dataNasc,
			String dataCont, String total_Vend, String endereço, String password) {
		super();
		Id_Vendedor = id_Vendedor;
		Nome = nome;
		CPF = cPF;
		this.email = email;
		Telefone = telefone;
		DataNasc = dataNasc;
		DataCont = dataCont;
		Total_Vend = total_Vend;
		Endereço = endereço;
		Password = password;
	}

	public String getId_Vendedor() {
		return Id_Vendedor;
	}

	public void setId_Vendedor(String id_Vendedor) {
		Id_Vendedor = id_Vendedor;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getDataCont() {
		return DataCont;
	}

	public void setDataCont(String dataCont) {
		DataCont = dataCont;
	}

	public String getTotal_Vend() {
		return Total_Vend;
	}

	public void setTotal_Vend(String total_Vend) {
		Total_Vend = total_Vend;
	}

	public String getEndereço() {
		return Endereço;
	}

	public void setEndereço(String endereço) {
		Endereço = endereço;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}


	
	

}
