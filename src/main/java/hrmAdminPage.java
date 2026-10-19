
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class hrmAdminPage {

    // ==========================
    // LOCATOR DANG NHAP
    // ==========================

    static final By loginUsername =
            By.xpath("//input[@name='username']");

    static final By loginPassword =
            By.xpath("//input[@name='password']");

    static final By loginButton =
            By.xpath("//button[@type='submit']");

    // ==========================
    // 21 LOCATOR BAI TAP 1
    // ==========================

    // 01. Menu Admin
    static final By menuAdmin = By.xpath(
            "//aside//a[.//span[normalize-space()='Admin']]"
    );

    // 02. Menu PIM
    static final By menuPIM = By.xpath(
            "//aside//a[.//span[normalize-space()='PIM']]"
    );

    // 03. Menu Leave
    static final By menuLeave = By.xpath(
            "//aside//a[.//span[normalize-space()='Leave']]"
    );

    // 04. Input Username
    static final By inputUsername = By.xpath(
            "//label[normalize-space()='Username']" +
                    "/ancestor::div[contains(@class,'oxd-input-group')]//input"
    );

    // 05. Dropdown User Role
    static final By dropdownUserRole = By.xpath(
            "//label[normalize-space()='User Role']" +
                    "/following::div[contains(@class,'oxd-select-text')][1]"
    );

    // 06. Option Admin
    static final By optionAdmin = By.xpath(
            "//div[@role='listbox']" +
                    "//*[@role='option' and normalize-space()='Admin']"
    );

    // 07. Option ESS
    static final By optionESS = By.xpath(
            "//div[@role='listbox']" +
                    "//*[@role='option' and normalize-space()='ESS']"
    );

    // 08. Input Employee Name
    static final By inputEmployeeName = By.xpath(
            "//label[normalize-space()='Employee Name']" +
                    "/ancestor::div[contains(@class,'oxd-input-group')]//input"
    );

    // 09. Button Reset
    static final By buttonReset = By.xpath(
            "//button[@type='reset' or normalize-space()='Reset']"
    );

    // 10. Button Search
    static final By buttonSearch = By.xpath(
            "//button[@type='submit' and normalize-space()='Search']"
    );

    // 11. Top tab User Management
    static final By topUserManagement = By.xpath(
            "//nav[contains(@class,'oxd-topbar-body-nav')]" +
                    "//span[normalize-space()='User Management']"
    );

    // XPath chung cho dong thu 2
    static final String ROW_2 =
            "(//div[contains(@class,'oxd-table-body')]" +
                    "//div[contains(@class,'oxd-table-card')])[2]";

    // 12. Checkbox dong thu 2
    static final By row2Checkbox = By.xpath(
            ROW_2 + "//div[contains(@class,'oxd-checkbox-wrapper')]"
    );

    // 13. O User Role dong thu 2
    static final By row2UserRole = By.xpath(
            ROW_2 +
                    "//*[@role='cell'][3]"
    );

    // 14. Button Delete dong thu 2
    static final By row2Delete = By.xpath(
            ROW_2 +
                    "//button[contains(@class,'oxd-icon-button')][1]"
    );

    // 15. Button Edit dong thu 2
    static final By row2Edit = By.xpath(
            ROW_2 +
                    "//button[contains(@class,'oxd-icon-button')][2]"
    );

    // 16. Header User Role
    static final By headerUserRole = By.xpath(
            "//div[contains(@class,'oxd-table-header')]" +
                    "//div[contains(@class,'oxd-table-header-cell')]" +
                    "[contains(normalize-space(.),'User Role')]"
    );

    // 17. Header Employee Name
    static final By headerEmployeeName = By.xpath(
            "//div[contains(@class,'oxd-table-header')]" +
                    "//div[contains(@class,'oxd-table-header-cell')]" +
                    "[contains(normalize-space(.),'Employee Name')]"
    );

    // 18. Breadcrumb Admin / User Management
    static final By breadcrumb = By.xpath(
            "//header[contains(@class,'oxd-topbar')]" +
                    "//div[contains(@class,'oxd-topbar-header-title')]"
    );

    // 19. Button thu gon Sidebar
    static final By sidebarCollapse = By.xpath(
            "//aside//button[contains(@class,'oxd-main-menu-button')]"
    );

    // 20. Button thu gon panel System Users
    static final By systemUsersCollapse = By.xpath(
            "//div[contains(@class,'oxd-table-filter-header')]" +
                    "//button[.//i[contains(@class,'bi-chevron') " +
                    "or contains(@class,'bi-caret')]]"
    );

    // 21. Button Add
    static final By buttonAdd = By.xpath(
            "//button[contains(normalize-space(.),'Add') " +
                    "and .//i[contains(@class,'bi-plus')]]"
    );

    // ==========================
    // DANH SACH 21 LOCATOR
    // ==========================

    public static Map<String, By> locators() {

        Map<String, By> m = new LinkedHashMap<>();

        m.put("01 Menu Admin", menuAdmin);
        m.put("02 Menu PIM", menuPIM);
        m.put("03 Menu Leave", menuLeave);
        m.put("04 Input Username", inputUsername);
        m.put("05 Dropdown User Role", dropdownUserRole);
        m.put("06 Option Admin", optionAdmin);
        m.put("07 Option ESS", optionESS);
        m.put("08 Input Employee Name", inputEmployeeName);
        m.put("09 Button Reset", buttonReset);
        m.put("10 Button Search", buttonSearch);
        m.put("11 Top User Management", topUserManagement);
        m.put("12 Row 2 Checkbox", row2Checkbox);
        m.put("13 Row 2 User Role", row2UserRole);
        m.put("14 Row 2 Delete", row2Delete);
        m.put("15 Row 2 Edit", row2Edit);
        m.put("16 Header User Role", headerUserRole);
        m.put("17 Header Employee Name", headerEmployeeName);
        m.put("18 Breadcrumb", breadcrumb);
        m.put("19 Sidebar Collapse", sidebarCollapse);
        m.put("20 System Users Collapse", systemUsersCollapse);
        m.put("21 Button Add", buttonAdd);

        return m;
    }

    // ==========================
    // KIEM TRA MOT LOCATOR
    // ==========================

    public static boolean kiemTra(
            WebDriver driver, String ten, By locator) {

        List<WebElement> elements =
                driver.findElements(locator);

        if (elements.isEmpty()) {
            System.out.println(
                    ten + ": NOT FOUND | " + locator
            );
            return false;
        }

        if (elements.size() > 1) {
            System.out.println(
                    ten + ": MULTIPLE (" + elements.size() +
                            ") | " + locator
            );
            return false;
        }

        System.out.println(
                ten + ": FOUND (1) | " + locator
        );

        return true;
    }

    // ==========================
    // HAM MAIN
    // ==========================

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(20)
        );

        int found = 0;
        int notFound = 0;

        try {

            // 1. Mo trang dang nhap
            driver.get(
                    "https://opensource-demo.orangehrmlive.com/"
            );

            // 2. Dang nhap
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            loginUsername
                    )
            ).sendKeys("Admin");

            driver.findElement(loginPassword)
                    .sendKeys("admin123");

            driver.findElement(loginButton).click();

            // 3. Cho menu Admin xuat hien
            wait.until(
                    ExpectedConditions.elementToBeClickable(menuAdmin)
            );

            // 4. Chuyen sang trang Admin
            driver.findElement(menuAdmin).click();

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            inputUsername
                    )
            );

            System.out.println(
                    "\n===== BAT DAU KIEM TRA 21 LOCATOR ====="
            );

            Map<String, By> ds = locators();

            // 5. Kiem tra cac locator truoc dropdown
            for (Map.Entry<String, By> item : ds.entrySet()) {

                String ten = item.getKey();

                if (ten.startsWith("06 ") ||
                        ten.startsWith("07 ")) {
                    continue;
                }

                boolean ketQua = kiemTra(
                        driver, ten, item.getValue()
                );

                if (ketQua) {
                    found++;
                } else {
                    notFound++;
                }
            }

            // 6. Mo dropdown de kiem tra Admin va ESS
            System.out.println(
                    "\n===== KIEM TRA OPTION USER ROLE ====="
            );

            try {
                WebElement dropdown = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                dropdownUserRole
                        )
                );

                dropdown.click();

                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                optionAdmin
                        )
                );

                if (kiemTra(driver, "06 Option Admin",
                        optionAdmin)) {
                    found++;
                } else {
                    notFound++;
                }

                if (kiemTra(driver, "07 Option ESS",
                        optionESS)) {
                    found++;
                } else {
                    notFound++;
                }

            } catch (Exception e) {

                System.out.println(
                        "Loi khi mo dropdown: " +
                                e.getMessage()
                );

                // Chi ghi nhan hai option la khong tim thay khi dropdown
                // khong mo duoc; khong cong them cho thao tac dong dropdown.
                notFound += 2;
            }

            // 7. Kiem tra du lieu thuc te cua dong 2
            System.out.println(
                    "\n===== KIEM TRA DU LIEU DONG 2 ====="
            );

            By row2 = By.xpath(ROW_2);
            List<WebElement> rows =
                    driver.findElements(row2);

            if (!rows.isEmpty()) {

                String rowText = rows.get(0).getText();

                System.out.println(
                        "Noi dung dong 2: " + rowText
                );

                if (rowText.contains("bala22")) {
                    System.out.println(
                            "Username bala22: FOUND"
                    );
                } else {
                    System.out.println(
                            "Username bala22: NOT FOUND"
                    );
                    System.out.println(
                            "Du lieu demo co the da thay doi."
                    );
                }

                List<WebElement> roles =
                        driver.findElements(row2UserRole);

                if (!roles.isEmpty()) {
                    String role = roles.get(0)
                            .getText().trim();

                    System.out.println(
                            "User Role dong 2: " + role
                    );

                    if (!role.equals("ESS")) {
                        System.out.println(
                                "Luu y: Dong 2 hien khong co " +
                                        "User Role ESS nhu slide."
                        );
                    }
                }

            } else {
                System.out.println(
                        "Khong tim thay dong thu 2."
                );
            }

            // 8. In tong ket
            System.out.println(
                    "\n========== TONG KET =========="
            );

            System.out.println(
                    "FOUND: " + found
            );

            System.out.println(
                    "NOT FOUND / MULTIPLE: " + notFound
            );

            System.out.println(
                    "TONG: " + (found + notFound) + "/21"
            );

            System.out.println(
                    "Khong thuc hien xoa hoac sua du lieu."
            );

        } catch (Exception e) {

            System.out.println(
                    "LOI CHUONG TRINH: " + e.getMessage()
            );

            e.printStackTrace();

        } finally {

            driver.quit();
        }
    }
}
