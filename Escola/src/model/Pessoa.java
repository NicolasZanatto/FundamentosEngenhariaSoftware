package model;

public class Pessoa {
	private int idpessoa;
	private String nome;
	private String cpf;
	private int tipousuario;
	
	public int getTipousuario() {
		return tipousuario;
	}
	public void setTipousuario(int tipousuario) {
		this.tipousuario = tipousuario;
	}
	public int getIdpessoa() {
		return idpessoa;
	}
	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public boolean ehDirecao() {
		if(this.tipousuario == 1)
			return true;
		
		return false;
	}
	public boolean ehProfessor() {
		if(this.tipousuario == 2)
			return true;
		
		return false;
	}
	public boolean ehAluno() {
		if(this.tipousuario == 3)
			return true;
		
		return false;
	}
	public boolean ehResponsavel() {
		if(this.tipousuario == 4)
			return true;
		
		return false;
	}
	
}
