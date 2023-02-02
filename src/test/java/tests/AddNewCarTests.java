package tests;

import model.Car;
import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            User user =new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
            app.getHelperUser().login(user);
            logger.info("The test needs login with data "+user.toString());
        }
    }

    @Test
    public void addNewCarSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Car car = Car.builder()
                .location("Haifa, Israel")
                .manufacture("BMW")
                .model("M5")
                .year("2020")
                .fuel("Petrol")
                .seats("4")
                .clasS("C")
                .carRegNumber("555-00-"+i)
                .price("65")
                .about("very nice car")
                .build();
        logger.info("The car model for success add car test is -->" +car.toString());


        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("/Users/tayahatum/Qa36/Qa36_IlCarro/comaro.jpeg");
        logger.info("The photo added by link -- '/Users/tayahatum/Qa36/Qa36_IlCarro/comaro.jpeg'");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isTitleMessageContains("Car added"));
        logger.info("Assert check dialog with message - 'Car added'" );

    }
    @AfterMethod
    public void postCondition(){
        app.getHelperCar().returnToSearch();
    }
}
