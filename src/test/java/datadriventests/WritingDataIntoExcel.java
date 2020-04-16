package datadriventests;

//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.*;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileOutputStream file = new FileOutputStream("C:\\Users\\Nandhu\\eclipse-workspace\\inetBankingV1\\src\\test\\java\\com\\inetbanking\\testdata\\deepthi.xls");
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Data");
		
		for(int i=0; i<=5;i++)
		{
			HSSFRow row = sheet.createRow(i);
			
			
			for(int j=0;j<3;j++)
			{
				row.createCell(j).setCellValue("XYZ");
			}
		}
		
		workbook.write(file);
		file.close();
		workbook.close();
		
		System.out.println("Written data into excel");
		
		

	}

}
