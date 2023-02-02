package manager;

import model.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        //click(By.id("1"));
      pause(500);
        click(By.xpath("//a[text()=' Let the car work ']"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getLocation());
        type(By.id("make"),car.getManufacture());
        type(By.id("model"),car.getModel());
        type(By.id("year"),car.getYear());
        select(By.id("fuel"),car.getFuel());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"),car.getClasS());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("about"),car.getAbout());


    }

    private void select(By locator, String option){
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(option);
        //select.selectByVisibleText();
        //select.selectByIndex();

    }

    private void typeLocation(String location) {
        type(By.id("pickUpPlace"),location);
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    public boolean isTitleMessageContains(String message) {

        return wd.findElement(By.cssSelector("div.dialog-container h1")).getText().equals(message);
    }

    public void attachPhoto(String link) {
        wd.findElement(By.id("photos")).sendKeys(link);
    }

    public void returnToSearch() {
        click(By.xpath("//button[text()='Search cars']"));
    }
}
