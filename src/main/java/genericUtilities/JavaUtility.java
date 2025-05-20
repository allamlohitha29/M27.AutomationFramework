package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of genericMethods related to java
 * @author Lohitha
 */

public class JavaUtility {
	
	/**
	 * This method will capture the current system Date in required format and return to caller
	 * 
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String dateinformat = f.format(d);
		return dateinformat;
		
	}
	

}
