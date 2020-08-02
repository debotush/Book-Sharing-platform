package com.diprobet.bookSharing.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int userId;
    @NotEmpty
    @Size(min = 5, max = 50, message = "Your full name must be between 5 to 50  characters long.")
    private String fullName;

    @NotNull
    @Size(min = 5, max = 20, message = "Username must be between 5 to 20  characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9] + $", message = "Username must be alphanumeric with no space")
    private String userName;

    @NotEmpty
    @Size(min = 6, max = 20, message = "User password must be between  to 20  characters long.")
    private String userPassword;

    @NotEmpty
    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+[A-Za-z]{2,4}", message="Invalid email address.")
    private String userMail;

    @NotEmpty
    @Pattern(regexp = "^[0-9]+$", message = "Your Contact number must be numberic ")
    private String userContact;


    private String userType;

    public User(int userId, @Size(min = 5, max = 50, message = "Your full name must be between 5 to 50  characters long.") String fullName, @Size(min = 5, max = 20, message = "Username must be between 5 to 20  characters long.") @Pattern(regexp = "^[a-zA-Z0-9] + $", message = "Username mustbe alphanumeric with no space") String userName, @Size(min = 6, max = 20, message = "User password must be between  to 20  characters long.") String userPassword, @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+[A-Za-z]{2,4}", message = "Invalid email address.") String userMmail, @Pattern(regexp = "^[0-9]+$", message = "Your Contact number must be numberic ") String userContact, String userType) {
        super();
        this.userId = userId;
        this.fullName = fullName;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMail = userMmail;
        this.userContact = userContact;
        this.userType = userType;
    }

    public User(@Size(min = 5, max = 20, message = "Username must be between 5 to 20  characters long.") @Pattern(regexp = "^[a-zA-Z0-9] + $", message = "Username mustbe alphanumeric with no space") String userName) {
        super();
        this.userName = userName;
    }

    public User() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserType() {
        return userType;
    }

    public boolean isAdmin() {
        return "Admin".equals(this.userType);
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
