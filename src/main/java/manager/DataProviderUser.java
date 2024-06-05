package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> loginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"marga@gmail.com", "Mmar123456$"});
        list.add(new Object[]{"marga@gmail.com", "Mmar123456$"});
        list.add(new Object[]{"elena.krylataya@gmail.com", "Lenakira11$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginModels() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("elena.krylataya@gmail.com").setPassword("Lenakira11$")});
        list.add(new Object[]{new User().setEmail("marga@gmail.com").setPassword("Mmar123456$")});
        list.add(new Object[]{new User().setEmail("elena.krylataya@gmail.com").setPassword("Lenakira11$")});
        return list.iterator();

    }
}

