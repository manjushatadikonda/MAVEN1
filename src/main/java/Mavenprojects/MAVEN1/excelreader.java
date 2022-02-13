package Mavenprojects.MAVEN1;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class excelreader
{
public static final String filepath="C:\\\\Users\\\\bhimk\\\\Desktop\\\\QA wrk space\\\\mavenflipkart\\\\target\\\\Excel1.xlsx";
DataFormatter dataformatter=new DataFormatter();
@Test
public void readexcel() throws EncryptedDocumentException, IOException
{
Workbook workbook=WorkbookFactory.create(new File(filepath));

for(org.apache.poi.ss.usermodel.Sheet sheet: workbook)
{
for(Row row: sheet)
{
for(Cell cell: row)
{
String cellvalue1=dataformatter.formatCellValue(cell);
System.out.println(cellvalue1);
}
}
}
}
}
