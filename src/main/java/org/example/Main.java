package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            Page page1 = context.newPage();
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
            page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).click();
            page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items")).click();
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
}