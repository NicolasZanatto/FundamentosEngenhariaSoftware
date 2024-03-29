package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Disciplina;;

public class DisciplinaDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	
	public DisciplinaDAO() {
		conn = new ConnectionFactory().getConexao();
	}
	
	public ArrayList<Disciplina> listarTodos(){
		String sql = "SELECT * FROM disciplina";
		ArrayList<Disciplina> lista = new ArrayList<Disciplina>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setIddisciplina(rs.getInt("iddisciplina"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setIdprofessor(rs.getInt("idprofessor"));
				lista.add(disciplina);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 5: " + erro);
		}
		
		return lista;
	}
	
	public ArrayList<Disciplina> listarPorIdProfessor(int idprofessor){
		String sql = "SELECT * FROM disciplina WHERE idprofessor = " + idprofessor;
		ArrayList<Disciplina> lista = new ArrayList<Disciplina>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setIddisciplina(rs.getInt("iddisciplina"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setIdprofessor(rs.getInt("idprofessor"));
				lista.add(disciplina);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 6: " + erro);
		}
		
		return lista;
	}
	
	public Disciplina buscarPorIdDisciplina(int idDisciplina){
		String sql = "SELECT * FROM disciplina WHERE iddisciplina = " + idDisciplina;
		ArrayList<Disciplina> lista = new ArrayList<Disciplina>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setIddisciplina(rs.getInt("iddisciplina"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setIdprofessor(rs.getInt("idprofessor"));
				lista.add(disciplina);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 6: " + erro);
		}
		
		return lista.get(0);
	}
}
