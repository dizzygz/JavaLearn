import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.*;
import org.apache.commons.lang3.*;
import java.text.ParseException;

public class SampleLang {
	/**
	 * Check if the key is valid
	 * @param key license key value
	 * @return true if key is valid, false otherwise.
	 */
	public static boolean checkLicenseKey(String key){
	    //checks if empty or null
	    if(StringUtils.isBlank(key)){
	        return false;
	    }
	    //delete all white space
	    key= StringUtils.deleteWhitespace(key);
	    //Split String using the - separator
	    String[] keySplit = StringUtils.split(key, "-");
	    //check lengths of whole and parts
	    if(keySplit.length != 2
	        || keySplit[0].length() != 4
	        || keySplit[1].length() != 4) {
	        return false;
	    }
	    //Check if first part is numeric
	    if(!StringUtils.isNumeric(keySplit[0])){
	        return false;
	    }
	    //Check if second part contains only
	    //the four characters 'J', 'A', 'V' and 'A'
	    if(! StringUtils.containsOnly(keySplit[1]
	            ,new char[]{'J', 'A', 'V', 'A'})){
	        return false;
	    }
	    //Check if the fourth character
		  //in the first part is a '0'
	    if(StringUtils.indexOf(keySplit[0], '0') != 3){
	        return false;
	    }
	    //If all conditions are fulfilled, key is valid.
	    return true;
	}
	
	public static void checkDate()	throws InterruptedException, ParseException {
	    //date1 created
	    Date date1= new Date();
	    //Print the date and time at this instant
	    System.out.println("The time right now is >>"+date1);
	    //Thread sleep for 1000 ms
	    Thread.currentThread().sleep(DateUtils.MILLIS_PER_MINUTE);
	    //date2 created.
	    Date date2= new Date();
	    //Check if date1 and date2 have the same day
	    System.out.println("Is Same Day >> "
	        + DateUtils.isSameDay(date1, date2));
	    //Check if date1 and date2 have the same instance
	    System.out.println("Is Same Instant >> "
	        +DateUtils.isSameInstant(date1, date2));
	    //Round the hour
	    System.out.println("Date after rounding >>"
	        +DateUtils.round(date1, Calendar.HOUR));
	    //Truncate the hour
	    System.out.println("Date after truncation >>"
	        +DateUtils.truncate(date1, Calendar.HOUR));
	    //Three dates in three different formats
	    String [] dates={"2005.03.24 11:03:26", "2005-03-24 11:03", 
	    "2005/03/24"};
	    //Iterate over dates and parse strings to java.util.Date objects
	    for(int i=0; i < dates.length; i++){
	        Date parsedDate= DateUtils.parseDate(dates[i],
	        new String []{"yyyy/MM/dd", "yyyy.MM.dd HH:mm:ss",
	      "yyyy-MM-dd HH:mm"});
	        System.out.println("Parsed Date is >>"+parsedDate);
	    }
	    //Display date in HH:mm:ss format
	    System.out.println("Now >>"
	        +DateFormatUtils.ISO_TIME_NO_T_FORMAT.format
	    (System.currentTimeMillis()));
	}
}
