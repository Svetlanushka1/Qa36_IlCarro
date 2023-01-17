package manager;


import model.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openFormLogin() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"),user.getPassword());
    }



    public String getMessage() {
        return wd.findElement(By.cssSelector("div.dialog-container>h2")).getText();
    }

    public void closeDialogContainer() {
        if(isElementPresent(By.xpath("//button[text()='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public boolean isLogged() {
        //return isElementPresent(By.xpath("//button[text()=' Logout ']"));
        return isElementPresent(By.cssSelector("div.header a:nth-child(5)"));
    }

    public void logout() {
       // click(By.xpath("//button[text()=' Logout ']"));
        click(By.cssSelector("div.header a:nth-child(5)"));
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public boolean isYallaButtonNotActive() {
       // return isElementPresent(By.cssSelector("button[disabled]"));
        return !wd.findElement(By.cssSelector("button[disabled]")).isEnabled();
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void checkPolicy() {
        //click(By.id("terms-of-use"));
        //click(By.cssSelector("label[for='terms-of-use']"));
        if(!wd.findElement(By.id("terms-of-use")).isSelected()) {
            click(By.cssSelector(".checkbox-container"));
        }
    }
    public void checkPolicyXY(){

        Dimension size = wd.manage().window().getSize();
        System.out.println("Window Height "+ size.getHeight());
        System.out.println("Window Width "+ size.getWidth());

        WebElement label =wd.findElement(By.cssSelector("label[for='terms-of-use']"));

        Rectangle rect = label.getRect();
        int xOffset = rect.getWidth()/2;

        Actions actions = new Actions(wd);
        actions.moveToElement(label,-xOffset,0).click().release().perform();

    }
    public void checkPolicyJS() {
        JavascriptExecutor js  = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').checked=true;");

    }

    public boolean isErrorMessageContains(String message) {
        return wd.findElement(By.cssSelector(".error")).getText().contains(message);
    }

    public void login(User user) {
        openFormLogin();
        fillLoginForm(user);
        submit();
        closeDialogContainer();
    }
}
