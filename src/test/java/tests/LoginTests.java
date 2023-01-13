package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }

    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openFormLogin();
        app.getHelperUser().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        app.getHelperUser().closeDialogContainer();


    }
    @Test
    public void loginSuccessModel(){
        User user=new User().setEmail("noa@gmail.com");



        app.getHelperUser().openFormLogin();
        app.getHelperUser().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        app.getHelperUser().closeDialogContainer();


    }

    @Test
    public void loginWrongEmail(){

    }
    @Test
    public void loginWrongPassword(){

    }
    @Test
    public void loginUnregisterUser(){

    }
}
