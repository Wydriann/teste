package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.enums.OrderStatus;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println();
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = input.nextLine();
		
		System.out.print("Email: ");
		String email = input.nextLine();
		
		System.out.print("Birth date(DD/MM/YYYY): ");
		Date birthDate = sdf.parse(input.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println();
		
		System.out.println("Enther the Order data: ");
		System.out.print("Satus: ");
		OrderStatus status = OrderStatus.valueOf(input.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println();
		
		System.out.print("How many items to this order? ");
		int os = input.nextInt();
		
		for (int i = 1; i <= os; i++) {
			System.out.println("Enter the #" + i + " Item data:" );
			System.out.print("Product Name: ");
			input.nextLine();
			String productName = input.nextLine();
			
			System.out.print("Product price: ");
			Double productPrice = input.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int quantity = input.nextInt();
			
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderItem);
			System.out.println();
		}
		
		System.out.println();
		System.out.println("ORDER SUMARY: ");
		System.out.println(order);
		
		input.close();
	}

}
