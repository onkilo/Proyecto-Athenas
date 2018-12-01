package util;

import java.time.LocalDate;

import com.github.lgooddatepicker.optionalusertools.DateVetoPolicy;

public class HoyVetoPolicy implements DateVetoPolicy{

	@Override
	public boolean isDateAllowed(LocalDate fecha) {
		if(fecha.isBefore(LocalDate.now())){
			return false;
		}
		return true;
	}

}
