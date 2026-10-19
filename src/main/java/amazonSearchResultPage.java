import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

public class amazonSearchResultPage {
    // Bai 3: 14 locators cua trang ket qua tim kiem adidas tren Amazon.
    // Thu tu san pham/gia/hang ton co the thay doi theo thoi gian va quoc gia.
    public static final By product3Image = By.xpath("(//div[@data-component-type='s-search-result'])[3]//img[contains(@class,'s-image')]"); // 1
    public static final By product4Price = By.xpath("(//div[@data-component-type='s-search-result'])[4]//span[contains(@class,'a-price')]/span[contains(@class,'a-offscreen')]"); // 2
    public static final By product2Price = By.xpath("(//div[@data-component-type='s-search-result'])[2]//span[contains(@class,'a-price')]/span[contains(@class,'a-offscreen')]"); // 3
    public static final By searchInput = By.id("twotabsearchtextbox"); // 4
    public static final By cart = By.id("nav-cart"); // 5
    public static final By todaysDeals = By.xpath("//a[contains(normalize-space(),\"Today's Deals\")]"); // 6
    public static final By product1AddToCart = By.xpath("(//div[@data-component-type='s-search-result'])[1]//button[contains(normalize-space(),'Add to cart')] | (//div[@data-component-type='s-search-result'])[1]//input[contains(@aria-labelledby,'add-to-cart')]"); // 7
    public static final By product2Name = By.xpath("(//div[@data-component-type='s-search-result'])[2]//h2//span"); // 8
    public static final By product1Bought = By.xpath("(//div[@data-component-type='s-search-result'])[1]//*[contains(normalize-space(),'bought in past month')]"); // 9
    public static final By product1Brand = By.xpath("(//div[@data-component-type='s-search-result'])[1]//*[normalize-space()='adidas']"); // 10
    public static final By resultsHeader = By.xpath("//*[self::h2 or self::span][normalize-space()='Results' or contains(normalize-space(),'Results')]"); // 11
    public static final By menCheckbox = By.xpath("//div[@id='s-refinements']//a[.//*[normalize-space()='Men'] or normalize-space()='Men']"); // 12
    public static final By resultsCount = By.xpath("//*[contains(normalize-space(),'results for') and contains(normalize-space(),'adidas')]"); // 13
    public static final By seeMore = By.xpath("//div[@id='s-refinements']//a[contains(normalize-space(),'See more')]"); // 14

    public static Map<String, By> locators() {
        Map<String, By> m = new LinkedHashMap<>();
        m.put("01 Product 3 image", product3Image); m.put("02 Product 4 price", product4Price);
        m.put("03 Product 2 price", product2Price); m.put("04 Search input", searchInput);
        m.put("05 Cart", cart); m.put("06 Today's Deals", todaysDeals);
        m.put("07 Product 1 add cart", product1AddToCart); m.put("08 Product 2 name", product2Name);
        m.put("09 Product 1 bought", product1Bought); m.put("10 Product 1 brand", product1Brand);
        m.put("11 Results", resultsHeader); m.put("12 Men checkbox", menCheckbox);
        m.put("13 Result count", resultsCount); m.put("14 See more", seeMore);
        return m;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.manage().window().maximize();
            driver.get("https://www.amazon.com/");
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys("adidas", Keys.ENTER);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-component-type='s-search-result']")));
            for (Map.Entry<String, By> entry : locators().entrySet()) {
                int count = driver.findElements(entry.getValue()).size();
                System.out.println(entry.getKey() + " -> " + (count > 0 ? "FOUND" : "NOT FOUND"));
            }
        } finally { driver.quit(); }
    }
}
