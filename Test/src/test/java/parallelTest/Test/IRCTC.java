package parallelTest.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IRCTC {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver wb=new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("https://www.irctc.co.in/nget/train-search");
		
		WebDriverWait wt=new WebDriverWait(wb, 10);
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()=' LOGIN ']")));
		wb.findElement(By.xpath("//a[text()=' LOGIN ']")).click();
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@placeholder='User Name']")));
		wb.findElement(By.xpath("//input[@placeholder='User Name']")).clear();
		wb.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys("UPRANT2012");

		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("pwd")));
		wb.findElement(By.name("pwd")).clear();
		wb.findElement(By.name("pwd")).sendKeys("9691938034");
		try{
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("captchaImg")));
		}catch(Exception e){
			wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("captchaImg")));
		}
		wb.findElement(By.id("captchaImg"));
		//wb.findElement(By.xpath("//div[@id='nlpImgContainer']/img[@id='captchaImg']"));
		Actions act=new Actions(wb);
		act.moveToElement(wb.findElement(By.id("captchaImg")));
		act.contextClick().build().perform();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(4000);
		System.out.println("./img");
		String s="Img";
		StringSelection stringSelection = new StringSelection(s);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		r.keyPress(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		File file=App.lastFileModified("C:/Users/uprant/Downloads");
		String text=App.getImgText(file);
		System.out.println("./img");
		System.out.println(text);
		
		
//		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("pwd")));
//		wb.findElement(By.name("nlpAnswer")).clear();
//		wb.findElement(By.name("nlpAnswer")).sendKeys("9691938034");
		
	}

}
