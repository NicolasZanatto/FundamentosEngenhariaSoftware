package util;

import model.Aviso;
import model.Nota;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class NotaTableModel extends AbstractTableModel {

	public static final int COL_IDNOTA = 0;
	public static final int COL_ALUNO = 1;
	public static final int COL_DISCIPLINA = 2;
	public static final int COL_DESCRICAO = 3;

	public static final int COL_NOTA = 4;
	public ArrayList<Nota> lista;
	
	public NotaTableModel(ArrayList<Nota> notas) {
		lista = new ArrayList<Nota>(notas);
	}
	
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Nota nota = lista.get(linha);
		if(coluna == COL_IDNOTA) 
			return nota.getIdnota();
		if(coluna == COL_ALUNO)
			return nota.getAluno().getPessoa().getNome();
		if(coluna == COL_DISCIPLINA)
			return nota.getDisciplina().getNome();
		if(coluna == COL_DESCRICAO)
			return nota.getDescricao();
		if(coluna == COL_NOTA)
			return nota.getNota();
	
		return "";
	}
	
	@Override
	public String getColumnName(int coluna) {
		if(coluna == COL_IDNOTA) 
			return "Id";
		if(coluna == COL_ALUNO)
			return "Aluno";
		if(coluna == COL_DISCIPLINA)
			return "Disciplina";
		if(coluna == COL_DESCRICAO)
			return "Descri��o";
		if(coluna == COL_NOTA)
			return "Nota";
		
		return "";
	}

}