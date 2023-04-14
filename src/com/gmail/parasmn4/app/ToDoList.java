package com.gmail.parasmn4.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ToDoList {
	
	private static File f;	
	
	public ToDoList() {
		f = new File("items.txt");
		
		if(f.exists()==false) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("File can not be created.."+e.getMessage());;
			}
		}
	}
	
	public void getList() {	
		
		 if(f.length()==0) {
			 System.out.println("No To-Do Item..");
			 return;
		 }
		 
		 Scanner scF = null;
		 try {	
			int i=1;
			scF = new Scanner(f);
			while(scF.hasNextLine()) {
				System.out.println(i+". "+scF.nextLine());
				i++;
			}
			scF.close();
		 }
		 
		 catch(IOException e) {
			 System.out.println("Error in get : "+e.getMessage());
		 }
	}
	
	
	
	public void addList(String item) {
		FileWriter fw=null;
		PrintWriter pw=null;
		try {
			fw = new FileWriter(f, true);
			pw = new PrintWriter(fw);
			pw.append("");
			pw.println(item);		
			pw.flush();			
		 }
		 
		 catch(IOException e) {
			 System.out.println("Error in add : "+e.getMessage());
		 }
		
		finally {
			pw.close();
		}
	}
	
	
	public void delList(int n) {
		
		File temp = new File("temp.txt");
		Scanner sc = null;
		PrintWriter pw = null;
		int i=1;
		
		try {
			pw = new PrintWriter(temp);
			sc = new Scanner(f);
			
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				if(i!=n) {
					pw.println(s);
				}
				i++;
			}
			
		} catch (IOException e) {
			
			System.out.println("Error in delete : "+e.getMessage());
		}
		
		finally {
			sc.close();
			pw.close();
			f.delete();
			temp.renameTo(f);
		}
	}
}
