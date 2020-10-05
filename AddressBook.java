package com.assignment;
import java.util.ArrayList;
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
	
}

