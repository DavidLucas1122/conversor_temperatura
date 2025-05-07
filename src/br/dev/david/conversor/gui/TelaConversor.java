package br.dev.david.conversor.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.david.conversor.model.Temperatura;

public class TelaConversor {

	private JTextField textCelsius;
	private JLabel labelCelsius;
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;

	public void criarTelaConversor() {
		JFrame tela = new JFrame();
		tela.setTitle("Conversor de Temperatura");
		tela.setSize(500, 400);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);

		// Componentes de Tela

		// Celsius
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em Graus Celsius (Digite apenas números)");
		textCelsius = new JTextField();
		textCelsius.setBounds(40, 90, 420, 30);

		// Botões
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText(" Fahreinheit");
		buttonFahreinheit.setBounds(40,130,200,40);

		buttonKelvin = new JButton();
		buttonKelvin.setText(" Kelvin");
		buttonKelvin.setBounds(260, 130, 200, 40);

		labelResultado = new JLabel();
		labelResultado.setBounds(40,190,420,40);

		labelMensagemErro = new JLabel();
		labelMensagemErro.setForeground(Color.red);
		labelMensagemErro.setBounds(40,240,420,40);

		tela.getContentPane().add(labelCelsius);
		tela.getContentPane().add(textCelsius);
		tela.getContentPane().add(buttonKelvin);
		tela.getContentPane().add(buttonFahreinheit);
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(labelMensagemErro);

		// Ouvinte de Eventos dos Botões

		// Botão Kelvin
		buttonKelvin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String valorCelsius = textCelsius.getText();
				try {
					Temperatura temperatura = new Temperatura();
					double celsius = Double.parseDouble(valorCelsius);
					temperatura.setCelsius(celsius);
					double kelvin = temperatura.converterParaKelvin();
					labelResultado.setText(kelvin + " Kelvin");
					labelMensagemErro.setText(null);
				}
				catch (NumberFormatException ex) {
					labelMensagemErro.setText("Erro! Valor Inválido! Digite apenas números!");
					textCelsius.setText(null);

				}

			}
		});

		// Botão Fahreiheit
		buttonFahreinheit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String valorCelsius = textCelsius.getText();
				try {
					Temperatura temperatura = new Temperatura();
					double celsius = Double.parseDouble(valorCelsius);
					temperatura.setCelsius(celsius);
					double fahreiheit = temperatura.converterParaFahreiheit();
					labelResultado.setText(fahreiheit + " Fahreiheit");
					labelMensagemErro.setText(null);
				}
				catch (NumberFormatException ex) {
					labelMensagemErro.setText("Erro! Valor Inválido! Digite apenas números!");
					textCelsius.setText(null);

				}

			}
		});

		// Última linha do código
		tela.setVisible(true);

	}

}
