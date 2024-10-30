package com.mycompany.st10444583part2;

public class Register {

    private String username;
    private String password;

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkUserName() {
        boolean containsUnderscore = false;
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == '_') {
                containsUnderscore = true;
            }
        }
        return containsUnderscore && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if ("!@#$%^&*()".indexOf(c) != -1) {
                hasSpecialCharacter = true;
            }
        }
        return password.length() >= 8 && hasUpperCase && hasNumber && hasSpecialCharacter;
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Invalid username format. Must contain an underscore (_) and be no more than 5 characters.";
        } else if (!checkPasswordComplexity()) {
            return "Invalid password format. Must be at least 8 characters long and contain a capital letter, a number, and a special character.";
        } else {
            return "Registration successful!";
        }
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public String returnLoginStatus(boolean successful) {
        return successful ? "Login successful!" : "Login failed. Please check your username and password and try again.";
    }
}
