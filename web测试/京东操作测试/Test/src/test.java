import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Example {

    // Mooctest Selenium Example

    // <!> Check if selenium-standalone.jar is added to build path.

    public static void test(WebDriver driver) throws InterruptedException {
        driver.get("https://www.jd.com/");
        WebElement city = driver.findElement(By.id("ttbar-mycity"));
        city.click();
        List<WebElement> citys = city.findElements(By.className("item"));
        for(WebElement c : citys){
            if (c.getText().equals("江苏")) {
                c.click();
                break;
            }
        }


        WebElement book = driver.findElement(By.linkText("图书"));
        book.click();
        switchHandle(driver);
        Thread.sleep(1000);

        WebElement element = driver.findElement(By.id("search-2014"));
        WebElement inputElement = element.findElement(By.tagName("input"));
        inputElement.sendKeys("软件测试朱少民");
        Thread.sleep(1000);
        WebElement searchElement = element.findElement(By.tagName("button"));
        searchElement.click();

        //driver.navigate().refresh();
        Thread.sleep(1000);
        element = driver.findElement(By.linkText("大学教材"));
        element.click();
        //driver.navigate().refresh();
        element = driver.findElement(By.className("f-sort"));
        element.findElement(By.linkText("价格")).click();
        Thread.sleep(1000);
        element.findElement(By.linkText("价格")).click();


        element = driver.findElement(By.className("ui-area-content"));
        driver.findElement(By.className("ui-area-text")).click();
        Thread.sleep(1000);
        List<WebElement> webElements = driver.findElements(By.className("ui-switchable-item"));
        webElements.get(0).click();
        List<WebElement> elements = element.findElements(By.tagName("a"));
        for (WebElement e : elements){
            if (e.getAttribute("data-id").equals("12")) {
                e.click();
                break;
            }
        }
        Thread.sleep(1000);
        elements = element.findElements(By.tagName("a"));
        for (WebElement e : elements){
            if (e.getAttribute("data-id").equals("904")) {
                e.click();
                break;
            }
        }
        Thread.sleep(1000);
        elements = element.findElements(By.tagName("a"));
        for (WebElement e : elements){
            if (e.getAttribute("data-id").equals("3377")) {
                e.click();
                break;
            }
        }
        Thread.sleep(1000);
        element = driver.findElement(By.linkText("京东物流"));
        element.click();
        Thread.sleep(1000);
        element = driver.findElement(By.className("f-price"));
        elements = element.findElements(By.tagName("input"));
        elements.get(0).sendKeys("35");
        elements.get(1).sendKeys("60");
        driver.findElement(By.id("J_selectorPrice")).click();
        driver.findElement(By.linkText("确定")).click();
        Thread.sleep(1000);
        elements = driver.findElements(By.className("gl-item"));
        element = elements.get(2).findElement(By.tagName("a"));
        element.click();
        switchHandle(driver);
        Thread.sleep(1000);
        driver.findElement(By.className("btn-add")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("加入购物车")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("去购物车结算")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("-")).click();
        driver.findElement(By.linkText("去结算")).click();

        Thread.sleep(20000);

        driver.findElement(By.linkText("去结算")).click();
        Thread.sleep(1000);

//        driver.findElement(By.linkText("新增收货地址")).click();
//        Thread.sleep(1000);
//        driver.switchTo().frame("dialogIframe");
//        element = driver.findElement(By.id("jd_area"));
//        driver.findElement(By.id("jd_area")).click();
//        Thread.sleep(1000);
//        elements = element.findElements(By.tagName("a"));
//        for (WebElement e : elements){
//            if (e.getAttribute("data-id").equals("12")) {
//                e.click();
//                break;
//            }
//        }
//        Thread.sleep(1000);
//        elements = element.findElements(By.tagName("a"));
//        for (WebElement e : elements){
//            if (e.getAttribute("data-id").equals("904")) {
//                e.click();
//                break;
//            }
//        }
//        Thread.sleep(1000);
//        elements = element.findElements(By.tagName("a"));
//        for (WebElement e : elements){
//            if (e.getAttribute("data-id").equals("3377")) {
//                e.click();
//                break;
//            }
//        }
//        Thread.sleep(1000);
//        driver.findElement(By.id("consignee_name")).sendKeys("somnus");
//        driver.findElement(By.id("consignee_address")).sendKeys("南京大学（鼓楼校区）汉口路 22号");
//        driver.findElement(By.id("consignee_mobile")).sendKeys("13712345678");
//        Thread.sleep(1000);
//        driver.findElement(By.id("saveConsigneeTitleDiv")).click();
//        driver.switchTo().defaultContent();


        Thread.sleep(1000);
        driver.findElement(By.id("order-submit")).click();
        Thread.sleep(1000);


        driver.findElement(By.linkText("我的订单")).click();
        switchHandle(driver);
        driver.findElement(By.id("ordertoPay")).click();
        Thread.sleep(1000);
//        driver.findElement(By.linkText("取消订单")).click();
//        Thread.sleep(1000);
//        driver.switchTo().frame("dialogIframe");
//        driver.findElements(By.className("reason")).get(3).click();
//        driver.findElement(By.linkText("提交")).click();
//        driver.switchTo().defaultContent();
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.close();
    }

    static void switchHandle(WebDriver driver){

        String handle = driver.getWindowHandle();
        for (String temhandle : driver.getWindowHandles()) {
            if (!temhandle.equals(handle))
                driver.close();
            driver.switchTo().window(temhandle);

        }
    }
    public static void main(String[] args) {
        // Run main function to test your script.
        WebDriver driver = new ChromeDriver();
        try {
            test(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
