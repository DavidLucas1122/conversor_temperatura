package br.dev.david.conversor.model;

public class Temperatura {

	private double celsius;

	
	// Fórmulando Cálculos
	public double getCelsius() {
		return celsius;
	}

	public void setCelsius(double celsius) {
		this.celsius = celsius;

	}
//Conversão para Fahreiheit
	public double converterParaFahreiheit() {
		return (celsius * 1.8) + 32.0;

	}
// Conversão para Kelvin
	public double converterParaKelvin() {
		return celsius + 273.15;
	}
}
