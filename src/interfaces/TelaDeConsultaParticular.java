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

import modelo.ConsultaParticular;
import repositorio.RepositorioConsultaParticular;
import repositorio.RepositorioMedico;
import repositorio.RepositorioPaciente;
import DAO.ConsultaParticularDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

public class TelaDeConsultaParticular extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField textFieldPaciente;
	private JTextField textFieldMedico;
	private JTextField txtValorConsulta;
	private JFormattedTextField txtHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeConsultaParticular frame = new TelaDeConsultaParticular();
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
	public TelaDeConsultaParticular() {
		setResizable(false);
		setTitle("Realizar Consulta Particular");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 421, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPaciente.setBounds(12, 0, 84, 44);
		contentPane.add(lblPaciente);

		JLabel lblMdico = new JLabel("Médico:");
		lblMdico.setFont(new Font("Dialog", Font.BOLD, 15));
		lblMdico.setBounds(12, 41, 70, 15);
		contentPane.add(lblMdico);

		JLabel lblHorrioEData = new JLabel("Data:");
		lblHorrioEData.setFont(new Font("Dialog", Font.BOLD, 15));
		lblHorrioEData.setBounds(12, 67, 55, 15);
		contentPane.add(lblHorrioEData);

		textFieldPaciente = new JFormattedTextField();
		textFieldPaciente.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldPaciente.setBounds(96, 13, 304, 19);
		contentPane.add(textFieldPaciente);
		textFieldPaciente.setColumns(10);

		textFieldMedico = new JTextField();
		textFieldMedico.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldMedico.setBounds(83, 39, 317, 19);
		contentPane.add(textFieldMedico);
		textFieldMedico.setColumns(10);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(63, 63, 117, 19);
		contentPane.add(dateChooser);

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Dialog", Font.BOLD, 15));
		lblHora.setBounds(198, 67, 55, 15);
		contentPane.add(lblHora);

		JButton btnEfetuarAConsulta = new JButton("Efetuar a Consulta");
		btnEfetuarAConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pacient = textFieldPaciente.getText();
				String medico = textFieldMedico.getText();
				String dat = new SimpleDateFormat("dd/MM/yyyy")
						.format(dateChooser.getDate());
				String hor = txtHora.getText();
				String valor = txtValorConsulta.getText();

				int aut = Integer.parseInt(hor);

				ConsultaParticular c = new ConsultaParticular();

				RepositorioConsultaParticular r = new ConsultaParticularDAO();
				RepositorioMedico p = new MedicoDAO();
				RepositorioPaciente a = new PacienteDAO();

				int diaSemana = (dateChooser.getDate().getDay() - 1);
				String diaString = Integer.toString(diaSemana);
				
				String diasaten = p.buscarDiaMedico();

				if (diasaten.contains(diaString)) {

					if ((aut >= 7 && aut <= 10) || (aut >= 13 && aut <= 16)) {
						if (a.buscarPaciente(pacient) != null) {
							if (p.buscarMedico(medico) != null) {
								if (r.buscarDataHora(dat, hor) == false) {
									c.setCrm_medico(medico);
									c.setCpf_paciente(pacient);
									c.setData(dat);
									c.setHora(hor);
									c.setValor(valor);

									r.adicionarConsultaParticular(c);
								} else {
									JOptionPane
											.showMessageDialog(null,
													"Já possui consulta marcada neste horário ou data!");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Médico ou Paciente não cadastrado");
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
				textFieldMedico.setText("");
				txtHora.setText("");
				txtValorConsulta.setText("");

				dispose();
			}
		});
		btnEfetuarAConsulta.setFont(new Font("Dialog", Font.BOLD, 15));
		btnEfetuarAConsulta.setBounds(12, 94, 212, 25);
		contentPane.add(btnEfetuarAConsulta);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCancelar.setBounds(283, 94, 117, 25);
		contentPane.add(btnCancelar);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Dialog", Font.BOLD, 15));
		lblValor.setBounds(299, 67, 55, 15);
		contentPane.add(lblValor);

		txtValorConsulta = new JTextField();
		txtValorConsulta.setBounds(350, 65, 50, 19);
		contentPane.add(txtValorConsulta);
		txtValorConsulta.setColumns(10);

		txtHora = new JFormattedTextField();
		txtHora.setBounds(242, 65, 30, 19);
		contentPane.add(txtHora);
		txtHora.setColumns(10);

		try {
			txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
					new javax.swing.text.MaskFormatter("##")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
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
