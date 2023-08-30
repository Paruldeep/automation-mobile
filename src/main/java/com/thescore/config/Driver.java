package com.thescore.config;

import com.thescore.util.Util;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
	
	// Let's not to instantiate the class
	private Driver() {}

	private static OS selectedOS;
	
	private static ThreadLocal<WebDriver> webDriver = ThreadLocal.withInitial(() -> {
		try {
			return initAppiumDriver(getOS());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	});

	public static OS getOS() {
		return selectedOS;
	}

	public static void setOS(String osType) {
		selectedOS = OS.valueOf(osType);
	}
	
	private static AndroidDriver initAppiumDriver(OS os) throws MalformedURLException {
		AndroidDriver androidDriver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("fullReset", true);
		
		if(os == OS.ANDROID) {
			capabilities.setCapability("platformName", "Android");
            capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			capabilities.setCapability("app", System.getProperty("user.dir") +"/apps/thescore.apk");
            capabilities.setCapability("deviceName", "Android Emulator");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("disableAndroidWatchers", true);
	        capabilities.setCapability("appPackage", Util.readConfigProperty("appPackage"));
	        capabilities.setCapability("appActivity", Util.readConfigProperty("appActivity"));

			String ip = Util.readConfigProperty("ip");
			String port = Util.readConfigProperty("port");
			androidDriver = new AndroidDriver(new URL("http://" + ip + ":" + port + "/wd/hub"), capabilities);
			androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return androidDriver;
		} else if(os == OS.IOS) {
			// Still need to put stub regarding IOS
			throw new IllegalStateException("Not implemented yet!");
		}

		throw new IllegalStateException("OS not supported!");
	}
	
	public static WebDriver getInstance() {
		return webDriver.get();
	}
	
	public static void close(WebDriver driver) {
		webDriver.remove();
	}
	
	public enum OS {
		IOS, ANDROID;
	}
}
