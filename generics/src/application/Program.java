package application;

import java.util.Scanner;

import services.PrintServices;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PrintServices <String> ps = new PrintServices();
		
		System.out.print("Ho many values? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			String value = sc.next();
			ps.addValue(value);
			
		}	
		ps.print();
		String x = ps.first();
		System.out.print("First: " + x);
		sc.close();
	}

}
