package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TestPage extends Base {


    @FindBy(how = How.CLASS_NAME, using = "_2zrpKA")
    private WebElement loginNumber;

    @FindBy(how = How.XPATH, using = "//input[@type=\"password\"]")
    private WebElement loginPassword;

    @FindBy(how = How.CLASS_NAME, using = "_2zrpKA")
    private WebElement loginBtn;

    @FindBy(how = How.XPATH, using = "//div[@class='_1Q5BxB' and text()='Logout']")
    private WebElement logoutBtn;

    @FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
    private WebElement profileBtn;

    @FindBy(how = How.XPATH, using = "//*[@class='_34Yjv1']")
    private WebElement linkLogout;

    @FindBy(how = How.XPATH, using = "//span[@class='_35KyD6']")
    private WebElement prodctDesc;

    @FindBy(how = How.XPATH, using = "//div[@class='_1vC4OE _3qQ9m1']")
    private WebElement productPrice;

    @FindBy(how = How.XPATH, using = "//div[@class='_1vC4OE _2rQ-NK']")
    private WebElement listPrice;
    @FindBy(how = How.XPATH, using = "//img[@class='_1Nyybr  _30XEf0' and @alt='Realme C2 (Diamond Blue, 16 GB)']")
    private WebElement mobileImage;
    @FindBy(how = How.XPATH, using = "//input[@class='LM6RPg' and @type='text']")
    private WebElement searchBox;
    @FindBy(how = How.XPATH, using = "//button[@class='vh79eN' and @type='submit']")
    private WebElement searchBtn;

    public TestPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getMobileImage() {
        return mobileImage;
    }

    public WebElement getLoginNumber() {
        return loginNumber;
    }

    public WebElement getLoginPassword() {
        return loginPassword;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }

    public WebElement getProdctDesc() {
        return prodctDesc;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getListPrice() {
        return listPrice;
    }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }

    public WebElement getLinkLogout() {
        return linkLogout;
    }

    public WebElement getProfileBtn() {
        return profileBtn;
    }
}
