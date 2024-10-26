package Generic_Utility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendsReportsImp implements ITestListener {
	ExtentTest test;
	ExtentReports report;

	public void onTestStart(ITestResult result) {//@Test
		test = report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
//		test.log(Status.PASS, result.getMethod().getMethodName());
//		test.log(Status.PASS, result.getThrowable());
		System.out.println("Script Pass");
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		

//		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
//		String src = ts.getScreenshotAs(OutputType.BASE64);
//		test.addScreenCaptureFromBase64String(src, testName + "_" + time);
		test.log(Status.FAIL, testName + "==>Failed==<");
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
////		System.out.println("Script fail");
//
//		System.out.println("----------im taking ScreenShot-----");
		String screenshot=null;
		try {
			screenshot = Webdriver_Utility.takeScreenShot1(BaseClass.sdriver, result.getMethod().getMethodName());

		} catch (Throwable e) {

			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshot);
		}

	public void onTestSkipped(ITestResult result) {
//		test.log(Status.SKIP, result.getMethod().getMethodName());
//		test.log(Status.SKIP, result.getThrowable());
		System.out.println("Script skipped");
	}

	public void onStart(ITestContext context) {
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandonNum();

		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html" + time);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReport");
		spark.config().setReportName("Shobha");

		// System configuration
		report = new ExtentReports();

		report.attachReporter(spark);
		report.setSystemInfo("platform", "window10");
		report.setSystemInfo("executedBy", "SHOBHA");
		report.setSystemInfo("Reviewed By", "Rathin");
	}

	public void onFinish(ITestContext context) {
		report.flush();

	}
}
