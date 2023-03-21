package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> lista = new ArrayList<>();
		
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Commom, used of imported (c/u/i): ");
			char type = sc.next().charAt(0);
			System.out.print("name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("price: ");
			Double price = sc.nextDouble();
			if(type == 'c') {
				lista.add(new Product(name, price));
			}
			else if (type == 'u'){
				System.out.print("ManuFacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				lista.add(new UsedProduct(name, price, date));
			}
			else {
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();
				lista.add(new ImportedProduct(name, price, customsFee));
			}	
		}
		System.out.println();
		
		System.out.println("ETIQUETAS DE PRECO:");
		for (Product prod : lista) {
			System.out.println(prod.priceTag());
		}	
	sc.close();

	}
}
