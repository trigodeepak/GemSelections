package tech.iosd.gemselections.DataProviders;

/**
 * Created by anonymous on 7/10/17.
 */

public class CustomDesignClass {

    private String name, email, phone, photoURL;

    public CustomDesignClass(String name, String email, String phone, String photoURL) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.photoURL = photoURL;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhotoURL() {
        return photoURL;
    }
}
