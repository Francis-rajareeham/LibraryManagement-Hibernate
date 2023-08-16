package com.libraryManagement;

import java.util.Scanner;




public class App {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		AppController ac = new AppController();
		boolean loop = true;
		System.out.println("LIBRARY MANAGEMENT SYSTEM");
		while(loop) {
			System.out.println("1. Book \n2. Author \n3. Member \n4. Exit");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				boolean a = true;
				while(a) {
					System.out.println("1. Add Book \n2. Update Book \n3. Delete Book \n4. Show All Books \n5. Exit");
					int bch = sc.nextInt();
					switch(bch) {
					case 1:
						ac.bookAdd();
						break;
					case 2:
						ac.bookUpdate();
						break;
					case 3:
						ac.bookDelete();
						break;
					case 4:
						ac.getAllBook();
						break;
					case 5:
						a = false;
					default:
						System.out.println("Invalid Input");
						a = false;
					}
				}
				break;
			case 2:
				boolean b = true;
				while(b) {
					System.out.println("1. Add Author \n2. Update Author \n3. Delete Author \n4. Show All Authors \n5. Exit");
					int ach = sc.nextInt();
					switch(ach) {
					case 1:
						ac.authorAdd();
						break;
					case 2:
						ac.authorUpdate();
						break;
					case 3:
						ac.authorDelete();
						break;
					case 4:
						ac.getAllAuthor();
						break;
					case 5:
						b = false;
						break;
					default:
						System.out.println("Invalid Input");
						b = false;
						break;
					}
				}
				break;
			case 3:
				boolean c = true;
				while(c) {
					System.out.println("1. Add Member \n2. Update Member \n3. Delete Member \n4. Show All Members \n5. Exit");
					int mch = sc.nextInt();
					switch(mch) {
					case 1:
						ac.memberAdd();
						break;
					case 2:
						ac.memberUpdate();
						break;
					case 3:
						ac.memberDelete();
						break;
					case 4:
						ac.getAllMember();
						break;
					case 5:
						c = false;
					default:
						System.out.println("Invalid Input");
						break;
					}
				}
				break;
			case 4:
				loop = false;
				break;
			default:
				System.out.println("Invalid Input");
				break;
				
			}
		}
	}
	
}



	
