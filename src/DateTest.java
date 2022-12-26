import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {
	
	@Test
	void testInvalidConstructorDate() {
		Exception ex = assertThrows(Exception.class, () -> new Date(76,12,2002));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	@Test
	void testNonLeap() {
		Exception ex = assertThrows(Exception.class, () -> new Date(29, 2, 2002));
		assertEquals("The value is out of range.", ex.getMessage());
	}

	@Test
	void testLeap() {
		Date dat = new Date(29,2,2004);
		assertEquals(dat.displayDate(), "The current date is 29/2/2004");
		assertThrows(Exception.class, () -> dat.setYear(2005));
	}
	
	@Test
	void testInvalidYear() {
		Exception ex = assertThrows(Exception.class, () -> new Date(29, 2, -1));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	
	@Test
	void testSetMonthFail() {
		Date dat = new Date(13, 12, 2002);
		Exception ex = assertThrows(Exception.class, () -> dat.setMonth(1000));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	@Test
	void testSetDayFail() {
		Date dat = new Date(13, 12, 2002);
		Exception ex = assertThrows(Exception.class, () -> dat.setDay(600));
		assertEquals("The value is out of range.", ex.getMessage());
	}

	@Test
	void testGetMonth() {
		Date dat = new Date(13, 12, 2002);
		assertEquals(dat.getMonth(),12);
	}

	@Test
	void testSetYearFail() {
		Date dat = new Date(13, 12, 2002);
		Exception ex = assertThrows(Exception.class, () -> dat.setYear(-1000));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	
	@Test
	void testGetDay() {
		Date dat = new Date(13, 12, 2002);
		assertEquals(dat.getDay(),13);
	}


	@Test
	void testGetters() {
		Date dat = new Date(13, 12, 2002);
		assertEquals(dat.getYear(), 2002);
		assertEquals(dat.getMonth(), 12);
		assertEquals(dat.getDay(), 13);
	}


	@Test
	void testDisplayDate() {
		Date dat = new Date(13,12,2002);
		assertEquals(dat.displayDate(), "The current date is 13/12/2002");
	}

	@Test
	void testAddDay() {
		Date d = new Date(1,1,2000);
		d.addDay(32);
		assertEquals("The current date is 2/2/2000", d.displayDate());

	}
	
	@Test 
	void testAddDay2() {
		Date d = new Date(1,12,2000);
		d.addDay(31);
		assertEquals(d.displayDate(), "The current date is 1/1/2001");
	}
	

}