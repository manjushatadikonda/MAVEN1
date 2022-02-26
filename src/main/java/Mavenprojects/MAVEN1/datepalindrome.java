package Mavenprojects.MAVEN1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class datepalindrome {
	public static boolean main(String[] args)
	{
	 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     Calendar cal = Calendar.getInstance();
     Date date = cal.getTime();
     String str = dateFormat.format(date);
      System.out.println("Today's date : " + str);
     // todaysdate.replace('/','');
      int i = 0, j = str.length() - 1;
      while (i < j) {
          if (str.charAt(i) != str.charAt(j))
              return false;
          i++;
          j--;
      }
      return true;
  }
	}

