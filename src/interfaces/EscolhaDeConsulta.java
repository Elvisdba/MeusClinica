package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Point;

public class EscolhaDeConsulta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolhaDeConsulta frame = new EscolhaDeConsulta();
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
	public EscolhaDeConsulta() {
		setTitle("Escolha do tipo de Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultaParticular = new JButton("Consulta Particular");
		btnConsultaParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaDeConsultaParticular().setVisible(true);
			}
		});
		btnConsultaParticular.setFont(new Font("Dialog", Font.BOLD, 15));
		btnConsultaParticular.setBounds(12, 12, 195, 25);
		contentPane.add(btnConsultaParticular);
		
		JButton btnConsultaPorPlano = new JButton("Consulta por Plano");
		btnConsultaPorPlano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaDeConsultaPlanoSaude().setVisible(true);
			}
		});
		btnConsultaPorPlano.setFont(new Font("Dialog", Font.BOLD, 15));
		btnConsultaPorPlano.setBounds(243, 12, 195, 25);
		contentPane.add(btnConsultaPorPlano);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(154, 64, 117, 25);
		contentPane.add(btnCancelar);
	}
}
