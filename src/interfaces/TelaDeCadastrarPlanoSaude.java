package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.PlanoDeSaude;
import repositorio.RepositorioPlanoDeSaude;
import DAO.PlanoDeSaudeDAO;

public class TelaDeCadastrarPlanoSaude extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRazaoSocial;
	private JLabel lblCnpj;
	private JTextField textFieldCNPJ;
	private JLabel lblEndereco;
	private JLabel lblTefefone;
	private JFormattedTextField textFieldTelefone;
	private JTextField textFieldEndereco;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeCadastrarPlanoSaude frame = new TelaDeCadastrarPlanoSaude();
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
	public TelaDeCadastrarPlanoSaude() {
		setTitle("Cadastrar Planos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelRazao = new JLabel("Razão Social:");
		labelRazao.setBounds(15, 12, 117, 23);
		labelRazao.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(labelRazao);
		
		textFieldRazaoSocial = new JTextField();
		textFieldRazaoSocial.setBounds(130, 14, 308, 19);
		textFieldRazaoSocial.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPane.add(textFieldRazaoSocial);
		textFieldRazaoSocial.setColumns(10);
		
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(15, 33, 47, 31);
		lblCnpj.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(lblCnpj);
		
		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setBounds(62, 39, 125, 19);
		textFieldCNPJ.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPane.add(textFieldCNPJ);
		textFieldCNPJ.setColumns(10);
		
		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(15, 58, 92, 31);
		lblEndereco.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(lblEndereco);
		
		lblTefefone = new JLabel("Tefefone:");
		lblTefefone.setBounds(215, 37, 86, 23);
		lblTefefone.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(lblTefefone);
		
		textFieldTelefone = new JFormattedTextField();
		textFieldTelefone.setBounds(298, 39, 140, 19);
		textFieldTelefone.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(15, 96, 117, 25);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String razao = textFieldRazaoSocial.getText();
				String cnpj = textFieldCNPJ.getText();
				String endere = textFieldEndereco.getText();
				String fone = textFieldTelefone.getText();
				
				PlanoDeSaude t = new PlanoDeSaude();
				t.setRazaoSocial(razao);
				t.setCNPJ(cnpj);
				t.setEndereco(endere);
				t.setTelefone(fone);
				
				RepositorioPlanoDeSaude p = new PlanoDeSaudeDAO();
				p.adicionarPLano(t);
				
				textFieldRazaoSocial.setText("");
				textFieldCNPJ.setText("");
				textFieldEndereco.setText("");
				textFieldTelefone.setText("");
				
				dispose();
			}
		});
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(321, 96, 117, 25);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnSair);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(104, 63, 334, 21);
		textFieldEndereco.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		try{
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			textFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
