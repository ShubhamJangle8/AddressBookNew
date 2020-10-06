package com.assignment;
import java.util.LinkedList;
import java.util.Scanner;
public class AddressBook {
	LinkedList<Contact> addressBook;
	String addLocation;
	public AddressBook() {
		addressBook = new LinkedList<Contact>();
	}
	public AddressBook(String msg) {
		this.addLocation = msg;
	}
	public void addContact(Contact contact) {
		addressBook.add(contact);
	}
	public LinkedList<Contact> getArray(){
		return addressBook;
	}
	public void setArrayList(LinkedList<Contact> array) {
		this.addressBook = array; 
	}
	public void editContact(String newName) {
		for(Contact contact:addressBook) {
			if(newName.equalsIgnoreCase(contact.getFirstName())) {
				Scanner sc = new Scanner(System.in);
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
	public void deleteContact(String name) {
		for(int i = 0; i < addressBook.size(); i++) {
			if(name.equals(addressBook.get(i).getFirstName())) {
				addressBook.remove(addressBook.get(i));
			}
		}
	}
}

