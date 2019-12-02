package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import model.Pessoa;

import java.awt.Panel;
import java.awt.Choice;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuView {

	private JFrame frmAppEscola;
	private static Pessoa usuarioLogado;

	/**
	 * Create the application.
	 */
	public MenuView(Pessoa usuarioLogado) {
		initialize();
		MenuView.usuarioLogado = usuarioLogado;
		this.frmAppEscola.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppEscola = new JFrame();
		frmAppEscola.setTitle("App Escola");
		frmAppEscola.setBounds(100, 100, 374, 191);
		frmAppEscola.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppEscola.getContentPane().setLayout(null);
		
		JButton btnAvisos = new JButton("Mural de Avisos");
		btnAvisos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAvisos.setBounds(80, 33, 195, 34);
		frmAppEscola.getContentPane().add(btnAvisos);
		
		JButton btnNotas = new JButton("Gerenciamento de Notas");
		btnNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!usuarioLogado.ehProfessor()) {
					new VisualizacaoNotasView(usuarioLogado);
				}
				else {
					new RegistroNotasView();
				}
			}
		});
		btnNotas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAvisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AvisoView(usuarioLogado);
			}
		});
		btnNotas.setBounds(80, 81, 195, 34);
		frmAppEscola.getContentPane().add(btnNotas);
	}
}
