package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.ConsultaPorPlano;
import repositorio.RepositorioConsultaPorPlano;
import repositorio.RepositorioMedico;
import repositorio.RepositorioPaciente;
import repositorio.RepositorioPlanoDeSaude;
import DAO.ConsultaPorPlanoDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.PlanoDeSaudeDAO;

import com.toedter.calendar.JDateChooser;

public class TelaDeConsultaPlanoSaude extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField textFieldPaciente;
	private JTextField textFieldMédico;
	private JFormattedTextField textFieldHora;
	private JTextField textFieldPlano;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeConsultaPlanoSaude frame = new TelaDeConsultaPlanoSaude();
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
	public TelaDeConsultaPlanoSaude() {
		setTitle("Tela de Consulta por Plano");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPaciente.setBounds(12, 7, 86, 15);
		contentPane.add(lblPaciente);

		JLabel lblMdico = new JLabel("Médico:");
		lblMdico.setFont(new Font("Dialog", Font.BOLD, 15));
		lblMdico.setBounds(12, 34, 70, 15);
		contentPane.add(lblMdico);

		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Dialog", Font.BOLD, 15));
		lblData.setBounds(12, 61, 70, 15);
		contentPane.add(lblData);

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Dialog", Font.BOLD, 15));
		lblHora.setBounds(187, 61, 54, 15);
		contentPane.add(lblHora);

		JLabel lblPlano = new JLabel("Plano:");
		lblPlano.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPlano.setBounds(290, 61, 54, 15);
		contentPane.add(lblPlano);

		textFieldPaciente = new JFormattedTextField();
		textFieldPaciente.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldPaciente.setBounds(95, 5, 343, 19);
		contentPane.add(textFieldPaciente);
		textFieldPaciente.setColumns(10);

		textFieldMédico = new JTextField();
		textFieldMédico.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldMédico.setBounds(89, 32, 349, 19);
		contentPane.add(textFieldMédico);
		textFieldMédico.setColumns(10);

		textFieldHora = new JFormattedTextField();
		textFieldHora.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldHora.setBounds(237, 59, 31, 19);
		contentPane.add(textFieldHora);
		textFieldHora.setColumns(10);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(60, 57, 109, 19);
		contentPane.add(dateChooser);

		JButton btnMarcarConsulta = new JButton("Efetuar a Consulta");
		btnMarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String paciente = textFieldPaciente.getText();
				String medico = textFieldMédico.getText();
				String dat = new SimpleDateFormat("dd/MM/yyyy")
						.format(dateChooser.getDate());
				String hora = textFieldHora.getText();
				String plano = textFieldPlano.getText();

				int aut = Integer.parseInt(hora);

				RepositorioMedico i = new MedicoDAO();
				RepositorioPaciente a = new PacienteDAO();
				RepositorioPlanoDeSaude h = new PlanoDeSaudeDAO();
				RepositorioConsultaPorPlano r = new ConsultaPorPlanoDAO();

				ConsultaPorPlano p = new ConsultaPorPlano();

				int diaSemana = (dateChooser.getDate().getDay() - 1);
				String diaString = Integer.toString(diaSemana);

				String diasaten = i.buscarDiaMedico();

				if (diasaten.contains(diaString)) {
					if ((aut >= 7 && aut <= 10) || (aut >= 13 && aut <= 16)) {
						if (h.buscarPlano(plano) != null) {
							if (i.buscarMedico(medico) != null) {
								if (a.buscarPaciente(paciente) != null) {
									if (r.buscarDataHora(dat,
											textFieldHora.getText()) == false) {
										p.setCpf_paciente(paciente);
										p.setCrm_medico(medico);
										p.setData(dat);
										p.setHora(hora);
										p.setNomePlano(plano);

										r.adicionarConsultaPorPlano(p);
									} else {
										JOptionPane
												.showMessageDialog(null,
														"Já possui consulta marcada neste horário ou data!");
									}
								}
							}
						} else {
							JOptionPane
									.showMessageDialog(null,
											"Plano, Médico ou Paciente não cadastrado!");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Não atendemos neste horário!");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Médico não atende neste dia!");
				}

				textFieldPaciente.setText("");
				textFieldMédico.setText("");
				textFieldHora.setText("");

				dispose();
			}
		});
		btnMarcarConsulta.setBounds(12, 88, 179, 25);
		contentPane.add(btnMarcarConsulta);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(321, 88, 117, 25);
		contentPane.add(btnSair);

		textFieldPlano = new JTextField();
		textFieldPlano.setBounds(341, 59, 97, 19);
		contentPane.add(textFieldPlano);
		textFieldPlano.setColumns(10);

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			textFieldHora
					.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
							new javax.swing.text.MaskFormatter("##")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			textFieldPaciente
					.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
							new javax.swing.text.MaskFormatter("###.###.###-##")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
