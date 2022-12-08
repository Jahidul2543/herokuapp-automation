package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.Base;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DropDownTests extends Base {
    @Test
    public void checkBoxTest(){
        String url = "http://the-internet.herokuapp.com/";
        driver.get(url);
        System.out.println("Main page is opened.");

        // Click on Form Authentication link
        driver.findElement(By.linkText("Checkboxes")).click();
        driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[1]")).click();

    }
}
