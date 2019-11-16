package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AvisoDAO;
import model.Aviso;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class CadastroAvisoView extends JFrame {

	private JPanel contentPane;
	private static CadastroAvisoView frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CadastroAvisoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroAvisoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarAviso = new JLabel("Cadastrar Aviso");
		lblCadastrarAviso.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblCadastrarAviso.setBounds(199, 11, 160, 14);
		contentPane.add(lblCadastrarAviso);
		
		TextField txbAviso = new TextField();
		txbAviso.setBounds(24, 49, 482, 173);
		contentPane.add(txbAviso);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aviso aviso = new Aviso();
				aviso.setMensagem(txbAviso.getText());
				
				AvisoDAO dao = new AvisoDAO();
				dao.inserir(aviso);
				setVisible(false); 
				dispose();
				
			}
		});
		btnEnviar.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnEnviar.setBounds(409, 247, 97, 23);
		contentPane.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false); //you can't see me!
				dispose();
			}
		});
		btnCancelar.setBounds(291, 247, 105, 23);
		contentPane.add(btnCancelar);
	}
}