package gov.iti.jets.common.dtos;

import java.io.Serializable;
import java.util.Date;

public class ContactDTO implements Serializable {
    private static final long serialVersionUID = 1420672609912364060L;
    private String phoneNumber;
    private String image;
    private String username;
    private String status;
    private String bio;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", image='" + image + '\'' +
                ", username='" + username + '\'' +
                ", status='" + status + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

}
