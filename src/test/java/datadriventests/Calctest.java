package datadriventests;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Calctest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nandhu\\eclipse-workspace\\inetBankingV1\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		FileInputStream file = new FileInputStream("C:\\Users\\Nandhu\\eclipse-workspace\\inetBankingV1\\src\\test\\java\\com\\inetbanking\\testdata\\caldata.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		
		for(int i=1 ; i<=rowcount; i++)
		{
			HSSFRow row = sheet.getRow(i);
			
			int principle = (int) row.getCell(0).getNumericCellValue();      //type casting
			int rateofinterest = (int) row.getCell(1).getNumericCellValue();
			int period = (int) row.getCell(2).getNumericCellValue();
			
			String frequency = row.getCell(3).toString();
			int maturityvalue = (int) row.getCell(4).getNumericCellValue();
			
			driver.findElement(By.name("principal")).sendKeys(String.valueOf(principle));
			driver.findElement(By.name("interest")).sendKeys(String.valueOf(rateofinterest));
			driver.findElement(By.name("tenure")).sendKeys(String.valueOf(period));
			
			Select s = new Select(driver.findElement(By.name("tenurePeriod")));
			s.selectByVisibleText("year(s)");
			
			Select sb= new Select(driver.findElement(By.name("frequency")));
			sb.selectByVisibleText(frequency);
			
			driver.findElement(By.xpath(".//*[@id='fdMatVal']/div[2]/a[1]/img")).click();
			
			String actual_value = driver.findElement(By.xpath(".//*[@id='resp_matval']/strong")).getText();
			
			if(Double.parseDouble(actual_value)==maturityvalue)
			{
				System.out.println("Test Passed");
			}
			else
			{
				System.out.println("Test failed");
			}
			driver.findElement(By.xpath(".//*[@id='fdMatVal']/div[2]/a[2]/img")).click();
			
			
			
		}
		driver.close();
		driver.quit();
		workbook.close();
		
		

	}

} 
