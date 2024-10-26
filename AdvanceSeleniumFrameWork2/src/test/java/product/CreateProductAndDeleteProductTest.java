package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.DeletePrdAndValidate;
import ObjectRepository.HomePage;
import ObjectRepository.VtigerLoginPage;

public class CreateProductAndDeleteProductTest extends BaseClass {

	@Test(enabled = false)
	public void createProductAndDeleteProductTest() throws Throwable {

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();

		HomePage home = new HomePage(driver);
		home.clickPrdLink();

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickloopUpImg();

		int ranNum = jlib.getRandonNum();

		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;

		prdPage.enterPrdName(prdName);
		prdPage.clicksaveButton();

		// ----------------------------------------------------------------------------------------------------
		// navigating the product table

		DeletePrdAndValidate delPrd = new DeletePrdAndValidate(driver);
		delPrd.clickPrdLink();

		delPrd.clickPrdName(driver, prdName);
		delPrd.clickOnDeleteLink();

		wlib.alertAccept(driver);

		delPrd.validatePrdDeleted(driver, prdName);

		Thread.sleep(1000);
		
	}

}
