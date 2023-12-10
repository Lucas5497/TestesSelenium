package br.ce.lopes.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

	private static WebDriver driver;
	
	private DriverFactory() {};
	
	public static WebDriver getDriver() {
		if(driver == null) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
			driver.manage().window().setSize(new Dimension(1366, 768));
		}
		return driver;
	};
	
	public static void killDriver() {
		if(driver!=null) {
			driver.quit();
			driver = null;
		}	
	};
}
