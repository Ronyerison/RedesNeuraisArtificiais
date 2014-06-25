package br.ufpi.easii.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

import br.ufpi.easii.redeNeural.MultiLayerPerceptron;
import br.ufpi.easii.redeNeural.Perceptron;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal {

	private JFrame frame;
	private JTextField textField;
	private MultiLayerPerceptron neuralNetwork;
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
		
		Integer[] camadas = {2,1};
		neuralNetwork = new MultiLayerPerceptron(camadas);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 759, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 11, 473, 374);
		frame.getContentPane().add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnPerceptron = new JButton("Treinar Quest\u00E3o 1");
		btnPerceptron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				treinarPrimeiraQuestao();
				textArea.setText(neuralNetwork.getStrResult().toString());
			}
		});
		btnPerceptron.setBounds(559, 73, 129, 23);
		frame.getContentPane().add(btnPerceptron);
		
		textField = new JTextField();
		textField.setBounds(633, 266, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSetPesos = new JButton("Set Pesos");
		btnSetPesos.setBounds(525, 265, 89, 23);
		frame.getContentPane().add(btnSetPesos);
		
		textField_1 = new JTextField();
		textField_1.setBounds(563, 299, 51, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(668, 299, 51, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblX = new JLabel("X1");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(525, 302, 28, 14);
		frame.getContentPane().add(lblX);
		
		JLabel lblX_1 = new JLabel("X2");
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setBounds(630, 302, 28, 14);
		frame.getContentPane().add(lblX_1);
		
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.setBounds(583, 341, 89, 23);
		frame.getContentPane().add(btnExecutar);
		
		JButton btnNewButton = new JButton("Treinar Quest\u00E3o 2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				treinarSegundaQuestao();
				textArea.setText(neuralNetwork.getStrResult().toString());
			}
		});
		btnNewButton.setBounds(559, 143, 129, 23);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void treinarPrimeiraQuestao(){
		Double[][] entradas = new Double[4][2];
		entradas[0][0] = 0.0; entradas[0][1] = 0.0;
		entradas[1][0] = 0.0; entradas[1][1] = 1.0;
		entradas[2][0] = 1.0; entradas[2][1] = 0.0;
		entradas[3][0] = 1.0; entradas[3][1] = 1.0;
		
		Double[][] saidaDesejada = new Double[4][1];
		saidaDesejada[0][0] = 0.0;
		saidaDesejada[1][0] = 0.0;
		saidaDesejada[2][0] = 1.0;
		saidaDesejada[3][0] = 1.0;
		
		neuralNetwork.treinamento(entradas, saidaDesejada, 0.5, 0.01);
	}
	
	public void treinarSegundaQuestao(){
		Double[][] entradas = new Double[4][2];
		entradas[0][0] = 0.0; entradas[0][1] = 0.0;
		entradas[1][0] = 0.0; entradas[1][1] = 1.0;
		entradas[2][0] = 1.0; entradas[2][1] = 0.0;
		entradas[3][0] = 1.0; entradas[3][1] = 1.0;
		
		Double[][] saidaDesejada = new Double[4][1];
		saidaDesejada[0][0] = 0.0;
		saidaDesejada[1][0] = 1.0;
		saidaDesejada[2][0] = 1.0;
		saidaDesejada[3][0] = 0.0;
		
		neuralNetwork.treinamento(entradas, saidaDesejada, 0.5, 0.01);
	}
}
