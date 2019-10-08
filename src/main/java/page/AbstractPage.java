package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AbstractPage extends AndroidPageFactory {
	protected AbstractPage(AppiumDriver appiumDriver){
		super(appiumDriver);
	}

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_message")
	MobileElement androidPermissionMessageTxtView;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	MobileElement allowPermissionBtn;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	MobileElement denyPermissionBtn;

	public void checkAndroidPermissionIsDisplayed(){
		assertElementIsDisplayed(androidPermissionMessageTxtView);
	}

	public void clickAllowPermissionBtn(){
		clickElement(allowPermissionBtn);
	}

	public void clickDenyPermissionBtn(){
		clickElement(denyPermissionBtn);
	}
}
