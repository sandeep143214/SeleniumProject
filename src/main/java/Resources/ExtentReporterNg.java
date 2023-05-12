package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
    public static ExtentReports getReporterNg()  {
    		String path=".//reports//index.html";
    		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
    		reporter.config().setReportName("WebAutomationResults");
    		reporter.config().setDocumentTitle("TestResults");
    		ExtentReports extent=new ExtentReports();
    		extent.attachReporter(reporter);
    		extent.setSystemInfo("tester", "sandeep");
    		return extent;
    }
}
