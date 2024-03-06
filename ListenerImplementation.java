package commonUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation  implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		System.out.println("TestScript execution is ");
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is started",true);
		test=report.createTest(methodName);
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"TestScript execution is Passed",true);
		test.log(Status.PASS,"TestScript execution is Passed");
		//test.log(Status.PASS, methodName);
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is failed" + message,true);
		
		WebDriverUtil util = new WebDriverUtil();
		test.log(Status.FAIL,"TestScript execution is Passed");
//		try {
//			util.screenShot(BaseClass.sdriver, "Contact");
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is skipped",true);
		
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log("",true);
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log("",true);
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		JavaUtil jutil = new JavaUtil();
		// TODO Auto-generated method stub
		Reporter.log("TestScript execution is started",true);
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+".html");
		
		//to set document title to the report
		reporter.config().setDocumentTitle("vtigercm");
		
		//to generate theme for report
		reporter.config().setTheme(Theme.DARK);
		
		//to set the name to the report
		reporter.config().setReportName("Pune");
		
		
		//use Extentreports to generate extentreport
	    report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("chromeVersion", "121");
		report.setSystemInfo("Author", "Pune");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("TestScript execution is end",true);
		
		//TO add all the status to a report
		report.flush();
		
		
	}
	

}
