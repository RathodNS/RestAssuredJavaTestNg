package listners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reportManager.ExtentReport;

public class Listeners implements ITestListener, ISuiteListener {
	
    private static final String MESSAGE = "Test - <b>";

    @Override
    public void onStart(ISuite suite) {
    	ExtentReport.initExtentReport();
    }
    
    
    @Override
    public void onFinish(ISuite suite) {
    	ExtentReport.flushExtentReport();
    }
    
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
        reportManager.ExtentLogger.pass(MESSAGE + result.getMethod().getMethodName() + "</b>  is started");

    }
    @Override
    public void onTestSuccess(ITestResult result) {
    	reportManager.ExtentLogger.pass(MESSAGE + result.getMethod().getMethodName() + "</b> is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	reportManager.ExtentLogger.logFailureDetails(MESSAGE + result.getMethod().getMethodName() + "</b> is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	reportManager.ExtentLogger.skip(MESSAGE + result.getMethod().getMethodName() + "</b> is skipped");
    }
}
