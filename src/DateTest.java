import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {
	Date dat = new Date(13,12,2002);
	
	@Test
	void testDate() {
		//Date dat = new Date();
	}

	@Test
	void testGetMonth() {
		assertEquals(dat.getMonth(),12);
	}

	@Test
	void testSetMonthFail(){
		Exception ex = assertThrows(Exception.class, () -> dat.setMonth(1000));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	
	@Test
	void testGetDay() {
		assertEquals(dat.getDay(),13);
	}

	@Test
	void testSetDay() {
		fail("Not yet implemented");
	}

	@Test
	void testGetYear() {
		assertEquals(dat.getYear(), 2002);
	}

	@Test
	void testSetYear() {
		fail("Not yet implemented");
	}

	@Test
	void testDisplayDate() {
		assertEquals(dat.displayDate(), "The current date is 13.12.2022");
	}
	

}