import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.User;
import utils.GSONHandler;

import java.lang.reflect.Modifier;

/**
 * Created by ahmetkucuk on 17/05/15.
 */
public class GSONTest {

    public static void main(String[] args) {

        User user = new User("ahmetkucuk", "ahmetkucuk92@gmail.com", "123456");
        Gson gson = new GsonBuilder().create();

        System.out.println("User before serialize: " + user.toString());
        String jsonString = gson.toJson(user);
        System.out.println("User serialized json: " + jsonString);
        User userFromJson = gson.fromJson(jsonString, User.class);
        System.out.println("User deserialize: " + user.toString());

        Gson gson2 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        jsonString = gson2.toJson(user);
        System.out.println("User deserialize: " + jsonString);

        Gson gson3 = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        jsonString = gson3.toJson(user);
        System.out.println("User deserialize: " + jsonString);

        //Using exclusion strategy
        System.out.print("User Serialized: " + GSONHandler.getInstance().toJson(user));

    }
}
