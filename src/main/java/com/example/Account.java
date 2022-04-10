package com.example;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name == null) {
            return false;
        } else if (name.length() < 3 || name.length() > 19) {
            return false;
        } else if (!name.contains(" ")) {
            return false;
        } else if (name.length() > name.trim().length()) {
            return false;
        } else if (!(name.indexOf(" ") == name.lastIndexOf(" "))) {
            return false;
        } else {
            return true;
        }
    }
}
