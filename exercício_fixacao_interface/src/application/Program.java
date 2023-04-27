package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractServices; 
import services.PaypalServices;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//--------------------------------------------------------------------		
		System.out.println("Entre com os dados do contrato:");
		System.out.print("numero: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
// --------------------------------------------------------------------
		
		System.out.print("Entre com o número de parcelas: ");
		int n = sc.nextInt();
		
		ContractServices contractService = new ContractServices(new PaypalServices());
		contractService.processContract(obj, n);		
		
//----------------------------------------------------------------------
		System.out.println("parcelas: ");
		for(Installment installment : obj.getInstallments()) {
			System.out.println(installment);
		}

		sc.close();

	}

}
