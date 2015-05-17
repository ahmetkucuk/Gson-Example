package utils;

import com.google.gson.*;
import models.User;

import java.lang.reflect.Type;

/**
 * Created by ahmetkucuk on 17/05/15.
 */
public class GSONHandler {

    private static final GSONHandler gsonHandler = new GSONHandler();

    private Gson gson = null;

    private GSONHandler() {
        //Use either exclusion strategy or custom serrializer
//        gson = new GsonBuilder().registerTypeAdapter(User.class, new UserSerializer()).create();
        gson = new GsonBuilder().setExclusionStrategies(new AnnotationExclusionStrategy()).create();
    }

    public static GSONHandler getInstance() {
        return gsonHandler;
    }

    public static class UserSerializer implements JsonSerializer<User> {
        public JsonElement serialize(User src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject obj = new JsonObject();

            obj.addProperty("name", src.getUsername());
            obj.addProperty("email", src.getEmail());

            return obj;
        };
    }

    /**
     * From a stackoverflow post:
     *
     * http://stackoverflow.com/a/27986860/2616232
     */
    public class AnnotationExclusionStrategy implements ExclusionStrategy {

        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            return f.getAnnotation(Exclude.class) != null;
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    }

    public String toJson(Object o) {
        return gson.toJson(o);
    }
}
