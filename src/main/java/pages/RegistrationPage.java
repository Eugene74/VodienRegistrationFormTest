package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//div[@data-label='first_name']")
    private WebElement firstNameTitleText;

    @FindBy(xpath = "//div[@data-label='last_name']")
    private WebElement lastNameTitleText;

    @FindBy(xpath = "//div[@data-label='address']")
    private WebElement addressNameTitleText;

    @FindBy(xpath = "//div[@data-label='city']")
    private WebElement cityNameTitleText;

    @FindBy(xpath = "//div[@data-label='post_code']")
    private WebElement postCodeNameTitleText;

    @FindBy(xpath = "//div[@data-label='country']")
    private WebElement countryNameTitleText;

    @FindBy(xpath = "//div[@data-label='phone']")
    private WebElement phoneNameTitleText;

    @FindBy(xpath = "//div[@data-label='email']")
    private WebElement emailNameTitleText;

    @FindBy(xpath = "//div[@data-label='username']")
    private WebElement usernameNameTitleText;

    @FindBy(xpath = "//div[@data-label='password']")
    private WebElement passwordNameTitleText;

    @FindBy(css = "#register_first_name")
    private WebElement registerFirstName;

    @FindBy(xpath = "//span[contains(text(),'First Name require a minimum two characters')]")
    private WebElement invalidRegisterFirstName;

    @FindBy(xpath = "//span[contains(text(),'Enter your first name')]")
    private WebElement emptyRegisterFirstName;

//-----last name
    @FindBy(id = "register_last_name")
    private WebElement registerLastName;

    @FindBy(xpath = "//span[contains(text(),'Last Name require a minimum two characters')]")
    private WebElement invalidRegisterLastName;

    @FindBy(xpath = "//span[contains(text(),'Enter your last name')]")
    private WebElement emptyRegisterLastName;
//==========
//-----email
    @FindBy(id = "register_email")
    private WebElement registerEmail;

    //xpath = "//*[@id=\"email\"]/div[2]/span"
    @FindBy(xpath = "//span[contains(text(),'Email address is invalid')]")
    private WebElement invalidRegisterEmail;

    @FindBy(xpath = "//span[contains(text(),'Enter your email address')]")
    private WebElement emptyRegisterEmail;
//==========
//-----address
    @FindBy(id = "register_address")
    private WebElement registerAddress;

    @FindBy(xpath = "//span[contains(text(),'Address require a minimum two characters')]")
    private WebElement invalidRegisterAddress;

    @FindBy(xpath = "//span[contains(text(),'Enter your current address')]")
    private WebElement emptyRegisterAddress;
//==========
//-----city
    @FindBy(id = "register_city")
    private WebElement registerCity;

    @FindBy(xpath = "//span[contains(text(),'City requires a minimum of 2 characters')]")
    private WebElement invalidRegisterCity;

    @FindBy(xpath = "//span[contains(text(),'City required')]")
    private WebElement emptyRegisterCity;
//==========
//-----post_code
    @FindBy(id = "register_post_code")
    private WebElement registerPostCode;

    @FindBy(xpath = "//span[contains(text(),'Postcode/Zip requires a minimum of 2 characters')]")
    private WebElement invalidRegisterPostCode;

    @FindBy(xpath = "//span[contains(text(),'Post Code required')]")
    private WebElement emptyRegisterPostCode;
//==========
//------phone
    @FindBy(id = "phone_number")
    private WebElement phoneNumber;

    //xpath = "//*[@id=\"phone\"]/div[2]/span"
    @FindBy(xpath = "//span[contains(text(),'You must enter a valid phone or mobile number')]")
    private WebElement invalidRegisterPhone;

    @FindBy(xpath = "//span[contains(text(),'Enter your phone or mobile number')]")
    private WebElement emptyRegisterPhone;
    // The length must be a minimum 4 characters
    @FindBy(xpath = "//span[contains(text(),'The length must be a minimum 4 characters')]")
    private WebElement invalidLengthRegisterPhone;
//==========
//------Country
    @FindBy(id = "country_name")
    private WebElement countryName;

    //todo выпадающий список стран или первая буква и подсказака

//==========
//------state
    @FindBy(id = "state_field")
    private WebElement stateField;
    @FindBy(xpath = "//span[contains(text(),'Enter you state')]")
    private WebElement emptyStateField;

    //todo выпадающий список штатаов и тут нет подсказки

//==========
//---------checkBox
    //xpath = "//*[@id=\"vodien_member_register\"]/div[9]/div[2]/label"
    @CacheLookup
    @FindBy(css = ".g-custom-checkbox")
    private WebElement checkBox;
//==========
//---------username
    @FindBy(id = "register_username")
    private WebElement registerUsername;

    @FindBy(xpath = "//span[contains(text(),'Username must be at least 2 valid characters')]")
    private WebElement invalidRegisterUsername;

    @FindBy(xpath = "//span[contains(text(),'Choose a username for your account')]")
    private WebElement emptyRegisterUsername;

    @FindBy(xpath = "//span[contains(text(),'Username is already taken')]")
    private WebElement isAlreadyTakenRegisterUsername;
