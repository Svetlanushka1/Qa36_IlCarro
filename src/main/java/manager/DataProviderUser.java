package manager;

import model.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> xxxx(){
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});
        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginDataFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/test/resources/logdata.csv")));
        String line  = bufferedReader.readLine();
        while (line!=null){
           String[] split =  line.split(",");
           list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
           line=bufferedReader.readLine();
        }


        return list.iterator();
    }

}
