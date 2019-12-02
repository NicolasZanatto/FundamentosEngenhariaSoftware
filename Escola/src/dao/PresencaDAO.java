package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Presenca;

public class PresencaDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet rs;
	
	public PresencaDAO() {
		conn = new ConnectionFactory().getConexao();
	}
	
	public void inserir(Presenca presenca) {
		String sql = "INSERT INTO presenca(idaluno,iddisciplina,faltas, descricao) VALUES (?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, presenca.getIdaluno());
			stmt.setInt(2, presenca.getIddisciplina());
			stmt.setFloat(3, presenca.getFaltas());
			stmt.setString(4, presenca.getDescricao());
			stmt.execute();
			stmt.close();
		}catch(Exception erro) {
			throw new RuntimeException("Erro 2: " + erro);
		}
	}
	
	public void atualizar(Presenca presenca) {
		String sql = "UPDATE presenca SET presenca = ?, idaluno = ?, iddisciplina = ?, descricao = ? WHERE idpresenca = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setFloat(1, presenca.getFaltas());
			stmt.setInt(2, presenca.getIdaluno());
			stmt.setInt(3, presenca.getIddisciplina());
			stmt.setString(4, presenca.getDescricao());
			stmt.setInt(5, presenca.getIdpresenca());
			stmt.execute();
			stmt.close();
		}catch(Exception erro) {
			throw new RuntimeException("Erro 3: " + erro);
		}
	}
	
	public void excluir(int valor) {
		String sql = "DELETE FROM presenca WHERE idpresenca = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valor);
			stmt.execute();
			stmt.close();
			
		}catch(Exception erro) {
			throw new RuntimeException("Erro 4: " + erro);
		}
	}
	
	public ArrayList<Presenca> listarTodos(){
		String sql = "SELECT * FROM presenca inner join aluno on presenca.idaluno = aluno.idaluno inner join disciplina on presenca.iddisciplina = disciplina.iddisciplina ";
		ArrayList<Presenca> lista = new ArrayList<Presenca>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Presenca presenca = new Presenca();
				presenca.setIdpresenca(rs.getInt("idpresenca"));
				presenca.setIdaluno(rs.getInt("idaluno"));
				presenca.setIddisciplina(rs.getInt("iddisciplina"));
				presenca.setFaltas(rs.getInt("faltas"));
				presenca.setDescricao(rs.getString("descricao"));
				AlunoDAO alunodao = new AlunoDAO();
				presenca.setAluno(alunodao.buscarPorId(rs.getInt("idaluno")));
				DisciplinaDAO disciplinadao = new DisciplinaDAO();
				presenca.setDisciplina(disciplinadao.buscarPorIdDisciplina(rs.getInt("iddisciplina")));
				lista.add(presenca);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 5: " + erro);
		}
		
		return lista;
	}
	
	public ArrayList<Presenca> buscarPorIdAlunoIdDisciplina(int idAluno, int idDisciplina){
		String sql = "SELECT * FROM presenca inner join aluno on presenca.idaluno = aluno.idaluno inner join disciplina on presenca.iddisciplina = disciplina.iddisciplina where presenca.iddisciplina = " + idDisciplina + " and presenca.idaluno = " + idAluno;
		ArrayList<Presenca> lista = new ArrayList<Presenca>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Presenca presenca = new Presenca();
				presenca.setIdpresenca(rs.getInt("idpresenca"));
				presenca.setIdaluno(rs.getInt("idaluno"));
				presenca.setIddisciplina(rs.getInt("iddisciplina"));
				presenca.setFaltas(rs.getInt("faltas"));
				presenca.setDescricao(rs.getString("descricao"));
				AlunoDAO alunodao = new AlunoDAO();
				presenca.setAluno(alunodao.buscarPorId(rs.getInt("idaluno")));
				DisciplinaDAO disciplinadao = new DisciplinaDAO();
				presenca.setDisciplina(disciplinadao.buscarPorIdDisciplina(rs.getInt("iddisciplina")));
				lista.add(presenca);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 5: " + erro);
		}
		
		return lista;
	}
	
	public Presenca buscarPoridpresenca(int idpresenca){
		String sql = "SELECT * FROM presenca inner join aluno on presenca.idaluno = aluno.idaluno inner join disciplina on presenca.iddisciplina = disciplina.iddisciplina where idpresenca = " + idpresenca;
		ArrayList<Presenca> lista = new ArrayList<Presenca>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Presenca presenca = new Presenca();
				presenca.setIdpresenca(rs.getInt("idpresenca"));
				presenca.setIdaluno(rs.getInt("idaluno"));
				presenca.setIddisciplina(rs.getInt("iddisciplina"));
				presenca.setFaltas(rs.getInt("faltas"));
				presenca.setDescricao(rs.getString("descricao"));
				AlunoDAO alunodao = new AlunoDAO();
				presenca.setAluno(alunodao.buscarPorId(rs.getInt("idaluno")));
				DisciplinaDAO disciplinadao = new DisciplinaDAO();
				presenca.setDisciplina(disciplinadao.buscarPorIdDisciplina(rs.getInt("iddisciplina")));
				lista.add(presenca);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 6: " + erro);
		}
		
		return lista.get(0);
	}
}
