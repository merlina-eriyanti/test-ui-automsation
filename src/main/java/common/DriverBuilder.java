package common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverBuilder {
	private String platform;
	private String appName;
	public AppiumDriver driver;
	private AppiumDriverLocalService appiumService;
	String appiumServiceUrl;
	private AppiumServiceBuilder builder;
	protected DesiredCapabilities capabilities;

	public AppiumDriver getDriver(){
		return driver;
	}

	public void startServer(){
		appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
		appiumServiceUrl = appiumService.getUrl().toString();
	}

	public void setDriver() throws Exception {
		if (platform.contains("Android")){
			File appDir = new File(Constant.DEFAULT_APP_PATH);
			File app = new File(appDir, Constant.DEFAULT_ANDROID_APP_NAME);
			capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Constant.DEFAULT_ANDROID_PLATFORM_VERSION);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Constant.DEFAULT_ANDROID_DEVICE_NAME);
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, Constant.DEFAULT_ANDROID_FULL_RESET_VALUE);
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, Constant.DEFAULT_ANDROID_COMMAND_TIMEOUT);
			capabilities.setCapability("appPackage", Constant.DEFAULT_ANDROID_PAKCAGE_NAME);
			capabilities.setCapability("appWaitActivity", Constant.DEFAULT_ANDROID_WAIT_ACTIVITY);
			capabilities.setCapability("appActivity", Constant.DEFAULT_ANDROID_ACTIVITY_NAME);
			capabilities.setCapability("recreateChromeDriverSessions", true);
			driver = new AndroidDriver(new URL(appiumServiceUrl), capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
	}

	protected void setPlatform(String platform){
		this.platform = platform;
	}

	protected void setApp(String appName){
		this.appName = appName;
	}

	public void stopServer() {
		appiumService.stop();
	}
}

