package week3;

import java.util.Scanner;

public class Employee extends Person {
  private String department;
  private int workDay;
  private String position;
  double allowance;
  double coefficientSalary;
  Scanner input = new Scanner(System.in);
  
  public Employee() {
	  super();
	  super.setCareer("NV");
  }
  
  public Employee(String name, int year, String address, double allowance, double coefficientSalary,
      String department, String position, int workDay) {
    super(name, year, address,"NV");
    this.department = department;
    this.workDay = workDay;
    this.position = position;
    this.allowance = allowance;
    this.coefficientSalary = coefficientSalary;
  }
  public double getAllowance() {
    return allowance;
  }
  public void setAllowance(String position) {
    if(position.equals("Truong Phong")) {
      this.allowance = 1000;
    }else if(position.equals("Pho Phong")) {
      this.allowance = 600;
    }else if(position.equals("Nhan Vien")) {
      this.allowance = 400;
    }
  }
  public double getCoefficientSalary() {
    return coefficientSalary;
  }
  public void setCoefficientSalary(double coefficientSalary) {
    this.coefficientSalary = coefficientSalary;
  }
  
  public String getDepartment() {
    return department;
  }
  public void setDepartment(String department) {
    this.department = department;
  }
  public int getWorkDay() {
    return workDay;
  }
  public void setWorkDay(int workDay) {
    this.workDay = workDay;
  }
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
  public double getSalary() {
    return (this.coefficientSalary*730+this.allowance+this.workDay*30);
  }
  @Override
  public void printInfor() {
	  super.printInfor();
	  System.out.printf("%-10s %-15s %-7s %-7s %-7s",this.getDepartment(),this.getPosition(),
	            this.getAllowance(),this.getWorkDay(),this.getCoefficientSalary());
  }
  public void inputInfor() {
	super.inputInfor();
    System.out.print("Nhap phong ban : ");
    this.setDepartment(inputMustString());
    System.out.println("Chon chuc vu : ");
    System.out.println("\t1.Nhan vien  2.Pho phong  3.Truong phong");
    int choose = input.nextInt();
    if(choose == 1) {
      this.setPosition("Nhan vien");
    }
    else if(choose == 2) {
      this.setPosition("Pho phong");
    }
    else if(choose == 3) {
      this.setPosition("Truong phong");
    }
    System.out.print("Nhap so ngay cong : ");
    this.setWorkDay(inputMustPositiveInt());
    System.out.print("Nhap he so luong : ");
    this.setCoefficientSalary(inputMustPositiveFloat());
    
    this.setAllowance(this.position);
  }
  
  public void edit() {
	    super.edit();
	    System.out.print("Nhap phong ban : ");
	    this.setDepartment(input.nextLine());
	    System.out.println("Chon chuc vu : ");
	    System.out.println("\t1.Nhan vien  2.Pho phong  3.Truong phong");
	    int choose = input.nextInt();
	    if(choose == 1) {
	      this.setPosition("Nhan vien");
	    }
	    else if(choose == 2) {
	      this.setPosition("Pho phong");
	    }
	    else if(choose == 3) {
	      this.setPosition("Truong phong");
	    }
	    System.out.print("Nhap so ngay cong : ");
	    this.setWorkDay(inputMustPositiveInt());
	    System.out.print("Nhap he so luong : ");
	    this.setCoefficientSalary(inputMustPositiveFloat());
	    
	    this.setAllowance(this.position);
  }
  
}
