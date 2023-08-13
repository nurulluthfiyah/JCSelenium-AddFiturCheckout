package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddProductToCart;
import com.juaracoding.pages.Checkout;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class MainApp {
    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com");

        //for login
        LoginPage loginPage = new LoginPage();
        System.out.println("Login Success");
        loginPage.login("Admin","admin123");

        //for add product to cart
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        AddProductToCart addProductToCart = new AddProductToCart();
        System.out.println("Add Product to Cart Success");
        addProductToCart.addToCart();

        //for checkout
        // (negative tc)
        Checkout checkout = new Checkout();
        System.out.println("Checkout Failed");
        checkout.checkout(
                "Nurul",
                "Luthfiyah",
                "Indonesia",
                "Jl. KH. Syafii",
                "Jakarta Timur",
                "DKI Jakarta",
                "13910",
                "08123456789",
                "noorelgroup@gmail.com",
                false);

        //(positive tc)
        System.out.println("Checkout Success");
        checkout.checkout(
                "Nurul",
                "Luthfiyah",
                "Indonesia",
                "Jl. KH. Syafii",
                "Jakarta Timur",
                "DKI Jakarta",
                "13910",
                "08123456789",
                "noorelgroup@gmail.com",
                true);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DriverSingleton.closeObjectInstance();
    }
}