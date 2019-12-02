package model;

public class Nota {
	private int idnota;
	private int idaluno;
	private int iddisciplina;
	private float nota;
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	private Aluno aluno;
	private Disciplina disciplina;
	
	public int getIdnota() {
		return idnota;
	}
	public void setIdnota(int idnota) {
		this.idnota = idnota;
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
	public float getNota() {
		return nota;
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
	public void setNota(float nota) {
		this.nota = nota;
	}
	
	
}
