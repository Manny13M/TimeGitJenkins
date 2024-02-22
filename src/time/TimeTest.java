package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	//GetTotalSeconds ==============================================================
	
	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		
		assertTrue("The total seconds were calculated properly", seconds==18305);
	}
	
	@Test
	void testGetTotalSecondsBad() {
		
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test
	void testGetTotalSecondsBoundary() {
		int seconds = Time.getTotalSeconds("05:59:59");
		
		assertTrue("The total seconds were calculated properly", seconds==21599);
	}
	
	//GetTotalHours ==============================================================
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
	void testGetTotalHours(String candidate) {
		
		int hours = Time.getTotalHours(candidate);
		
		assertTrue(
				"The hours were calculated properly",
				hours ==5);
	}

	
	//GetSeconds ==============================================================
	
	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("05:05:05");
		
		assertTrue("The seconds were calculated properly", seconds==05);
	}
	
	@Test
	void testGetSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test
	void testGetSecondsBoundary() {
		int seconds = Time.getSeconds("05:05:59");
		
		assertTrue("The seconds were calculated properly", seconds==59);
	}

	//GetTotalMinutes ==============================================================
	
	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("05:05:05");

		
		assertTrue("The minutes were calculated properly", minutes==05);
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(
				NumberFormatException.class,
				()-> {Time.getTotalMinutes("10:00:590");});
	}
	
	@Test
	void testGetTotalMinutesBoundary() {
		int minutes = Time.getTotalMinutes("05:59:05");

		
		assertTrue("The minutes were calculated properly", minutes==59);
	}
	
	//GetTotalHours ==============================================================

	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("05:05:05");
				

		assertTrue("The hours were calculated properly", hours==05);
	}
	
	@Test
	void testGetTotalHoursBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test
	void testGetTotalHoursBoundary() {
		int hours = Time.getTotalHours("23:05:05");
		

		assertTrue("The hours were calculated properly", hours==23);
	}

}
