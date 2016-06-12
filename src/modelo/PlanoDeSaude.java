package modelo;

public class PlanoDeSaude {
	private String razaoSocial;
	private String CNPJ;
	private String endereco;
	private String telefone;
	
	public PlanoDeSaude(){}

	public PlanoDeSaude(String razaoSocial, String cNPJ, String endereco, String telefone) {
		this.razaoSocial = razaoSocial;
		CNPJ = cNPJ;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