//==========
//---------Password
    @FindBy(id = "pass")
    private WebElement pass;

    //xpath = "//*[@id=\"password\"]/div[2]/span"
    @FindBy(xpath = "//span[contains(text(), 'Password must be at least 8 valid characters')]")
    private WebElement invalidRegisterPassword;

    @FindBy(xpath = "//span[contains(text(),'Choose a password for your account')]")
    private WebElement emptyRegisterPassword;

    @FindBy(xpath = "//span[contains(text(),'Password is not strong enough')]")
    private WebElement notStrongPassRegisterPassword;
//==========

    @FindBy(id = "continue_order")
    private WebElement continueOrder;

    //xpath = "//*[@id=\"vodien_member_register\"]/div[9]/div[1]" //span[@class= "linkTip tip_link"]
    @FindBy(xpath = "//span[@class= \"linkTip tip_link\" and contains(text(),'Contact Permission')]")
    private WebElement contactPermission;
    // todo при наведении появляется подсказака проверить "во всех полях"


    public WebElement getNotStrongPassRegisterPassword() {
        return notStrongPassRegisterPassword;
    }

    public WebElement getIsAlreadyTakenRegisterUsername() {
        return isAlreadyTakenRegisterUsername;
    }

    public WebElement getFirstNameTitleText() {
        return firstNameTitleText;
    }

    public WebElement getLastNameTitleText() {
        return lastNameTitleText;
    }

    public WebElement getAddressNameTitleText() {
        return addressNameTitleText;
    }

    public WebElement getCityNameTitleText() {
        return cityNameTitleText;
    }

    public WebElement getPostCodeNameTitleText() {
        return postCodeNameTitleText;
    }

    public WebElement getCountryNameTitleText() {
        return countryNameTitleText;
    }

    public WebElement getPhoneNameTitleText() {
        return phoneNameTitleText;
    }

    public WebElement getEmailNameTitleText() {
        return emailNameTitleText;
    }

    public WebElement getUsernameNameTitleText() {
        return usernameNameTitleText;
    }

    public WebElement getPasswordNameTitleText() {
        return passwordNameTitleText;
    }

    public WebElement getInvalidLengthRegisterPhone() {
        return invalidLengthRegisterPhone;
    }

    public WebElement getContactPermission() {
        return contactPermission;
    }

    public WebElement getInvalidRegisterPhone() {
        return invalidRegisterPhone;
    }

    public WebElement getInvalidRegisterUsername() {
        return invalidRegisterUsername;
    }

    public WebElement getEmptyRegisterUsername() {
        return emptyRegisterUsername;
    }

    public WebElement getEmptyRegisterPassword() {
        return emptyRegisterPassword;
    }

    public WebElement getInvalidRegisterEmail() {
        return invalidRegisterEmail;
    }

    public WebElement getInvalidRegisterPassword() {
        return invalidRegisterPassword;
    }

    public WebElement getRegisterFirstName() {
        return registerFirstName;
    }

    public WebElement getRegisterLastName() {
        return registerLastName;
    }

    public WebElement getRegisterEmail() {
        return registerEmail;
    }

    public WebElement getRegisterAddress() {
        return registerAddress;
    }

    public WebElement getRegisterCity() {
        return registerCity;
    }

    public WebElement getRegisterPostCode() {
        return registerPostCode;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getStateField() {
        return stateField;
    }

    public WebElement getCountryName() {
        return countryName;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public WebElement getRegisterUsername() {
        return registerUsername;
    }

    public WebElement getPass() {
        return pass;
    }

    public WebElement getContinueOrder() {
        return continueOrder;
    }

    public WebElement getEmptyRegisterPhone() {
        return emptyRegisterPhone;
    }

    public WebElement getInvalidRegisterFirstName() {
        return invalidRegisterFirstName;
    }

    public WebElement getEmptyRegisterFirstName() {
        return emptyRegisterFirstName;
    }

    public WebElement getInvalidRegisterLastName() {
        return invalidRegisterLastName;
    }

    public WebElement getEmptyRegisterLastName() {
        return emptyRegisterLastName;
    }

    public WebElement getEmptyRegisterEmail() {
        return emptyRegisterEmail;
    }

    public WebElement getInvalidRegisterAddress() {
        return invalidRegisterAddress;
    }

    public WebElement getEmptyRegisterAddress() {
        return emptyRegisterAddress;
    }

    public WebElement getInvalidRegisterCity() {
        return invalidRegisterCity;
    }

    public WebElement getEmptyRegisterCity() {
        return emptyRegisterCity;
    }

    public WebElement getInvalidRegisterPostCode() {
        return invalidRegisterPostCode;
    }

    public WebElement getEmptyRegisterPostCode() {
        return emptyRegisterPostCode;
    }

    public WebElement getEmptyStateField() {
        return emptyStateField;
    }
}

