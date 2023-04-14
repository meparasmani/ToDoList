package com.gmail.parasmn4.app;

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
		ToDoList td = new ToDoList();
		
		while(loop) {
			System.out.println("----------------------------------------");
			td.getList();			
			System.out.println("----------------------------------------\n");
			
			System.out.println("Choose your operation");
			System.out.println("1 : Add\n"
					         + "2 : Remove\n"
					         + "3 : Exit");
			
			int op = Integer.parseInt(scIn.nextLine());
			
			switch(op) {
			case 1: System.out.println("Type to do item : ");
					String e = scIn.nextLine();
					td.addList(e);
					break;
			case 2: 
				System.out.println("Item No to delete : ");
				int i = Integer.parseInt(scIn.nextLine());
				td.delList(i);
				break;
				
			case 3:
				loop=false;
				break;
				
			default : System.out.println("Enter valid option..");
			}
		}
		
		scIn.close();
	}
}