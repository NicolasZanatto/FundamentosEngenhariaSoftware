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
		String sql = "INSERT INTO notas(idaluno,iddisciplina,nota) VALUES (?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, nota.getIdaluno());
			stmt.setInt(2, nota.getIddisciplina());
			stmt.setFloat(3, nota.getNota());
			stmt.execute();
			stmt.close();
		}catch(Exception erro) {
			throw new RuntimeException("Erro 2: " + erro);
		}
	}
	
	public void atualizar(Nota nota) {
		String sql = "UPDATE notas SET nota = ? WHERE idnota = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setFloat(1, nota.getNota());
			stmt.setInt(2, nota.getIdnota());
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
		String sql = "SELECT * FROM notas";
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
				lista.add(nota);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 5: " + erro);
		}
		
		return lista;
	}
}
