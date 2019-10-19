package frontend.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PageElementHelper {



    public PageElementHelper click(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        return this;
    }


    public PageElementHelper setValue(WebElement element, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='"+value+"';", element);
        return this;
    }


    public String getValueByAttribute(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }


    public PageElementHelper setCheckboxState(WebElement element, String state){
        boolean checked = element.isSelected();
        if (state.equals("checked")) {
            if (! checked){
                click(element);
            }
        } else {
            if (checked){
                click(element);
            }
        }
        return this;
    }


    public String getCheckCheckboxState(By locator){
        boolean checked = driver.findElement(locator).isSelected();
        if (checked) {
            return "checked";
        } else {
            return "";
        }
    }



    @Autowired private WebDriver driver;
}
