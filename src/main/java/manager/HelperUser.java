package manager;


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

    public void submit() {
        click(By.xpath("//button[text()='Y’alla!']"));
       // click(By.xpath("//button[@type='submit']"));

    }

    public String getMessage() {
        return wd.findElement(By.cssSelector("div.dialog-container>h2")).getText();
    }

    public void closeDialogContainer() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//button[text()=' Logout ']"));
    }
}
