package datadriventests;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.*;
//import org.apache.poi.xssf.usermodel.*;

public class ReaddataFromExcel {
	
	public static void main(String[] args) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Nandhu\\Desktop\\TestData.xls");
		
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		
		HSSFSheet sheet = workbook.getSheet("Sheet1");  //Providing sheet name
		//XSSFSheet sheet = workbook.getSheetAt(0);     //Using index
		
		int rowcount = sheet.getLastRowNum();     //Provides last row number
		int colcount = sheet.getRow(0).getLastCellNum();         //Provides number of columns
		
		for(int i=0; i<rowcount;i++)
		{
			HSSFRow currentrow = sheet.getRow(i);       //Focus on current row   
			
			for(int j=0;j<colcount;j++)
			{
				String value = currentrow.getCell(j).toString();  //Read the value from cell
				System.out.print(" " +value);
			}
			System.out.println();
		}
		workbook.close();
		file.close();
		
	}

}
