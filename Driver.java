package impl;
import java.util.*;

import exceptions.ChoiceHandler;
import exceptions.EmailHandler;
import exceptions.IdHandler;
import exceptions.MyExceptions;
import exceptions.NameHandler;
import exceptions.PhoneNumberHandler;

public class Driver {
	public static void main(String[] args){
		System.out.println("welcome to Contact Management System");
		ContactManager ob = new ContactManager();
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			try {
				System.out.println("\n === Contact Management System Menu ===");
	            System.out.println("||1. Add a Contact                     ||");
	            System.out.println("||2. Search By Name                    ||");
	            System.out.println("||3. Search By Number                  ||");
	            System.out.println("||4. Display Contact                   || ");
	            System.out.println("||5. Delete Contact By ID              ||");
	            System.out.println("||6. Update Contact By ID              ||");
	            System.out.println("||7. Exit.                             ||");
	            System.out.println("========================================");
	            System.out.println("Enter your choice: ");   
	            String ch = sc.nextLine();
	            ChoiceHandler.check(ch);
	            int final_choice = Integer.parseInt(ch);
	            String cid = null, cnum = null, cname = null, cemail = null;
				switch(final_choice) {
				case 1: {
					try {
						boolean tempflag = true;
						int j=1;
						while(tempflag) {
							try {
								switch(j) {
									case 1:{
										System.out.println("Enter ID:");
										cid = sc.nextLine();
										IdHandler.check(cid);
										List<Contact> list = ob.getContactList();
										for (Contact i : list) {
											if (i.getId().equalsIgnoreCase(cid)) {
												throw new MyExceptions("ID already exists!");
											}
										}
										j++;
										break;
									}
									case 2:{
										System.out.println("Enter Name:");
										cname = sc.nextLine();
										NameHandler.check(cname);
										j++;
										break;
										
									}
									case 3:{
										System.out.println("Enter PhoneNumber:");
										cnum = sc.nextLine();
										PhoneNumberHandler.check(cnum);
										j++;
										break;
									}
									case 4:{
										System.out.println("Enter Email:");
										cemail = sc.nextLine();
										EmailHandler.check(cemail);
										j++;
										tempflag=false;
										break;
									}
								}
							}
							catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						if(j==5) {
							ob.addContact(new Contact(cid, cname, cnum, cemail));
							break;
						}
						else {
							throw new MyExceptions("Contact not created!");
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						break;
					}
				}
					case 2:{
						System.out.println("Enter the name you want to search:");
						try {
							String name = sc.nextLine();
							NameHandler.check(name);
							if(ob.searchByName(name))
								System.out.println("Present");
							else
								System.out.println("Contact Not Present");
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					}
					case 3:{
						try {
							System.out.println("Enter the number you want to search:");
							String num = sc.nextLine();
							PhoneNumberHandler.check(num);
							if(ob.searchByNumber(num))
								System.out.println("Present");
							else
								System.out.println("Contact Not Present");
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					}
					case 4:{
						ob.displayContacts();
						break;
					}
					case 5:{
						System.out.println("Enter the id you want to delete");
						try {
							String cid1 = sc.nextLine();
							IdHandler.check(cid1);
							if(ob.deleteById(cid1))	
								System.out.println("Deleted Succesfully");
							else
								System.out.println("ID not present");
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					}
					case 6:{
						try {
							System.out.println("Enter the id you want to update");					
							String id = sc.nextLine();
							IdHandler.check(id);
							System.out.println("Enter contact Name");
							String name = sc.nextLine();
							NameHandler.check(name);
							System.out.println("Enter contact PhoneNumber");
							String phone = sc.nextLine();
							PhoneNumberHandler.check(phone);
							System.out.println("Enter contact Email");
							String mail = sc.nextLine();
							EmailHandler.check(mail);
							if(ob.UpdateContact(id, name, phone, mail))
								System.out.println("Updated Successfully!");
							else
								System.out.println("Contact with the ID:"+id+" not present!");
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					}
					case 7:{
						System.out.println("thanks, closing the system");
						System.exit(0);
						sc.close();
						break;
					}
					default:{
						try {
							throw new MyExceptions("Input Mismatch");
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					}
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}