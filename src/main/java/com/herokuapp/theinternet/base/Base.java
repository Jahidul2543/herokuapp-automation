package com.herokuapp.theinternet.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base {
    protected WebDriver driver;

    @Parameters({ "browser", "osName" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, String osName) {
        // Create driver
        System.out.println("Create driver: " + browser);
        switch (browser) {
            case "chrome":
                if(osName.equals("mac"))
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                else if (osName.equals("windows"))
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "firefox":
                if(osName.equals("mac"))
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                else if (osName.equals("windows"))
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Do not know how to start: " + browser + ", starting chrome.");
                if(osName.equals("mac"))
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                else if (osName.equals("windows"))
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("Close driver");
        // Close browser
        driver.quit();
    }

}
