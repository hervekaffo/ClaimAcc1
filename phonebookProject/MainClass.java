package phonebookProject;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Initial Array Initialized with 3 persons
		Address johnDoeAdd = new Address("114 Market St", "St Louis", "MO", "63403");
		Person johnDoe = new Person("John", "", "Doe", "2456895241", johnDoeAdd);
		Address johnEDoeAdd = new Address("324 Main St", "St Charles", "MO", "63303");
		Person johnEDoe = new Person("John","E","Doe", "8475390126", johnEDoeAdd);
		Address johnMDoeAdd = new Address("574 Pole ave", "St. Peters", "MO", "63333");
		Person johnMDoe = new Person("John Michael","","West Doe", "5628592375", johnMDoeAdd);
		
		Person [] persons = new Person[3];
		persons[0] = johnDoe;
		persons[1] = johnEDoe;
		persons[2] = johnMDoe;

		//Display the Menu
		System.out.println("WELCOME TO PHONE THE BOOK APP");
		int choice = 1; // Variable to hold the user choice
		do {
			System.out.println("Enter you choice or 0(Zeoro) to quit");
			System.out.println("1 to Add new entries");
			System.out.println("2 to Search by first name");
			System.out.println("3 to Search by last name");
			System.out.println("4 to Search by full name");
			System.out.println("5 to Search by phone number");
			System.out.println("6 to Search by city or state");
			System.out.println("7 update a record for a given phone number");
			System.out.println("8 delete a record for a given phone number");
			System.out.println("9 Show all records in asc order ");
			choice = sc.nextInt();	
			
			switch (choice) {
			case 0: {
				System.out.println("Thank you for using the phone book app..");
				break;
			}
			case 1: {
				System.out.println("Enter the person information in format ");
				System.out.println("first middle last, street, city, state,zip code, phone");
				System.out.println("If No middle name, just enter first and last name");
				System.out.println("If you want to enter the fields separetely, just Enter N");
				Scanner sc1 = new Scanner(System.in);
				String in = sc1.nextLine();
				
				if(!in.equals("N")) { // The user decided to enter all input once
					String [] res = in.split(", ");
					String [] fullName = res[0].split(" ");
					System.out.println(fullName.length);
					String firstN = "";
					String lastN = "";
					String middleN = "";
					if(fullName.length == 3) {
						firstN = fullName[0];
						middleN = fullName[1];
						lastN = fullName[2];	
					}else if(fullName.length == 2) {
						firstN = fullName[0];
						middleN = "";
						lastN = fullName[1];	
					}
					String street = res[1];
					String city = res[2];
					String state = res[3];
					String zip = res[4];
					String phone = res[5];
					Address add = new Address(street, city, state, zip);
					Person p = new Person(firstN, middleN, lastN, phone, add);
					persons = addNewEntry(persons, p);
				}else { // The user want to enter the fields separately
					persons = addNewEntry(persons, null);
				}
				break;
			}
			case 2: {
				System.out.print("Enter the first Name you want to search: ");
				Scanner inpF = new Scanner(System.in);
				String fn = inpF.nextLine();
				Person [] fnSearchePerson = searchByFirstName(fn, persons);
				if(fnSearchePerson.length==0) {
					System.out.println("No person with the first name "+fn);
				}else {
					System.out.println("Persons with first name "+fn);
					listPersons(fnSearchePerson);
				}
				break;
			}
			case 3: {
				System.out.print("Enter the last Name you want to search: ");
				Scanner inpL = new Scanner(System.in);
				String ln = inpL.nextLine();
				Person [] lnSearchePerson = searchByLastName(ln, persons);
				if(lnSearchePerson.length==0) {
					System.out.println("No person with the last name "+ln);
				}else {
					System.out.println("Persons with last name "+ln);
					listPersons(lnSearchePerson);
				}
				
				break;
			}
			case 4: {
				System.out.print("Enter the full name in the format fitst milldle last: ");
				Scanner inpL = new Scanner(System.in);
				String name = inpL.nextLine();
				Person [] lnSearchePerson = searchByFullName(name, persons);
				if(lnSearchePerson.length==0) {
					System.out.println("No person with the full name "+name);
				}else {
					System.out.println("Persons with full name "+name);
					listPersons(lnSearchePerson);
				}
				break;
			}
			case 5: {
				System.out.print("Enter the 10 digits phone number you want to search: ");
				Scanner inpPn = new Scanner(System.in);
				String pn = inpPn.nextLine();
				Person [] lnSearchePerson = searchByPhoneNumber(pn, persons);
				if(lnSearchePerson.length==0) {
					System.out.println("No person with phone number "+pn);
				}else {
					System.out.println("Persons with phone number "+pn);
					listPersons(lnSearchePerson);
				}
				break;
			}
			case 6: {
				System.out.print("Enter the City or State you want to search: ");
				Scanner inpL = new Scanner(System.in);
				String citSt = inpL.nextLine();
				Person [] lnSearchePerson = searchByCityOrState(citSt, persons);
				if(lnSearchePerson.length==0) {
					System.out.println("No person with City or State "+citSt);
				}else {
					System.out.println("Persons with City or State "+citSt);
					listPersons(lnSearchePerson);
				}
				break;
			}
			case 7: {
				System.out.print("Enter the 10 digits phone number you want to update: ");
				Scanner inpPn = new Scanner(System.in);
				String pn = inpPn.nextLine();
				Person [] lnSearchePerson = searchByPhoneNumber(pn, persons);
				if(lnSearchePerson.length==0) {
					System.out.println("No person with phone number "+pn);
				}else {
					System.out.println("Persons with phone number "+pn);
					listPersons(lnSearchePerson);
				}
				
				System.out.println("What field you want to update?");
				int choice1 = 1;
				do {
					System.out.println("Enter you choice or 0(Zeoro) to quit");
					System.out.println("1 to update first name");
					System.out.println("2 to update the last name");
					System.out.println("3 to update the phone number");
					System.out.println("4 to update the Street");
					System.out.println("5 to update the city");
					System.out.println("6 to update the state");
					System.out.println("7 to update the Zip Code");
					Scanner ch = new Scanner(System.in);
					choice1 = ch.nextInt();
					
					switch (choice1) {
					case 0: {
						System.out.println("*You are Back to the main menu use 9 to see the updated record*");
						break;
					}
					case 1:
						System.out.println("The exixting first name is: "+lnSearchePerson[0].getFirstName());
						System.out.println("Enter the new first name");
						String newFirstName = inpPn.nextLine();
						updateName(lnSearchePerson[0], newFirstName);
						System.out.println("First name updated successfully");
						break;
					case 2:
						System.out.println("The exixting Last name is: "+lnSearchePerson[0].getLastName());
						System.out.println("Enter the new last name");
						String newLastName = inpPn.nextLine();
						updateLastName(lnSearchePerson[0], newLastName);
						System.out.println("Last name updated successfully");
						break;
					case 3:
						System.out.println("The exixting Phone number is: "+lnSearchePerson[0].getPhoneNumber());
						System.out.println("Enter the new Phone Number");
						String newPhone = inpPn.nextLine();
						updatePhone(lnSearchePerson[0], newPhone);
						System.out.println("Phone Number updated successfully");
						break;
					case 4:
						System.out.println("The exixting Street is: "+lnSearchePerson[0].getAddress().getStreet());
						System.out.println("Enter the new Street");
						String newStreet = inpPn.nextLine();
						updateStreet(lnSearchePerson[0], newStreet);
						System.out.println("Street updated successfully");
						break;
					case 5:
						System.out.println("The exixting city is: "+lnSearchePerson[0].getAddress().getCity());
						System.out.println("Enter the new City");
						String newCity = inpPn.nextLine();
						updateCity(lnSearchePerson[0], newCity);
						System.out.println("City updated successfully");
						break;
					case 6:
						System.out.println("The exixting State is: "+lnSearchePerson[0].getAddress().getState());
						System.out.println("Enter the new State");
						String newState = inpPn.nextLine();
						updateState(lnSearchePerson[0], newState);
						System.out.println("State updated successfully");
						break;
					case 7:
						System.out.println("The exixting Zip Code is: "+lnSearchePerson[0].getAddress().getZipCode());
						System.out.println("Enter the new Zip Code");
						String newZip = inpPn.nextLine();
						updateZip(lnSearchePerson[0], newZip);
						System.out.println("Zip Code updated successfully");
						break;
					default:
						System.out.println(choice1+" is not a valid choice");
						System.out.println();
						break;
					}
					
				} while (choice1 !=0);
				
				break;
				
			}
			case 8: {
				System.out.print("Enter the phone number for the person you want to delete: ");
				Scanner inpPn = new Scanner(System.in);
				String pn = inpPn.nextLine();
				Person [] lnSearchePerson = deleteByPhoneNumber(pn, persons);
				if(lnSearchePerson.length==0) {
					System.out.println("No person with phone number "+pn);
				}else {
					System.out.println("New list of Persons ");
					persons = lnSearchePerson;
					listPersons(persons);
				}
				break;
			}
			case 9: {
				listPersons(persons);
				break;
			}
			default:
				System.out.println(choice+" is not a valid choice");
				System.out.println();
				break;
			}
		}while(choice !=0);	

	}


	//Add a new record
	public static Person[] addNewEntry(Person [] p, Person pers) {
		if(pers == null) {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the person first name: ");
			String firstName = input.nextLine();
			System.out.print("Enter the person Middle name or press Enter if none: ");
			String middleName = input.nextLine();
			middleName = !middleName.equals("") ? middleName : ""; 
			System.out.print("Enter the person last name: ");
			String lastName = input.nextLine();
			System.out.print("Enter the person 10 digits phone number: ");
			String phone = input.nextLine();
			while(phone.length() != 10) {
				System.out.print("The phone number must be 10 digits try again: ");
				phone = input.nextLine();
			}
			
			System.out.print("Enter "+firstName+"'s street: ");
			String street = input.nextLine();
			System.out.print("Enter "+firstName+"'s City: ");
			String city = input.nextLine();
			System.out.print("Enter "+firstName+"'s State: ");
			String state = input.nextLine();
			System.out.print("Enter "+firstName+"'s Zip Code: ");
			String zip = input.nextLine();
			
			Address addr = new Address(street, city, state, zip);
			
			Person newP = new Person(firstName, middleName, lastName, phone, addr);
			
			Person [] p1 = new Person[p.length +1];
			for (int i= 0;  i< p1.length -1 ; i++) {
				p1[i] = p[i];
			}
			p1[p.length] = newP;
			return p1;
		}else {
			Person newP = pers;
			Person [] p1 = new Person[p.length +1];
			for (int i= 0;  i< p1.length -1 ; i++) {
				p1[i] = p[i];
			}
			p1[p.length] = newP;
			return p1;
		}
		
		
	}
	
	// List all the records
	public static void listPersons(Person [] p) {
		String [] pString = new String[p.length];
		for (int i = 0; i < pString.length; i++) {
			pString[i] = p[i].toString();
		}
		Arrays.sort(pString);
		for (int i = 0; i < pString.length; i++) {
			System.out.println(pString[i]);
		}
		System.out.println();
	}
	
	//Search By first Name
	public static Person[] searchByFirstName(String firstName, Person[] p) {
		int count = 0;
		for (int i = 0; i < p.length; i++) {
			if(p[i].getFirstName().equals(firstName)) {
				count++;
			}	
		}
		Person[] tmp = new Person[count];
		int x = count;
		for (int i = 0; i < p.length; i++) {
			if(p[i].getFirstName().equals(firstName)) {
				tmp[count - x] = p[i];
				x--;
			}	
		}
		
		return tmp;
	}
	
	//Search By last Name
		public static Person[] searchByLastName(String lastName, Person[] p) {
			int count = 0;
			for (int i = 0; i < p.length; i++) {
				if(p[i].getLastName().equals(lastName)) {
					count++;
				}	
			}
			Person[] tmp = new Person[count];
			int x = count;
			for (int i = 0; i < p.length; i++) {
				if(p[i].getLastName().equals(lastName)) {
					tmp[count - x] = p[i];
					x--;
				}	
			}
			
			return tmp;
		}
		
		//Search By phone number
		public static Person[] searchByPhoneNumber(String phoneNumber, Person[] p) {
			int count = 0;
			for (int i = 0; i < p.length; i++) {
				if(p[i].getPhoneNumber().equals(phoneNumber)) {
					count++;
				}	
			}
			Person[] tmp = new Person[count];
			int x = count;
			for (int i = 0; i < p.length; i++) {
				if(p[i].getPhoneNumber().equals(phoneNumber)) {
					tmp[count - x] = p[i];
					x--;
				}	
			}
			
			return tmp;
		}
		
		//Delete By phone number
		public static Person[] deleteByPhoneNumber(String phoneNumber, Person[] p) {
			int count = 0;
			for (int i = 0; i < p.length; i++) {
				if(!p[i].getPhoneNumber().equals(phoneNumber)) {
					count++;
				}	
			}
			Person[] tmp = new Person[count];
			int x = count;
			for (int i = 0; i < p.length; i++) {
				if(!p[i].getPhoneNumber().equals(phoneNumber)) {
					tmp[count - x] = p[i];
					x--;
				}	
			}
			
			return tmp;
		}
		
		//Search By City or state
		public static Person[] searchByCityOrState(String s, Person[] p) {
			int count = 0;
			for (int i = 0; i < p.length; i++) {
				if(p[i].getAddress().getCity().equals(s) || p[i].getAddress().getState().equals(s)) {
					count++;
				}	
			}
			Person[] tmp = new Person[count];
			int x = count;
			for (int i = 0; i < p.length; i++) {
				if(p[i].getAddress().getCity().equals(s) || p[i].getAddress().getState().equals(s)) {
					tmp[count - x] = p[i];
					x--;
				}	
			}
			
			return tmp;
		}
		
		//Search By Full name
		public static Person[] searchByFullName(String fullName, Person[] p) {
			String [] names = fullName.split(" ");
			int count = 0;
			for (int i = 0; i < p.length; i++) {
				if(p[i].getFirstName().equals(names[0]) && p[i].getMiddleName().equals(names[1]) && p[i].getLastName().equals(names[2])) {
					count++;
				}	
			}
			Person[] tmp = new Person[count];
			int x = count;
			for (int i = 0; i < p.length; i++) {
				if(p[i].getFirstName().equals(names[0]) && p[i].getMiddleName().equals(names[1]) && p[i].getLastName().equals(names[2])) {
					tmp[count - x] = p[i];
					x--;
				}	
			}
			
			return tmp;
		}
		
		//Update the person first name 
		public static void updateName(Person person, String newFirstName) {
			person.setFirstName(newFirstName);	
		}
		
		//Update the person last name 
		public static void updateLastName(Person person, String newLastName) {
			person.setLastName(newLastName);	
		}
		
		//Update the person Phone number
		private static void updatePhone(Person person, String newPhone) {
			person.setPhoneNumber(newPhone);		
		}
		
		//Update the person City
		private static void updateCity(Person person, String newCity) {
			person.getAddress().setCity(newCity);	
		}
		
		//Update the Person Street
		private static void updateStreet(Person person, String newStreet) {
			person.getAddress().setStreet(newStreet);	
		}
		
		//Update the person State
		private static void updateState(Person person, String newState) {
			person.getAddress().setState(newState);	
		}
		
		//Update the person Zip code 
		private static void updateZip(Person person, String newZip) {
			person.getAddress().setZipCode(newZip);	
		}

}
