package appiumPractrice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestSwipDemo {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities d=new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME,"shah");
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		d.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		d.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		d.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,d);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		
		Dimension s = driver.manage().window().getSize();
		int height=s.getHeight();
		int width=s.getWidth();
		int x=width/2;
		int starty=(int)(height*0.8);
		int endy=(int)(height*0.1);
		
		//Top to down
		TouchAction t=new TouchAction(driver);
		t.press(PointOption.point(x,starty)).
		waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4))).
		moveTo(PointOption.point(x,endy)).release().perform();
		
		Thread.sleep(3000);
		//Down to top
		
		TouchAction t1=new TouchAction(driver);
		t1.press(PointOption.point(x,endy)).
		waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4))).
		moveTo(PointOption.point(x,starty)).release().perform();
		
	}

}

