package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class url_test03 {
	public static String id = "webdriver.chrome.driver";
	public static String path = "F:\\workspace\\lib\\selenium-java-4.4.0\\chromedriver_win32\\chromedriver.exe";
	
	private WebDriver driver;
	
	//크롤링 할 URL
	private String url;
	
	public url_test03() {
        super();
 
        //System Property SetUp
        System.setProperty(id, path);
        
        //Driver SetUp
        driver = new ChromeDriver();
        url = "https://vibe.naver.com/chart/total";
    }
	
	public void crawl() {
		try {
			driver.get(url);
			System.out.println(driver.getPageSource());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			driver.close();
		}
	}
	
	public static void main(String[] args) {
		url_test03 url03 = new url_test03();
		url03.crawl();
		
	}
}
