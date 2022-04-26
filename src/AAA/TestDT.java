package AAA;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
//import java.util.Date; //java 8

public class TestDT {
	public static void WeileCode() 
	{
		LocalDateTime bday = LocalDateTime.of(2004, 2, 7, 0, 0, 0, 0); //china
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai")); 
//		sop("now:"+now);
//		
//		LocalDateTime now2 = LocalDateTime.now(); //US
//		sop("now2:"+now2);
		
		
		sop(now);
		sop(bday + "\n");
		long difference_sec = ChronoUnit.SECONDS.between(bday, now);
		long difference_min = ChronoUnit.MINUTES.between(bday, now);
		sop("Seconds passed since birth: " + difference_sec);
		sop("Minutes passed since birth: " + difference_min);

		LocalDate birthday = LocalDate.of(2004, 2, 7);
		int i;
		for (i = 0; i < 30; i++) {
			if (2022 - (2004 + i) < 1 && 2022 - (2004 + i) > -1) { //2022
				LocalDate lastbirthday = birthday.plusYears(i);
				sop("My last birthday was on: " + lastbirthday);
			} else if (2022 - (2004 + i) < 0 && 2022 - (2004 + i) > -2) {//2023
				LocalDate nextbirthday = birthday.plusYears(i);
				sop("My next birthday is on: " + nextbirthday);
				LocalDate today = LocalDate.now();
				long difference_day = ChronoUnit.DAYS.between(today, nextbirthday);
				sop("Days until my next birthday: " + difference_day);
			}

		}

	}
	
	
	public static void WeileCode2() 
	{
		LocalDateTime bday = LocalDateTime.of(2004, 2, 7, 0, 0, 0, 0); //china
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai")); 
//		sop("now:"+now);
//		
//		LocalDateTime now2 = LocalDateTime.now(); //US
//		sop("now2:"+now2);
		
		
		sop(now);
		sop(bday + "\n");
		long difference_sec = ChronoUnit.SECONDS.between(bday, now);
		long difference_min = ChronoUnit.MINUTES.between(bday, now);
		sop("Seconds passed since birth: " + difference_sec);
		sop("Minutes passed since birth: " + difference_min);
		
		MonthDay bornMD = MonthDay.of(2, 7);
		MonthDay nowMD = MonthDay.of(now.getMonthValue(), now.getDayOfMonth());
		if(nowMD.compareTo(bornMD)==0) {
			System.out.println("Birth day is today!");
		}
		
		if(nowMD.compareTo(bornMD)>0) {
			System.out.println("Birth day passed in this year!");
			//last birthday 
			LocalDate lastbday = LocalDate.of(now.getYear(), 2, 7);
			//next bithday
			LocalDate nextbday = LocalDate.of(now.getYear()+1, 2, 7);
			System.out.println("lastbday:"+lastbday+"  nextbday:"+nextbday);
		}else {
			System.out.println("Birth day coming soon in this year!");
			//last birthday 
			LocalDate lastbday = LocalDate.of(now.getYear()-1, 2, 7);
			//next bithday
			LocalDate nextbday = LocalDate.of(now.getYear(), 2, 7);
			System.out.println("lastbday:"+lastbday+"  nextbday:"+nextbday);
		}


	}
	
	
	public static void sop(Object o)
	{
		System.out.println(o);
	}

	public static void Birth() {
		LocalDateTime ldtBorndatetime = LocalDateTime.of(2004, 2, 7, 8, 30, 45);
		System.out.println(ldtBorndatetime);

		ZonedDateTime zdtnowChina = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println(zdtnowChina);

		LocalDateTime ldtnowChina = zdtnowChina.toLocalDateTime();
		System.out.println(ldtnowChina);

		Duration d = Duration.between(ldtBorndatetime, ldtnowChina); // Period 
		// System.out.println("Duration:"+d);
		System.out.println("weile's life in days:" + d.toDays()); // life:days
		System.out.println("weile's life in second:" + d.toSeconds());// life: second

		LocalDateTime nextbirthdatetime = ldtBorndatetime;
		do {
			nextbirthdatetime = nextbirthdatetime.plusYears(1);
		} while (nextbirthdatetime.isBefore(ldtnowChina));
		Duration d2 = Duration.between(ldtnowChina, nextbirthdatetime);
		System.out.println("after " + d2.toDays() + " days, it reach to birthday in " + nextbirthdatetime);

		LocalDateTime lastbirthdatetime = nextbirthdatetime.minusYears(1);
		System.out.println("last birthday in " + lastbirthdatetime);

	}

	public static void main(String[] args) {

		WeileCode2();
		if (true)
			return;

		LocalDateTime ldhere = LocalDateTime.now();
		System.out.println(ldhere + "  0000");

		ZonedDateTime there = ldhere.atZone(ZoneId.of("Asia/Shanghai"));
		System.out.println(there + "  不行");

		LocalDateTime ldhere2 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println(ldhere2 + "  方法2");

		ZonedDateTime zdhere = ZonedDateTime.now();
		System.out.println(zdhere + "  所在时区的时间");

		ZonedDateTime sh = zdhere.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
		System.out.println(sh + "  方法3");

		ZonedDateTime zd2 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println(zd2 + "  方法4");

	}

//	    ZoneId sh = ZoneId.of("America/New_York");
//        
//	    LocalDateTime localtDateAndTime = LocalDateTime.now();
//	        
//	    ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, sh );
//	   // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:MM:SS");
//		System.out.println("New: " + dateAndTimeInNewYork);
//
//		
//	    LocalDateTime datetime =  LocalDateTime.now();
//	    ZoneOffset offset = ZoneOffset.of("+03:00");
//	    OffsetDateTime date = OffsetDateTime.of(datetime, offset);  
//	    System.out.println("Date and Time with timezone offset in Java : " + date);
//	    
//	    Instant t = Instant.now();
//	    System.out.println(t.toString());  //2022-04-17   06:17:11 . 346380900 Z

//		
//		// TODO Auto-generated method stub
//		LocalDate today = LocalDate.now();
//		
//		LocalDateTime todaydt = LocalDateTime.now();
//		LocalDateTime future = todaydt.plusHours(300);
//		System.out.println(future.getDayOfYear()+"|"+future.getMonth()+"|"+future.getDayOfMonth());
//		
//		
//		
//		LocalDate oneday = LocalDate.of(2004, Month.of(2), 7);
//		
//		System.out.println(oneday.getDayOfWeek());
//		Period p = Period.between(oneday, today);
//		System.out.println(p.toString());
//		
//		
//		
//		System.out.println(today.toString());
//		System.out.println(today.getDayOfYear());
//		//today.getDayOfYear()
//		
//	}

}
