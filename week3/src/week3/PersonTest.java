package week3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	Person person = new Person();
	@Before
	  public void setUp() throws Exception {
	    person = new Person("Cham",1996,"QN","GV");
	  }
	@Test
	public void testPerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testPersonStringIntStringString() {
		assertEquals("cham", person.getName());
		assertEquals(1996,person.getYear());
		assertEquals("QN",person.getAddress());
		assertEquals("GV",person.getCareer());
	}

	@Test
	public void testGetSetName() {
		person.setName("cham");
		assertEquals("cham", person.getName());
	}


	@Test
	public void testGetSetYear() {
		person.setYear(1998);
	    assertEquals(1998,person.getYear());
	}

	@Test
	public void testGetSetAddress() {
		person.setAddress("QN");
	    assertEquals("QN",person.getAddress());
	}

	@Test
	public void testGetSetCareer() {
		person.setName("GV");
	    assertEquals("GV",person.getCareer());
	}

	@Test
	public void testPrintInfor() {
		fail("Not yet implemented");
	}

	@Test
	public void testEdit() {
		fail("Not yet implemented");
	}

	@Test
	public void testInputInfor() {
		fail("Not yet implemented");
	}

	@Test
	public void testInputMustString() {
		fail("Not yet implemented");
	}

	@Test
	public void testInputMustPositiveInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testInputMustPositiveFloat() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
