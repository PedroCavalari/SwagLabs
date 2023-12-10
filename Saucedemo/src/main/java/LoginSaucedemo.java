import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSaucedemo {

	@Test
	public void teste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pedro\\OneDrive\\Área de Trabalho\\Selenium\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();		
		//Maximiza a tela do navegador 
		driver.manage().window().maximize();		
		driver.get("https://www.saucedemo.com/");
			Assert.assertEquals("Swag Labs", driver.getTitle());
		
		//Digita e confere o valor inserido no campo Username
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
			Assert.assertEquals("standard_user", driver.findElement(By.id("user-name")).getAttribute("value"));
		
		//Digita o valor no campo Password
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		//Seleciona o botão de Login
		driver.findElement(By.id("login-button")).click();
		
		//Seleciona o produto "Sauce Labs Backpack" para o carrinho
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			Assert.assertEquals("remove-sauce-labs-backpack", driver.findElement(By.id("remove-sauce-labs-backpack")).getAttribute("name"));
		
		//Seleciona o produto "Sauce Labs Bike Light" para o carrinho
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
			Assert.assertEquals("remove-sauce-labs-bike-light", driver.findElement(By.id("remove-sauce-labs-bike-light")).getAttribute("name"));
		
		//Confere a listagem dos 2 itens selecionados no carrinho
		Assert.assertEquals("2",driver.findElement(By.className("shopping_cart_badge")).getText());
		
		//Clica no botão do carrinho
		driver.findElement(By.className("shopping_cart_link")).click();
		
		//Confere a tela do carrinho
		Assert.assertEquals("Your Cart",driver.findElement(By.className("title")).getText());
		
		//Seleciona o botão de Checkout
		driver.findElement(By.id("checkout")).click();
		
		//Digita e confere o valor inserido no campo first-name
		driver.findElement(By.id("first-name")).sendKeys("Pedro");
			Assert.assertEquals("Pedro", driver.findElement(By.id("first-name")).getAttribute("value"));
				
		//Digita e confere o valor inserido no campo last-name
		driver.findElement(By.id("last-name")).sendKeys("Cavalari");
			Assert.assertEquals("Cavalari", driver.findElement(By.id("last-name")).getAttribute("value"));

		//Digita e confere o valor inserido no campo postal-code
		driver.findElement(By.id("postal-code")).sendKeys("14580-000");
			Assert.assertEquals("14580-000", driver.findElement(By.id("postal-code")).getAttribute("value"));
		
		//Seleciona o botão de Continue
		driver.findElement(By.id("continue")).click();
		
		//Confere a tela do Checkout
		Assert.assertEquals("Checkout: Overview",driver.findElement(By.className("title")).getText());
				
		//Seleciona o botão de Finish
		driver.findElement(By.id("finish")).click();		
		
		//Confere a tela do Checkout Completo - Dupla confirmação
		//Realiza a confirmação do "Checkout: Complete!"
		Assert.assertEquals("Checkout: Complete!",driver.findElement(By.className("title")).getText());
		//Realiza a confirmação da mensagem de "Thank you for your order!"
		Assert.assertEquals("Thank you for your order!",driver.findElement(By.className("complete-header")).getText());
						
		//Seleciona o botão de Back Home
		driver.findElement(By.id("back-to-products")).click();
		
		driver.close();
		}
}
