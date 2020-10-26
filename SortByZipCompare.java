package com.addressbook;

import java.util.Comparator;

public class SortByZipCompare implements Comparator<Contact>{
	public int compare(Contact a, Contact b) {
		return Integer.parseInt(a.getZip()) - Integer.parseInt(b.getZip());
	}
}
