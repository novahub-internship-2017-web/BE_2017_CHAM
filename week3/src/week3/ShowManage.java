package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ShowManage {
	public static List<Person> list = new ArrayList<Person>();
	public static Scanner input = new Scanner(System.in);

	public Teacher addTeacher() {
		Teacher obj = new Teacher();
		obj.inputInfor();
		return obj;
	}

	public Employee addEmployee() {
		Employee obj = new Employee();
		obj.inputInfor();
		return obj;
	}

	public void addPersonToList(int choose1) {
		System.out.println("Moi ban chon kieu can bo?(1.giao vien/ 2.nhan vien)");
		int chose = input.nextInt();
		Person obj = new Person();
		if (chose == 1) {
			obj = new Teacher();
			obj = addTeacher();
		} else if (chose == 2) {
			obj = new Employee();
			obj = addEmployee();
		}
		switch (choose1) {
		case 1:
			list.add(obj);
			break;
		case 2:
			list.add(0, obj);
			break;
		case 3:
			System.out.print("Vi tri muon them vao : ");
			int number = input.nextInt();
			list.add(number, obj);
			break;
		default:
			break;
		}
	}

	public void editPerson(Person obj) {
		if (obj.getCareer() == "GV") {
			Teacher teacher = (Teacher) obj;
			teacher.edit();
		} else if (obj.getCareer() == "NV") {
			Employee employee = (Employee) obj;
			employee.edit();
		}
	}

	public void colsNameDisplay() {
		System.out.printf("%-3s %-15s %-8s %-10s %-4s %-10s %-15s %-7s %-7s %-7s", "STT", "Ten", "Nam sinh", "Que quan",
				"Loai", "C1", "C2", "C3", "C4", "C5");
	}

	public void displayList(List<Person> listPerson) {
		colsNameDisplay();
		for (int i = 0; i < listPerson.size(); i++) {
			System.out.print("\n");
			System.out.printf("%-3s ", i);

			if (listPerson.get(i).getCareer() == "GV") {
				Teacher obj1 = (Teacher) listPerson.get(i);
				obj1.printInfor();
			}
			if (listPerson.get(i).getCareer() == "NV") {
				Employee obj1 = (Employee) listPerson.get(i);
				obj1.printInfor();

			}
		}
	}

	public void sortBySalary() {
		List<Person> listSortBySalary = new ArrayList<Person>();
		listSortBySalary.addAll(list);
		Collections.sort(listSortBySalary, new SoftBySalary());
		displayList(listSortBySalary);
	}

	public void sortByName() {
		List<Person> listSortByName = new ArrayList<Person>();
		listSortByName.addAll(list);
		Collections.sort(listSortByName, new Comparator<Person>() {
			@Override
			public int compare(Person obj1, Person obj2) {
				return (obj1.getName().compareTo(obj2.getName()));
			}
		});
		displayList(listSortByName);
	}

	public void searchByName() {
		input.nextLine();
		System.out.print("Nhap ten muon tim kiem : ");
		String nameSearch = input.nextLine().toLowerCase();
		String name = "";
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			name = list.get(i).getName().toLowerCase();
			if (name.contains(nameSearch)) {
				count++;
				if (count == 1) {
					colsNameDisplay();
				}
				System.out.println();
				System.out.printf("%3s\t ", i);
				list.get(i).printInfor();
			}
		}
		if (count == 0) {
			System.out.println("Khong tim thay.");
		}
	}

	public void searchByYear() {
		input.nextLine();
		System.out.print("Nhap nam sinh muon tim kiem : ");
		int yearSearch = input.nextInt();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getYear() == yearSearch) {
				count++;
				if (count == 1) {
					colsNameDisplay();
				}
				System.out.println();
				System.out.printf("%3s\t ", i);
				list.get(i).printInfor();
			}
		}
		if (count == 0) {
			System.out.println("Khong tim thay.");
		}
	}

	public void show() {
		String choose;
		do {
			System.out.println("+---------------MENU---------------+");
			System.out.println("|1)Them moi can bo                 |");
			System.out.println("|2)Chinh sua thong tin can bo      |");
			System.out.println("|3)Xoa can bo                      |");
			System.out.println("|4)Hien thi danh sach can bo       |");
			System.out.println("|5)Thoat chuong trinh              |");
			System.out.println("+----------------------------------+");
			System.out.println("|Moi ban chon chuc nang(1->5)...   |");
			System.out.println("+----------------------------------+");
			Scanner keyboard = new Scanner(System.in);
			int i = keyboard.nextInt();
			switch (i) {
			case 1:
				System.out.println("+---------------MENU2--------- ----+");
				System.out.println("|1)Them can bo vao cuoi danh sach  |");
				System.out.println("|2)Them can bo vao dau danh sach   |");
				System.out.println("|3)Them can bo vao sau vi tri thu k|");
				System.out.println("|4)Quay lai muc truoc              |");
				System.out.println("+----------------------------------+");
				System.out.println("|Moi ban chon chuc nang(1->4)...   |");
				System.out.println("+----------------------------------+");
				int ii = keyboard.nextInt();
				switch (ii) {
				case 1:
					do {
						addPersonToList(1);
						System.out.print("Ban co muon nhap them can bo (y/n) : ");
					} while (input.next().equals("y"));
					break;
				case 2:
					do {
						addPersonToList(2);
						System.out.print("Ban co muon nhap them can bo (y/n) : ");
					} while (input.next().equals("y"));
					break;
				case 3:
					do {
						addPersonToList(3);
						System.out.print("Ban co muon nhap them can bo (y/n) : ");
					} while (input.next().equals("y"));
					break;
				case 4:
					show();
				}
				break;
			case 2:
				System.out.print("Nhap so thu tu can bo muon sua : ");
				int edit_position = input.nextInt();
				if (edit_position < list.size()) {
					editPerson(list.get(edit_position));
				} else {
					System.out.println("Khong co can bo tai stt " + edit_position);
				}
				break;
			case 3:
				System.out.print("Nhap so thu can bo can xoa : ");
				int iii = keyboard.nextInt();
				list.remove(iii);
				break;
			case 4:
				System.out.println("+-------------------MENU3-------------------+");
				System.out.println("|1)Hien thi danh sach hien tai              |");
				System.out.println("|2)Hien thi danh sach theo luong tang dan   |");
				System.out.println("|3)Hien thi danh sach theo ten chu cai      |");
				System.out.println("|4)Tim kiem can bo theo ten                 |");
				System.out.println("|5)Tim kiem can bo theo nam sinh            |");
				System.out.println("+-------------------------------------------+");
				System.out.println("|Moi ban chon chuc nang(1->5)...            |");
				System.out.println("+-------------------------------------------+");
				int iiii = keyboard.nextInt();
				switch (iiii) {
				case 1:
					displayList(list);
					System.out.println();
					break;
				case 2:
					sortBySalary();
					System.out.println();
					break;
				case 3:
					sortByName();
					System.out.println();
					break;
				case 4:
					searchByName();
					System.out.println();
					break;
				case 5:
					searchByYear();
					System.out.println();
					break;
				default:
					break;
				}
				break;
			case 5:
				System.exit(0);
			}
			System.out.println("Ban co muon thuc hien tiep chu nang(c/k)?");
			choose = keyboard.next();
		} while (choose != "c");
	}
}