package edu.disease.asn5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.disease.asn1.Disease;

class ContainerTest {

	@Test
	void testContainer() {
		Disease d = new Disease();
		Disease[]arr= new Disease[0];
		Container<Disease> di= new Container<Disease>(d);
		IllegalArgumentException exc=assertThrows(IllegalArgumentException.class, ()->{Container<Disease> d2= new Container<Disease>(arr);});
		assertEquals("No arguments provided.", exc.getMessage());
		
		

	}

	@Test
	void testSize() {
		Disease d = new Disease();
		Container<Disease> di= new Container<Disease>(d);
		assertEquals(di.size(),1);
	}

	@Test
	void testGet() {
		Disease d = new Disease();
		Container<Disease> di= new Container<Disease>(d);
		IllegalArgumentException exc=assertThrows(IllegalArgumentException.class, ()->{di.get(-1);});
		assertEquals("Invalid index.",exc.getMessage());
		IllegalArgumentException exc1=assertThrows(IllegalArgumentException.class, ()->{di.get(2);});
		assertEquals("Invalid index.",exc1.getMessage());
		assertEquals(di.get(0),d);
	}

}
