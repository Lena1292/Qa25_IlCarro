package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }


    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elena.krylataya@gmail.com", "Lenakira11$");
        app.getHelperUser().submitLogin();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOKButton();

    }

    @Test
    public void loginSuccess1() {
        User user = new User().setEmail("elena.krylataya@gmail.com").setPassword("Lenakira11$");
//        User user1 = new User();
//        user1.setEmail().setPassword().setFirstName();

//        user.setEmail("elena.krylataya@gmail.com");
//        user.setPassword("Lenakira11$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOKButton();

    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elena.krylataya@gmail.com", "Lenakira11$");
        app.getHelperUser().submitLogin();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOKButton();

    }

    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elena.krylatayagmail.com", "Lenakira11$");
        app.getHelperUser().submitLogin();
       Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));



    }

    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elena.krylataya@gmail.com", "Lenakira1");
        app.getHelperUser().submitLogin();
       Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));


    }


    @AfterMethod
    public void postCondition() {

        app.getHelperUser().clickOKButton();
       // Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
}