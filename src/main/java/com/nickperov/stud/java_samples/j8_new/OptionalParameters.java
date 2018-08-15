package com.nickperov.stud.java_samples.j8_new;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class OptionalParameters {
	
	public static final int getDayOfWeek(Optional<Date> date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date.get());
		
		return c.get(Calendar.DAY_OF_WEEK);
	}
}
