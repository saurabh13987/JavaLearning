package com.saurabh.testcases;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFileConcept {

	public WebDriver driver;
	public File folder;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup() {
		folder = new File(UUID.randomUUID().toString());

		folder.mkdir();

		System.out.println(folder.getAbsolutePath());

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Saurabh\\OneDrive\\Desktop\\Utilities\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();

		options.addArguments("window-size=1400,800");
		options.addArguments("headless");

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());

		options.setExperimentalOption("prefs", prefs);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver(capabilities);

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void downloadFile() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.xpath("//a[text()='shalini.txt']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[text()='logo.ico']")).click();
		Thread.sleep(5000);

		File listOfFiles[] = folder.listFiles();
		Assert.assertNotEquals(listOfFiles.length, 0);

		for (File file : folder.listFiles()) {
			Assert.assertNotEquals(file.length(), 0);
			System.out.println(file.getName());
		}

		Assert.assertEquals(listOfFiles.length, 2);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();

		for (File file : folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}

}
