package appiumPractrice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class TestSwipeToParticular {

	public static void main(String[] args) throws MalformedURLException {
		
		
		DesiredCapabilities d=new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME,"shah");
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		d.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		d.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		d.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,d);
		//AppiumDriver<WebElement> driver=new AppiumDriver<WebElement>(url,d);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text='WebView3']")).click();
//		 TouchAction touchAction = new TouchAction(driver);
//         touchAction.tap(PointOption.point(551, 469))
//                    .perform();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		WebElement elem = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		TouchAction t=new TouchAction(driver);
		t.longPress(LongPressOptions.longPressOptions()
		.withElement(ElementOption.element(elem)))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).release().perform();
	}

}
