package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;

import dao.AlunoDAO;
import dao.DisciplinaDAO;
import dao.NotaDAO;
import model.Aluno;
import model.Disciplina;
import model.Nota;
import util.ComboboxItem;
import util.NotaTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class RegistroNotasView {

	public JFrame frmRegistroDeNotas;
	private JTextField txbNota;
	private JTable tbNotas;
	private JScrollPane scrollPane;
	private JTextField txbDescricao;
	private JTextField txbIdSelecionado;
	private NotaDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroNotasView window = new RegistroNotasView();
					window.frmRegistroDeNotas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistroNotasView() {
		initialize();
		buscarNotas();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		dao = new NotaDAO();
		frmRegistroDeNotas = new JFrame();
		frmRegistroDeNotas.setTitle("REGISTRO DE NOTAS- EDI\u00C7\u00C3O");
		frmRegistroDeNotas.setResizable(false);
		frmRegistroDeNotas.setBounds(100, 100, 539, 335);
		frmRegistroDeNotas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeNotas.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 187, 479, 108);
		frmRegistroDeNotas.getContentPane().add(scrollPane);
		
		tbNotas = new JTable();
		
		scrollPane.setViewportView(tbNotas);
		
		JLabel lblAluno = new JLabel("ALUNO:");
		lblAluno.setBounds(68, 32, 46, 14);
		frmRegistroDeNotas.getContentPane().add(lblAluno);
		
		JLabel lblDisciplina = new JLabel("DISCIPLINA:");
		lblDisciplina.setBounds(68, 66, 70, 14);
		frmRegistroDeNotas.getContentPane().add(lblDisciplina);
		
		JLabel lblNota = new JLabel("NOTA:");
		lblNota.setBounds(68, 127, 46, 14);
		frmRegistroDeNotas.getContentPane().add(lblNota);
		
		JComboBox<ComboboxItem> cmbDisciplina = new JComboBox<ComboboxItem>();
		cmbDisciplina.setEditable(true);
		cmbDisciplina.setBounds(155, 63, 204, 20);
		this.alimentarComboDisciplinas(cmbDisciplina);
		frmRegistroDeNotas.getContentPane().add(cmbDisciplina);
		
		txbNota = new JTextField();
		txbNota.setBounds(155, 121, 204, 20);
		frmRegistroDeNotas.getContentPane().add(txbNota);
		txbNota.setColumns(10);
		
		JButton btnInserirNota = new JButton("INSERIR");
		
		btnInserirNota.setBounds(68, 153, 105, 23);
		frmRegistroDeNotas.getContentPane().add(btnInserirNota);
		
		JButton btnAtualizarNota = new JButton("ATUALIZAR");
		btnAtualizarNota.setBounds(183, 153, 105, 23);
		frmRegistroDeNotas.getContentPane().add(btnAtualizarNota);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(298, 153, 90, 23);
		frmRegistroDeNotas.getContentPane().add(btnExcluir);
		
		JLabel lblAluno_1 = new JLabel("   Aluno");
		lblAluno_1.setBounds(78, 187, 46, 14);
		frmRegistroDeNotas.getContentPane().add(lblAluno_1);
		
		JLabel lblDisciplina_1 = new JLabel("   Disciplina");
		lblDisciplina_1.setBounds(155, 187, 72, 14);
		frmRegistroDeNotas.getContentPane().add(lblDisciplina_1);
		
		JLabel lblNota_1 = new JLabel("   Nota");
		lblNota_1.setBounds(237, 187, 46, 14);
		frmRegistroDeNotas.getContentPane().add(lblNota_1);
		
		JLabel lblData = new JLabel("   Data");
		lblData.setBounds(325, 187, 46, 14);
		frmRegistroDeNotas.getContentPane().add(lblData);
		
		JComboBox<ComboboxItem> cmbAluno = new JComboBox<ComboboxItem>();
		cmbAluno.setEditable(true);
		cmbAluno.setBounds(155, 29, 204, 20);
		this.alimentarComboAlunos(cmbAluno);
		
		tbNotas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txbIdSelecionado.setText(tbNotas.getValueAt(tbNotas.getSelectedRow(), NotaTableModel.COL_IDNOTA).toString());
				Nota nota = dao.buscarPorIdNota(Integer.parseInt(txbIdSelecionado.getText()));
				cmbAluno.setSelectedIndex(buscarIndice(cmbAluno,nota.getIdaluno()));
				cmbDisciplina.setSelectedIndex(buscarIndice(cmbDisciplina,nota.getIddisciplina()));
				txbDescricao.setText(nota.getDescricao());
				txbNota.setText(Integer.toString((int)nota.getNota()));

			}
		});
		
		frmRegistroDeNotas.getContentPane().add(cmbAluno);
		
		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O:");
		lblDescrio.setBounds(68, 102, 70, 14);
		frmRegistroDeNotas.getContentPane().add(lblDescrio);
		
		txbDescricao = new JTextField();
		txbDescricao.setColumns(10);
		txbDescricao.setBounds(155, 90, 204, 20);
		frmRegistroDeNotas.getContentPane().add(txbDescricao);
		
		txbIdSelecionado = new JTextField();
		txbIdSelecionado.setColumns(10);
		txbIdSelecionado.setBounds(387, 63, 136, 20);
		txbIdSelecionado.setVisible(false);
		frmRegistroDeNotas.getContentPane().add(txbIdSelecionado);
		
		btnInserirNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ComboboxItem cmbA = (ComboboxItem) cmbAluno.getSelectedItem();
				ComboboxItem cmbD = (ComboboxItem) cmbDisciplina.getSelectedItem();
				if(Validacoes(cmbA, cmbD)) {
					NotaDAO notadao = new NotaDAO();
					Nota nota = new Nota();
					
					
					
					nota.setIdaluno(cmbA.getValue());
					nota.setIddisciplina(cmbD.getValue());
					nota.setNota(Float.parseFloat(txbNota.getText()));
					nota.setDescricao(txbDescricao.getText());
					notadao.inserir(nota);
					buscarNotas();
				}
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolha = JOptionPane.showConfirmDialog(null,"Deseja excluir?","Aviso - Exclus�o", JOptionPane.YES_NO_OPTION);
				if(escolha == 0) {
					dao.excluir(Integer.parseInt(txbIdSelecionado.getText()));
					System.out.println("Id: " + Integer.parseInt(txbIdSelecionado.getText()));
					buscarNotas();
				}
			}
		});
		
		btnAtualizarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ComboboxItem cmbA = (ComboboxItem) cmbAluno.getSelectedItem();
				ComboboxItem cmbD = (ComboboxItem) cmbDisciplina.getSelectedItem();
				
				
				Nota nota = new Nota();
				nota.setIdaluno(cmbA.getValue());
				nota.setIddisciplina(cmbD.getValue());
				nota.setDescricao(txbDescricao.getText());
				nota.setNota(Float.parseFloat(txbNota.getText()));
				nota.setIdnota(Integer.parseInt(txbIdSelecionado.getText()));
				dao.atualizar(nota);
				buscarNotas();
			}
		});
		
		frmRegistroDeNotas.setVisible(true);

	}
	
	public void buscarNotas() {
		tbNotas.setModel(new NotaTableModel(new NotaDAO().listarTodos()));
		tbNotas.getColumnModel().getColumn(0).setPreferredWidth(15);
	}
	
	public int buscarIndice(JComboBox<ComboboxItem> combo, int key) {
		for(int i=0; i<combo.getItemCount(); i++)
		{
			if(combo.getItemAt(i).getValue() == key)
				return i;
		}
		
		return 100;
	}
	
	
	private void alimentarComboAlunos(JComboBox<ComboboxItem> cmbAluno) {
		
		ArrayList<Aluno> alunos = new AlunoDAO().listarTodos();
		for(Aluno aluno : alunos) {
			cmbAluno.addItem(new ComboboxItem(aluno.getIdaluno(), aluno.getPessoa().getNome()));
		}
		
	}
	
	private void alimentarComboDisciplinas(JComboBox<ComboboxItem> cmbDisciplina) {
		
		ArrayList<Disciplina> disciplinas = new DisciplinaDAO().listarTodos();
		for(Disciplina disciplina : disciplinas) {
			cmbDisciplina.addItem(new ComboboxItem(disciplina.getIddisciplina(), disciplina.getNome()));
		}
		
	}
	
	public boolean Validacoes(ComboboxItem cmbA, ComboboxItem cmbD) {

		if(!isParsable(txbNota.getText()) || Integer.parseInt(txbNota.getText()) >10 || Integer.parseInt(txbNota.getText()) <0) {
			JOptionPane.showMessageDialog(null, "Valor Inv�lido");
			return false;
		}
		/*ArrayList<Nota> notas = new NotaDAO().buscarPorIdAlunoIdDisciplina(cmbA.getValue(), cmbD.getValue());
		for(Nota nota : notas) {
			if(nota.getDescricao() !=null && nota.getDescricao().trim().toUpperCase() == txbDescricao.getText().trim().toUpperCase()) {
				JOptionPane.showMessageDialog(null, "Nota j� foi inserida");
				return false;
			}
		}*/
		
		return true;
	}
	
	public boolean isParsable(String input){
	    try{
	        Integer.parseInt(input);
	        return true;
	    }catch(Exception e){
	        return false;
	    }
	}
}