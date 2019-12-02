package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dao.PessoaDAO;
import model.Pessoa;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView {

	public JFrame frame;
	private JTextField txbUsuario;
	private JPasswordField txbSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 417, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsurio = new JLabel("CPF:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsurio.setBounds(77, 31, 63, 27);
		frame.getContentPane().add(lblUsurio);
		
		txbUsuario = new JTextField();
		txbUsuario.setBounds(70, 60, 256, 30);
		frame.getContentPane().add(txbUsuario);
		txbUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(77, 101, 69, 26);
		frame.getContentPane().add(lblSenha);
		
		txbSenha = new JPasswordField();
		txbSenha.setBounds(70, 130, 256, 30);
		frame.getContentPane().add(txbSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa usuario = loginValido();
				if(usuario != null) {
					new MenuView(usuario);
					frame.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Usu�rio Inv�lido");
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(161, 185, 84, 38);
		frame.getContentPane().add(btnEntrar);
		
		frame.setVisible(true);
	}
	
	private Pessoa loginValido() {
		PessoaDAO pessoaDao = new PessoaDAO();
		return pessoaDao.buscarParaLogar(txbUsuario.getText(), new String(txbSenha.getPassword()).trim());
		
		
	}
}