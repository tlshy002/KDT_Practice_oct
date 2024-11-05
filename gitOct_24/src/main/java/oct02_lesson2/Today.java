package oct02_lesson2;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class Today {
	public String hhmmss() {
		
		String hms = "";
		int hh = gc.get(Calendar.HOUR_OF_DAY);
		if(hh < 10) {
			hms = hms + "0" + hh + ":"; //int자료형과 String이 더해져서 => String이 되기때문에 hms변수에 담길수있음
		}else {
			hms = hms + hh + ":";			
		}
		
		int mm = gc.get(Calendar.MINUTE);
		if(mm < 10) {
			hms = hms + "0" + mm + ":";
		}else {
			hms = hms + mm + ":";			
		}
		int ss = gc.get(Calendar.SECOND);
		if(ss < 10) {
			hms = hms + "0" + ss;
		}else {
			hms = hms + ss;			
		}
		
		
		hms = gc.get(Calendar.HOUR_OF_DAY) + ":";
		return "D";
	}
	
	public Today() {}
	GregorianCalendar gc = new GregorianCalendar();
	public String yyyymmdd() {
		String ymd = "";
		ymd = gc.get(Calendar.YEAR) + "/";
		ymd = ymd + (gc.get(Calendar.MONTH)+1) + "/";
		int date = gc.get(Calendar.DATE);
		if(date < 10) {
			ymd = ymd + "0" + date;
		} else 
			ymd += date;
		return ymd;
	}
	public static void main(String[] args) {

	}
}
