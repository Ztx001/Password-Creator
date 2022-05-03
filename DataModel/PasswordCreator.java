package com.example.password_creator.DataModel;

public class PasswordCreator {
    private final String password;

    public PasswordCreator(Source source, int length) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * source.toString().length());
            char ch = source.toString().charAt(random);
            password.append(ch);
        }
        this.password = password.toString();
    }

    public String getPassword() {
        return password;
    }
}