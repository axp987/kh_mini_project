package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class driver_test {

  public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // ����̹� ID
  public static final String WEB_DRIVER_PATH = "F:\\workspace\\lib\\chromedriver_win32\\chromedriver.exe"; // ����̹� ���

  public static void main(String[] args) {
    System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

    ChromeOptions options = new ChromeOptions();
    // ������ ������ �ʱ�
    // options.addArguments("headless");

    WebDriver driver = new ChromeDriver(options);
    driver.get("https://www.google.com/");

    driver.findElement(By.name("q")).sendKeys("������");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

    // ������ �ݱ�
    if (driver != null) {
      // driver.close();
      // driver.quit();
    }
  }
}
