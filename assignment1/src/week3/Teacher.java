package week3;

import java.util.Scanner;

public class Teacher extends Person {
  String faculty;
  String degree;
  int lesson;
  double allowance;
  double coefficientSalary;
  Scanner input = new Scanner(System.in);
  public Teacher() {
    super();
    super.setCareer("GV");
  }
  
  public Teacher(String name, int year, String address, double allowance, double coefficientSalary,
      String faculty, String degree, int lesson) {
    super(name, year, address,"GV");
    this.faculty = faculty;
    this.degree = degree;
    this.lesson = lesson;
    this.allowance = allowance;
    this.coefficientSalary = coefficientSalary;
    
  }
  public String getFaculty() {
    return faculty;
  }
  public void setFaculty(String faculty) {
    this.faculty = faculty;
  }
  public String getDegree() {
    return degree;
  }
  public void setDegree(String degree) {
    this.degree = degree;
  }
  public int getLesson() {
    return lesson;
  }
  public void setLesson(int lesson) {
    this.lesson = lesson;
  }
  public double getAllowance() {
    return allowance;
  }

  public void setAllowance(String degree) {
    if(degree.equals("Cu Nhan")) {
      this.allowance = 300;
    }else if(degree.equals("Thac Si")) {
      this.allowance = 900;
    }else if(degree.equals("Tien Si")) {
      this.allowance = 2000;
    }    
  }
  public double getCoefficientSalary() {
    return coefficientSalary;
  }

  public void setCoefficientSalary(double coefficientSalary) {
    this.coefficientSalary = coefficientSalary;
  }
  public double getSalary() {
    double salary = this.coefficientSalary*730+this.allowance+this.lesson*45;
    return salary;
  }
  @Override
  public void printInfor() {
	  super.printInfor();
	  System.out.printf("%-10s %-15s %-7s %-7s %-7s",this.getFaculty(),this.getDegree(),
	            this.getAllowance(),this.getLesson(),this.getCoefficientSalary());
  }
  public void inputInfor() {
	super.inputInfor();
    System.out.print("Nhap khoa : ");
    this.setFaculty(inputMustString());
    System.out.println("Chon trinh do : ");
    System.out.println("\t1.Cu nhan 2.Thac si 3.Tien si");
    int choose = input.nextInt();
    if(choose == 1) {
      this.setDegree("Cu nhan");
    }
    else if(choose == 2) {
      this.setDegree("Thac si");
    }
    else if(choose == 3) {
      this.setDegree("Tien si");
    }
    System.out.print("Nhap so tiet day/thang : ");
    this.setLesson(inputMustPositiveInt());
    System.out.print("Nhap he so luong : ");
    this.setCoefficientSalary(inputMustPositiveFloat());
    input.nextLine();
    this.setAllowance(this.degree);
  }
  
  public void edit() {
	  super.edit();
	  System.out.print("Nhap khoa : ");
	  this.setFaculty(inputMustString());
	  System.out.println("Chon trinh do : ");
	  System.out.println("\t1.Cu nhan 2.Thac si 3.Tien si");
	  int choose = input.nextInt();
	  if(choose == 1) {
	    this.setDegree("Cu nhan");
	  }
	  else if(choose == 2) {
	    this.setDegree("Thac si");
	  }
	  else if(choose == 3) {
	    this.setDegree("Tien si");
	  }
	  System.out.print("Nhap so tiet day/thang : ");
	  this.setLesson(inputMustPositiveInt());
	  System.out.print("Nhap he so luong : ");
	  this.setCoefficientSalary(inputMustPositiveFloat());
	  input.nextLine();
	  this.setAllowance(this.degree);
  }
}