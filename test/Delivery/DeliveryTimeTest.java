package Delivery;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeliveryTimeTest {

	@Test
	public void testAddTimeWeekend() {
		User user = new User();

		LocalTime crossingTime = LocalTime.of(2, 30);
		user.time.add(crossingTime);

		LocalDateTime inputTime = LocalDateTime.of(2023, Month.AUGUST, 19, 12, 0);

		LocalDateTime result = user.addtime(inputTime);

		LocalDateTime expected = LocalDateTime.of(2023, Month.AUGUST, 21, 14, 30);
		assertEquals(expected, result);
	}

	@Test
	public void testAddTimeHoliday() {
		User user = new User();

		LocalTime crossingTime = LocalTime.of(3, 15);
		user.time.add(crossingTime);

		LocalDateTime inputTime = LocalDateTime.of(2023, Month.JANUARY, 1, 15, 30);

		LocalDateTime result = user.addtime(inputTime);

		LocalDateTime expected = LocalDateTime.of(2023, Month.JANUARY, 2, 18, 45);
		assertEquals(expected, result);
	}

	@Test
	public void testAddTimeRegular() {
		User user = new User();

		LocalTime crossingTime = LocalTime.of(1, 0);
		user.time.add(crossingTime);

		LocalDateTime inputTime = LocalDateTime.of(2023, Month.APRIL, 10, 8, 45);

		LocalDateTime result = user.addtime(inputTime);

		LocalDateTime expected = LocalDateTime.of(2023, Month.APRIL, 10, 9, 45);
		assertEquals(expected, result);
	}

	@Test
	public void testAddTimeSaturday() {
		User user = new User();

		LocalTime crossingTime = LocalTime.of(4, 0);
		user.time.add(crossingTime);

		LocalDateTime inputTime = LocalDateTime.of(2023, Month.AUGUST, 19, 20, 0);

		LocalDateTime result = user.addtime(inputTime);

		LocalDateTime expected = LocalDateTime.of(2023, Month.AUGUST, 21, 0, 0);
		assertEquals(expected, result);
	}

	@Test
	public void testAddTimeSunday() {
		User user = new User();

		LocalTime crossingTime = LocalTime.of(2, 15);
		user.time.add(crossingTime);

		LocalDateTime inputTime = LocalDateTime.of(2023, Month.AUGUST, 20, 15, 30);

		LocalDateTime result = user.addtime(inputTime);

		LocalDateTime expected = LocalDateTime.of(2023, Month.AUGUST, 21, 17, 45);
		assertEquals(expected, result);
	}

	@Test
	public void testAddTimeHolidaySkip() {
		User user = new User();

		LocalTime crossingTime = LocalTime.of(1, 0);
		user.time.add(crossingTime);

		LocalDateTime inputTime = LocalDateTime.of(2023, Month.JANUARY, 26, 12, 0);

		LocalDateTime result = user.addtime(inputTime);

		LocalDateTime expected = LocalDateTime.of(2023, Month.JANUARY, 27, 13, 0);
		assertEquals(expected, result);
	}

	@Test
	public void testAddTimeLeapYear1() {
		User user = new User();

		LocalTime crossingTime = LocalTime.of(3, 45);
		user.time.add(crossingTime);

		LocalDateTime inputTime = LocalDateTime.of(2024, Month.FEBRUARY, 28, 18, 30);

		LocalDateTime result = user.addtime(inputTime);

		LocalDateTime expected = LocalDateTime.of(2024, Month.FEBRUARY, 29, 22, 15);
		assertNotEquals(expected, result);
	}
	
}
