package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import DAO.MedicoDAO;
import repositorio.RepositorioMedico;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class PesquisarMedicoPorEspecialidade extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEspecialidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarMedicoPorEspecialidade frame = new PesquisarMedicoPorEspecialidade();
					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PesquisarMedicoPorEspecialidade() {
		setResizable(false);
		setTitle("Pesquisar Médico por Especialidade");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelEspecialidade = new JLabel("Especialidade:");
		labelEspecialidade.setFont(new Font("Dialog", Font.BOLD, 15));
		labelEspecialidade.setBounds(12, 12, 119, 23);
		contentPane.add(labelEspecialidade);
		
		textFieldEspecialidade = new JTextField();
		textFieldEspecialidade.setBounds(135, 12, 303, 23);
		contentPane.add(textFieldEspecialidade);
		textFieldEspecialidade.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RepositorioMedico rm = new MedicoDAO();
				
				if(rm.buscarMedicoPorEspecialidade(textFieldEspecialidade.getText()) != null){
					JOptionPane.showMessageDialog(null, rm.buscarMedicoPorEspecialidade(textFieldEspecialidade.getText()).getNome());
				}else{
					JOptionPane.showMessageDialog(null, "Nenhum Médico encontrado");
				}
				
			}
		});
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnPesquisar.setBounds(12, 47, 117, 25);
		contentPane.add(btnPesquisar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSair.setBounds(321, 47, 117, 25);
		contentPane.add(btnSair);
	}
}
