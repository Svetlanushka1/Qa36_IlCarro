package tests;

import model.Car;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }
    }

    @Test
    public void addNewCarSuccess(){

        Car car = Car.builder()
                .location("Haifa, Israel")
                .manufacture("BMW")
                .model("M5")
                .year("2020")
                .fuel("Petrol")
                .seats("4")
                .clasS("C")
                .carRegNumber("12345677890")
                .price("65")
                .about("very nice car")
                .build();


        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
       // app.getHelperCar().attachPhoto();
        app.getHelperCar().submit();

    }
}
