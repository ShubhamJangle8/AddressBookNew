package com.addressbook;

import java.util.Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class AddressBookFileService {
	public static String FILE_NAME = "AddressBook.txt";
	public static String CSV_FILE_NAME = "C:\\Users\\DELL\\eclipse-workspace\\AddressBookGradel\\src\\main\\java\\com\\addressbook\\addressbook.csv";
	public static String GSON_FILE_NAME = "C:\\Users\\DELL\\eclipse-workspace\\AddressBookGradel\\src\\main\\java\\com\\addressbook\\addressbook.json";

	public void writeData(Map<String, AddressBook> stateAddressBookMap) {
		StringBuffer personBuffer = new StringBuffer();
		stateAddressBookMap.values().stream().map(book -> book.getBook()).forEach(list -> {
			list.forEach(person -> {
				String empString = person.toString().concat("\n");
				personBuffer.append(empString);
			});
		});
		try {
			Files.write(Paths.get(FILE_NAME), personBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readData() {
		try {
			Files.lines(new File(FILE_NAME).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeDataCSV(Map<String, AddressBook> stateAddressBookMap) {

		File file = new File(CSV_FILE_NAME);

		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			List<String[]> data = new ArrayList<String[]>();
			String[] header = { "FName", "LName", "Address", "City", "State", "ZIP", "PhoneNo",
					"Email ID" };
			data.add(header);
			stateAddressBookMap.values().stream().map(entry -> entry.getBook())
					.forEach(listEntry -> listEntry.forEach(person -> {
						String[] personData = { person.getFirstName(), person.getLastName(), person.getAddress(),
								person.getCity(), person.getState(), person.getZip(),
								Long.toString(person.getPhoneNumber()), person.getEmail() };
						data.add(personData);
					}));

			writer.writeAll(data);
			writer.close();
			System.out.println("Data entered successfully to addressbook.csv file.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void readDataCSV() {
		try {
			FileReader filereader = new FileReader(CSV_FILE_NAME);
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;

			// we are going to read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
			csvReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeDataGSON(Map<String, AddressBook> stateAddressBookMap) {
		try {
			Gson gson = new Gson();
			FileWriter writer = new FileWriter(GSON_FILE_NAME);
			stateAddressBookMap.values().stream().map(entry -> entry.getBook())
					.forEach(listEntry -> listEntry.forEach(person -> {
						String json = gson.toJson(person);
						try {
							writer.write(json);
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}));
			writer.close();
			System.out.println("Data entered successfully to addressbook.json file.");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public void readDataGSON() {
		Gson gson = new Gson();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(GSON_FILE_NAME));
			JsonStreamParser parser = new JsonStreamParser(bufferedReader);
			while (parser.hasNext()) {
				JsonElement json = parser.next();
				if (json.isJsonObject()) {
					Contact person = gson.fromJson(json, Contact.class);
					System.out.println(person);
				}
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

}
