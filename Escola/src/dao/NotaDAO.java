package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Nota;;

public class NotaDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet rs;
	
	public NotaDAO() {
		conn = new ConnectionFactory().getConexao();
	}
	
	public void inserir(Nota nota) {
		String sql = "INSERT INTO notas(idaluno,iddisciplina,nota, descricao) VALUES (?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, nota.getIdaluno());
			stmt.setInt(2, nota.getIddisciplina());
			stmt.setFloat(3, nota.getNota());
			stmt.setString(4, nota.getDescricao());
			stmt.execute();
			stmt.close();
		}catch(Exception erro) {
			throw new RuntimeException("Erro 2: " + erro);
		}
	}
	
	public void atualizar(Nota nota) {
		String sql = "UPDATE notas SET nota = ?, idaluno = ?, iddisciplina = ?, descricao = ? WHERE idnota = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setFloat(1, nota.getNota());
			stmt.setInt(2, nota.getIdaluno());
			stmt.setInt(3, nota.getIddisciplina());
			stmt.setString(4, nota.getDescricao());
			stmt.setInt(5, nota.getIdnota());
			stmt.execute();
			stmt.close();
		}catch(Exception erro) {
			throw new RuntimeException("Erro 3: " + erro);
		}
	}
	
	public void excluir(int valor) {
		String sql = "DELETE FROM notas WHERE idnota = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valor);
			stmt.execute();
			stmt.close();
			
		}catch(Exception erro) {
			throw new RuntimeException("Erro 4: " + erro);
		}
	}
	
	public ArrayList<Nota> listarTodos(){
		String sql = "SELECT * FROM notas inner join aluno on notas.idaluno = aluno.idaluno inner join disciplina on notas.iddisciplina = disciplina.iddisciplina ";
		ArrayList<Nota> lista = new ArrayList<Nota>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Nota nota = new Nota();
				nota.setIdnota(rs.getInt("idnota"));
				nota.setIdaluno(rs.getInt("idaluno"));
				nota.setIddisciplina(rs.getInt("iddisciplina"));
				nota.setNota(rs.getFloat("nota"));
				nota.setDescricao(rs.getString("descricao"));
				AlunoDAO alunodao = new AlunoDAO();
				nota.setAluno(alunodao.buscarPorId(rs.getInt("idaluno")));
				DisciplinaDAO disciplinadao = new DisciplinaDAO();
				nota.setDisciplina(disciplinadao.buscarPorIdDisciplina(rs.getInt("iddisciplina")));
				lista.add(nota);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 5: " + erro);
		}
		
		return lista;
	}
	
	public ArrayList<Nota> buscarPorIdAlunoIdDisciplina(int idAluno, int idDisciplina){
		String sql = "SELECT * FROM notas inner join aluno on notas.idaluno = aluno.idaluno inner join disciplina on notas.iddisciplina = disciplina.iddisciplina where notas.iddisciplina = " + idDisciplina + " and notas.idaluno = " + idAluno;
		ArrayList<Nota> lista = new ArrayList<Nota>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Nota nota = new Nota();
				nota.setIdnota(rs.getInt("idnota"));
				nota.setIdaluno(rs.getInt("idaluno"));
				nota.setIddisciplina(rs.getInt("iddisciplina"));
				nota.setNota(rs.getFloat("nota"));
				nota.setDescricao(rs.getString("descricao"));
				AlunoDAO alunodao = new AlunoDAO();
				nota.setAluno(alunodao.buscarPorId(rs.getInt("idaluno")));
				DisciplinaDAO disciplinadao = new DisciplinaDAO();
				nota.setDisciplina(disciplinadao.buscarPorIdDisciplina(rs.getInt("iddisciplina")));
				lista.add(nota);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 5: " + erro);
		}
		
		return lista;
	}
	
	public Nota buscarPorIdNota(int idNota){
		String sql = "SELECT * FROM notas inner join aluno on notas.idaluno = aluno.idaluno inner join disciplina on notas.iddisciplina = disciplina.iddisciplina where idnota = " + idNota;
		ArrayList<Nota> lista = new ArrayList<Nota>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Nota nota = new Nota();
				nota.setIdnota(rs.getInt("idnota"));
				nota.setIdaluno(rs.getInt("idaluno"));
				nota.setIddisciplina(rs.getInt("iddisciplina"));
				nota.setNota(rs.getFloat("nota"));
				nota.setDescricao(rs.getString("descricao"));
				AlunoDAO alunodao = new AlunoDAO();
				nota.setAluno(alunodao.buscarPorId(rs.getInt("idaluno")));
				DisciplinaDAO disciplinadao = new DisciplinaDAO();
				nota.setDisciplina(disciplinadao.buscarPorIdDisciplina(rs.getInt("iddisciplina")));
				lista.add(nota);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 6: " + erro);
		}
		
		return lista.get(0);
	}
}
