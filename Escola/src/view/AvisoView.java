package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import dao.AvisoDAO;
import model.Pessoa;
import util.AvisoTableModel;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AvisoView extends JFrame {

	private JPanel contentPane;
	private JTable tbAvisos;
	private JScrollPane scrollPane;
	private JButton btnRefresh;
	private JButton btnCriar;
	private JButton btnExcluir;
	private JTextField txbIdSelecionado;
	private AvisoDAO dao;
	
	private Pessoa usuarioLogado;

	/**
	 * Create the frame.
	 */
	public AvisoView(Pessoa usuarioLogado) {
		initComponents();
		setVisible(true);
		this.usuarioLogado = usuarioLogado;
		buscarAvisos();
		permissoes();
	}
	
	public void initComponents() {
		dao = new AvisoDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mural de Avisos");
		lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(262, 11, 157, 14);
		contentPane.add(lblNewLabel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 641, 355);
		contentPane.add(scrollPane);
		
		tbAvisos = new JTable();
		tbAvisos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txbIdSelecionado.setText(tbAvisos.getValueAt(tbAvisos.getSelectedRow(), AvisoTableModel.COL_IDAVISO).toString());
			}
		});
		scrollPane.setViewportView(tbAvisos);
		
		btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroAvisoView().setVisible(true);
			}
		});
		btnCriar.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnCriar.setBounds(547, 421, 95, 23);
		contentPane.add(btnCriar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolha = JOptionPane.showConfirmDialog(null,"Deseja excluir?","Aviso - Exclus�o", JOptionPane.YES_NO_OPTION);
				if(escolha == 0) {
					dao.excluir(Integer.parseInt(txbIdSelecionado.getText()));
					System.out.println("Id: " + Integer.parseInt(txbIdSelecionado.getText()));
					buscarAvisos();
				}
			}
		});
		btnExcluir.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnExcluir.setBounds(434, 421, 103, 23);
		contentPane.add(btnExcluir);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarAvisos();
			}
		});
		btnRefresh.setBounds(10, 21, 103, 23);
		contentPane.add(btnRefresh);
		
		txbIdSelecionado = new JTextField();
		txbIdSelecionado.setBounds(20, 422, 86, 20);
		contentPane.add(txbIdSelecionado);
		txbIdSelecionado.setColumns(10);
		txbIdSelecionado.setVisible(false);
	}
	
	public void buscarAvisos() {
		tbAvisos.setModel(new AvisoTableModel(new AvisoDAO().listarTodos()));
		tbAvisos.getColumnModel().getColumn(0).setPreferredWidth(15);
	}
	
	public void permissoes() {
		if(usuarioLogado.ehAluno() || usuarioLogado.ehResponsavel())
		{
			btnExcluir.setVisible(false);
			btnCriar.setVisible(false);
		}
	}
	
}
