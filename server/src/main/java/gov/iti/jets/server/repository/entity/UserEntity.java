package gov.iti.jets.server.repository.entity;


import java.sql.Date;

public class UserEntity {
    private String phoneNumber;
    private String username;
    private String email;
    private String image;
    private String password;
    private String gender;
    private String country;
    private Date dateOfBirth;
    private String bio;
    private String status;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public String getStatus() {
        return status;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        return "phoneNumber: " + phoneNumber + " "
                + "username: " + username + " "
                + "email: "+ email + " "
                + "image: " + image + " "
                + "password: " + password + " "
                + "gender: " + gender + " "
                + "country: "+country + " "
                + "dob: " + dateOfBirth + " "
                + "bio: " + bio + " "
                + "status: " + status;
    }

}
