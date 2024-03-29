package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class LoginPage extends AbstractPage {
	public LoginPage(AppiumDriver appiumDriver){
		super(appiumDriver);
	}

	@AndroidFindBy(id = "txt_title_dialog")
	MobileElement allowDialogTxtView;

	@AndroidFindBy(id = "btn_positive")
	MobileElement setujuBtn;

	@AndroidFindBy(id = "btn_negative")
	MobileElement batalBtn;

	@AndroidFindBy(id = "inputMobileNumber")
	MobileElement nomorPonselTxtBox;

	@AndroidFindBy(id = "inputPIN")
	MobileElement pinTxtBox;

	@AndroidFindBy(id = "btn_sign_in")
	MobileElement signInBtn;

	@AndroidFindBy(id = "btn_join")
	MobileElement joinNowBtn;

	@AndroidFindBy(id = "btn_help_center")
	MobileElement helpCenterBtn;

	@AndroidFindBy(id = "md_content")
	MobileElement errorLoginMessageTxtView;

	@AndroidFindBy(id = "md_buttonDefaultPositive")
	MobileElement okeErrorLoginBtn;

	@Step("Check Login Screen Is Displayed")
	public void checkLoginPageIsDisplayed(){
		assertElementIsDisplayed(allowDialogTxtView);
	}

	@Step("Click Setuju Button")
	public void clickSetujuBtn(){
		clickElement(setujuBtn);
	}

	public void clickBatalBtn(){
		clickElement(batalBtn);
	}

	@Step("Input Nomor Ponsel Textbox")
	public void inputNomorPonselTxtBox(String nomorPonsel){
		clickElement(nomorPonselTxtBox);
		inputTextToElement(nomorPonselTxtBox, nomorPonsel);
	}

	@Step("Input PIN")
	public void inputNomorPinTxtBox(String pin){
		clickElement(pinTxtBox);
		inputTextToElement(pinTxtBox, pin);
	}

	@Step("Click Sign In Button")
	public void clickSignInBtn(){
		clickElement(signInBtn);
	}

	public void clickJoinNowBtn(){
		clickElement(joinNowBtn);
	}

	public void clickBtnHelpCenterBtn(){
		clickElement(helpCenterBtn);
	}

	@Step("Check Error Login Message Text View Is Displayed")
	public void checkErrorLoginMessageTxtViewIsDisplayed(){
		assertElementIsDisplayed(errorLoginMessageTxtView);
	}

	@Step("Click Oke Login Button")
	public void clickOkeLoginBtn(){
		clickElement(okeErrorLoginBtn);
	}
}
