package gov.iti.jets.common.dtos;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1420672609912364060L;

    @NotNull(message = "phone number is required")
    @Size(min = 11 , max = 15 , message = "number should be min=11 max=15")
    @Pattern(regexp="\\d{11,15}" ,message = "invalid phone number")
    private String phoneNumber;

    @NotNull(message = "email is required")
    @Email(message = "invalid email")
    private String email;

    private String image="";

    @NotNull(message = "user name is required")
    @Size(min = 3 , message = "user name should min=3")
    private String username;

    @NotNull(message = "password is required")
    private String password;

    private String status="";

    @NotNull(message = "date of birth is required")
    private long dob;

    @NotNull(message = "gender is required")
    private String gender;

    @NotNull(message = "country is required")
    private String country;

    private String bio="";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO(){}

    public UserDTO(String phoneNumber , String email , String username , String password , String gender ,long dob, String country){
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.username=username;
        this.password=password;
        this.gender=gender;
        this.country=country;
        this.dob=dob;
    }

}
