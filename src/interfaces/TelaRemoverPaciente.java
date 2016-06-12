package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Paciente;
import repositorio.RepositorioPaciente;
import DAO.PacienteDAO;

import javax.swing.JFormattedTextField;

public class TelaRemoverPaciente extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField textFieldNome;
	private JButton btnRemover;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverPaciente frame = new TelaRemoverPaciente();
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
	public TelaRemoverPaciente() {
		setTitle("Remover Paciente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 105);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPaciente.setBounds(12, 12, 79, 15);
		contentPane.add(lblPaciente);
		
		textFieldNome = new JFormattedTextField();
		textFieldNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldNome.setBounds(104, 10, 385, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numcpf = textFieldNome.getText();
				
				RepositorioPaciente r = new PacienteDAO();
				
				Paciente p = new Paciente();
				p.setCpf(numcpf);
				
				if(r.buscarPaciente(numcpf) != null){
					r.removerPaciente(p);
				}else{
					JOptionPane.showMessageDialog(null, "Paciente não removido!");
				}
				
				dispose();
			}
		});
		btnRemover.setBounds(12, 45, 117, 25);
		contentPane.add(btnRemover);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(372, 41, 117, 25);
		contentPane.add(btnSair);
		
		try{
			textFieldNome.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
