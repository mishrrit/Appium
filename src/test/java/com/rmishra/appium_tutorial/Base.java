package com.rmishra.appium_tutorial;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Base {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    public InetAddress getLocalHost() throws UnknownHostException {
	InetAddress ip = InetAddress.getLocalHost();
	return ip;
    }

    public AppiumDriverLocalService AppiumServerStart() throws UnknownHostException {
	AppiumDriverLocalService service;

	// Run Appium Server
	service = new AppiumServiceBuilder()
		.withAppiumJS(new File(
			"C:\\Users\\RMISHRA\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		.withIPAddress(getLocalHost().getHostAddress()).usingPort(4723).build();
	// .withIPAddress("127.0.0.1").usingPort(4723).build();

	// Start Appium Server
	service.start();
	return service;

    }

    public void AppiumServerStop(AndroidDriver driver, AppiumDriverLocalService service) throws UnknownHostException {

	driver.quit();
	service.stop();

    }

    public UiAutomator2Options configureDC() throws MalformedURLException, UnknownHostException, InterruptedException {

	// Set capabilities
	UiAutomator2Options options = new UiAutomator2Options();
	options.setCapability("platformName", "ANDROID");
	options.setCapability("automationName", "UIAutomator2");
	options.setCapability("autoGrantPermissions", true);

	// Set device and os_version
	options.setCapability("device", "Pixel 7");
	options.setCapability("os_version", "14.0");

	// Set the apk path
	options.setCapability("app", System.getProperty("user.dir") + "\\src\\test\\java\\resources\\demo.apk");
	// options.setCapability("app","URL of the app");

	// Set other BrowserStack capabilities
	options.setCapability("project", "First Appium Project");
	options.setCapability("build", "Maven");
	options.setCapability("name", "Login Page");

	return options;

    }

    public AndroidDriver URLBuild(AndroidDriver driver, InetAddress ip, UiAutomator2Options options)
	    throws MalformedURLException {

	// create object for Android driver
	try {
	    driver = new AndroidDriver(new URL("http://" + getLocalHost().getHostAddress() + ":4723"), options);
	} catch (MalformedURLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (UnknownHostException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	// driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	return driver;
    }

    public void AcceptAlert(AndroidDriver driver) {
	Alert alert = driver.switchTo().alert();
	alert.accept();
    }

    @Test
    public void TestLoginPage() throws MalformedURLException, UnknownHostException, InterruptedException {
	InetAddress ip = null;
	AndroidDriver driver = null;
	AppiumDriverLocalService service = AppiumServerStart();
	UiAutomator2Options options = configureDC();
	driver = URLBuild(driver, ip, options);
	AcceptAlert(driver);

	// Getting Elements
	driver.findElement(By.id("com.dgotlieb.automationsample:id/userName")).sendKeys("admin");
	driver.findElement(By.id("com.dgotlieb.automationsample:id/userPassword")).sendKeys("admin");
	driver.findElement(By.id("com.dgotlieb.automationsample:id/loginButton")).click();
	WebElement ErrorMessage = driver.findElement(By.id("com.dgotlieb.automationsample:id/errorTV"));
	System.out.println("Captured text is : " + ErrorMessage.getText());
	Assert.assertEquals(ErrorMessage.getText(), "Wrong username or password");

	AppiumServerStop(driver, service);
    }

}
