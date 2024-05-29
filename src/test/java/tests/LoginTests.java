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
            logger.info("Before method finish logout");
        }
    }


    @Test
    public void loginSuccess() {
        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data --->: email: 'mara@gmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("marga@gmail.com", "Mmar123456$");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOKButton();
        logger.info("Assert check is Element button 'Logged in success' present");


    }

    @Test
    public void loginSuccess1() {
        logger.info("Start");
        User user = new User().setEmail("marga@gmail.com").setPassword("Mmar123456$");
//        User user1 = new User();
//        user1.setEmail().setPassword().setFirstName();

//        user.setEmail("marga@gmail.com");
//        user.setPassword("Mmar123456$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOKButton();
        logger.info("End");

    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("marga@gmail.com", "Mmar123456$");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOKButton();

    }

    @Test
    public void loginWrongEmail(){
        logger.info("Test data --->: email: 'maragmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("margagmail.com", "Mmar123456$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check is Element button 'It'snot look like email' present");
    }

    @Test
    public void loginWrongPassword(){
        logger.info("Test data --->: email: 'maragmail.com' & password: 'Mmar123'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("marga@gmail.com", "Mmar123");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check is Element button 'Login or Password incorrect' present");

    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data --->: email: 'luck@gmail.com' & password: 'Lluck123456$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("luck@gmail.com", "Lluck123456$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check is Element button 'Login or Password incorrect' present");

    }


    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOKButton();
    }
}