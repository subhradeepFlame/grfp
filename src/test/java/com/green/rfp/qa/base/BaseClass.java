package com.green.rfp.qa.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
//import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.green.rfp.qa.helper.alert.AlertHelper;
import com.green.rfp.qa.pages.AdministrationPage;
import com.green.rfp.qa.pages.DashboardIndexPage;
import com.green.rfp.qa.pages.DashboardVerificationPage;
import com.green.rfp.qa.pages.ForgotPasswordPage;
import com.green.rfp.qa.pages.LoginPage;
import com.green.rfp.qa.pages.MyProfilePage;
import com.green.rfp.qa.pages.RFPIndexPage;
import com.green.rfp.qa.pages.bidTablePage;
import com.green.rfp.qa.pages.RFPVerificationPage;
import com.green.rfp.qa.pages.TemplateIndexPage;
import com.green.rfp.qa.pages.TemplateVerificationPage;
import com.green.rfp.qa.utility.ConfigReader;
import com.green.rfp.qa.utility.XLUtils;
import com.green.rfp.qa.utility.trelloUtils;
import com.green.rfp.qa.utility.FileHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static int note_data = 0;
	public static String suiteName = "";
	public static String testName = "";
	public String currentTest;
	protected static String screenshot_folder_path = null; // Path to screenshot folder
	public static ConfigReader con = new ConfigReader();
	public static WebDriver driver;
	public static String env = con.getEnv();
	public String browser = con.getBrowser();
	public String baseURl = con.getUrl();
	public String headless = con.getconfigdData("headless");
	public static int explicitWait = con.getExplicitTime();
	public String superAdminUserName = con.getSuperAdminUsername();
	public String superAdminPassword = con.getSuperAdminPassword();
	public String inboxLink = con.getconfigdData("mailinatorLink");
	public static Logger logger;
	public static String userDir = System.getProperty("user.dir");
	public static String browserName = "";
	public static String browserVersion = "";
	public static String testUrl;
	public static HashMap<String, String> globalMap = new HashMap<String, String>();
	public static TemplateVerificationPage templateVerificationPage;
	public static DashboardVerificationPage dashboardVerificationPage;
	public static DashboardIndexPage dashboardIndexPage;
	public static TemplateIndexPage templateIndexPage;
	public static RFPIndexPage rfpIndexPage;
	public static bidTablePage bidTablePage;
	public static RFPVerificationPage rfpVerificationPage;
	public static LoginPage loginPage;
	public static AdministrationPage adminstrationPage;
	public static ForgotPasswordPage forgotPasswordPage;
	public static trelloUtils tu;

	public static MyProfilePage myProfilePage;
	public static AlertHelper alertHelper;
	public FileHelper fileHelper;
	public static long PAGE_LOAD_TIMEOUT = Integer.parseInt(con.getconfigdData("PAGE_LOAD_TIMEOUT"));
	public static long IMPLICIT_WAIT = Integer.parseInt(con.getconfigdData("IMPLICIT_WAIT"));
	public static long SET_SCRIPT_TIMEOUT = Integer.parseInt(con.getconfigdData("SET_SCRIPT_TIMEOUT"));
	public static int stepCount;
	public int retry = con.getconfigdDataInt("retry");
	protected static String reportFolder = "Report" + File.separator + "TestingReport" + "-" + env + "-"
			+ getCurrentTimeStampString("ddMMYYYY-HH-mm");
	static File reportf;
	static String screenshotFolderPath;
	static File screenshotFolder;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriverWait wait;
	public static WebDriverWait waitFor2mins;


	public void pause(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException interruptedException) {

		}
	}

	@BeforeSuite(alwaysRun = true)
	protected void fetchSuiteConfiguration(ITestContext testContext) {
		reportf = new File(reportFolder);
		screenshotFolderPath = reportFolder + File.separator + "screenshots";
		screenshotFolder = new File(screenshotFolderPath);

		String effectivePOM = System.getProperty("pom");
		if (effectivePOM == null)
			effectivePOM = "pom";
		switch (effectivePOM) {
		case "pom1": {
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdirs();
			}
			con.setKeyValue("reportfile", reportf.getAbsoluteFile() + File.separator + "extent-report.html");
			extent = new ExtentReports(reportf.getAbsoluteFile() + File.separator + "extent-report.html", false);
		}
			break;
		case "pom2": {
			extent = new ExtentReports(reportf.getAbsoluteFile() + File.separator + "extent-report.html", false);

			con.setKeyValue("reportfile", "na");
		}
			break;
		case "pom": {
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdirs();
			}
			extent = new ExtentReports(reportf.getAbsoluteFile() + File.separator + "extent-report.html", false);
		}
			break;
		default: {
			System.out.println("Decleared POM file is not available");
		}
			break;

		}

		System.out.println("======" + testUrl + "=========");

		extent.addSystemInfo("Environment", env.toUpperCase().trim());
		extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

	}

	@BeforeClass
	public void setup(ITestContext testContext) {
		String SCREENSHOT_FOLDER_NAME = "screenshots";
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();
		suiteName = testContext.getSuite().getName();
		currentTest = testContext.getCurrentXmlTest().getName(); // get Name of current test.
		log("current test- " + currentTest);
		log("Current Xml Suite is:---->" + suiteName);
		logger = Logger.getLogger(currentTest);
		initiateBrowser();
		logger.info("Url opened successfully");

		templateVerificationPage = new TemplateVerificationPage();
		dashboardVerificationPage = new DashboardVerificationPage();
		dashboardIndexPage = new DashboardIndexPage();
		templateIndexPage = new TemplateIndexPage();
		rfpIndexPage = new RFPIndexPage();
		bidTablePage = new bidTablePage();
		rfpVerificationPage = new RFPVerificationPage();
		loginPage = new LoginPage();
		adminstrationPage = new AdministrationPage();
		forgotPasswordPage = new ForgotPasswordPage();
		alertHelper = new AlertHelper(driver);
		myProfilePage = new MyProfilePage();
		tu = new trelloUtils();
		wait = new WebDriverWait(driver, explicitWait);
		waitFor2mins=new WebDriverWait(driver, 120);

	}

	public void initiateBrowser() {

		log(browser);

		if (browser.equalsIgnoreCase("chrome")) {
			// setup the chromedriver using WebDriverManager
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "downloads");
			options.setExperimentalOption("prefs", prefs);

			if (SystemUtils.OS_NAME.equalsIgnoreCase("Linux")) {
				WebDriverManager.chromedriver().setup();
				options.addArguments("headless");
				options.addArguments("disable-gpu");
				options.addArguments("--window-size=1325x744");
				driver = new ChromeDriver(options);

			} else if (SystemUtils.OS_NAME.contains("Windows"))
				;
			{
				WebDriverManager.chromedriver().setup();

				if (headless.equalsIgnoreCase("y"))
					options.addArguments("--headless");
				options.addArguments("disable-infobars");
				driver = new ChromeDriver(options);
			}
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", "/usr/bin/chrome‌​driver");

			// Create driver object for Chrome

			maximizeBrowser();
			logger.info("Chrome Browser Opened");
			logger.info("Running Headless");
			extent.addSystemInfo("Browser", con.getBrowser().toUpperCase().trim());
			if (headless.equalsIgnoreCase("y"))
				extent.addSystemInfo("Mode", " : Headless");
			driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			logger.info("PageLoad wait given");
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
			logger.info("Implicit wait given");
			driver.manage().timeouts().setScriptTimeout(SET_SCRIPT_TIMEOUT, TimeUnit.SECONDS);
			logger.info("Java Script wait given");

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			// setup the firefoxdriver using WebDriverManager
			WebDriverManager.firefoxdriver().setup();
			// Create driver object for firefox
			driver = new FirefoxDriver();
			logger.info("FireFox Browser Opened");
			driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			logger.info("PageLoad wait given");
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
			logger.info("Implicit wait given");
			driver.manage().timeouts().setScriptTimeout(SET_SCRIPT_TIMEOUT, TimeUnit.SECONDS);
			logger.info("Java Script wait given");
			maximizeBrowser();

		}

		driver.get(con.getUrl());
	}

	@BeforeMethod
	public void beforeMethod(ITestContext testContext, Method method) {
		test = extent.startTest(
				testContext.getName() + " : " + this.getClass().getSimpleName() + " - " + method.getName(),
				testContext.getSuite().getName());
		System.err.println("Test Started" + testContext.getName() + ": " + method.getName());
		stepCount = 1;

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult, Method method) {

		if (testResult.getStatus() == ITestResult.SUCCESS) {
			passed_count++;
			test.log(LogStatus.PASS, "Test Status", "PASSED");
		}

		else if (testResult.getStatus() == ITestResult.FAILURE) {
			failed_count++;
			test.log(LogStatus.FAIL, "", "FAILED");

		}

		else if (testResult.getStatus() == ITestResult.SKIP) {
			skipped_count++;
			test.log(LogStatus.SKIP, "", "SKIPPED");

		}
		try {
			testName = testResult.getName();
			if (testResult.getStatus() != ITestResult.SUCCESS) {
				System.out.println("TEST FAILED - " + testName);
				System.out.println("ERROR MESSAGE: " + testResult.getThrowable());
				System.out.println("\n");
				Reporter.setCurrentTestResult(testResult);
				Reporter.log("<br></br><Strong><font color=#ff0000>Fail                  </font></strong><img src='"
						+ screenshotFolderPath + "\\fail.png' alt='fail' height='15' width='15'/>");
				String screenshotName = currentTest + "" + method.getName() + getCurrentTimeStampString();
				makeScreenshot(screenshotName);
				System.out.println(screenshotFolder + File.separator + screenshotName + ".png");
				test.log(LogStatus.FAIL, "",
						test.addScreenCapture("screenshots" + File.separator + screenshotName + ".png"));
				test.log(LogStatus.FAIL, " ", testResult.getThrowable());
				if (SystemUtils.OS_NAME.equalsIgnoreCase("Linux")) {
					String cardlink = tu.addcard(testName,
							convertStackTraceToString(testResult.getThrowable().fillInStackTrace()));
					if (cardlink != null) {
						testInfoLog("Card added in trello " + "<a href=" + cardlink + ">" + cardlink + "</a>");
					}
				}
			} else {
				System.out.println("TEST PASSED - " + testName + "\n");
			}
			System.out.println(" Test status : " + testResult.getStatus() + "  ");

		} catch (Exception throwable) {
			System.out.println("message from tear down" + throwable);
		} finally {

			if (browserName.contains("internet explorer")) {
				// killIEServer();
				pause(5);
			}
		}
		extent.endTest(test);
		extent.flush();

	}

	private static String convertStackTraceToString(Throwable throwable) {
		try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
			throwable.printStackTrace(pw);
			return sw.toString();
		} catch (IOException ioe) {
			throw new IllegalStateException(ioe);
		}
	}

	@AfterClass
	public void close() {
		driver.close();
		driver.quit();
		System.err.println("pause for 30 secconds");
		pause(30);
	}

	@AfterSuite
	public void testResults() throws FileNotFoundException {
		System.out.println("The passed tests - " + passed_count);
		System.out.println("The failed tests - " + failed_count);
		System.out.println("The skipped tests - " + skipped_count);
		extent.flush();
		extent.close();
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
		/* maximizing window for headless mode */
		if (headless.equalsIgnoreCase("y"))
			driver.manage().window().setSize(new Dimension(1440, 900));
		logger.info("Maximize Window Size of browser");
	}

	public static int passed_count = 0;
	public static int failed_count = 0;
	public static int skipped_count = 0;

	public void jsClick(WebElement element) {
		waitforElementClickable(element);
		pause(1);
		highlightElement(element);

		try {
			String st = element.getAttribute("name");
			if (st == null || st.isEmpty())
				st = "";
			else
				st = st + " : ";
			System.out.println("Click on : " + st + element.getText());
			((JavascriptExecutor) driver).executeScript("return arguments[0].click();", element);
		} catch (Exception e) {
			pause(5);
			element.click();
		}
		waitForPageLoaded();

	}

	public static void clickableElement(WebElement webelement) {
		(new WebDriverWait(driver, con.getExplicitTime())).until(ExpectedConditions.elementToBeClickable(webelement));

	}

	public void add_screenShot(String testname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/ScreenShots/" + testname + ".PNG");
		FileUtils.copyFile(source, target);

	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(2);
		return (generatedString2);
	}

	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void scrollToBottom()

	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollToTop() {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
	}

	public static void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 70);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public boolean waitforElementClickable(WebElement element, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			highlightElement(element);
			return true;
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}
	}

	public boolean waitforElementClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, con.getExplicitTime());
			wait.until(ExpectedConditions.elementToBeClickable(element));
			highlightElement(element);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public void highlightElement(WebElement element) {

		// draw a border around the found element

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '3px solid yellow'", element);

			pause(2);

			((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '0px'", element);
		} catch (Exception e) {

		}
	}

	public static void mouseHover(WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();

	}

	public static void waitForElement(WebElement element) {
		(new WebDriverWait(driver, con.getExplicitTime())).until(ExpectedConditions.visibilityOf(element));
	}

	public static void log(String msg) {

		System.out.println("======" + msg + "======");
		Reporter.log("<br>" + msg);
	}

	public void failedLog(String msg) {
		System.out.println("<strong>======" + msg + "======</strong>");
		Reporter.log("<font color=#FF0000>--Failed- </font>" + "<strong>======" + msg + "======</strong>");
	}

	public void testCaselog(String msg) {
		System.out.println("<strong>======" + msg + "======</strong>");
		Reporter.log("<br></br>" + "<strong>======" + msg + "======</strong>");
	}

	public static void testInfoLog(String msg) {
		test.log(LogStatus.INFO, "info", msg);
		System.err.println("Info : " + msg);

		log(msg);
	}

	public static void testFatalLog(String msg) {
		test.log(LogStatus.FATAL, "info", msg);
		System.err.println("Fatal : " + msg);

		log(msg);
	}

	public static void testErrorLog(String msg) {
		test.log(LogStatus.ERROR, "info", msg);
		System.err.println("Error : " + msg);

		log(msg);
	}

	public void testSkipLog(String msg) {
		test.log(LogStatus.SKIP, "", msg);
		System.err.println("Skip : " + msg);
		log(msg);

	}

	public void testPassLog(String msg) {
		test.log(LogStatus.PASS, "", msg);
		System.err.println("Pass : " + msg);
		log(msg);
	}

	public void testStepsLog(String steps, String msg) {

		System.err.println(steps + " : " + msg);
		test.log(LogStatus.PASS, steps, msg);
		log(msg);
		extent.flush();
	}

	public void testVerifyLog(String msg) {
		test.log(LogStatus.PASS, "Verify", msg);
		log("<font color=#000080>" + msg + "</font>");
	}

	public static String getCurrentTimeStampString() {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("ddMMYYYY_HH-mm-ss");
		TimeZone timeZone = TimeZone.getDefault();
		Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
		sd.setCalendar(cal);
		return sd.format(date);
	}

	public static String getCurrentTimeStampString(String timeformat) {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat(timeformat);
		TimeZone timeZone = TimeZone.getDefault();
		Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
		sd.setCalendar(cal);
		return sd.format(date);
	}

	public static void makeScreenshot(String screenshotName) {

		WebDriver augmentedDriver = new Augmenter().augment(driver);

		/* Take a screenshot */
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		String nameWithExtention = screenshotName + ".png";

		/* Copy screenshot to specific folder */
		try {
			reportFolder = reportFolder + File.separator;

			FileUtils.copyFile(screenshot,
					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			log("Failed to capture screenshot: " + e.getMessage());
		}
		log("<br><b>Screenshot- </b>" + getScreenshotLink(nameWithExtention, nameWithExtention)); // add
	}

	public static String getScreenshotLink(String screenshot_name, String link_text) {

		return "<a href='../test-output/screenshots/" + screenshot_name + "' target='_new'>" + link_text + "</a>";
	}

	public static boolean isPresenceOfElement(By locator, WebDriver driver) {
		try {
			(new WebDriverWait(driver, con.getExplicitTime()))
					.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static void PresenceOfElement(By locator) {
		(new WebDriverWait(driver, explicitWait)).until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public static void PresenceOfElement(WebElement e) {
		(new WebDriverWait(driver, explicitWait)).until(ExpectedConditions.visibilityOf(e));

	}

	public void clickOn(WebElement element) {
		highlightElement(element);
		pause(1);
		element.click();
	}

	/*
	 * login with customeradmin
	 */
	public void loginValid() {
		if (isInLoginPage()) {

			testStepsLog("Steps " + stepCount++, "Enter user name");
			driver.findElement(By.name("email")).sendKeys(userName);
			testStepsLog("Steps " + stepCount++, "Click on Arrow");
			driver.findElement(By.cssSelector("div#login-form>form>div>md-icon")).click();
			testStepsLog("Steps " + stepCount++, "Enter Password");
			loginPage.enterPassword(passWord);

			testStepsLog("Steps " + stepCount++, "Click on  Login");
			jsClick(driver.findElement(By.xpath("//button[@aria-label='LOG IN']")));

			if (afetrloginPopUP()) {
				pause(1);
				driver.findElement(By.xpath("//button[text()='SKIP']")).click();
			}

			else {
				System.out.println("Pop Not Displyed");
			}
		}

	}

	public void loginValid(String userName, String passWord) {
		pause(3);
		driver.findElement(By.name("email")).sendKeys(userName);
		pause(3);
		driver.findElement(By.cssSelector("div#login-form>form>div>md-icon")).click();
		driver.findElement(By.name("password")).sendKeys(passWord);
		driver.findElement(By.xpath("//*[text()='LOG IN']")).click();
		pause(3);
		// boolean status = afetrloginPopUP();
		if (afetrloginPopUP()) {
			pause(3);
			driver.findElement(By.xpath("//button[text()='SKIP']")).click();
		}

		else {
			System.out.println("Pop Not Displyed");
		}

	}

	public void closeAfterLoginPopup() {
		if (afetrloginPopUP()) {
			pause(3);
			driver.findElement(By.xpath("//button[text()='SKIP']")).click();
			System.out.println("Close Afterlogin popup");
		}

		else {
			System.out.println("Pop Not Displyed");
		}
	}

	public void superAdminloginValid() {
		testStepsLog("Step " + (stepCount++), " Go to : " + baseURl);

		driver.get(baseURl);
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), "Enter email : " + superAdminUserName);

		driver.findElement(By.name("email")).sendKeys(superAdminUserName);
		driver.findElement(By.cssSelector("div#login-form>form>div>md-icon")).click();
		testStepsLog("Step " + (stepCount++), "Enter password : " + superAdminPassword);
		driver.findElement(By.name("password")).sendKeys(superAdminPassword);
		testStepsLog("Step " + (stepCount++), "Click on Login");
		driver.findElement(By.xpath("//*[text()='LOG IN']")).click();
		waitForPageLoaded();

		testInfoLog("Logged in as Super Admin");
	}

	public boolean afetrloginPopUP() {

		try {
			driver.findElement(By.xpath(
					"//md-dialog[contains(@class, 'md-transition-in')]//*[text()[normalize-space()='Tour of GreenRFP']]"))
					.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean changeUser()

	{
		System.out.println("Going to close userr");
		return driver.findElement(By.className("icon-window-close")).isDisplayed();
	}

	public void switchUser() {
		System.out.println("Start the execution");
		pause(3);
		boolean s = driver.findElement(By.xpath("//*[@class='header-close']//span[1]")).isDisplayed();
		System.out.println(s);
		pause(3);
		if (s) {
			pause(3);
			System.out.println("Going to close user");
			jsClick(driver.findElement(By.xpath("//*[@class='header-close']//span[1]")));
			jsClick(driver.findElement(By.xpath("//button[text()='Yes']")));
		}

		else {
			System.out.println("No need to swtich to user");
		}
	}

	// will return number between 1 and length (both inclusive)
	public static int randomNumericValueGenerate(int length) {

		Random randomGenerator = new Random();

		int randomInt = randomGenerator.nextInt(length);
		return (randomInt + 1);
	}

	public static int[] randomNumericValuesGenerate(int length, int count) {

		Random randomGenerator = new Random();

		int[] randomInts = randomGenerator.ints(1, (length + 1)).distinct().limit(count).toArray();
		return randomInts;
	}

	public static String randomStringGenerate() {

		int length = randomNumericValueGenerate(10);
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return "ccqa" + sb.toString();
	}

	public static String randomStringGenerate(int len) {

		int length = randomNumericValueGenerate(len);
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public static void type(WebElement element, String data) {
		element.clear();
		element.sendKeys(data);
	}

	public void scrollToElementTillTrue(WebElement element) {
		pause(2);
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			pause(8);
		} catch (Exception e) {
			System.out.println("e");
		}
	}

	public static void enterDataIn(WebElement element, String search_phrase) {
		try {
			element.clear();
		} catch (Exception e) {
			testInfoLog("Unable to clear");
		}
		element.sendKeys(search_phrase);
	}

	public static boolean invisibilityOfElementLocated(By locator, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			return true;
		} catch (TimeoutException e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean visibilityOfElementLocated(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, explicitWait);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (TimeoutException e) {
			// System.out.println(e);
			return false;
		}
	}

	public void deleteCookies() {
		pause(3);
		driver.manage().deleteAllCookies();
		pause(5);
	}

	public static void SwitchtoTab(int tabNumber) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabNumber));
	}

	@FindBy(className = "icon-window-close")
	WebElement remote_close_btn;

	public void closingSession_bk() {
		driver.navigate().refresh();
		waitForPageLoaded();
		testInfoLog("Closing session");
		if (isRemoteCloseIcon()) {
			testStepsLog("Step " + (stepCount++), " Click on Close Remote button.");
			templateVerificationPage = templateIndexPage.clickOnCloseRemoteButton();
			pause(3);
			testStepsLog("Step " + (stepCount++), " Click on Yes button.");
			templateVerificationPage = templateIndexPage.clickOnYesButton();
			waitForPageLoaded();
		} else {
			System.out.println("Close icon not present");
		}
	}

	public void closingSession() {

		String currentSessionUserName = null;
		int count = 1;
		do {
			testInfoLog("Closing session attempt - " + count);
			driver.navigate().refresh();
			waitForPageLoaded();
			testInfoLog("Closing session");
			if (isRemoteCloseIcon()) {
				testStepsLog("Step " + (stepCount++), " Click on Close Remote button.");
				templateVerificationPage = templateIndexPage.clickOnCloseRemoteButton();
				pause(3);
				testStepsLog("Step " + (stepCount++), " Click on Yes button.");
				templateVerificationPage = templateIndexPage.clickOnYesButton();
				waitForPageLoaded();

			} else {
				System.out.println("Close icon not present");
			}
			currentSessionUserName = driver
					.findElement(By.xpath("//*[@id='user-menu']//span[contains(@class, 'username ')]")).getText();
			count++;
			if (currentSessionUserName.equalsIgnoreCase("Super1 Admin")) {
				break;
			}
		} while (count <= retry);

	}

	public boolean isRemoteCloseIcon() {
		try {
			driver.findElement(By.className("icon-window-close")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String getSystemDate() {
		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String getScreenshot(String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "\\Report\\Images" + screenshotName + dateName + ".png";
		System.out.println("path" + destination);
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public void loginAs(String Company, String user) {

		try {

			testInfoLog(" Login as for company:" + Company + " : user : " + user);
			testStepsLog("Step " + (stepCount++), " Click on LoginAs button.");
			templateIndexPage.clickOnLogInAsButton();
			testStepsLog("Step " + (stepCount++), " Select Company as : " + Company);
			templateIndexPage.selectCompany(Company);
			testStepsLog("Step " + (stepCount++), " Click on Select User Button");
			templateIndexPage.clickOnSelectUserButton();

			pause(3);
			testStepsLog("Step " + (stepCount++), " Select user as : " + user);
			rfpIndexPage.selectUser(user);
			testStepsLog("Step " + (stepCount++), " Click on Go ");
			templateIndexPage.clickOnGoButton();
			testStepsLog("Step " + (stepCount++), " Select Yes on Alert. ");
			templateIndexPage.clickOnYesButton();
			waitForPageLoaded();
		} catch (Exception e) {
		}

	}

	@FindBy(xpath = "//md-menu-bar[@id='user-menu']")
	public WebElement userMenu;

	public boolean isLogedin() {
		try {
			driver.findElement(By.xpath("//md-menu-bar[@id='user-menu']")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isInLoginPage() {
		try {
			driver.findElement(By.xpath("//div[@id='login-form']")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@FindBy(xpath = "//md-menu-item/button[contains(text(),'Logout')]")
	public WebElement logoutMenu;
	XLUtils XLUtils = new XLUtils();

	public void logOut() {
		pause(2);
		waitforElementClickable(driver.findElement(By.xpath("//md-menu-bar[@id='user-menu']")));
		jsClick(driver.findElement(By.xpath("//md-menu-bar[@id='user-menu']")));

		waitforElementClickable(driver.findElement(By.xpath("//md-menu-item/button[contains(text(),'Logout')]")));
		jsClick(driver.findElement(By.xpath("//md-menu-item/button[contains(text(),'Logout')]")));
		waitForPageLoaded();

	}

	protected String datafile = System.getProperty("user.dir")
			+ "/src/main/java/com/green/rfp/qa/testdata/userData.xlsx";
	String sheet = env;

	public String getCompanyName(String user) {
		return XLUtils.dataLookup(datafile, sheet, 1, user);
	}

	public String getUsername(String user) {
		return XLUtils.dataLookup(datafile, sheet, 2, user);
	}

	public String getEmail(String user) {
		return XLUtils.dataLookup(datafile, sheet, 3, user);
	}

	public String getPassword(String user) {
		return XLUtils.dataLookup(datafile, sheet, 4, user);
	}

	public String userName = getEmail("Customer Admin");
	public String passWord = getPassword("Customer Admin");

	public String[] getUserData(String user) {
		String[] arr = new String[4];
		arr[0] = getCompanyName(user);
		arr[0] = getUsername(user);
		arr[0] = getCompanyName(user);
		arr[0] = getPassword(user);
		return arr;

	}

	public void loginAsFor(String company, String user) {

		String currentUser = null;
		int attempt = 1;

		do {
			if (!isLogedin()) {
				superAdminloginValid();
				waitForPageLoaded();
			}
			if (isRemoteCloseIcon()) {
				closingSession();
				waitForPageLoaded();
			}

			System.out.println("Loginas attempt : " + attempt);
			currentUser = null;
			loginAs(company, user);
			driver.navigate().refresh();
			waitForPageLoaded();
			currentUser = driver.findElement(By.xpath("//*[@id='user-menu']//span[contains(@class, 'username ')]"))
					.getText();
		} while (attempt++ <= retry && !user.equalsIgnoreCase(currentUser));

	}

	public void loginAsFor(String user) {
		loginAsFor(getCompanyName(user), getUsername(user));
	}

	public String getStepperTabStatus(String tabNmae) {
		WebElement tab = driver.findElement(By.xpath("//md-step-label-wrapper[@class='" + tabNmae + "']"));
		String colorRGB = ((JavascriptExecutor) driver).executeScript(
				"return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", tab)
				.toString();
		String status = "disabled";
		if (colorRGB.equals("rgb(25, 165, 30)"))
			status = "completed";
		else if (colorRGB.equals("rgb(255, 165, 0)"))
			status = "pending";
		return status;
	}

	/*
	 * question type= yesNo, freeForm
	 */
	public void createGenericRfp(String rfpName, String[] sectionname, int steps, String questionType) {
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		waitForPageLoaded();
		templateIndexPage.searchSelectTemplate(rfpName);
		pause(5);
		driver.findElement(By.xpath("//md-step-label-wrapper[@class='Needs']")).click();
		waitForPageLoaded();

		List<WebElement> tabs = driver
				.findElements(By.xpath("//div[@md-steppers-template='::step.template']//md-tab-item[@tabindex='-1']"));
		String answerType = questionType;
		String questionWeight = "Medium";
		for (int i = 0; i < tabs.size(); i++) {
			String tabName = tabs.get(i).getText();
			System.out.println("tabname: " + tabName);
			System.out.println("tabindex: " + i);
			templateIndexPage.scrollTillSections();
			tabs.get(i).click();

			testStepsLog("Step " + (stepCount++), " Scroll till New Question button.");
			templateVerificationPage = templateIndexPage.scrollTillNewQuestionBtnObj();
			testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
			templateVerificationPage = templateIndexPage.clickNewQuestion();
			testStepsLog("Step " + (stepCount++),
					" Add new question-1 with answer type,question,question weight,section");
			templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType,
					tabName + " section question 1", questionWeight, tabName);
			testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
			templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
			testStepsLog("Step " + (stepCount++), " Scroll till New Question button.");
			templateVerificationPage = templateIndexPage.scrollTillNewQuestionBtnObj();
			testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
			templateVerificationPage = templateIndexPage.clickNewQuestion();
			testStepsLog("Step " + (stepCount++),
					" Add new question-2 with answer type,question,question weight,section");
			templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType,
					tabName + " section question 2", questionWeight, tabName);
			testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
			templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		}
	}

	public void createQuestion(String answerType, String questionWeight, String SectionName, int questionCount) {
		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateIndexPage.clickNewQuestion();
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateIndexPage.fillNewQuestion(answerType, SectionName + " section question " + questionCount,
				questionWeight);

		// step to select section in runtime----

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		waitForPageLoaded();
	}

	public void createQuestion(String answerType, String questionWeight, String SectionName, String Question) {
		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateIndexPage.clickNewQuestion();
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateIndexPage.fillNewQuestion(answerType, Question, questionWeight);

		// step to select section in runtime----

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		waitForPageLoaded();
	}

	public void clickOnRFPTemplateTab(String st) {
		PresenceOfElement(By.xpath("//md-step-item//md-step-label-wrapper[@class='" + st + "']"));
		clickableElement(driver.findElement(By.xpath("//md-step-item//md-step-label-wrapper[@class='" + st + "']")));
		jsClick(driver.findElement(By.xpath("//md-step-item//md-step-label-wrapper[@class='" + st + "']")));

	}

	public boolean hasClass(WebElement element, String className) {
		String classes = element.getAttribute("class");
		for (String c : classes.split(" ")) {
			if (c.equals(className)) {
				return true;
			}
		}

		return false;
	}
}