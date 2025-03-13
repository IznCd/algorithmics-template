package algstudent.s3.championship;

import java.time.Duration;
import java.time.Instant;

/* CALENDAR. CALCULATING TIMES FOR n=64,128,256,...*/
public class CalendarTimes { 
	public static void main (String arg [] ) {
	  for (int n=2; n<1000000; n*=2) {
		  Calendar calendar = new Calendar(n); //number of players to create the table
		  Instant start = Instant.now();
		  for (int nTimes=1 ; nTimes <= 1000; nTimes++)
			  calendar.schedule(0, n-1); //first and last player (we work from 0 to n-1)
		  Instant end = Instant.now();
		  //calendar.printBoard();
		  System.out.println("n="+n+"**"+"TIME="+(Duration.between(start, end).toMillis())+" MILLISECONDS");
	  } //for
	} //main
} //class
