package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Aluno;;

public class AlunoDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	public AlunoDAO() {
		conn = new ConnectionFactory().getConexao();
	}
	
	public ArrayList<Aluno> listarTodos(){
		String sql = "SELECT * FROM aluno";
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setIdaluno(rs.getInt("idaluno"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setIdpessoa(rs.getInt("idpessoa"));
				lista.add(aluno);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 5: " + erro);
		}
		
		return lista;
	}
	
	public Aluno buscarPorId(int idaluno){
		String sql = "SELECT * FROM aluno WHERE idaluno = " + idaluno;
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setIdaluno(rs.getInt("idaluno"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setIdpessoa(rs.getInt("idpessoa"));
				lista.add(aluno);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 5: " + erro);
		}
		
		return lista.get(0);
	}
}
