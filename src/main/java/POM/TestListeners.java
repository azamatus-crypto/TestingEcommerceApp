package POM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners extends BaseTest implements ITestListener {
    ExtentReports reporter=getExtentReporter();
    ExtentTest test;
    ThreadLocal<ExtentTest>threadLocal=new ThreadLocal<>();
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
       test=reporter.createTest(result.getMethod().getMethodName());
       threadLocal.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        threadLocal.get().log(Status.PASS,"passed azamat good boy");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String nam;
        ITestListener.super.onTestFailure(result);
        threadLocal.get().fail(result.getThrowable());
        try {
            driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        nam=getScreenshootPath(result.getMethod().getMethodName(),driver);
        threadLocal.get().addScreenCaptureFromPath(nam,result.getMethod().getMethodName());

    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        reporter.flush();
    }
}
