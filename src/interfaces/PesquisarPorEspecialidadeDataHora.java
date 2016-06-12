package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import DAO.ConsultaGeraisDAO;
import DAO.MedicoDAO;
import repositorio.RepositorioGerais;
import repositorio.RepositorioMedico;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisarPorEspecialidadeDataHora extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEspecialidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarPorEspecialidadeDataHora frame = new PesquisarPorEspecialidadeDataHora();
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
	public PesquisarPorEspecialidadeDataHora() {
		setTitle("Pesquisar médico por especialidade numa determinada data ou horário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelEspecia = new JLabel("Especialidade:");
		labelEspecia.setFont(new Font("Dialog", Font.BOLD, 14));
		labelEspecia.setBounds(12, 12, 121, 22);
		contentPane.add(labelEspecia);

		textFieldEspecialidade = new JTextField();
		textFieldEspecialidade.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldEspecialidade.setBounds(141, 12, 150, 22);
		contentPane.add(textFieldEspecialidade);
		textFieldEspecialidade.setColumns(10);

		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Dialog", Font.BOLD, 14));
		lblData.setBounds(10, 40, 48, 22);
		contentPane.add(lblData);

		JFormattedTextField txtData = new JFormattedTextField();
		txtData.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtData.setBounds(63, 41, 70, 22);
		contentPane.add(txtData);

		try {
			txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
					new javax.swing.text.MaskFormatter("##/##/####")));

			JLabel lblHora = new JLabel("Hora:");
			lblHora.setFont(new Font("Dialog", Font.BOLD, 14));
			lblHora.setBounds(161, 40, 48, 22);
			contentPane.add(lblHora);

			JFormattedTextField txtHora = new JFormattedTextField();
			txtHora.setBounds(216, 40, 75, 22);
			contentPane.add(txtHora);

			try {
				txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.MaskFormatter("##")));

				JButton btnPesquisar = new JButton("Pesquisar");
				btnPesquisar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String aux1 = "";
						String aux2 = "";
						
						RepositorioMedico r = new MedicoDAO();
						RepositorioGerais rg = new ConsultaGeraisDAO();

						if (r.buscarMedicoPorEspecialidade(textFieldEspecialidade
								.getText()) != null) {
							aux1 = r.buscarMedicoPorEspecialidade(
									textFieldEspecialidade.getText())
									.getNumeroCRM();
						}
						if (rg.buscarDataHora(txtData.getText(),
								txtHora.getText()) != null) {
							aux2 = rg.buscarDataHora(txtData.getText(),
									txtHora.getText()).getCrm_medico();
						}

						if (aux1 == aux2) {
							JOptionPane.showMessageDialog(null, "O CRM do médico é " + aux1);
						}else{
							JOptionPane.showMessageDialog(null, "Nenhum médico encontrado");
						}
					}
				});
				btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 14));
				btnPesquisar.setBounds(421, 10, 117, 25);
				contentPane.add(btnPesquisar);

				JButton btnSair = new JButton("Sair");
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSair.setFont(new Font("Dialog", Font.BOLD, 14));
				btnSair.setBounds(421, 39, 117, 25);
				contentPane.add(btnSair);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
