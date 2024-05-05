package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegistrationForm(){
        click(new By.ByCssSelector("a[href='/login?url=%2Search']"));
    }

    public void fillLoginRegistrationForm(String email, String password){
        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);


    }
    public void submitLogin(){
        click(By.xpath("(//h1[normalize-space()='Log in'])"));


    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//h1[normalize-space()='Logged in']"));

    }
    public void logout(){
        click(By.xpath("//a[normalize-space()='Logout']"));
    }


}
