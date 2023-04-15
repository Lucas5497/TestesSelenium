import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import junit.framework.Assert;

public class TesteCampoTreinamento {
	@Test
	public void testeTextField() throws InterruptedException{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "/Users/lucas/Downloads/chromedriver_win321/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://wcaquino.me/selenium/componentes.html");
		
		//driver.wait(1000);
		driver.findElement(By.id("elementosForm:nome")).sendKeys("teste de escrita");
		
		Assert.assertEquals("teste de escrita",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void interagirComTextArea() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "/Users/lucas/Downloads/chromedriver_win321/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://wcaquino.me/selenium/componentes.html");
		
		
		//procura o elemento através do id, class, name xpath etc. Escreve um texto no elemento
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("testes\n\nselenium\n\nultimalinha\n\n\nops tem mais uma rsrs");
		
		driver.quit();	
	}
	
	@Test
	public void interagirComRadioButton() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "/Users/lucas/Downloads/chromedriver_win321/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://wcaquino.me/selenium/componentes.html");
		
		
		//interagindo com o radio button
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		//verificando se o botão está selecionado verifica se o resultado é true
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		driver.quit();
	}
	
	@Test
	public void interagirComCheckBox() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "/Users/lucas/Downloads/chromedriver_win321/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://wcaquino.me/selenium/componentes.html");
		
		
		//interagindo com o checkBox
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		//verificando se o botão está selecionado verifica se o resultado é true
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		
		driver.quit();
	
	}
	
}
