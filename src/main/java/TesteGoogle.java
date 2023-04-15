import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TesteGoogle {
	@Test
	public void teste() {
		
		//inicialização do driver e configurações
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "/Users/lucas/Downloads/chromedriver_win321/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(co);
		
		//comanddo para maximizar a tela do navegador.
		driver.manage().window().maximize();
		
		//comando para abrir a tela em um tamanho específico.
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		//comando para abrir uma página web.
		driver.get("https://wcaquino.me/selenium/componentes.html");
		
		//comando para abrir uma página web dentro da raiz do projeto.
		//driver.get("file:///" + System.getProperty("user.dir") + "src/main/resources/component.html");
		
		//retorna raiz do projeto
		System.getProperty("user.dir");
		
		//comadando para verificar a igualdade de um elemento.
		Assert.assertEquals("Campo de Treinamento", driver.getTitle());
		
		//comando para printar o conteúdo no terminal.
		System.out.println(driver.getTitle());
		
		//comadando para fechar o navegador.
		driver.quit();
		


	}
}