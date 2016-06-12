package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

public class TelaPrincipal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		setTitle("Clínica House");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 790, 350);
		getContentPane().setLayout(null);
		
		JButton btnCadastrarPlanosDe = new JButton("Cadastrar Planos de Sáude");
		btnCadastrarPlanosDe.setBackground(new Color(51, 51, 153));
		btnCadastrarPlanosDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaDeCadastrarPlanoSaude().setVisible(true);
			}
		});
		btnCadastrarPlanosDe.setForeground(new Color(255, 255, 255));
		btnCadastrarPlanosDe.setBounds(12, 169, 315, 25);
		getContentPane().add(btnCadastrarPlanosDe);
		
		JButton btnVisualizarMdicosLivres = new JButton("Visualizar horários de Médicos Livres");
		btnVisualizarMdicosLivres.setBackground(new Color(51, 51, 153));
		btnVisualizarMdicosLivres.setForeground(new Color(255, 255, 255));
		btnVisualizarMdicosLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PesquisarHorariosLivres().setVisible(true);
			}
		});
		btnVisualizarMdicosLivres.setBounds(12, 265, 370, 25);
		getContentPane().add(btnVisualizarMdicosLivres);
		
		JButton btnConsultarMdicoPor = new JButton("Consultar Médico por Especilidade");
		btnConsultarMdicoPor.setBackground(new Color(51, 51, 153));
		btnConsultarMdicoPor.setForeground(new Color(255, 255, 255));
		btnConsultarMdicoPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PesquisarMedicoPorEspecialidade().setVisible(true);
			}
		});
		btnConsultarMdicoPor.setBounds(12, 216, 336, 25);
		getContentPane().add(btnConsultarMdicoPor);
		
		JButton btnConsultarMdicoPor_1 = new JButton("Pesquisar Médico por especialidade, data ou horário");
		btnConsultarMdicoPor_1.setBackground(new Color(51, 51, 153));
		btnConsultarMdicoPor_1.setForeground(new Color(255, 255, 255));
		btnConsultarMdicoPor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PesquisarPorEspecialidadeDataHora().setVisible(true);
			}
		});
		btnConsultarMdicoPor_1.setBounds(12, 12, 410, 25);
		getContentPane().add(btnConsultarMdicoPor_1);
		
		JButton buttonSair = new JButton("");
		buttonSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonSair.setSelected(true);
		buttonSair.setIcon(new ImageIcon("/home/neto/Dropbox/workspace/Clínica/src/Imagens/botaoSair.png"));
		buttonSair.setBounds(697, 265, 81, 25);
		getContentPane().add(buttonSair);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/neto/Dropbox/workspace/Clínica/src/Imagens/logo.jpg"));
		label.setBounds(0, 0, 790, 320);
		getContentPane().add(label);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnCadastrarMdico = new JButton("Cadastrar Médico");
		btnCadastrarMdico.setBackground(new Color(204, 255, 255));
		btnCadastrarMdico.setForeground(new Color(0, 0, 0));
		btnCadastrarMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeladeCadastroMedico().setVisible(true);
			}
		});
		menuBar.add(btnCadastrarMdico);
		
		JButton btnCadastrarPaciente = new JButton("Cadastrar Paciente");
		btnCadastrarPaciente.setBackground(new Color(204, 255, 255));
		btnCadastrarPaciente.setForeground(new Color(0, 0, 0));
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeladeCadastroPaciente().setVisible(true);
			}
		});
		menuBar.add(btnCadastrarPaciente);
		
		JButton btnRemoverMdico = new JButton("Remover Médico");
		btnRemoverMdico.setBackground(new Color(204, 255, 255));
		btnRemoverMdico.setForeground(new Color(0, 0, 0));
		btnRemoverMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaRemoverMedico().setVisible(true);
			}
		});
		menuBar.add(btnRemoverMdico);
		
		JButton btnRemoverPaciente = new JButton("Remover Paciente");
		btnRemoverPaciente.setBackground(new Color(204, 255, 255));
		btnRemoverPaciente.setForeground(new Color(0, 0, 0));
		btnRemoverPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaRemoverPaciente().setVisible(true);
			}
		});
		menuBar.add(btnRemoverPaciente);
		
		JButton btnRealizarConsulta = new JButton("Marcar Consulta");
		btnRealizarConsulta.setBackground(new Color(204, 255, 255));
		btnRealizarConsulta.setForeground(new Color(0, 0, 0));
		btnRealizarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EscolhaDeConsulta().setVisible(true);
			}
		});
		menuBar.add(btnRealizarConsulta);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
