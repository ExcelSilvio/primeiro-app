package br.com.setcons.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AgendaApp extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTxt;
	private JTextField telefoneTxt;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaApp frame = new AgendaApp();
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
	public AgendaApp() {
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel painelSuperior = new JPanel();
		contentPane.add(painelSuperior, BorderLayout.NORTH);
		painelSuperior.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNome = new JLabel("Nome");
		painelSuperior.add(lblNome);
		
		nomeTxt = new JTextField();
		painelSuperior.add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		painelSuperior.add(lblTelefone);
		
		telefoneTxt = new JTextField();
		painelSuperior.add(telefoneTxt);
		telefoneTxt.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		painelSuperior.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		painelSuperior.add(btnRemover);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tabela = new JTable();
		scrollPane.setViewportView(tabela);
	}

}
