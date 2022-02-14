package gov.iti.jets.server.repository.entity;

import java.sql.Date;
import java.util.Set;

public class UserEntity {
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String Email;
    private String password;
    private char gender;
    private Country country;
    private Date dateOfBirth;
    private String bio;
    private Date createAt;
    private Set<UserEntity> contacts;
}
