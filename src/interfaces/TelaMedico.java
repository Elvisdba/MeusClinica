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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import modelo.Consulta;
import repositorio.RepositorioGerais;
import DAO.ConsultaGeraisDAO;

public class TelaMedico extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMedico frame = new TelaMedico();
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
	
	RepositorioGerais o = new ConsultaGeraisDAO();
	private JFormattedTextField textFieldHora;
	
	
	public TelaMedico() {
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtpnObserva = new JTextArea();
		txtpnObserva.setText("Queixas do paciente:\n\n\n\n\nPrescrições médicas:\n\n\n\n\nResultados finais:\n\n\n\n\n");
		txtpnObserva.setBounds(12, 12, 448, 281);
		contentPane.add(txtpnObserva);
		
		
		
		JButton btnGravarObservaes = new JButton("Gravar observações");
		btnGravarObservaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Consulta c = new Consulta();
				c.setObservacoes(txtpnObserva.getText());
				
				o.atualizarObservacoes(c, textFieldHora.getText());
			}
		});
		btnGravarObservaes.setFont(new Font("Dialog", Font.BOLD, 14));
		btnGravarObservaes.setBounds(12, 305, 546, 25);
		contentPane.add(btnGravarObservaes);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtpnObserva.setText(o.buscarObservacoes(textFieldHora.getText()));
			}
		});
		btnBuscar.setBounds(472, 12, 86, 25);
		contentPane.add(btnBuscar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(472, 268, 86, 25);
		contentPane.add(btnSair);
		
		textFieldHora = new JFormattedTextField();
		textFieldHora.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldHora.setBounds(472, 134, 86, 25);
		contentPane.add(textFieldHora);
		textFieldHora.setColumns(10);
		
		JLabel lblHorrio = new JLabel("Horário:");
		lblHorrio.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHorrio.setBounds(478, 80, 70, 15);
		contentPane.add(lblHorrio);
		
		JLabel lblHorrio_1 = new JLabel("Horário:");
		lblHorrio_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHorrio_1.setBounds(478, 200, 70, 15);
		contentPane.add(lblHorrio_1);
		
		try{
			textFieldHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
