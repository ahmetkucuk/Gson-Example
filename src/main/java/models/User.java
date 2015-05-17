package models;

import com.google.gson.annotations.Expose;
import utils.Exclude;

/**
 * Created by ahmetkucuk on 17/05/15.
 */
public class User {

    @Expose
    private String username;

    private String email;


    @Exclude
    private String password;
//    private transient String password;

    public User(String u, String e, String p) {
        this.username = u;
        this.email = e;
        this.password = p;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
