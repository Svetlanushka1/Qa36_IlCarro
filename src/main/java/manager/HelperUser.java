package manager;


import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void submit() {
        click(By.xpath("//button[text()='Y’alla!']"));
       // click(By.xpath("//button[@type='submit']"));

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
}
