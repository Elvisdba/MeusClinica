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

import modelo.Medico;
import repositorio.RepositorioMedico;
import DAO.MedicoDAO;

import javax.swing.JFormattedTextField;

public class TelaRemoverMedico extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JButton btnRemover;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverMedico frame = new TelaRemoverMedico();
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
	public TelaRemoverMedico() {
		setTitle("Remover Médico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 105);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMdico = new JLabel("Médico:");
		lblMdico.setFont(new Font("Dialog", Font.BOLD, 15));
		lblMdico.setBounds(12, 12, 70, 15);
		contentPane.add(lblMdico);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(89, 10, 349, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numcrm = textFieldNome.getText();
				
				RepositorioMedico m = new MedicoDAO();
				Medico c = new Medico();
				c.setNumeroCRM(numcrm);
				
				if(m.buscarMedico(numcrm) != null){
					m.removerMedico(c);
				}else{
					JOptionPane.showMessageDialog(null, "Médico não removido");
				}
				
				dispose();
			}
		});
		btnRemover.setBounds(12, 44, 117, 25);
		contentPane.add(btnRemover);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(321, 41, 117, 25);
		contentPane.add(btnSair);
		
	}
}
