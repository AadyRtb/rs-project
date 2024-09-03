package com.tp.webTest;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.nio.file.Path;
import java.nio.file.Paths;


public class TestCase {
    public WebDriver webDriver;


    @Test
    public void openBaibu() {
      Path p1= Paths.get("src","drivers","chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",p1.toAbsolutePath().toString());
      webDriver=new ChromeDriver();
        webDriver.get("http://localhost:8080/doc.html#/home");
    }
}
