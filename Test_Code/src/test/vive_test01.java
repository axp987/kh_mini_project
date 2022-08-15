package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class vive_test01 {
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // ����̹� ID
	public static final String WEB_DRIVER_PATH = "F:\\workspace\\lib\\chromedriver_win32\\chromedriver.exe"; // ����̹� ���
	
	
	public static void main(String[] args) {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

	    ChromeOptions options = new ChromeOptions();
	    // ������ ������ �ʱ�
	    options.addArguments("headless");

	    WebDriver driver = new ChromeDriver(options);
	    driver.get("https://vibe.naver.com/chart/total");

	    WebElement list = driver.findElement(By.className("tracklist"));
	    //driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//	    try {
//	    	Thread.sleep(1000);
//	    }catch(Exception e) {
//	    	e.printStackTrace();
//	    }
	    
	    WebElement rank = driver.findElement(By.className("/html/body/div/div/div/div[3]/div/div[4]/div[2]/div/table/tbody/tr[1]/td[3]/span"));
	    WebElement song = driver.findElement(By.className("inner_cell"));
	    WebElement artist = driver.findElement(By.className("link_artist"));
	    
	    //System.out.println(list.getText());
	    System.out.println("����: " + rank.getText());
	    //System.out.println("����: " + song.getText());
	    //System.out.println("����: " + artist.getText());
	    
	    // ������ �ݱ�
	    if (driver != null) {
	       //driver.close();
	       //driver.quit();
	    }
	}

}
