package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import DAO.ConsultaGeraisDAO;
import repositorio.RepositorioGerais;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JLabel;

import modelo.Consulta;

public class PesquisarHorariosLivres extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldcrmMedico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarHorariosLivres frame = new PesquisarHorariosLivres();
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
	public PesquisarHorariosLivres() {
		setResizable(false);
		setTitle("Pesquisar por horários Livres");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 115);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> horas = new ArrayList<String>();
				horas.add("07");
				horas.add("08");
				horas.add("09");
				horas.add("10");
				horas.add("13");
				horas.add("14");
				horas.add("15");
				horas.add("16");
				
				RepositorioGerais r = new ConsultaGeraisDAO();
				List<Consulta> consultas = new ArrayList<Consulta>();
				consultas = r.buscarTodosConsultas();
				
				for(int j = 0; j < consultas.size(); j++){
					for(int i = 0; i < horas.size(); i++){
						if(consultas.get(j).getHora().equals(horas.get(i))){
							horas.remove(i);
						}
					}
				}
				JOptionPane.showMessageDialog(null, horas);
			}
		});
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnPesquisar.setBounds(12, 51, 130, 25);
		contentPane.add(btnPesquisar);
		
		textFieldcrmMedico = new JTextField();
		textFieldcrmMedico.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldcrmMedico.setBounds(127, 21, 160, 21);
		contentPane.add(textFieldcrmMedico);
		textFieldcrmMedico.setColumns(10);
		
		JLabel lblDigiteOCrm = new JLabel("Digite o crm:");
		lblDigiteOCrm.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDigiteOCrm.setBounds(15, 24, 114, 15);
		contentPane.add(lblDigiteOCrm);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSair.setBounds(157, 51, 130, 25);
		contentPane.add(btnSair);
	}
}
