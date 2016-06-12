package interfaces;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import repositorio.RepositorioAtendente;
import repositorio.RepositorioGerente;
import repositorio.RepositorioMedico;
import DAO.AtendenteDAO;
import DAO.GerenteDAO;
import DAO.MedicoDAO;

public class TelaDeLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordFieldSenha;
	private JTextField textFieldUsuario;
//	JComboBox comboBoxUsuario;
//	String esp = (String)comboBoxUsuario.getSelectedItem();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin frame = new TelaDeLogin();
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
	public TelaDeLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/neto/Área de Trabalho/icone-usuario.png"));
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setBounds(12, 24, 70, 15);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(12, 51, 50, 15);
		contentPane.add(lblSenha);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(78, 49, 240, 19);
		contentPane.add(passwordFieldSenha);
		
		JButton btnEntrar = new JButton("");
		btnEntrar.setIcon(new ImageIcon("/home/neto/Dropbox/workspace/Clínica/src/Imagens/botaoEntrar.png"));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepositorioMedico t = new MedicoDAO();
				RepositorioAtendente a = new AtendenteDAO();
				RepositorioGerente g = new GerenteDAO();
				
				String logar = textFieldUsuario.getText();
				String senh = passwordFieldSenha.getText();

				if(t.buscarLogin(logar, senh) == true){
					new TelaMedico().setVisible(true);
					dispose();
				}else if(a.buscarLogin(logar, senh) == true){
					new TelaPrincipal().setVisible(true);
					dispose();
				}else if(g.buscarLogin(logar, senh) == true){
					new TelaGerente().setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Login ou senha Incorretos!");
				}
			}
		});
		btnEntrar.setBounds(350, 14, 78, 25);
		contentPane.add(btnEntrar);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon("/home/neto/Dropbox/workspace/Clínica/src/Imagens/botaoSair.png"));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnLimpar.setBounds(350, 51, 78, 25);
		contentPane.add(btnLimpar);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(78, 22, 240, 19);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
	}
}
