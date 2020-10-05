package com.assignment;

import java.util.Scanner;
public class AddressBookMain extends AddressBook{
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the address Book");
		AddressBook addBook = new AddressBook();
		AddressBookMain addMain = new AddressBookMain();
		System.out.println("Enter the option what you want to execute : 1. AddContact 2. Edit Contact 3. Delete Contact 4. Exit");
		int option = sc.nextInt();
		switch(option) {
			case 1:
				addBook.addContact(addMain.getDetails());
				break;
			case 2:
				System.out.println("Enter the name you want to edit details for : ");
				String newName = sc.next();
				addBook.editContact(newName);
				break;
			case 3:
				System.out.println("Enter the person name you want to delete details for : ");
				String dName = sc.next();
				addBook.deleteContact(dName);
				break;
			default:
				System.out.println("Exit");
				break;
		}
		sc.close();
	}
}
