package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("The test needs logout");

        }

    }
    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User().withName("Lisa").withLastName("Simpson").withEmail("lisa"+i+"@mail.com").withPassword("Lisa12345$");
        logger.info("Registration with valid model :  "+user.toString());
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");
        logger.info("Assert check message 'You are logged in success'");

    }
    @Test
    public void registrationWrongEmail(){

        User user = new User().withName("Lisa").withLastName("Simpson").withEmail("lisamail.com").withPassword("Lisa12345$");
        logger.info("Registration with valid model :  "+user.toString());
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isErrorMessageContains("Wrong email format"));
        logger.info("Assert check error message with text --> 'Wrong email format'" );
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check if Y'alla button not active");


    }
    @Test
    public void registrationWrongPassword(){

        User user = new User().withName("Lisa").withLastName("Simpson").withEmail("lisa@mail.com").withPassword("Li");
        logger.info("Registration with valid model :  "+user.toString());
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isErrorMessageContains("Password must contain"));
        logger.info("Assert check error message with text --> 'Password must contain'" );
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check if Y'alla button not active");

    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().closeDialogContainer();
        logger.info("Post Condition close dialog");
    }
}
