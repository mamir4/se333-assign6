package playwrightLLM;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BookstoreLLMTest {

    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

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
        page = context.newPage();
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
    void testSearchEarbudsFilterByColorAndAddToCart() {
        // Navigate to bookstore
        page.navigate("https://depaul.bncollege.com/");
        
        // Click on the search textbox
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).click();
        
        // Type "earbuds" in the search box
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("earbuds");
        
        // Press Enter to search
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).press("Enter");
        
        // Wait a moment for page to load
        page.waitForTimeout(2000);
        
        // Click Color filter button
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Color")).click();
        
        // Wait for color options to appear
        page.waitForTimeout(500);
        
        // Click Black color option (first li in facet list)
        page.locator("#facet-Color > .facet__values > .facet__list > li:first-child > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg")
                .first().click();
        
        // Wait for filter to apply
        page.waitForTimeout(1000);
        
        // Click on JBL Quantum product
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JBL Quantum True Wireless")).click();
        
        // Wait for product page to load
        page.waitForTimeout(1000);
        
        // Click Add to cart button
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).click();
        
        // Wait for cart to update
        page.waitForTimeout(1000);
        
        // Verify cart shows 1 item
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items"))).isVisible();
    }
}
