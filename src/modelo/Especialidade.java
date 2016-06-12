package modelo;

public class Especialidade {
	private String nome;
	private String codigoID;
	
	public Especialidade(){}

	public Especialidade(String nome, String codigoID) {
		this.nome = nome;
		this.codigoID = codigoID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoID() {
		return codigoID;
	}

	public void setCodigoID(String codigoID) {
		this.codigoID = codigoID;
	}

}
