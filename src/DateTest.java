import static org.junit.jupiter.api.Assertions.*;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;

class DateTest {
	@Category(BaseTests.class)
	@Test
	void testInvalidConstructorDate() {
		Exception ex = assertThrows(Exception.class, () -> new Date(76,12,2002));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	
	@Category(BaseTests.class)
	@Test
	void testNonLeap() {
		Exception ex = assertThrows(Exception.class, () -> new Date(29, 2, 2002));
		assertEquals("The value is out of range.", ex.getMessage());
	}

	@Category(BaseTests.class)
	@Test
	void testLeap() {
		Date dat = new Date(29,2,2004);
		assertEquals(dat.displayDate(), "The current date is 29/2/2004");
		assertThrows(Exception.class, () -> dat.setYear(2005));
	}
	
	@Category(BaseTests.class)
	@Test
	void testInvalidYear() {
		Exception ex = assertThrows(Exception.class, () -> new Date(29, 2, -1));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	
	@Category(BaseTests.class)
	@Test
	void testSetMonthFail() {
		Date dat = new Date(13, 12, 2002);
		Exception ex = assertThrows(Exception.class, () -> dat.setMonth(1000));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	
	@Category(BaseTests.class)
	@Test
	void testSetDayFail() {
		Date dat = new Date(13, 12, 2002);
		Exception ex = assertThrows(Exception.class, () -> dat.setDay(600));
		assertEquals("The value is out of range.", ex.getMessage());
	}

	@Category(BaseTests.class)
	@Test
	void testGetMonth() {
		Date dat = new Date(13, 12, 2002);
		assertEquals(dat.getMonth(),12);
	}

	@Category(BaseTests.class)
	@Test
	void testSetYearFail() {
		Date dat = new Date(13, 12, 2002);
		Exception ex = assertThrows(Exception.class, () -> dat.setYear(-1000));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	
	@Category(BaseTests.class)
	@Test
	void testGetDay() {
		Date dat = new Date(13, 12, 2002);
		assertEquals(dat.getDay(),13);
	}

	@Category(BaseTests.class)
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
		d.addDays(32);
		assertEquals("The current date is 2/2/2000", d.displayDate());

	}
	
	@Test 
	void testAddDay2() {
		Date d = new Date(1,12,2000);
		d.addDays(31);
		assertEquals(d.displayDate(), "The current date is 1/1/2001");
	}
	
	
	@Test
	void testAddDaysNeg() {
		Date d = new Date(9,1,2000);
		d.addDays(-2);
		assertEquals(d.displayDate(), "The current date is 7/1/2000");
		
	}
	
	
	@Test
	void testSubDay() {
		Date d = new Date(4,2,2001);
		d.subsctractDays(5);
		assertEquals(d.displayDate(), "The current date is 30/1/2001");
		
	}
	
	@Test
	void subDaysYear() {
		Date d = new Date(1,1,2000);
		d.subsctractDays(9);
		assertEquals("The current date is 23/12/1999", d.displayDate());
		
	}
	
	
	@Test
	void testSubDays2() {
		Date d = new Date(4,3,2004);
		d.subsctractDays(5);
		assertEquals("The current date is 28/2/2004", d.displayDate());
	}
	
	
	@Test
	void testSubDayNotNegative() {
		Date d = new Date(24,1,2002);
		d.subsctractDays(4);
		assertEquals(d.displayDate(), "The current date is 20/1/2002");
	}
	
	@Test 
	void testSubDaysException() {
		Date dat = new Date(13, 12, 2002);
		Exception ex = assertThrows(Exception.class, () -> dat.subsctractDays(-1000));
		assertEquals("The value cannot be negative.", ex.getMessage());
	}
	

}