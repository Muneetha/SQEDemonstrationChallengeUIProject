package com.sample.test.demo.tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaTypes;

public class DemoTest extends TestBase {


	@Test
	public void demoTest() {
		System.out.println("HELLO WORLD");
	}

	@Test
	public void placeAnOrderSuccessFullyWithAllTheDetails() {
		int noOfQuantity = 10;

		// Select value for Pizza1
		selectValueFromDropDown(driver.findElement(By.id("pizza1Pizza")), PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName());

		// Select value for Pizza1
		selectValueFromDropDown(driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']")), "Olives");

		// Select value for Pizza1
		selectValueFromDropDown(driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings2']")), "Mushrooms");

		// Enter Quantity
		driver.findElement(By.id("pizza1Qty")).clear();
		driver.findElement(By.id("pizza1Qty")).sendKeys(Integer.toString(noOfQuantity));
		driver.findElement(By.id("pizza1Qty")).sendKeys(Keys.TAB);

		// Verify the cost is displayed correctly
		Float costOfPizza = Float.valueOf(driver.findElement(By.id("pizza1Cost")).getAttribute("value")).floatValue();
		float price = (float) (PizzaTypes.MEDIUM_TWOTOPPINGS.getCost() * noOfQuantity);
		Assert.assertEquals(costOfPizza, price);

		// Enter Name, Email and Phone
		driver.findElement(By.id("name")).sendKeys("Muneetha Muppalla");
		driver.findElement(By.id("email")).sendKeys("Muneethareddy@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("1231231234");

		// Select payment information
		selectValueFromRadioButton(driver.findElements(By.xpath("//input[@type='radio']")), "Cash on Pickup");

		// Click place order
		driver.findElement(By.id("placeOrder")).click();

		// Verify alert is displayed and retrieve the Text
		if (driver.findElement(By.id("dialog")).isDisplayed()) {
			System.out.println("Dialog is displayed");
			String dialogText = driver.findElement(By.xpath("//div[@id='dialog']/p")).getText();
			Float actualPrice = Float.parseFloat(dialogText.split(":")[1].trim().split(" ")[0].toString());
			Assert.assertEquals(actualPrice, price);
			System.out.println("Success message is displayed with correct price");
		} else {
			System.out.println("Dialog is not displayed");
		}

	}

	@Test
	public void cannotPlaceAnOrderWithoutName() {
		int noOfQuantity = 10;

		// Select value for Pizza1
		selectValueFromDropDown(driver.findElement(By.id("pizza1Pizza")), PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName());

		// Select value for Pizza1
		selectValueFromDropDown(driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']")), "Olives");

		// Select value for Pizza1
		selectValueFromDropDown(driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings2']")), "Mushrooms");

		// Enter Quantity
		driver.findElement(By.id("pizza1Qty")).clear();
		driver.findElement(By.id("pizza1Qty")).sendKeys(Integer.toString(noOfQuantity));
		driver.findElement(By.id("pizza1Qty")).sendKeys(Keys.TAB);

		// Verify the cost is displayed correctly
		Float costOfPizza = Float.valueOf(driver.findElement(By.id("pizza1Cost")).getAttribute("value")).floatValue();
		float price = (float) (PizzaTypes.MEDIUM_TWOTOPPINGS.getCost() * noOfQuantity);
		Assert.assertEquals(costOfPizza, price);

		// Enter Name, Email and Phone
//		name.sendKeys("Muneetha Muppalla");
		driver.findElement(By.id("email")).sendKeys("Muneethareddy@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("1231231234");

		// Select payment information
		selectValueFromRadioButton(driver.findElements(By.xpath("//input[@type='radio']")), "Cash on Pickup");

		// Click place order
		driver.findElement(By.id("placeOrder")).click();

		// Verify alert is displayed and retrieve the Text
		// Verify alert is displayed and retrieve the Text
		if (driver.findElement(By.id("dialog")).isDisplayed()) {
			System.out.println("Dialog is displayed");
			String dialogText = driver.findElement(By.xpath("//div[@id='dialog']/p")).getText();
			Assert.assertEquals(dialogText.trim(), "Missing name");
			System.out.println("Proper error message is displayed for missing name field");
		} else {
			System.out.println("Dialog is not displayed");
		}
	}

	/**
	 * Name : selectValueFromDropDown Description : This method is used to select
	 * the expected option from the given dropdown element
	 * 
	 * @param dropDown : input webElement
	 * @param expValue : Expected value
	 */
	public void selectValueFromDropDown(WebElement dropDown, String expValue) {
		Select drp = new Select(dropDown);
		List<WebElement> options = drp.getOptions();
		boolean flag = true;
		for (int i = 0; i < options.size(); i++) {
			String str1 = options.get(i).getAttribute("value").trim();
			if (str1.equalsIgnoreCase(expValue)) {
				options.get(i).click();
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("Expected option is not displayed in the DropDown");
		}
	}

	/**
	 * Name : selectValueFromRadioButton Description : Accept list of elements to
	 * select expected one from them.
	 * 
	 * @param radio     : List of options under the Radio group
	 * @param expButton : Expected Value
	 */
	public static void selectValueFromRadioButton(List<WebElement> radio, String expButton) {
		for (int i = 0; i < radio.size(); i++) {
			String str = radio.get(i).getAttribute("value").trim();
			if (str.equals(expButton)) {
				radio.get(i).click();
				break;
			}
		}
	}

}
