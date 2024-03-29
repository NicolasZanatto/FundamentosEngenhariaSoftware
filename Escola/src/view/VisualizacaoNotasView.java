package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.AlunoDAO;
import dao.DisciplinaDAO;
import dao.NotaDAO;
import model.Aluno;
import model.Disciplina;
import model.Pessoa;
import util.ComboboxItem;
import util.NotaTableModel;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizacaoNotasView {

	private JFrame frmRegistroDeNotas;
	private JTextField txbAluno;
	private Pessoa usuarioLogado;
	private JTable tbNotas;
	private JScrollPane scrollPane;
	
	/**
	 * Create the application.
	 */
	public VisualizacaoNotasView(Pessoa usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeNotas = new JFrame();
		frmRegistroDeNotas.setBackground(Color.BLUE);
		frmRegistroDeNotas.setTitle("REGISTRO DE NOTAS- VISUALIZA\u00C7\u00C3O");
		frmRegistroDeNotas.setBounds(100, 100, 450, 300);
		frmRegistroDeNotas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeNotas.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 414, 108);
		frmRegistroDeNotas.getContentPane().add(scrollPane);
		
		tbNotas = new JTable();
		
		scrollPane.setViewportView(tbNotas);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(29, 29, 91, 98);
		frmRegistroDeNotas.getContentPane().add(panel);
		
		JLabel lblAluno = new JLabel("ALUNO:");
		lblAluno.setBounds(150, 47, 46, 14);
		frmRegistroDeNotas.getContentPane().add(lblAluno);
		
		JLabel lblDisciplina = new JLabel("DISCIPLINA:");
		lblDisciplina.setBounds(150, 85, 73, 14);
		frmRegistroDeNotas.getContentPane().add(lblDisciplina);
		
		txbAluno = new JTextField();
		txbAluno.setBounds(228, 44, 117, 20);
		frmRegistroDeNotas.getContentPane().add(txbAluno);
		txbAluno.setColumns(10);
		txbAluno.setText(usuarioLogado.getNome());
		txbAluno.setEnabled(false);
		JComboBox<ComboboxItem> cmbDisciplinas = new JComboBox<ComboboxItem>();
		cmbDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarNotas(cmbDisciplinas);
			}
		});
		cmbDisciplinas.setToolTipText("");
		cmbDisciplinas.setEditable(true);
		cmbDisciplinas.setBounds(228, 82, 117, 20);
		frmRegistroDeNotas.getContentPane().add(cmbDisciplinas);
		
		alimentarComboDisciplinas(cmbDisciplinas);
		
		frmRegistroDeNotas.setVisible(true);
		
		buscarNotas(cmbDisciplinas);
	}
	
	private void alimentarComboDisciplinas(JComboBox<ComboboxItem> cmbDisciplina) {
		
		ArrayList<Disciplina> disciplinas = new DisciplinaDAO().listarTodos();
		for(Disciplina disciplina : disciplinas) {
			cmbDisciplina.addItem(new ComboboxItem(disciplina.getIddisciplina(), disciplina.getNome()));
		}
		
	}
	public void buscarNotas(JComboBox<ComboboxItem> cmbDisciplina) {
		ComboboxItem cmbD = (ComboboxItem) cmbDisciplina.getSelectedItem();
		
		if(usuarioLogado.ehAluno()) {
			Aluno aluno = new AlunoDAO().buscarPorIdPessoa(usuarioLogado.getIdpessoa());
			tbNotas.setModel(new NotaTableModel(new NotaDAO().buscarPorIdAlunoIdDisciplina(aluno.getIdaluno(), cmbD.getValue())));
			tbNotas.getColumnModel().getColumn(0).setPreferredWidth(15);
		}
	}
	
}