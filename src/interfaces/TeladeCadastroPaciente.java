package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Paciente;
import repositorio.RepositorioPaciente;
import DAO.PacienteDAO;

public class TeladeCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JFormattedTextField textFieldCPF;
	private JFormattedTextField textFieldTelefone;
	private JTextField textFieldEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeladeCadastroPaciente frame = new TeladeCadastroPaciente();
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
	public TeladeCadastroPaciente() {
		setResizable(false);
		setTitle("Cadastro de Pacientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNome.setBounds(12, 12, 62, 15);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCpf.setBounds(12, 39, 45, 15);
		contentPane.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTelefone.setBounds(206, 39, 83, 15);
		contentPane.add(lblTelefone);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEndereo.setBounds(12, 66, 90, 15);
		contentPane.add(lblEndereo);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldNome.setBounds(74, 10, 335, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JFormattedTextField();
		textFieldCPF.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldCPF.setBounds(52, 37, 134, 19);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldTelefone = new JFormattedTextField();
		textFieldTelefone.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldTelefone.setBounds(287, 37, 122, 19);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(104, 64, 305, 19);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		try{
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			textFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			textFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				String cpf = textFieldCPF.getText();
				String telefone = textFieldTelefone.getText();
				String endereco = textFieldEndereco.getText();
				
				if(nome.equals("") || cpf.equals("")){
					JOptionPane.showMessageDialog(null, "Nenhum campo pode estar vazio!");
				}else{
//					Atendente f = new Atendente();
					Paciente p = new Paciente();
					
					p.setNome(nome);
					p.setCpf(cpf);
					p.setTelefone(telefone);
					p.setEndereço(endereco);
					
					RepositorioPaciente eheh = new PacienteDAO();
					eheh.adicionarPaciente(p);
					
//					f.cadastrarPaciente(p);
					
					textFieldNome.setText("");
					textFieldCPF.setText("");
					textFieldTelefone.setText("");
					textFieldEndereco.setText("");
					
					dispose();
				}
			}
		});
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCadastrar.setBounds(12, 93, 117, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setText("");
				textFieldCPF.setText("");
				textFieldTelefone.setText("");
				textFieldEndereco.setText("");
			}
		});
		btnLimpar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnLimpar.setBounds(152, 93, 117, 25);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCancelar.setBounds(292, 93, 117, 25);
		contentPane.add(btnCancelar);
	}
}
