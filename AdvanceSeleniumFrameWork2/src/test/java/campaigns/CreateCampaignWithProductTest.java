package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
@Listeners(Generic_Utility.ExtendsReportsImp.class)
public class CreateCampaignWithProductTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createCampaignWithProductTest() throws Throwable {

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();


		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();

		int ranNum = jlib.getRandonNum();

		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;

		driver.findElement(By.name("productname")).sendKeys(prdName);
	//	Assert.fail();
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		// ---------------------------------------------------------------------------------------------------
//Navigating to campaigns module

		WebElement moreLink = driver.findElement(By.linkText("More"));
		wlib.mouseMoveToElement(driver, moreLink);

		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		String campData = elib.getExcelData("Campaigns", 0, 0) + ranNum;

		driver.findElement(By.name("campaignname")).sendKeys(campData);
		// -----------------------------------------------------------------------
//window switching
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();

		wlib.windowSwitching(driver, "Products&action");

		driver.findElement(By.name("search_text")).sendKeys(prdName);
		driver.findElement(By.name("search")).click();

		// driver.findElement(By.xpath("//a[text()='Iphone61']")).click();

		Thread.sleep(2000);
		// dynamic xapth
		driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
		// -+-----------------------------------------------------------------------------------------------
		// driver switching back to main win

		wlib.windowSwitching(driver, "Campaigns&action");
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();

		
	}
}
