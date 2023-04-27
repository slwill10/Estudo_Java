package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractServices {
	
	private OnlinePaymentService onlinePaymentServices;

	public ContractServices(OnlinePaymentService onlinePaymentServices) {
		this.onlinePaymentServices = onlinePaymentServices;
	}
	
	public void processContract(Contract contract, int months) {
		
		double basicQuota = contract.getTotalValue() / months;
		
		for(int i=1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double interest =  onlinePaymentServices.interest(basicQuota, i);			
			double fee = onlinePaymentServices.paymentFee(basicQuota + interest);			
			double quota = basicQuota + interest + fee;
			
			contract.getInstallments().add(new Installment(dueDate, quota));
		}
	}
	
}

	
	


