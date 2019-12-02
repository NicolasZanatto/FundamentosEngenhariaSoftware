package model;

public class Presenca {
	private int idpresenca;
	private int idaluno;
	private int iddisciplina;
	private int faltas;
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	private Aluno aluno;
	private Disciplina disciplina;
	
	public int getIdpresenca() {
		return idpresenca;
	}
	public void setIdpresenca(int idpresenca) {
		this.idpresenca = idpresenca;
	}
	public int getIdaluno() {
		return idaluno;
	}
	public void setIdaluno(int idaluno) {
		this.idaluno = idaluno;
	}
	public int getIddisciplina() {
		return iddisciplina;
	}
	public void setIddisciplina(int iddisciplina) {
		this.iddisciplina = iddisciplina;
	}
	public float getFaltas() {
		return faltas;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	
	
}
