AUTOMATION TEST 1 - 3 BAI TAP LOCATOR

Yeu cau theo slide:
Bai 1: hrmAdminPage.java - 21 locators OrangeHRM
Bai 2: airbnbHomePage.java - 14 locators CyberSoftbnb
Bai 3: amazonSearchResultPage.java - 14 locators Amazon
Tong cong: 49 locators.

HUONG DAN:
1. Mo IntelliJ IDEA -> Open -> chon thu muc AutomationTest1.
2. Cho Maven tai dependency Selenium (pom.xml).
3. Cai Chrome va Java JDK 17 hoac moi hon.
4. Mo tung file trong src/main/java va chay main().
5. Quan sat ket qua FOUND/NOT FOUND trong Run.

LUU Y QUAN TRONG:
- Locator la phuong an de xuat dua tren slide, CHUA DUOC XAC MINH TREN DOM TRANG WEB THAT.
- Giao dien va thu tu san pham Amazon thay doi theo thoi gian. So lieu tren slide
  nhu '$53.00', 'bala22', ngay 07/12/2024 co the khong con dung.
- Option User Role (Bai 1), nut +/- khach (Bai 2) chi xuat hien khi mo dropdown/popup.
- Ket qua NOT FOUND can duoc kiem tra qua Inspect (F12) va cap nhat XPath.
- Khong click Delete, Add to cart hoac tao/xoa du lieu; chuong trinh chi kiem tra locator.
