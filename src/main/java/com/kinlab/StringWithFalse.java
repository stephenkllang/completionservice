package com.kinlab;

/**
 * Created by slangg on 0028, June, 28, 2016.
 */
public class StringWithFalse {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    public void aMethod() {
        String myString = "\u0048\u0065\u006C\u006C\u006F World";

        setEmail("\u0000");
        String tmpString = getEmail();

    }
}
