package week3;
import java.util.Comparator;

public class SoftBySalary implements Comparator<Person>{
  @Override
  public int compare(Person person1,Person person2) {
    if(person1.getSalary()> person2.getSalary()) {
      return 1;
    }
    return -1;
  }
}
