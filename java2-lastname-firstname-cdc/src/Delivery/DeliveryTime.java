package Delivery;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryTime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the destination count:");
		int n = sc.nextInt();

		User user = new User();
		user.addcus(n);
		System.out.println("Enter the Date(yyyy:MM:dd HH:mm)::");
		String da = sc.next();
		String[] dat = da.split(":");
		int year = Integer.parseInt(dat[0]);
		int month = Integer.parseInt(dat[1]);
		int dayOfMonth = Integer.parseInt(dat[2]);
		int hour = Integer.parseInt(dat[3]);
		int minute = Integer.parseInt(dat[4]);
		LocalDateTime currentTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
		System.out.println("Delivery DateandTime::" + user.addtime(currentTime));
	}
}

class User {
	List<String> destination = new ArrayList<String>();
	List<LocalTime> time = new ArrayList<LocalTime>();

	public void addcus(int n) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= n; i++) {

			if ((i != 1 && i != 2)) {
				System.out.println("Enter the time in hours for crossing two stations HH:mm:");
				String crossingTime = sc.next();
				String[] parts = crossingTime.split(":");
				int hours = Integer.parseInt(parts[0]);
				int min = Integer.parseInt(parts[1]);
				LocalTime t = LocalTime.of(hours, min);
				time.add(t);

			}
			System.out.println("Destination " + i + ":");
			String name = sc.next();
			destination.add(name);
		}

	}

	public LocalDateTime addtime(LocalDateTime lc) {
		for (LocalTime t : time) {
			lc = lc.plusHours(t.getHour()).plusMinutes(t.getMinute());
			if (lc.getDayOfWeek() == DayOfWeek.SATURDAY || lc.getDayOfWeek() == DayOfWeek.SUNDAY) {
				if (lc.getDayOfWeek() == DayOfWeek.SATURDAY) {
					lc = lc.plusHours(24).plusMinutes(0);
				}
				if (lc.getDayOfWeek() == DayOfWeek.SUNDAY) {
					lc = lc.plusHours(24).plusMinutes(0);
				}
			} else if (((lc.getMonth() == Month.JANUARY) && (lc.getDayOfMonth() == 1))
					|| ((lc.getMonth() == Month.AUGUST) && (lc.getDayOfMonth() == 15))
					|| ((lc.getMonth() == Month.JANUARY) && (lc.getDayOfMonth() == 26))
					|| ((lc.getMonth() == Month.FEBRUARY) && (lc.getDayOfMonth() == 29))) {
				System.out.println(lc.getDayOfWeek() + " " + t.getHour());
				lc = lc.plusHours(24).plusMinutes(0);
			}
		}
		return lc;
	}
}
