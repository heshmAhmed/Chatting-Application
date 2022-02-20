package gov.iti.jets.server.repository.entity;

public class ContactEntity {
    private String phoneNumber;
    private String status;
    private String username;
    private String image;
    private String bio;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }
    @Override
    public String toString() {
        return "ContactEntity{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                ", name='" + username + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
