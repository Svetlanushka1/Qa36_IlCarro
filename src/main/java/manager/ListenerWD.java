package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class ListenerWD implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(ListenerWD.class);

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.info("The have a 'problem'");
        logger.info("******************");
        logger.info("Method method ---> " +method.getName());
        logger.info("******************");
       // logger.info("InvocationTargetException getMessage()" +e.getMessage()); /// null
        logger.info("InvocationTargetException getTargetException()" +e.getTargetException());
        logger.info("******************");
//        logger.info("InvocationTargetException Cause()" +e.getCause());
//        logger.info("******************");
        logger.info("Object target --->" +target.toString());
        logger.info("******************");
        WebDriver wd = (ChromeDriver)target;
       int i = new Random().nextInt(1000);
       String link = "src/test/screenshots/screen-"+i+".png";
       logger.info("Screen with error is --->" +link);

       //TakesScreenshot takesScreenshot = (TakesScreenshot) wd;
      // takesScreenshot.getScreenshotAs(OutputType.FILE);
       File tmp =  ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(link));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        logger.info("Before find element --> " +locator);

    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        logger.info("After find element --> " +locator);
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
        logger.info("Before find elements --> " +locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        logger.info("After find elements --> " +locator);
        logger.info("List suze is --> " +result.size());
    }
}
