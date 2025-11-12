package playwrightTraditional;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
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
        page1.locator(
                ".facet__list.js-facet-list.js-facet-top-values > li:nth-child(3) > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg")
                .first().click();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Color")).click();
        page1.locator(
                "#facet-Color > .facet__values > .facet__list > li > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg")
                .first().click();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Price")).click();
        page1.locator(
                "#facet-price > .facet__values > .facet__list > li:nth-child(2) > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg")
                .click();
        page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JBL Quantum True Wireless")).click();
        assertThat(page1.getByLabel("main").getByRole(AriaRole.HEADING))
                .containsText("JBL Quantum True Wireless Noise Cancelling Gaming Earbuds- Black");
        assertThat(page1.getByLabel("main")).containsText("sku 668972707");
        assertThat(page1.getByLabel("main")).containsText("$164.98");
        assertThat(page1.getByLabel("main")).containsText(
                "Adaptive noise cancelling allows awareness of environment when gaming on the go. Light weight, durable, water resist. USB-C dongle for low latency connection < than 30ms.");
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).click();
        assertThat(page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items"))).isVisible();
        page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items")).click();
        assertThat(page1.getByLabel("main")).containsText("Your Shopping Cart");
        assertThat(page1.getByLabel("main"))
                .containsText("JBL Quantum True Wireless Noise Cancelling Gaming Earbuds- Black");
        assertThat(page1.getByLabel("main")).containsText("$164.98");
        assertThat(page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Quantity, edit and press")))
                .hasValue("1");
        assertThat(page1.getByLabel("main")).containsText("Subtotal $164.98");
        assertThat(page1.getByLabel("main")).containsText(
                "Handling To support the bookstore's ability to provide a best-in-class online and campus bookstore experience, and to offset the rising costs of goods and services, an online handling fee of $3.00 per transaction is charged. This fee offsets additional expenses including fulfillment, distribution, operational optimization, and personalized service. No minimum purchase required. $3.00");
        assertThat(page1.getByLabel("main")).containsText("Taxes TBD");
        assertThat(page1.getByLabel("main")).containsText("Estimated Total $167.98");
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed To Checkout")).first().click();
        assertThat(page1.getByLabel("main")).containsText("Create Account");
        page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed As Guest")).click();
        assertThat(page1.getByLabel("main")).containsText("Contact Information");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).fill("malaeka");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)"))
                .fill("malaekaa");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).fill("amir");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address (required)")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address (required)"))
                .fill("mamir4@depaul.edu");
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number (required)")).click();
        page1.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number (required)"))
                .fill("8728086814");
        assertThat(page1.getByText("Order Summary Order Subtotal").nth(1)).isVisible();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page1.getByLabel("main"))
                .containsText("Full Name malaekaa amir Email Address mamir4@depaul.edu Phone Number +18728086814");
        assertThat(page1.locator("#bnedPickupPersonForm")).containsText(
                "Pickup Location DePaul University Loop Campus & SAIC 1 E. Jackson Boulevard, , Illinois, Chicago, 60604");
        assertThat(page1.getByText("Pickup Person I'll pick them")).isVisible();
        assertThat(page1.getByLabel("main")).containsText(
                "Order Summary Order Subtotal $164.98 Handling To support the bookstore's ability to provide a best-in-class online and campus bookstore experience, and to offset the rising costs of goods and services, an online handling fee of $3.00 per transaction is charged. This fee offsets additional expenses including fulfillment, distribution, operational optimization, and personalized service. No minimum purchase required. $3.00 Tax TBD Merchant Processing Fee TBD Total $167.98 167.98 $ Pick Up: 85 1 E. Jackson Boulevard, Chicago, Illinois, 60604, United States 312-362-8792 PICKUP DePaul University Loop Campus & SAIC JBL Quantum True Wireless Noise Cancelling Gaming Earbuds- Black Quantity: Qty: 1 $164.98");
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        assertThat(page1.getByLabel("main")).containsText(
                "Order Summary Order Subtotal $164.98 Handling To support the bookstore's ability to provide a best-in-class online and campus bookstore experience, and to offset the rising costs of goods and services, an online handling fee of $3.00 per transaction is charged. This fee offsets additional expenses including fulfillment, distribution, operational optimization, and personalized service. No minimum purchase required. $3.00 Tax $17.22 Merchant Processing Fee TBD Total $185.20 185.2 $ Pick Up: 85 1 E. Jackson Boulevard, Chicago, Illinois, 60604, United States 312-362-8792 PICKUP DePaul University Loop Campus & SAIC JBL Quantum True Wireless Noise Cancelling Gaming Earbuds- Black Quantity: Qty: 1 $164.98");
        page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Back to cart")).click();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove product JBL Quantum")).click();
        assertThat(page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 0 items"))).isVisible();
    }

}
