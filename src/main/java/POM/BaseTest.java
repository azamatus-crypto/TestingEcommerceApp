package POM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;

public class BaseTest {

    WebDriver driver;
    Log_In_Test logInTest;

    public WebDriver initDrivers() throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("src/main/java/PropertiesFiles/BrowsersFile.properties");
        properties.load(inputStream);
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : properties.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/java/drivers/geckodriver.exe");
        }
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public Log_In_Test launchApp() throws IOException {
        driver = initDrivers();
        logInTest = new Log_In_Test(driver);
        logInTest.goTowebsite(driver);
        return logInTest;
    }

    public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
        String jsonStrings = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, String>> mapList = objectMapper.readValue(jsonStrings, new TypeReference<List<HashMap<String, String>>>() {
        });
        return mapList;
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }

    public ExtentReports getExtentReporter() {
        String a = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(a);
        sparkReporter.config().setDocumentTitle("Eccomerce web testing");
        sparkReporter.config().setReportName("Eccomerce automation");
        ExtentReports extentReporter = new ExtentReports();
        extentReporter.attachReporter(sparkReporter);
        extentReporter.setSystemInfo("Tester", "Azamat");
        return extentReporter;
    }

    public String getScreenshootPath(String testCaseName, WebDriver driver) {
        TakesScreenshot t = (TakesScreenshot) driver;
        File f = t.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f, new File("C:\\Users\\Lenovo\\IdeaProjects\\EndToEndTest\\src\\main\\java\\Screenshoots\\" + testCaseName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "C:\\Users\\Lenovo\\IdeaProjects\\EndToEndTest\\src\\main\\java\\Screenshoots\\" + testCaseName + ".png";

    }

}
