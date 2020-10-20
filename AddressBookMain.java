package com.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {

	public static Map<String, AddressBook> addressBookMap = new HashMap<>();

	public static Contact getDetails(Scanner scanner) {
		System.out.println("Enter the first name");
		String firstName = scanner.nextLine();
		System.out.println("Enter the last name");
		String lastName = scanner.nextLine();
		System.out.println("Enter the address");
		String address = scanner.nextLine();
		System.out.println("Enter the city name");
		String city = scanner.nextLine();
		System.out.println("Enter the state name");
		String state = scanner.next();
		System.out.println("Enter the ZIP code");
		String zip = scanner.next();
		System.out.println("Enter the phone number");
		long phoneNumber = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the email");
		String email = scanner.nextLine();
		Contact c = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
		return c;
	}

	public static void addAddressBook(String city) {
		AddressBook addBook = new AddressBook(city);
		addressBookMap.put(city, addBook);
	}

	public void searchPersonByCity(String name, String city) {
		List<Contact> list = new ArrayList<Contact>();
		for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
			for (int i = 0; i < entry.getValue().getBook().size(); i++) {
				if (entry.getValue().getBook().get(i).getCity().equals(city)
						&& name.equals(entry.getValue().getBook().get(i).getFirstName()
								+ entry.getValue().getBook().get(i).getLastName())) {
					list.add(entry.getValue().getBook().get(i));
				}
			}
		}
		for (Contact c : list) {
			System.out.println(c);
		}
	}

	public void searchPersonByState(String name, String state) {
		List<Contact> list = new ArrayList<Contact>();
		for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
			for (int i = 0; i < entry.getValue().getBook().size(); i++) {
				if (entry.getValue().getBook().get(i).getState().equals(state)
						&& name.equals(entry.getValue().getBook().get(i).getFirstName()
								+ entry.getValue().getBook().get(i).getLastName())) {
					list.add(entry.getValue().getBook().get(i));
				}
			}
		}
		for (Contact c : list) {
			System.out.println(c);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AddressBookMain addBookMain = new AddressBookMain();
		int v;
		while (true) {
			System.out.println("1.to create addbook");
			System.out.println("2.to add person");
			System.out.println("3.to edit contact");
			System.out.println("4.to delete contact");
			System.out.println("5.to view addbook");
			System.out.println("6.to search contact in city");
			System.out.println("7.to search contact in state");
			System.out.println("8.exit");
			System.out.println("Enter what you want to do : ");
			v = scanner.nextInt();
			scanner.nextLine();
			switch (v) {
			case 1:
				System.out.println("Enter the city name to create addressBook");
				String City = scanner.nextLine();
				addAddressBook(City);
				break;
			case 2:
				System.out.println("Enter name of the addressBook you want to add contact in : ");
				String city = scanner.next();
				System.out.println("Enter the details of the contact you want to add : ");
				Contact c = getDetails(scanner);
				for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
					if (entry.getKey().equalsIgnoreCase(city)) {
						entry.getValue().addContact(c);
					}
				}
				break;
			case 3:
				System.out.println("Enter the name to edit contact");
				String x = scanner.nextLine();
				System.out.println("Enter the city");
				city = scanner.nextLine();
				for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
					if (entry.getKey().equalsIgnoreCase(city)) {
						entry.getValue().editContact(x);
					} else {
						System.out.println("The addressbook does not exist, please create addressbook for that city");
					}
				}
				break;
			case 4:
				System.out.println("Enter the name to delete");
				String y = scanner.nextLine();
				System.out.println("Enter the city");
				city = scanner.nextLine();
				for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
					if (entry.getKey().equalsIgnoreCase(city)) {
						entry.getValue().deleteContact(y);
					} else {
						System.out.println("The addressbook does not exist, please create addressbook for that city");
					}
				}
				break;
			case 5:
				for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
					System.out.println("The addressbook for city " + entry.getKey() + " is :");
					entry.getValue().viewList();
				}
				break;
			case 6:
				System.out.println("Enter the name to search");
				String person = scanner.nextLine();
				System.out.println("Enter the city");
				city = scanner.nextLine();
				addBookMain.searchPersonByCity(person, city);
				break;
			case 7:
				System.out.println("Enter the name to search");
				person = scanner.nextLine();
				System.out.println("Enter the state");
				String state = scanner.nextLine();
				addBookMain.searchPersonByState(person, state);
				break;
			case 8:
				System.exit(0);
				break;
				
			}
		}
	}
}