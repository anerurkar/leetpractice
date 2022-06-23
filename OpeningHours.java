package com.leetcode.exercises;

import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * 
 * Wolt Home Assignment:
 * Create an app for opening hours
 * Human representation of a venue's open hours in java
 * https://github.com/firsthus/RestaurantOpeningHours.git - this is done in Java
 * Design a DB schema with relations for booking a table at the restaurant
 * Plenty of questions about asynchronous computations, high load
 * 
 *
 * https://stackoverflow.com/questions/7980364/which-is-the-best-way-to-represent-the-business-opening-hours-in-a-java-object
 * For example, do you need to override the standard opening days on certain
 * days of the year, e.g. closures for special events? What about public
 * holidays, do you open for these?
 * 
 * My simple suggested solution would be:
 * 
 * Create a database table with (day, opening time, closing time) as fields
 * Create a function that take a day and time as parameters, and looks up in the
 * database table to see if is within the opening/closing times for given day
 * Provide an easy way for business users to update the open/closing times after
 * pre-populating them with your standard times
 */
public class OpeningHours {

	public enum DAY {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	public OpeningHours(DAY day, Integer from, Integer to) {
		this.day = day;
		this.from = from; // format time using 800 for 8:00am or 2300 for 23:00
		this.to = to;
	}

	@Override
	public String toString() {
		return "OpeningHours [day=" + day + ", from=" + from + ", to=" + to + ", isAllDay=" + isAllDay + "]";
	}

	public OpeningHours() {

	}

	public DAY day;
	public Integer from;
	public Integer to;
	public boolean isAllDay = false;

	public void isOpenx(LocalDateTime start) {

	}

	public boolean isOpen(LocalDateTime start) {

		/*if (day.ordinal() != start.getDayOfWeek() - 1) {
			return false;
		}*/

		if (isAllDay)
			return true;

		String f = String.format("%04d", from);
		String t = String.format("%04d", to);

		Integer fh = Integer.valueOf(f.substring(0, 2));
		Integer fm = Integer.valueOf(f.substring(2));

		Integer th = Integer.valueOf(t.substring(0, 2));
		Integer tm = Integer.valueOf(t.substring(2));

		LocalDateTime intStart = start.withHour(fh).withMinute(fm);
		LocalDateTime intEnd = start.withHour(th).withMinute(tm);

		if (intStart.equals(start) || intEnd.equals(start)) {
			return true;
		}
		if (intStart.isBefore(start) && intEnd.isAfter(start)) {
			return true;
		}

		return false;

	}
//}
	//HashSet<OpeningHours> hours = new HashSet<OpeningHours>();hours.add(new OpeningHours(OpeningHours.DAY.MONDAY,800,1200));hours.add(new OpeningHours(OpeningHours.DAY.MONDAY,1230,1600));

	//LocalDateTime dateToCheck = new LocalDateTime(2012, 9, 4, 8, 00, 0, 0);

	/*for(
	OpeningHours item:hours)
	{
	 // boolean isOpen = item.isOpen(dateToCheck );
	  /*if (isOpen){
	    System.out.println("Is Open!");
	  }*/

}

