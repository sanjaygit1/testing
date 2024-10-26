package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;

//@Listeners(Generic_Utility.RealListenersImpClass.class)
public class CreateProductTest extends BaseClass {

	@Test()
	public void createProductTest() throws Throwable {

		
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
	
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	
Excel_Utility elib = new Excel_Utility();
		String prdName = elib.getExcelData("Product", 0, 0)+ranNum;
		driver.findElement(By.name("productname")).sendKeys(prdName);
		
	//	Assert.fail("Im failing the prdScript");
	
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
	//	Assert.fail("Im failing the prdScript");
		Thread.sleep(2000);
String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

//Assert.assertEquals(actData, prdName,"prdName not created");
//System.out.println("prdName is created");

//if(actData.contains(prdName))
//{
//System.out.println("product name is created");
//}
//else
//{
//System.out.println("product name not created");
//}


	}

}
