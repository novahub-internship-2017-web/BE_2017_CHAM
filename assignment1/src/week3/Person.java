package week3;

import java.util.Scanner;

public class Person {
	String name;
	int year;
	String address;
	private String career;
	Scanner input = new Scanner(System.in);

	public Person() {

	}

	public Person(String name, int year, String address, String career) {
		this.name = name;
		this.year = year;
		this.address = address;
		this.career = career;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return 0;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public void printInfor() {
		System.out.printf("%-15s %-8s %-10s %-4s ", this.getName(), this.getYear(), this.getAddress(),
				this.getCareer());
	}

	public void edit() {
		System.out.print("Nhap ten : ");
		this.setName(inputMustString());// name
		System.out.print("Nhap nam sinh : ");
		setYear(inputMustPositiveInt());
		System.out.print("Nhap que quan : ");
		setAddress(inputMustString());
	}

	public void inputInfor() {
		System.out.print("Nhap ten : ");
		this.setName(inputMustString());// name
		System.out.print("Nhap nam sinh : ");
		setYear(inputMustPositiveInt());
		System.out.print("Nhap que quan : ");
		setAddress(inputMustString());

	}

	String inputMustString() {
		Scanner input = new Scanner(System.in);
		String str;
		while (!input.hasNextLine()) {
			System.out.println("That's not a line");
			input.next(); // this is important!
		}
		str = input.nextLine();
		return str;
	}

	Integer inputMustPositiveInt() {
		int number;
		do {
			while (!input.hasNextInt()) {
				System.out.println("That must a integer number!");
				input.next(); // this is important!
			}
			number = input.nextInt();
			if (number <= 0) {
				System.out.println("That must a positive number!");
			}
		} while (number <= 0);
		return number;

	}

	Float inputMustPositiveFloat() {
		float number;
		do {
			while (!input.hasNextFloat()) {
				System.out.println("That must a float number!");
				input.next(); // this is important!
			}
			number = input.nextFloat();
			if (number <= 0) {
				System.out.println("That must a positive number!");
			}
		} while (number <= 0);
		return number;

	}

}
