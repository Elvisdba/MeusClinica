package interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Consulta;
import repositorio.RepositorioGerais;
import DAO.ConsultaGeraisDAO;

public class TelaGerente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerente frame = new TelaGerente();
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
	public TelaGerente() {
		setTitle("Bem vindo Gerente!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListarConsultasDo = new JButton("Listar Consultas do Dia");
		btnListarConsultasDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepositorioGerais rg = new ConsultaGeraisDAO();
				List<Consulta> consultas = new ArrayList<Consulta>();
				consultas = rg.buscarTodosConsultas();
				String tudo = "";
				for(int i = 0; i < consultas.size(); i++){
					tudo = tudo + "Horário - " + consultas.get(i).getHora()
							+ "\nCPF do paciente - "+ consultas.get(i).getCpf_paciente()
							+"\nCRM do médico - "+ consultas.get(i).getCrm_medico() + "\n\n";
				}
				JOptionPane.showMessageDialog(null, tudo);
			}
		});
		btnListarConsultasDo.setBounds(12, 39, 206, 25);
		contentPane.add(btnListarConsultasDo);
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setIcon(new ImageIcon("/home/neto/Dropbox/workspace/Clínica/src/Imagens/botaoSair.png"));
		btnSair.setBounds(324, 39, 82, 25);
		contentPane.add(btnSair);
	}
}
