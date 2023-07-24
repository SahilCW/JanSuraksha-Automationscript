package com.capitaworld.indexPages;
import com.capitaworld.proxy.logInProxy;
import com.capitaworld.commonutil.CommonMethods;
import com.capitaworld.commonutil.Constants;
import com.capitaworld.commonutil.DataUtil;
import com.capitaworld.config.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.Map;

public class loginUser extends AbstractPage {
    Map<String, Object> details;
    DataUtil util = null;

    public loginUser(WebDriver driver) {
        super(driver);
        System.out.println("Driver instance created---" + driver.getTitle());
        util = DataUtil.getInstance();
        details = util.getDetails();
        // TODO Auto-generated constructor stub
    }

    //login user
    @FindBy(xpath = "//mat-select[@formcontrolname='userType']//div[1]/div[2]")
    private WebElement dropDownButton;
    @FindBy(xpath = "//span[contains(text(),'Banker')]")
    private WebElement bankerDD;
    @FindBy(xpath = "//span[contains(text(),'Insurer')]")
    private WebElement insurerDD;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement userEmail;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement userPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;
    @FindBy(xpath = "//span[contains(text(),'PMSBY')]")
    private WebElement pmsbyScheme;
    @FindBy(xpath = "//span[contains(text(),'PMJJBY')]")
    private WebElement pmjjbyScheme;
    @FindBy(xpath = "//ul[2]/li[1]/a[1]/span[1]")
    private WebElement schemeName;

    //Enrollment Journey
    @FindBy(xpath = "//input[@placeholder='Enter account number']")
    private WebElement enrollACno;
    @FindBy(xpath = "//input[@placeholder='Select Date']")
    private WebElement enrollDOB;




    public void login(String user) throws InterruptedException {
        if(user.equalsIgnoreCase("Indian Banker")){
            CommonMethods.clickOnElementUsingJS(dropDownButton, driver);
            CommonMethods.clickOnElementUsingJS(bankerDD, driver);
            logInProxy loginproxy = (logInProxy)details.get(Constants.User.INDIAN_BANKER_USER);
            CommonMethods.isLoadedAndSendkeys(userEmail,driver,loginproxy.getEmail());
            CommonMethods.isLoadedAndSendkeys(userPassword,driver,loginproxy.getPassword());
            CommonMethods.sleep(15);
            CommonMethods.clickOnElementUsingJS(loginBtn,driver);
        } else if(user.equalsIgnoreCase("Central Banker")){
            CommonMethods.clickOnElementUsingJS(dropDownButton, driver);
            CommonMethods.clickOnElementUsingJS(bankerDD, driver);
            logInProxy loginproxy = (logInProxy)details.get(Constants.User.CENTRAL_BANKER_USER);
            CommonMethods.isLoadedAndSendkeys(userEmail,driver,loginproxy.getEmail());
            CommonMethods.isLoadedAndSendkeys(userPassword,driver,loginproxy.getPassword());
            CommonMethods.sleep(15);
            CommonMethods.clickOnElementUsingJS(loginBtn,driver);
        } else if(user.equalsIgnoreCase("Indian Insurer")){
            CommonMethods.clickOnElementUsingJS(dropDownButton, driver);
            CommonMethods.clickOnElementUsingJS(insurerDD, driver);
            logInProxy loginproxy = (logInProxy)details.get(Constants.User.INDIAN_INSURER_USER);
            CommonMethods.isLoadedAndSendkeys(userEmail,driver,loginproxy.getEmail());
            CommonMethods.isLoadedAndSendkeys(userPassword,driver,loginproxy.getPassword());
            CommonMethods.sleep(15);
            CommonMethods.clickOnElementUsingJS(loginBtn,driver);
        } else if(user.equalsIgnoreCase("Central Insurer")){
            CommonMethods.clickOnElementUsingJS(dropDownButton, driver);
            CommonMethods.clickOnElementUsingJS(insurerDD, driver);
            logInProxy loginproxy = (logInProxy)details.get(Constants.User.CENTRAL_INSURER_USER);
            CommonMethods.isLoadedAndSendkeys(userEmail,driver,loginproxy.getEmail());
            CommonMethods.isLoadedAndSendkeys(userPassword,driver,loginproxy.getPassword());
            CommonMethods.sleep(15);
            CommonMethods.clickOnElementUsingJS(loginBtn,driver);
        }

    }

}
