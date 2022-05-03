package com.example.password_creator.DataModel;

public class Source {
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "0123456789";
    public static final String SYMBOLS = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private final StringBuilder source;

    public Source(boolean upperCase, boolean lowerCase, boolean numbers, boolean symbols) {
        StringBuilder sb = new StringBuilder();
        if (upperCase){
            sb.append(UPPERCASE_LETTERS);
        }
        if (lowerCase){
            sb.append(LOWERCASE_LETTERS);
        }
        if (numbers){
            sb.append(NUMBERS);
        }
        if (symbols){
            sb.append(SYMBOLS);
        }
        this.source = sb;
    }

    @Override
    public String toString() {
        return this.source.toString();
    }
}