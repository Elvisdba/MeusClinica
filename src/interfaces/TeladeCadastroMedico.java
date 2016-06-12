package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Medico;
import repositorio.RepositorioMedico;
import repositorio.RepositorioPlanoDeSaude;
import DAO.MedicoDAO;
import DAO.PlanoDeSaudeDAO;

import com.toedter.calendar.JDateChooser;

public class TeladeCadastroMedico extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldNumCRM;
	private JFormattedTextField textFieldTelefone;
	private JTextField textFieldEndereco;
	private JTextField textFieldPlanos;
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeladeCadastroMedico frame = new TeladeCadastroMedico();
					frame.setVisible(true);
					// frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeladeCadastroMedico() {
		setTitle("Cadastro de Médicos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 595, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNome.setBounds(12, 12, 70, 15);
		contentPane.add(lblNome);

		JLabel lblnumeroCRM = new JLabel("Numero de CRM:");
		lblnumeroCRM.setFont(new Font("Dialog", Font.BOLD, 15));
		lblnumeroCRM.setBounds(12, 39, 142, 15);
		contentPane.add(lblnumeroCRM);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEndereo.setBounds(12, 66, 99, 15);
		contentPane.add(lblEndereo);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTelefone.setBounds(310, 39, 99, 15);
		contentPane.add(lblTelefone);

		JLabel lblDiasDeAntedimento = new JLabel("Dias de Antedimento:");
		lblDiasDeAntedimento.setForeground(Color.BLACK);
		lblDiasDeAntedimento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDiasDeAntedimento.setBounds(12, 93, 195, 15);
		contentPane.add(lblDiasDeAntedimento);

		JLabel lblPlanosDeSade = new JLabel("Plano de Saúde:");
		lblPlanosDeSade.setForeground(Color.BLACK);
		lblPlanosDeSade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPlanosDeSade.setBounds(222, 93, 142, 15);
		contentPane.add(lblPlanosDeSade);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldNome.setBounds(75, 10, 507, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldNumCRM = new JTextField();
		textFieldNumCRM.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldNumCRM.setBounds(154, 37, 154, 19);
		contentPane.add(textFieldNumCRM);
		textFieldNumCRM.setColumns(10);

		textFieldTelefone = new JFormattedTextField();
		textFieldTelefone.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldTelefone.setBounds(393, 37, 189, 19);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldEndereco.setBounds(106, 64, 476, 19);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);

		JCheckBox chckbxPediatra = new JCheckBox("Pediatra");
		chckbxPediatra.setFont(new Font("Dialog", Font.BOLD, 14));
		chckbxPediatra.setBounds(403, 122, 129, 23);
		contentPane.add(chckbxPediatra);

		JCheckBox chckbxOrtopedista = new JCheckBox("Ortopedista");
		chckbxOrtopedista.setFont(new Font("Dialog", Font.BOLD, 14));
		chckbxOrtopedista.setBounds(403, 149, 129, 23);
		contentPane.add(chckbxOrtopedista);

		JCheckBox chckbxEndocopista = new JCheckBox("Endocopista");
		chckbxEndocopista.setFont(new Font("Dialog", Font.BOLD, 14));
		chckbxEndocopista.setBounds(403, 176, 129, 23);
		contentPane.add(chckbxEndocopista);

		JCheckBox chckbxRadiologista = new JCheckBox("Radiologista");
		chckbxRadiologista.setFont(new Font("Dialog", Font.BOLD, 14));
		chckbxRadiologista.setBounds(403, 203, 129, 23);
		contentPane.add(chckbxRadiologista);

		JCheckBox chckbxUrologista = new JCheckBox("Urologista");
		chckbxUrologista.setFont(new Font("Dialog", Font.BOLD, 14));
		chckbxUrologista.setBounds(403, 230, 129, 23);
		contentPane.add(chckbxUrologista);

		JCheckBox checkBoxSegunda = new JCheckBox("Segunda-Feira");
		checkBoxSegunda.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxSegunda.setBounds(12, 122, 147, 23);
		contentPane.add(checkBoxSegunda);

		JCheckBox chckbxTerafeira = new JCheckBox("Terça-Feira");
		chckbxTerafeira.setFont(new Font("Dialog", Font.BOLD, 14));
		chckbxTerafeira.setBounds(12, 151, 125, 19);
		contentPane.add(chckbxTerafeira);

		JCheckBox chckbxQuartafeira = new JCheckBox("Quarta-Feira");
		chckbxQuartafeira.setFont(new Font("Dialog", Font.BOLD, 14));
		chckbxQuartafeira.setBounds(12, 176, 125, 23);
		contentPane.add(chckbxQuartafeira);

		JCheckBox chckbxQuintafeira = new JCheckBox("Quinta-Feira");
		chckbxQuintafeira.setFont(new Font("Dialog", Font.BOLD, 14));
		chckbxQuintafeira.setBounds(12, 203, 129, 23);
		contentPane.add(chckbxQuintafeira);

		JCheckBox chckbxSextafeira = new JCheckBox("Sexta-Feira");
		chckbxSextafeira.setFont(new Font("Dialog", Font.BOLD, 14));
		chckbxSextafeira.setBounds(12, 230, 125, 23);
		contentPane.add(chckbxSextafeira);

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			textFieldTelefone
					.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
							new javax.swing.text.MaskFormatter("(##)####-####")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JCheckBox jc[] = { checkBoxSegunda, chckbxTerafeira,
						chckbxQuartafeira, chckbxQuintafeira, chckbxSextafeira };

				String guarda = "";
				for (int i = 0; i < jc.length; i++) {
					if (jc[i].isSelected() == true) {
						String inova = Integer.toString(i);
						guarda = guarda + inova;
					}
				}

				String nome = textFieldNome.getText();
				String numero = textFieldNumCRM.getText();
				String telefo = textFieldTelefone.getText();
				String endere = textFieldEndereco.getText();
				String planos = textFieldPlanos.getText();
				String log = textFieldLogin.getText();
				String sen = passwordFieldSenha.getText();

				if (nome.equals("") || endere.equals("")) {
					JOptionPane.showMessageDialog(null,
							"Nenhum campo pode estar vazio!");
				} else {

					Medico c = new Medico();

					RepositorioPlanoDeSaude ps = new PlanoDeSaudeDAO();

					if (ps.buscarPlano(planos) != null) {
						c.setNumeroCRM(numero);
						c.setNome(nome);
						c.setTelefone(telefo);
						c.setEndereco(endere);
						c.setDiasDeAtendimento(guarda);
						c.setPlanosDeSaude(planos);
						c.setLogin(log);
						c.setSenha(sen);
					} else {
						JOptionPane.showMessageDialog(null,
								"Plano não cadastrado ou incorreto!");
					}

					if (chckbxOrtopedista.isSelected()) {
						c.setEspecialidades("121");
					} else if (chckbxPediatra.isSelected()) {
						c.setEspecialidades("122");
					} else if (chckbxEndocopista.isSelected()) {
						c.setEspecialidades("123");
					} else if (chckbxRadiologista.isSelected()) {
						c.setEspecialidades("124");
					} else if (chckbxUrologista.isSelected()) {
						c.setEspecialidades("125");
					} else {
						JOptionPane.showMessageDialog(null,
								"Selecione alguma especialidade");
					}

					RepositorioMedico t = new MedicoDAO();
					t.adicionarMedico(c);

					textFieldNome.setText("");
					textFieldNumCRM.setText("");
					textFieldTelefone.setText("");
					textFieldEndereco.setText("");
					textFieldPlanos.setText("");

					dispose();
				}
			}
		});
		buttonCadastrar.setBounds(7, 310, 200, 50);
		contentPane.add(buttonCadastrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(383, 310, 200, 50);
		contentPane.add(btnCancelar);

		textFieldPlanos = new JTextField();
		textFieldPlanos.setBounds(222, 120, 142, 19);
		contentPane.add(textFieldPlanos);
		textFieldPlanos.setColumns(10);

		JLabel lblEspecialidades = new JLabel("Especialidade:");
		lblEspecialidades.setForeground(Color.BLACK);
		lblEspecialidades.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEspecialidades.setBounds(393, 93, 125, 15);
		contentPane.add(lblEspecialidades);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 15));
		lblLogin.setBounds(12, 283, 70, 15);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSenha.setBounds(268, 283, 70, 15);
		contentPane.add(lblSenha);

		textFieldLogin = new JTextField();
		textFieldLogin.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldLogin.setBounds(71, 283, 189, 19);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setFont(new Font("Dialog", Font.PLAIN, 14));
		passwordFieldSenha.setBounds(333, 283, 249, 19);
		contentPane.add(passwordFieldSenha);
	}
}
