import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	
	@Test
	public void cadastro() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driverwhitelistedIps", "C://Users//lucas\\OneDrive//Área de Trabalho//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://wcaquino.me/selenium/componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lucas");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Lopes");
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		//verificando se o botão está selecionado verifica se o resultado é true
		//Assert.assertTrue(!driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		//interagindo com o checkBox
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		
		//verificando se o botão está selecionado verifica se o resultado é true
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		//interagindo com a lista | Inicializando a instãncia do webelement 
		WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		//interagindo com o combo
		Select combo = new Select(elemento);
		combo.selectByValue("superior");
		
		//Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Aprendam Java e Selenium");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		System.out.print(driver.findElement(By.id("resultado")).getText());
		
		Assert.assertTrue("Cadastrado!", driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue("Lucas", driver.findElement(By.id("descNome")).getText().endsWith("Lucas"));
		
		//Assert.assertEquals("Lopes", driver.findElement(By.id("descSobrenome")).getText());
		
		//Assert.assertEquals("Masculino", driver.findElement(By.id("descSexo")).getText());
		//Assert.assertEquals("Masculino", driver.findElement(By.id("descComida")).getText());
		//Assert.assertEquals("Masculino", driver.findElement(By.id("descEscolaridade")).getText());
		//Assert.assertEquals("Masculino", driver.findElement(By.id("descEsportes")).getText());
		
		//Assert.assertEquals("Aprendam Java e Selenium", driver.findElement(By.id("descSugestoes")).getText());
		
		
		
		driver.quit();
		
		
	}

}
