import org.openqa.selenium.Alert;
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
	
	
	/*****  Área e campos de texto ****/
	
	public void escrever(By by, String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}
	
	public void escrever(String id_campo, String texto) {
		
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String pegarValorDoCampo(String id_campo) {
		
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	
	/****** Radio e Check ******/
	
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
	
	/****** Combo ******/
	
	public void selecionarCombo(String id, String valor) {
		
		WebElement elemento = driver.findElement(By.id(id)); 
		Select combo = new Select(elemento);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	public String pegarValorCombo(String id) {
		
		WebElement elemento = driver.findElement(By.id(id));
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText() ;
	}
	
	
	/****** Botões ******/
	
	public void clicarBotao(String id) {
		
		driver.findElement(By.id(id)).click();
	}
	
	public String obterValueElemento(String id){
		return driver.findElement(By.id(id)).getAttribute("value");
	}
	
	/****** Link ******/
	
	public void clicarLink(String id) {
		
		driver.findElement(By.linkText(id)).click();
	}
	
	/****** Texto *****/
	
	public String pegarTexto(By by) {
		
		return driver.findElement(by).getText();
	}
	
	public String pegarTexto(String id) {
		return pegarTexto(By.id(id));
	}
	
	
	/****** Alerts ******/
	
	public String alertaObterTexto() {
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}
	
	public String alertaObterTextoAceitar() {
		
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		alert.accept();
		return texto;
	}
	
	public String alertaObterTextoNegar() {
		
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		alert.dismiss();
		return texto;
	}

	/***** Frames e Janelas *******/
	
	public void entrarFrame(String id_frame) {
		
		driver.switchTo().frame(id_frame);
	}
	
	public void sairFrame() {
		
		driver.switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		driver.switchTo().window(id);
	}
	
}
