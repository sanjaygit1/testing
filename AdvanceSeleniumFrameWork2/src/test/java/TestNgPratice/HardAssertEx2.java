package TestNgPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx2 {

	@Test
	public void login() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");

		WebElement UserText = driver.findElement(By.name("user_name"));

		Assert.assertTrue(UserText.isDisplayed());
		//Assert.assertFalse(UserText.isDisplayed());
		UserText.sendKeys("admin");

		WebElement PassWordText = driver.findElement(By.name("user_password"));
		Assert.assertTrue(PassWordText.isDisplayed());

		PassWordText.sendKeys("admin");

		driver.findElement(By.id("submitButton")).click();

	}

	@Test
	public void m1() {
		int a = 1;
		int b = 10;

		Assert.assertEquals(a, b, "not equals = ");
		System.out.println("it is equals");
	}

	@Test
	public void m2() {
		int a = 10;
		int b = 10;
		Assert.assertNotEquals(a, b, "it is equal");
		System.out.println("its not equal");
	}

	@Test
	public void m3() {
		String s = "hello";
		String s1 = "hell";

		Assert.assertTrue(s.equalsIgnoreCase(s1), "false =");
		System.out.println("true");

	}

	@Test
	public void m4() {
		// condition shld not satisfied
		String s = "hi";
		// String s1="hello";
		Assert.assertFalse(s.contains("s"), "yes it contains");
		System.out.println("not contains");
	}

	@Test
	public void m5() {
		String s = "hi";
		Assert.assertNull(s, "not null");
		System.out.println("yes it is null");
	}

	@Test
	public void m6() {
		String s = null;
		Assert.assertNotNull(s, "it is  null");
		System.out.println("yes it is not null");
	}

	@Test
	public void m7() {
		int a = 1;
		int b = 1;
		Assert.assertSame(a, b, "not same");
		System.out.println("same");

//		Assert.assertNotSame(a, b,"same");
//		System.out.println("not same");
		Assert.fail("i am failing this");
	}

}
