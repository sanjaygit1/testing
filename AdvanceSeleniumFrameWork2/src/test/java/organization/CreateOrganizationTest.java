package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;

public class CreateOrganizationTest extends BaseClass{

	@Test(enabled = false)
	public void createOrganizationTest() throws Throwable {

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();

		int ranNum = jlib.getRandonNum();

		String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;
		String PhnNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
		String email = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);

		driver.findElement(By.name("accountname")).sendKeys(OrgName);

		driver.findElement(By.id("phone")).sendKeys(PhnNum);

		driver.findElement(By.id("email1")).sendKeys(email);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

		if (actData.contains(OrgName)) {
			System.out.println("Organization name is created");
		} else {
			System.out.println("Organization name not created");
		}
		Thread.sleep(1000);
		
	}

}
