package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	// Inversão de controle
	private OnlinePaymentService onlinePaymentService;
	
	// Implementação de injeção de dependência
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	/**
	 * @param contract responsavel por instânciar N objetos que serão as parcelas
	 * @param months quantidade de parcelas/mês
	 */
	public void processContract(Contract contract, int months) {	
		
		double basicQuota = contract.getTotalValue() / months;
		// basicQuota = 200
		for (int i = 1; i <= months; i++) {
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			// updatedQuota = 202
			double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
			// fullQuota = 206.04
			Date dueDate = addMounts(contract.getDate(), i);
			contract.getInstallments().add(new Installment(dueDate, fullQuota));
		}
	}

	/**
	 * @param date setar a data informada por parâmetro
	 * @param N adicionar N meses (Calendar.MONDAY) no calendar
	 * @return retornar a data
	 */
	private Date addMounts(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONDAY, N);
		return calendar.getTime();		
	}
	
}
