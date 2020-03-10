package unit;

import data.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserDataTest {
    private static final String MAIL = "Testmail@pisz.to";
    private static final String PASSWORD = "Testtesttest";

    @Test
    public void testConstructor(){
        UserData user = new UserData(MAIL, PASSWORD);
        Assert.assertEquals(user.getEmail(), MAIL);
        Assert.assertEquals(user.getPassword(), PASSWORD);
    }

    @Test
    public void testSetEmail(){
        UserData userDefault = new UserData();
        userDefault.setEmail(MAIL);
        Assert.assertEquals(userDefault.getEmail(), MAIL);
    }
    @Test
    public void testSetPassword(){
        UserData userdefault = new UserData();
        userdefault.setPassword(PASSWORD);
        Assert.assertEquals(userdefault.getPassword(), PASSWORD);
    }

}