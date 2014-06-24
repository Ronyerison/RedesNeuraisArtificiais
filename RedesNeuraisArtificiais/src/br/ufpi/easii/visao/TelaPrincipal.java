package br.ufpi.easii.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

import br.ufpi.easii.redeNeural.Perceptron;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;
	private JTextField textField;
	private Perceptron perceptron;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		perceptron = new Perceptron();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 759, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 11, 469, 374);
		frame.getContentPane().add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnPerceptron = new JButton("Treinar Perceptron");
		btnPerceptron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				treinarPerceptron();
				textArea.setText(perceptron.getStrResult().toString());
			}
		});
		btnPerceptron.setBounds(507, 13, 129, 23);
		frame.getContentPane().add(btnPerceptron);
		
		textField = new JTextField();
		textField.setBounds(647, 48, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSetPesos = new JButton("Set Pesos");
		btnSetPesos.setBounds(517, 47, 89, 23);
		frame.getContentPane().add(btnSetPesos);
		
		textField_1 = new JTextField();
		textField_1.setBounds(570, 113, 51, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(682, 113, 51, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblX = new JLabel("X1");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(532, 116, 28, 14);
		frame.getContentPane().add(lblX);
		
		JLabel lblX_1 = new JLabel("X2");
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setBounds(644, 116, 28, 14);
		frame.getContentPane().add(lblX_1);
		
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.setBounds(554, 162, 89, 23);
		frame.getContentPane().add(btnExecutar);
	}
	
	public void treinarPerceptron(){
		Double[][] entradas = new Double[4][2];
		entradas[0][0] = 0.0; entradas[0][1] = 0.0;
		entradas[1][0] = 0.0; entradas[1][1] = 1.0;
		entradas[2][0] = 1.0; entradas[2][1] = 0.0;
		entradas[3][0] = 1.0; entradas[3][1] = 1.0;
		
		Double[] saidaDesejada = {0.0,0.0,1.0,1.0};
		perceptron.treinamento(entradas, saidaDesejada, 0.05);
	}
}
