package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Since201109Ex {
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "F:/workspace/lib/selenium-java-4.4.0/chromedriver_win32/chromedriver.exe";
    
    //ũ�Ѹ� �� URL
    private String base_url;
    
    public Since201109Ex() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.naver.com";
    }
 
    public void crawl() {
        try {
            //get page (= ���������� url�� �ּ�â�� ���� �� request �� �Ͱ� ����)
            driver.get(base_url);
            System.out.println(driver.getPageSource());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             driver.close();
        }
     }
    public static void main(String[] args) {
    	Since201109Ex selTest = new Since201109Ex();
        selTest.crawl();
    }
 }
