/*import org.junit.Assert;
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
}*/

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TesteGoogle {
	
    @Test
    public void testAllCliAttributes() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("C:\\Users\\lucas\\eclipse-workspace\\lerXmlCadpos\\lerXmlCadpos\\src\\main\\example.xml"));

        NodeList nodeList = document.getElementsByTagName("Cli");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element cliElement = (Element) nodeList.item(i);
            
            //System.out.println("CLI [PASS]");
            String tipCli = cliElement.getAttribute("TipCli");
            
            Assert.assertTrue(tipCli.equals("1") || tipCli.equals("2"));
            Assert.assertNotNull(tipCli); // Verifica se o atributo não é nulo
            Assert.assertNotEquals("", tipCli); // Verifica se o atributo não é vazio
            System.out.printf("tipCli:"+tipCli+ " [OK] ");

            
            String idfcCli = cliElement.getAttribute("IdfcCli");
            //Assert.assertEquals("1", idfcCli);
            Assert.assertNotNull(idfcCli); // Verifica se o atributo não é nulo
            Assert.assertNotEquals("", idfcCli); // Verifica se o atributo não é vazio
            
            
            String nmCli = cliElement.getAttribute("NmCli");
            //Assert.assertEquals("100000XXXXXXXXXXXXXXXXXXXXXXXXXXXX", nmCli);
            Assert.assertNotNull(nmCli); // Verifica se o atributo não é nulo
            Assert.assertNotEquals("", nmCli); // Verifica se o atributo não é vazio
            
            String ntzRlc = cliElement.getAttribute("NtzRlc");
            //Assert.assertEquals("1", ntzRlc);
            Assert.assertNotNull(ntzRlc); // Verifica se o atributo não é nulo
            Assert.assertNotEquals("", ntzRlc); // Verifica se o atributo não é vazio

            String hstCmt = cliElement.getAttribute("HstCmt");
            //Assert.assertEquals("1", hstCmt);
            Assert.assertNotNull(hstCmt); // Verifica se o atributo não é nulo
            Assert.assertNotEquals("", hstCmt); // Verifica se o atributo não é vazio
            
            String cdOcr = cliElement.getAttribute("CdOcr");
            //Assert.assertEquals("1", cdOcr);
            Assert.assertNotNull(cdOcr); // Verifica se o atributo não é nulo
            Assert.assertNotEquals("", cdOcr); // Verifica se o atributo não é vazio
            
            
            
            
            
            System.out.println("CLI "+i+" [PASS] ");
         
        }
        
    }

    @Ignore
    public void aplicarFor() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("C:\\\\Users\\\\lucas\\\\eclipse-workspace\\\\lerXmlCadpos\\\\lerXmlCadpos\\\\src\\\\main\\\\example.xml"));
        Element cliElement = (Element) document.getElementsByTagName("Cli").item(0);

        String tipCli = cliElement.getAttribute("TipCli");
        Assert.assertEquals("1", tipCli);

        String idfcCli = cliElement.getAttribute("IdfcCli");
        Assert.assertEquals("1", idfcCli);

        String nmCli = cliElement.getAttribute("NmCli");
        Assert.assertEquals("John Smith", nmCli);

        String ntzRlc = cliElement.getAttribute("NtzRlc");
        Assert.assertEquals("2", ntzRlc);

        String hstCmt = cliElement.getAttribute("HstCmt");
        Assert.assertEquals("false", hstCmt);

        String cdOcr = cliElement.getAttribute("CdOcr");
        Assert.assertEquals("12345", cdOcr);
    }

    @Test
    public void testOprAttributes() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("C:\\\\Users\\\\lucas\\\\eclipse-workspace\\\\lerXmlCadpos\\\\lerXmlCadpos\\\\src\\\\main\\\\example.xml"));
        
        NodeList nodeList = document.getElementsByTagName("Opr");
        for(int countOpr = 0;countOpr < nodeList.getLength(); countOpr++) {
        	
        	Element oprElement = (Element) document.getElementsByTagName("Opr").item(countOpr);
		
		    String nrUnco = oprElement.getAttribute("NrUnco");
		    //Assert.assertEquals("01", nrUnco);
		    Assert.assertNotNull(nrUnco);
		    String prfAg = oprElement.getAttribute("PrfAg");
		    //Assert.assertEquals("01", prfAg);
		    Assert.assertNotNull(prfAg);
		    String nrCtr = oprElement.getAttribute("NrCtr");
		    //Assert.assertEquals("01", nrCtr);
		    Assert.assertNotNull(nrCtr);
		    /*String dtCtrc = oprElement.getAttribute("DtCtrc");
		    Assert.assertEquals("2022-01-01", dtCtrc);
		
		    String cdMdld = oprElement.getAttribute("CdMdld");
		    Assert.assertEquals("001", cdMdld);
		
		    String dtAprc = oprElement.getAttribute("DtAprc");
		    Assert.assertEquals("2022-01-01", dtAprc);
		
		    String cnpjCtrc = oprElement.getAttribute("CnpjCtrc");
		    Assert.assertEquals("12345678901234", cnpjCtrc);*/
		    System.out.println("Opr "+countOpr+" [PASS]");
        }
        
    }
    
    
    
    @Test
    public void arrumar() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("C:\\Users\\lucas\\eclipse-workspace\\lerXmlCadpos\\lerXmlCadpos\\src\\main\\example.xml"));

        NodeList nodeList = document.getElementsByTagName("Cli");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element cliElement = (Element) nodeList.item(i);
            
            System.out.println("CLI [PASS]");
            
            String tipCli = cliElement.getAttribute("TipCli");
            
            Assert.assertTrue(tipCli.equals("1") || tipCli.equals("2"));
            Assert.assertNotNull(tipCli); // Verifica se o atributo não é nulo
            Assert.assertNotEquals("", tipCli); // Verifica se o atributo não é vazio


            
            /*String idfcCli = cliElement.getAttribute("IdfcCli");
            Assert.assertEquals("1", idfcCli);

            String nmCli = cliElement.getAttribute("NmCli");
            Assert.assertEquals("100000XXXXXXXXXXXXXXXXXXXXXXXXXXXX", nmCli);

            String ntzRlc = cliElement.getAttribute("NtzRlc");
            Assert.assertEquals("1", ntzRlc);

            String hstCmt = cliElement.getAttribute("HstCmt");
            Assert.assertEquals("1", hstCmt);

            String cdOcr = cliElement.getAttribute("CdOcr");
            Assert.assertEquals("1", cdOcr);*/
            System.out.println("CLI "+i+" [PASS]");
        }
        
    }


}
