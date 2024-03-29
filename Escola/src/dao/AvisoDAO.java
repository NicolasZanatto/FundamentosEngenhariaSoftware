package dao;

import java.sql.Connection;
import model.Aviso;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class AvisoDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet rs;
	
	public AvisoDAO() {
		conn = new ConnectionFactory().getConexao();
	}
	
	public void inserir(Aviso aviso) {
		String sql = "INSERT INTO aviso(idaviso,mensagem) VALUES (?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, aviso.getIdaviso());
			stmt.setString(2, aviso.getMensagem());
			stmt.execute();
			stmt.close();
		}catch(Exception erro) {
			throw new RuntimeException("Erro 2: " + erro);
		}
	}
	
	public void atualizar(Aviso aviso) {
		String sql = "UPDATE aviso SET mensagem = ? WHERE idaviso = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, aviso.getMensagem());
			stmt.setInt(2, aviso.getIdaviso());
			stmt.execute();
			stmt.close();
		}catch(Exception erro) {
			throw new RuntimeException("Erro 3: " + erro);
		}
	}
	
	public void excluir(int valor) {
		String sql = "DELETE FROM aviso WHERE idaviso = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valor);
			stmt.execute();
			stmt.close();
			
		}catch(Exception erro) {
			throw new RuntimeException("Erro 4: " + erro);
		}
	}
	
	public ArrayList<Aviso> listarTodos(){
		String sql = "SELECT * FROM aviso";
		ArrayList<Aviso> lista = new ArrayList<Aviso>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Aviso aviso = new Aviso();
				aviso.setIdaviso(rs.getInt("idaviso"));
				aviso.setMensagem(rs.getString("mensagem"));
				lista.add(aviso);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 5: " + erro);
		}
		
		return lista;
	}
	
	public ArrayList<Aviso> listarTodosPorMensagem(String valor){
		String sql = "SELECT * FROM aviso WHERE mensagem LIKE '%" + valor + "%' ";
		ArrayList<Aviso> lista = new ArrayList<Aviso>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Aviso aviso = new Aviso();
				aviso.setIdaviso(rs.getInt("idaviso"));
				aviso.setMensagem(rs.getString("mensagem"));
				lista.add(aviso);
			}
				
		}catch(Exception erro) {
			throw new RuntimeException("Erro 6: " + erro);
		}
		
		return lista;
	}
}
