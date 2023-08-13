package com.juaracoding.drivers;

import com.juaracoding.drivers.strategies.DriverStrategy;
import com.juaracoding.drivers.strategies.DriverStrategyImplementer;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;
    private DriverSingleton(String driver){
        instantiate(driver);
    }

    public static void scroll() {
    }

    public static void selectDropdownByValue(String paramValueCountry) {
    }

    public void instantiate(String stategy){
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(stategy);
        assert driverStrategy != null;
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void getInstance(String driver){
        if(instance == null){
            instance = new DriverSingleton(driver);
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }
}
