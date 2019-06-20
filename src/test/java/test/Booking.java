package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Booking {

@Test
    public void Test () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://www.booking.com");
    WebElement city_field=driver.findElement(By.xpath("//input[@id='ss']"));
    city_field.sendKeys("Рим");
    WebElement dropMenu=driver.findElement(By.xpath("//li[contains(@class,'c-autocomplete__item sb-autocomplete__item sb-autocomplete__item-with_photo sb-autocomplete__item--airport sb-autocomplete__item__item--elipsis')] "));
    dropMenu.click();
    TimeUnit.SECONDS.sleep(3);
    WebElement dayDeparture=driver.findElement(By.xpath("//div[contains(@class,'bui-calendar__main')]//div[1]//table[1]//tbody[1]//tr[6]//td[7]"));
    dayDeparture.click();
    TimeUnit.SECONDS.sleep(2);
    WebElement dayArrival=driver.findElement(By.xpath("//div[@class='bui-calendar__content']/div[2]/table/tbody/tr[2]/td[7]"));
    dayArrival.click();
    WebElement buttonCheckPrice=driver.findElement(By.xpath("//div[contains(@class,'sb-searchbox-submit-col -submit-button')]//button[contains(@class,'')]"));
    buttonCheckPrice.click();
    TimeUnit.SECONDS.sleep(3);
    WebElement closeMap=driver.findElement(By.xpath("//div[@class='map_full_overlay__close']"));
    closeMap.click();
    WebElement sortMinPrice=driver.findElement(By.xpath("//li[contains(@class,'sort_price')]"));
    sortMinPrice.click();
    WebElement apartments=driver.findElement(By.xpath("//div[contains(@class,'sr_header--title')]//div[contains(@class,'sr_header')]"));
    String total=(apartments.getText()).replaceAll("[^0-9]", "");
    System.out.println("Total apartments: " + total);
    TimeUnit.SECONDS.sleep(2);


 /*   WebElement priceOfApartment=driver.findElement(By.xpath("//div[@class='prco-wrapper bui-price-display prco-sr-default-assembly-wrapper prc-d-sr-wrapper']/div[2]/div"));
    String minPrice= (priceOfApartment.getText()).replaceAll("[^0-9]", "");
    System.out.println("The price of the cheapest apartment: " +minPrice+ " UAH");*/

    List<WebElement> price = driver.findElements(By.xpath("//div[@class='prco-wrapper bui-price-display prco-sr-default-assembly-wrapper prc-d-sr-wrapper']/div[2]/div"));
 //   price.size();
    System.out.println(price.size());

    }
}
