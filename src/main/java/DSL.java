import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void escrever(String id_campo, String texto) {
		
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String pegarValorDoCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public void clicarRadio(String id) {
		driver.findElement(By.id(id)).click();	
	}
	
	public boolean verRadioMarcado (String id) {
		return driver.findElement(By.id(id)).isSelected();	
	}
	
	public void clicarCheckBox(String id) {
		driver.findElement(By.id(id)).click();	
	}
	 
	public boolean verCheckBoxMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();	
	}
	
	public void selecionarCombo(String id, String valor) {
		WebElement elemento = driver.findElement(By.id(id)); 
		Select combo = new Select(elemento);
		combo.selectByVisibleText(valor);
	}
	
	public String pegarValorCombo(String id) {
		WebElement elemento = driver.findElement(By.id(id));
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText() ;
	}
	
	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarLink(String id) {
		driver.findElement(By.linkText(id)).click();
	}
	
	public String pegarTexto(By by) {
		return driver.findElement(by).getText();
	}
	
	
	
}
