package services;

import java.security.InvalidParameterException;

public interface InterestService {
	
	/**
	 * Faz a chamada do m�todo pra pegar a taxa de juros da classe especif�ca
	 */
	double getInterestRate();

	/**
	 * Implementa��o do default method
	 * @param amount recebe o valor a ser pago 
	 * @param months quantidade de meses
	 * @return retorna o c�lculo de juros composto padr�o de 1% ao m�s
	 */
	default double payment(double amount, int months) {
		if (months < 1) {
			throw new InvalidParameterException("Months must be greater than zero");
		}
		return amount * Math.pow(1.0 + getInterestRate() / 100, months);
	}

}
