package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Checkout {
    private WebDriver driver;

    public Checkout() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='button wc-forward']")
    WebElement btnViewCart;
    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    WebElement btnCheckout;
    @FindBy(xpath = "//input[@id='billing_first_name']")
    WebElement fieldFirstName;
    @FindBy(xpath = "//input[@id='billing_last_name']")
    WebElement fieldLastName;
    @FindBy(id = "billing_country")
    WebElement dropDownCountry;
    @FindBy(xpath = "//input[@id='billing_address_1']")
    WebElement fieldStreetAddress;
    @FindBy(xpath = "//input[@id='billing_city']")
    WebElement fieldTownCity;
    @FindBy(id = "billing_state")
    WebElement dropDownProvince;
    @FindBy(xpath = "//input[@id='billing_postcode']")
    WebElement fieldPostalCode;
    @FindBy(xpath = "//input[@id='billing_phone']")
    WebElement fieldPhoneNumber;
    @FindBy(xpath = "//input[@id='billing_email']")
    WebElement fieldEmail;
    @FindBy(xpath = "//input[@id='terms']")
    WebElement checkBox;
    @FindBy(xpath = "//button[@id='place_order']")
    WebElement btnPlaceOrder;
    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
    WebElement textCheckoutSuccess;
    // for negative tcs
    @FindBy(xpath = "//li[contains(text(),'Please read and accept the terms and conditions to')]")
    WebElement textMessageErrorNoClickChecbox;

    public void checkout (String paramFirstName,
                          String paramLastName,
                          String paramValueCountry,
                          String paramStreetAddress,
                          String paramfieldTownCity,
                          String paramValueProvince,
                          String paramPostalCode,
                          String paramPhoneNumber,
                          String paramEmail,
                          boolean checkBoxValue) {
        try{
            btnViewCart.click();
            DriverSingleton.scroll();
            btnCheckout.click();
        }catch (Exception ignored){
        }

        DriverSingleton.scroll();
        fieldFirstName.clear();
        fieldFirstName.sendKeys(paramFirstName);
        fieldLastName.clear();
        fieldLastName.sendKeys(paramLastName);

        DriverSingleton.selectDropdownByValue(paramValueCountry);
        fieldStreetAddress.clear();
        fieldStreetAddress.sendKeys(paramStreetAddress);
        fieldTownCity.clear();
        fieldTownCity.sendKeys(paramfieldTownCity);

        DriverSingleton.selectDropdownByValue(paramValueProvince);
        fieldPostalCode.clear();
        fieldPostalCode.sendKeys(paramPostalCode);
        fieldPhoneNumber.clear();
        fieldPhoneNumber.sendKeys(paramPhoneNumber);
        fieldEmail.clear();
        fieldEmail.sendKeys(paramEmail);
        DriverSingleton.scroll(); // scroll keatas

        if (checkBoxValue){
            checkBox.click();
            btnPlaceOrder.click();
        }else {
            btnPlaceOrder.click();
        }
    }

}
