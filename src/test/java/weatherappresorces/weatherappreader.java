package weatherappresorces;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class weatherappreader {
	
	DataFormatter dataformatter=new DataFormatter();

	public String[][] getExcelData(String filename)
    {
    	
    	String Data[][]= new String[5][2]; 
    	try
    	{
    		Workbook workbook=WorkbookFactory.create(new File(filename));
    		Sheet worksheet=(Sheet)workbook.getSheetAt(0);
    		 
    	     for(int i=0; i<5; i++) 
    	     {  
    	     Row row= worksheet.getRow(i+1);
    	     
    	     for (int j=0; j<2; j++)
    	     {
    	     if(row==null)
    	     Data[i][j]= "";
    	     else 
    	     {
    	     Cell cell= row.getCell(j);
    	     if(cell==null)
    	     Data[i][j]= ""; 
    	     else
    	     {
    	     String value=dataformatter.formatCellValue(cell);
    	     Data[i][j]=value;
    	     }
    	     }
    	     }
    	     }
    	     return Data;

    	}
    	 catch(Exception e)
    	 {
    		System.out.println(e); 
    		return Data;
    	 }
   
    }
}
