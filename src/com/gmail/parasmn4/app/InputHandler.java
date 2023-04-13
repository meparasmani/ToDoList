/**
 * 
 */
package com.gmail.parasmn4.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author parasmn4@gmail.com
 *
 */
public class InputHandler {
	static int itemNum=0;
	public static void  main(String args[]) {
		Scanner scIn = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("----------------------------------------");
			getList();			
			System.out.println("----------------------------------------\n");
			
			System.out.println("Choose your operation");
			System.out.println("1 : Add\n"
					         + "2 : Remove\n"
					         + "3 : Exit");
			
			int op = Integer.parseInt(scIn.nextLine());
			
			switch(op) {
			case 1: System.out.println("Type to do item : ");
					String e = scIn.nextLine();
					addList(e);
					break;
			case 2: 
				System.out.println("Item No to delete : ");
				int i = Integer.parseInt(scIn.nextLine());
				delList(i);
				break;
				
			case 3:
				loop=false;
				break;
				
			default : System.out.println("Enter valid option..");
			}
		}
		
		scIn.close();
	}
	
	
	
	public static void getList() {		 
		 Scanner scF = null;
		 try {
			File f = new File("items.txt");
			if(f.exists()==false) {
				f.createNewFile();
				System.out.println("To-Do Empty...");
			}
			
			else {
				int i=1;
				scF = new Scanner(f);
				while(scF.hasNextLine()) {
					System.out.println(i+". "+scF.nextLine());
					i++;
				}
				scF.close();
			}			
		 }
		 
		 catch(IOException e) {
			 System.out.println("Error in get : "+e.getMessage());
		 }
	}
	
	
	
	public static void addList(String item) {
		FileWriter fw;
		try {
			fw = new FileWriter("items.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			pw.append("");
			pw.println(item);
			itemNum++;
			
			
			pw.flush();
			pw.close();
			
		 }
		 
		 catch(IOException e) {
			 System.out.println("Error in add : "+e.getMessage());
		 }
		//getList();
	}
	
	
	public static void delList(int n) {
		File f = new File("items.txt");
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
