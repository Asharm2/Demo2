package AmanEnterprise.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportsDemoTest {
    ExtentReports extent;

    @BeforeTest
    public void config(){
        String reportFilePath = System.getProperty("user.dir") + "//reports//index.html";

        //two important classes -> ExtentReports , ExtentSparkReporter

        //ExtentSparkReporter is responsible to create one html and file and it's configurations
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportFilePath);
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setReportName("Web Automation Results");

        //ExtentReports is our main class -> responsible for driving all reporting execution
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Aman");

    }

    @Test
    public void initialDemo(){
        //when we create a test, an object is created for our complete test method, we can catch that object by writing ExtentTest
        ExtentTest test = extent.createTest("Initiaze Demo");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        driver.quit();

        test.fail("Results do not match");
        extent.flush();

    }
}
