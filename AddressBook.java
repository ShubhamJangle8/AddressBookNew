package com.assignment;
import java.util.ArrayList;
import java.util.Scanner;
public class AddressBook {
	ArrayList<Contact> addressBook;
	public AddressBook() {
		addressBook = new ArrayList<Contact>();
	}
	public void addContact(Contact contact) {
		addressBook.add(contact);
	}
	public ArrayList<Contact> getArray(){
		return addressBook;
	}
	public void setArrayList(ArrayList<Contact> array) {
		this.addressBook = array; 
	}
	public void editContact(String newName) {
		Scanner sc = new Scanner( System.in);
		for(Contact contact:addressBook) {
			if(newName.equalsIgnoreCase(contact.getFirstName())) {
				System.out.println("Enter what you want to change : ");
				int choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter your new address : ");
					String newAddress = sc.next();
					contact.setAddress(newAddress);
					break;
				case 2:
					System.out.println("Enter your new city name : ");
					String newCity = sc.next();
					contact.setCity(newCity);
					break;
				case 3:
					System.out.println("Enter your new state name : ");
					String newState = sc.next();
					contact.setState(newState);
					break;
				case 4:
					System.out.println("Enter your new zip : ");
					int newZip = sc.nextInt();
					contact.setZip(newZip);
					break;
				case 5:
					System.out.println("Enter your new phone number : ");
					long newPNo = sc.nextLong();
					contact.setPhoneNo(newPNo);
					break;
				case 6:
					System.out.println("Enter your new Email : ");
					String newEmail = sc.next();
					contact.setEmail(newEmail);
					break;
				default:
					break;
				}
			}
			else {
				System.out.println("No such contact exists");
			}
		}
	}
}

