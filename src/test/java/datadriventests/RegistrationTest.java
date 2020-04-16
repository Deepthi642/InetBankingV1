package datadriventests;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Data driven test for flight Registration using excel file
public class RegistrationTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nandhu\\eclipse-workspace\\inetBankingV1\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		
		//Getting Data from excel sheet
		
		FileInputStream file = new FileInputStream("C:\\Users\\Nandhu\\eclipse-workspace\\inetBankingV1\\src\\test\\java\\com\\inetbanking\\testdata\\Book1.xls");
		
		//Get the workbook instance for XLS file
		
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		
		//Get firstsheet from the workbook
		
		HSSFSheet sheet = workbook.getSheet("Sheet1");
		
		//Get first row from the sheet
		
		int noOfRows = sheet.getLastRowNum();
		
		System.out.println("No of Records in the excel sheet:" + noOfRows);
		
		for(int row = 1; row<=noOfRows; row++)
		{
			HSSFRow current_row = sheet.getRow(row);
			
			
			String First_name = current_row.getCell(0).toString();
			String Last_name = current_row.getCell(1).toString();
			String Phone = current_row.getCell(2).toString();
			String Email = current_row.getCell(3).toString();
			String Address = current_row.getCell(4).toString();
			String City = current_row.getCell(5).toString();
			String State = current_row.getCell(6).toString();
			String Pincode = current_row.getCell(7).toString();
			String Country = current_row.getCell(8).toString();
			String UserName = current_row.getCell(9).toString();
			String Password = current_row.getCell(10).toString();
			
			// Registration Process
			
			driver.findElement(By.linkText("REGISTER")).click();
			
			// Entering contact information
			
			driver.findElement(By.name("firstName")).sendKeys(First_name);
			driver.findElement(By.name("lastName")).sendKeys(Last_name);
			driver.findElement(By.name("phone")).sendKeys(Phone);
			driver.findElement(By.name("userName")).sendKeys(Email);
			
			//Entering Mailing information
			
			driver.findElement(By.name("address1")).sendKeys(Address);
			driver.findElement(By.name("city")).sendKeys(City);
			driver.findElement(By.name("state")).sendKeys(State);
			driver.findElement(By.name("postalCode")).sendKeys(Pincode);
			
			// country dropdown
			Select coun = new Select(driver.findElement(By.name("country")));
			coun.selectByVisibleText(Country);
			
			// Entering user information
			driver.findElement(By.name("email")).sendKeys(UserName);
			driver.findElement(By.name("password")).sendKeys(Password);
			driver.findElement(By.name("confirmPassword")).sendKeys(Password);
			
			//Submitting form
			driver.findElement(By.name("register")).click();
			
			//validation
			
		if(driver.getPageSource().contains("Thank you for registering"))
		{
			System.out.println(" Registration completed for "+ row + " record");
		}
		else {
			System.out.println(" Registration failed for "+ row + " record");
		}
					
					
		}
		System.out.println("Data driven test completed");
		driver.close();
		driver.quit();
		workbook.close();
		file.close();
		
		
		
		
		

	}

}
