package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductToCart {
    JavascriptExecutor js;
    private WebDriver driver;
    public AddProductToCart(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    @FindBy(className = "cart-button")
    WebElement btnCart;
    @FindBy(xpath = "//a[@class='button wc-backward wp-element-button']")
    WebElement btnReturnShop;
    @FindBy(className = "noo-product-inner")
    WebElement productItem;
    @FindBy(id = "pa_color")
    WebElement colorItem;
    @FindBy(id = "pa_size")
    WebElement sizeItem;
    @FindBy(className = "single_add_to_cart_button")
    WebElement btnAddToCart;
    @FindBy(className = "woocommerce-message")
    WebElement messageAddToCartSuccess;
    @FindBy(xpath = "//a[contains(text(),'clear shopping cart')]")
    WebElement btnClearShoppingCart;

    public void addToCart(){
        js.executeScript("window.scrollBy(0,-500)");
        btnCart.click();
        btnReturnShop.click();
        js.executeScript("window.scrollBy(0,500)");
        productItem.click();
        js.executeScript("window.scrollBy(0,500)");
        colorItem.sendKeys("Beige");
        sizeItem.sendKeys("Large");
        btnAddToCart.click();
        DriverSingleton.getDriver();
    }
}
