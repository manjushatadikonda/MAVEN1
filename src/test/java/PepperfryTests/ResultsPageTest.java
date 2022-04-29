package PepperfryTests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import PepperfryPages.ResultsPage;
import PepperfryPages.TestBase;

public class ResultsPageTest extends TestBase{
	ResultsPage res1=null;
	
	@Test
	public void test1()
	{
		res1=PageFactory.initElements(driver,ResultsPage.class);
		
		
        List<WebElement> list=res1.check();
        List<String> Ascendinglist1=new ArrayList<String>();
        Reporter.log("---------------------Ascending Order-----------");
        for(int i=0;i<list.size();i++)
        {
        	Ascendinglist1.add(list.get(i).getText());
        }
        Collections.sort(Ascendinglist1, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
        for(int i=0;i<Ascendinglist1.size();i++)
        {
        	Reporter.log(Ascendinglist1.get(i));
        }
        Reporter.log("---------------------Descending Order-----------");
        List<String> Descendinglist1=new ArrayList<String>();
        //Collections.sort(null, null);
        for(int i=0;i<list.size();i++)
        {
        	Descendinglist1.add(list.get(i).getText());
        }
        Collections.sort(Descendinglist1, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareToIgnoreCase(s1);
            }
        });
        for(int i=0;i<Descendinglist1.size();i++)
        {
        	Reporter.log(Descendinglist1.get(i));
        }
	}

}
