package tech.iosd.gemselections.AuthRelated;

/**
 * Created by anonymous on 20/6/17.
 */

public class UserInfo {
    private String name, email, contact;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public UserInfo(String name, String email, String contact) {

        this.name = name;
        this.email = email;
        this.contact = contact;
    }
}
