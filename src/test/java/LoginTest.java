import common.BaseAndroidTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class LoginTest extends BaseAndroidTest{

	@Test()
	public void LoginPage() throws InterruptedException {
		onboardingPage.checkOnboardingScreenIsDisplayed();
		onboardingPage.swipeOnboardingLayout();
		onboardingPage.clickMulaiBtn();

		loginPage.checkLoginPageIsDisplayed();
		loginPage.clickSetujuBtn();
		loginPage.checkAndroidPermissionIsDisplayed();
		loginPage.clickAllowPermissionBtn();
		loginPage.inputNomorPonselTxtBox("085711114071");
		loginPage.inputNomorPinTxtBox("123456");
		loginPage.clickSignInBtn();
		loginPage.checkErrorLoginMessageTxtViewIsDisplayed();
		loginPage.clickOkeLoginBtn();
	}


		public static void startLogin() {

	}
}
