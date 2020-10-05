package com.assignment;
import java.util.Scanner;
public class AddressBookMain {
	Scanner sc = new Scanner(System.in);
	public Contact getDetails() {
		System.out.println("Enter your first name : ");
		String fName = sc.next();
		System.out.println("Enter your last name : ");
		String lName = sc.next();
		System.out.println("Enter your address : ");
		String address = sc.next();
		System.out.println("Enter your city name : ");
		String city = sc.next();
		System.out.println("Enter your state name : ");
		String state = sc.next();
		System.out.println("Enter your zip : ");
		int zip = sc.nextInt();
		System.out.println("Enter your phone number : ");
		long pNo = sc.nextLong();
		System.out.println("Enter your Email : ");
		String email = sc.next();
		Contact contact = new Contact(fName,lName,address,city,state,zip,pNo,email);
		return contact;
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to the address Book");
		new AddressBookMain().getDetails();
		
		
	}
}
