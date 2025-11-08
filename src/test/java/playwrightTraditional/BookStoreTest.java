package playwrightTraditional;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class BookStoreTest {

    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page1;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    void newContext() {
        context = browser.newContext(new Browser.NewContextOptions()
                        .setRecordVideoDir(Paths.get("videos/"))
                        .setRecordVideoSize(1280, 720));
        page1 = context.newPage();
    }
    @AfterEach
    void closeContext() {
        context.close();
    }

    @AfterAll
    static void tearDown() {
        playwright.close();
    }

    @Test
    void depaulBookstoreTest() {
        page1.navigate("https://depaul.bncollege.com/");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("earbuds");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).press("Enter");
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("brand")).click();
        page1.locator(".facet__list.js-facet-list.js-facet-top-values > li:nth-child(3) > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg").first().click();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Color")).click();
        page1.locator("#facet-Color > .facet__values > .facet__list > li > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg").first().click();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Price")).click();
        page1.locator("#facet-price > .facet__values > .facet__list > li:nth-child(2) > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg").click();
        page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JBL Quantum True Wireless")).click();

        String expectedName = "JBL Quantum True Wireless Noise Cancelling Gaming Earbuds- Black";
        assertEquals(expectedName, page1.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("JBL Quantum True Wireless Noise Cancelling Gaming Earbuds- Black")).textContent());
        String price = page1.getByText("$164.98").textContent().trim();
        assertEquals("$164.98", price);

        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).click();
        page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items")).click();

        page1.waitForSelector("a:has-text('Cart 1 items')", new Page.WaitForSelectorOptions().setTimeout(10000));
        assertTrue(page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items")).isVisible());

        page1.getByText("FAST In-Store PickupDePaul").click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).press("CapsLock");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).fill("T");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).press("CapsLock");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).fill("T");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).press("CapsLock");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).fill("TEST");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).press("CapsLock");
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply Promo Code")).click();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed To Checkout")).first().click();
        page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed As Guest")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).press("CapsLock");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).fill("M");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).press("CapsLock");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).fill("Malaeka");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).press("CapsLock");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).press("CapsLock");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).press("CapsLock");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).fill("A");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).press("CapsLock");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).fill("Amir");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address (required)")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address (required)")).fill("mamir4@depaul.edu");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number (required)")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number (required)")).fill("8728086814");
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        page1.getByText("I'll pick them up").click();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Back to cart")).click();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove product JBL Quantum")).click();
    }

}
