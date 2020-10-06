package com.assignment;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
public class AddressBookMain extends AddressBook{
	Scanner sc = new Scanner(System.in);
	LinkedList<AddressBook> linkAddressBook = new LinkedList<>();
	AddressBook addBook = new AddressBook();
	Map<String,AddressBook> addMapBook = new HashMap<>();
	public void addAddressBook(String s) {
		linkAddressBook.add(addBook);
		addMapBook.put(s, addBook);
	}
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
		AddressBookMain addMain = new AddressBookMain();
		do {
			System.out.println("Enter the option what you want to execute : 1. AddContact 2. Edit Contact 3. Delete Contact 4. Add an AddressBook 5. Exit");
			int option = sc.nextInt();
			switch(option) {
				case 1:
					addMain.addBook.addContact(addMain.getDetails());
					break;
				case 2:
					System.out.println("Enter the name you want to edit details for : ");
					String newName = sc.next();
					addMain.addBook.editContact(newName);
					break;
				case 3:
					System.out.println("Enter the person name you want to delete details for : ");
					String dName = sc.next();
					addMain.addBook.deleteContact(dName);
					break;
				case 4:
					System.out.println("Add an Address Book");
					String addressBookName = sc.next();
					addMain.addAddressBook(addressBookName);
					break;
				default:
					System.out.println("Thankyou");
					break;
			}
		System.out.println("Do you want to perform another operation ?(Y/N)");
		} while(sc.next().charAt(0) == 'Y');
		sc.close();
	}
}
