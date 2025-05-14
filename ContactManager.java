package impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.MyExceptions;

public class ContactManager {
	List<Contact> contactList = new ArrayList<>();
	
	public void addContact(Contact con) {
		contactList.add(con);
		System.out.println("Contact Added Successfully!");
	}
	public boolean searchByNumber(String num) {
		try {
			Contact x = contactList.stream().filter(e -> e.getPhoneNumber().equalsIgnoreCase(num)).findFirst().orElse(null);
			if(x!=null)
				System.out.println("Present");
		}catch(Exception e) {
			
		}
		return false;
	}
	public boolean searchByName(String name) {
		try {
			Contact x = contactList.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
			if(x!=null)
				System.out.println("Present");
		}catch(Exception e) {
			
		}
		return false;
	}
	public boolean deleteById(String id) {
		try {
			Iterator<Contact> iterator = contactList.iterator();
			while(iterator.hasNext()) {
				Contact x = iterator.next();
				if(x.getId().equalsIgnoreCase(id)) {
					iterator.remove();
					System.out.println("Contact with ID:"+id+" deleted!");
					return true;
				}
					
			}
			throw new MyExceptions("ID now found");			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
		
		
	}
	public boolean UpdateContact(String id, String name, String num, String mail) {
		Contact c;
		for(Contact x : contactList) {
			if(x.getId().equals(id)) {
				c = x;
				c.setEmail(mail);
				c.setName(name);
				c.setPhoneNumber(num);
				System.out.println("Contact Updated successfully: "+c);
				return true;
			}				
		}
		return false;
	}
	public void displayContacts() {
		System.out.println(".....Contact List.....");
		if(contactList.size()==0)
			System.out.println("Oops no contact present, pls add");
		for(Contact x : contactList) {
			System.out.println(x);
		}
	}
}
