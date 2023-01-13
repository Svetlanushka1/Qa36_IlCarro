package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

    }
    @Test
    public void loginSuccessModel(){
        User user=new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

        app.getHelperUser().openFormLogin();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }

    @Test
    public void loginWrongEmail(){
        User user=new User().withEmail("noagmail.com").withPassword("Nnoa12345$");

        app.getHelperUser().openFormLogin();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }
    @Test
    public void loginWrongPassword(){
        User user=new User().withEmail("noa@gmail.com").withPassword("Nnoa1");

        app.getHelperUser().openFormLogin();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }
    @Test (enabled = false)
    public void loginUnregisterUser(){

    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().closeDialogContainer();
    }
}
