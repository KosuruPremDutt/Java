package com.wipro.view;

import java.io.IOException;
import java.util.Scanner;

import com.wipro.controller.Customercontroller;
import com.wipro.controller.Customerinterface;

public class CustomerView {

	public static void main(String[] args) {

		Customerinterface cc = new Customercontroller();
		Scanner sc = new Scanner(System.in);
		String str = null;
		do {
			System.out.println("Enter your choice :");
			System.out.println("1. Add Customer");
			System.out.println("2. View Customer");
			System.out.println("3. Sort CustomerById");
			System.out.println("4. Sort CustomerByName");
			System.out.println("5. Serialize Customer");
			System.out.println("6. DeSerialize Customer");
			System.out.println("7/ Get Database info");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				cc.addCustomer();
				break;

			}
			case 2: {
				cc.viewCustomer();
				break;
			}
			case 3: {
				cc.sortCustomerByIdComparable();
				break;
			}
			case 4: {
				cc.sortCustomerByNameComparator();
				break;
			}
			case 5: {
				try {
					cc.serializeCustomer();
				} catch (IOException e) {

					e.printStackTrace();
				}
				break;
			}
			case 6: {
				try {
					cc.deSerializeCustomer();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 7: {
				cc.getDBMetaData();
				break;
			}
			case 8: {
				cc.insertusingProcedure();
				break;
			}
			default:
				System.out.println("Enter  the right choice ...");
			}
			System.out.println("Do u wanna continue? Y | y");
			str = sc.next();

		} while (str.equals("Y") || str.equals("y"));

		System.out.println("Thanks for using our application :)");
		System.exit(0);
	}

}