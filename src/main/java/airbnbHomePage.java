import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class airbnbHomePage {
    // Bai 2: 14 locators da doi chieu voi DOM hien tai cua CyberSoftbnb.
    public static final By logo = By.xpath("//nav//a[.//img[@alt='Cyber Logo'] and .//span[normalize-space()='CyberSoft']]"); // 1
    public static final By navHome = By.xpath("//nav//a[normalize-space()='Home']"); // 2
    public static final By navAbout = By.xpath("//nav//a[normalize-space()='About']"); // 3
    public static final By userProfile = By.xpath("//nav//button[.//img[contains(@src,'6596121')]]"); // 4
    public static final By locationPicker = By.xpath("//p[normalize-space()='Bạn sắp đi đâu?']/parent::div"); // 5
    public static final By datePicker = By.xpath("//div[contains(@class,'border-2') and contains(@class,'grid')]/div[contains(@class,'col-span-4')]"); // 6
    public static final By searchButton = By.xpath("//p[normalize-space()='Thêm khách']/following-sibling::div[.//span[@aria-label='search']]"); // 7
    public static final By guestsIncrease = By.xpath("//button[normalize-space()='+' or .//span[contains(@class,'anticon-plus')]]"); // 8
    public static final By guestsDecrease = By.xpath("//button[normalize-space()='-' or .//span[contains(@class,'anticon-minus')]]"); // 9
    public static final By hoChiMinhCard = By.xpath("//a[@href='/rooms/ho-chi-minh']"); // 10
    public static final By canThoTitle = By.xpath("//a[@href='/rooms/can-tho']//h2[normalize-space()='Cần Thơ']"); // 11
    public static final By filterPropertyType = By.xpath("//button[contains(normalize-space(),'Loại nơi ở')]"); // 12
    public static final By filterPrice = By.xpath("//button[normalize-space()='Giá' or contains(normalize-space(),'Giá ')]"); // 13
    public static final By nhaTrangDriveTime = By.xpath("//a[@href='/rooms/nha-trang']//p[normalize-space()='6.5 giờ lái xe']"); // 14

    // Chi dung de mo popup truoc khi kiem tra locator 08 va 09.
    private static final By guestsPicker = By.xpath("//p[normalize-space()='Thêm khách']/parent::div");

    public static Map<String, By> locators() {
        Map<String, By> m = new LinkedHashMap<>();
        m.put("01 Logo", logo); m.put("02 Home", navHome); m.put("03 About", navAbout);
        m.put("04 Profile", userProfile); m.put("05 Location", locationPicker);
        m.put("06 Date", datePicker); m.put("07 Search", searchButton);
        m.put("08 Guests plus", guestsIncrease); m.put("09 Guests minus", guestsDecrease);
        m.put("10 Ho Chi Minh card", hoChiMinhCard); m.put("11 Can Tho", canThoTitle);
        m.put("12 Property type", filterPropertyType); m.put("13 Price", filterPrice);
        m.put("14 Nha Trang driving time", nhaTrangDriveTime);
        return m;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://demo5.cybersoft.edu.vn/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

            // Locator 08/09 chi xuat hien sau khi mo popup Khách.
            List<WebElement> guestPickers = driver.findElements(guestsPicker);
            if (!guestPickers.isEmpty()) {
                guestPickers.get(0).click();
                try {
                    new WebDriverWait(driver, Duration.ofSeconds(5))
                            .until(ExpectedConditions.presenceOfElementLocated(guestsIncrease));
                } catch (Exception ignored) {
                    System.out.println("Popup khách chưa hiển thị nút +/-.");
                }
            }

            int found = 0;
            for (Map.Entry<String, By> entry : locators().entrySet()) {
                int count = driver.findElements(entry.getValue()).size();
                boolean isFound = count > 0;
                if (isFound) {
                    found++;
                }
                System.out.println(entry.getKey() + " -> " + (isFound ? "FOUND" : "NOT FOUND") + " (" + count + ")");
            }
            System.out.println("TỔNG KẾT: " + found + "/14 locator được tìm thấy.");
        } finally { driver.quit(); }
    }
}
