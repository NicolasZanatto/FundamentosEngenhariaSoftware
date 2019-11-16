package table;

import model.Aviso;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class AvisoTableModel extends AbstractTableModel {

	public static final int COL_IDAVISO = 0;
	public static final int COL_MENSAGEM = 1;
	public ArrayList<Aviso> lista;
	
	public AvisoTableModel(ArrayList<Aviso> avisos) {
		lista = new ArrayList<Aviso>(avisos);
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Aviso aviso = lista.get(linha);
		if(coluna == COL_IDAVISO) 
			return aviso.getIdaviso();
		if(coluna == COL_MENSAGEM)
			return aviso.getMensagem();
		
		return "";
	}
	
	@Override
	public String getColumnName(int coluna) {
		if(coluna == COL_IDAVISO) 
			return "Id";
		if(coluna == COL_MENSAGEM)
			return "Mensagem";
		
		return "";
	}

}
