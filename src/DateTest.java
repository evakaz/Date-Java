import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {
	Date dat = new Date(13,12,2002);
	
	@Test
	void testDate() {
		//Date dat = new Date();
		Date dat = new Date(13,12,2002);
	}
	@Test
	void testDate2(){
		Exception ex = assertThrows(Exception.class, () -> new Date(76,12,2002));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	@Test
	void testLeap() {
		Exception ex = assertThrows(Exception.class, () -> new Date(29, 2, 2002));
		assertEquals("The value is out of range.", ex.getMessage());
	}

	@Test
	void testLeapDone() {
		Date dat = new Date(29,2,2004);
		assertEquals(dat.displayDate(), "The current date is 29/2/2004");
	}
	
	@Test
	void testYr()
	{
		Exception ex = assertThrows(Exception.class, () -> new Date(29, 2, -1));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	
	@Test
	void testSetMonthFail(){
		Exception ex = assertThrows(Exception.class, () -> dat.setMonth(1000));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	@Test
	void testSetDayFail(){
		Exception ex = assertThrows(Exception.class, () -> dat.setDay(600));
		assertEquals("The value is out of range.", ex.getMessage());
	}

	@Test
	void testGetMonth() {
		assertEquals(dat.getMonth(),12);
	}

	@Test
	void testSetYearFail(){
		Exception ex = assertThrows(Exception.class, () -> dat.setYear(-1000));
		assertEquals("The value is out of range.", ex.getMessage());
	}
	
	@Test
	void testGetDay() {
		assertEquals(dat.getDay(),13);
	}


	@Test
	void testGetYear() {
		assertEquals(dat.getYear(), 2002);
	}


	@Test
	void testDisplayDate() {
		assertEquals(dat.displayDate(), "The current date is 13/12/2002");
	}
	

}