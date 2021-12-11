package services;

import java.security.InvalidParameterException;

public interface InterestService {
	
	/**
	 * Faz a chamada do método pra pegar a taxa de juros da classe especifíca
	 */
	double getInterestRate();

	/**
	 * Implementação do default method
	 * @param amount recebe o valor a ser pago 
	 * @param months quantidade de meses
	 * @return retorna o cálculo de juros composto padrão de 1% ao mês
	 */
	default double payment(double amount, int months) {
		if (months < 1) {
			throw new InvalidParameterException("Months must be greater than zero");
		}
		return amount * Math.pow(1.0 + getInterestRate() / 100, months);
	}

}
