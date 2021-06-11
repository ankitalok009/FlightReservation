package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	
	public static Object[][] getData(String testcaseName, String TestSheet) throws IOException
	{
	
		
		
	//fileInputStream argument
	Object[][] data=null;
	try {
	String path=System.getProperty("user.dir");
	FileInputStream fis=new FileInputStream(path+ "\\src\\main\\java\\resources\\TestData.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	System.out.println(path+ "\\src\\main\\java\\resources\\TestData.xlsx");
	Sheet exlSheet=workbook.getSheet(TestSheet);

	Iterator<Row>  rows= exlSheet.iterator();// sheet is collection of rows
	Row firstrow= rows.next();
	
	Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
	int k=0;
	int column =1;
	while(ce.hasNext())
	{
	Cell value=ce.next();

	if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
	{
	column=k;
	
	}

	k++;
	}
	
	
	int testIdRow=0;
	data=new Object[1][exlSheet.getRow(0).getLastCellNum()];
	
	for(int i=0;i<exlSheet.getLastRowNum();i++) {
		Row rowvalue=rows.next();
		if(rowvalue.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
			testIdRow++;
			if(testIdRow<2) {
				for(int j=0;j<exlSheet.getRow(0).getLastCellNum();j++) {
					data[testIdRow-1][j]=String.valueOf(exlSheet.getRow(i+1).getCell(j));
				}
			}
			else {
				System.out.println(" more than one test case ids have same ids");
			}
		}}
	workbook.close();
	////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
	
	}
	catch(Exception e)
	{
		System.err.println("Error in test data");
		throw e;
	}
	return data;

	}

}
