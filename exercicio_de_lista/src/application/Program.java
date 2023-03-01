package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entites.Employee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.println("How many employees will be registered? ");
		int n = sc.nextInt();
		System.out.println();
		for(int i = 0 ; i < n; i++) {
			System.out.println("Employee #"+ (i+1) + ": ");
			System.out.print("ID: ");
			Integer id = sc.nextInt();
			System.out.print("name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("salary: ");
			Double salary = sc.nextDouble();
			System.out.println();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		System.out.println("Enter the employee id that will have salary increase: ");
		int idsalary = sc.nextInt();
		Integer pos = position(list, idsalary);
		if(pos == null) {
			System.out.println("This id does not exists!");
		}else {
			System.out.println("Enter the porcentage: ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}
		System.out.println();
		System.out.println("List of employess: ");
		for(Employee emp : list) {
			System.out.println(emp);
		}
		
		sc.close();
	}
	
	public static Integer position(List<Employee> list, int id) {
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
}
