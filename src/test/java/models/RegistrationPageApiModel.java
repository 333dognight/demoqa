package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class RegistrationPageApiModel {
    private String firstName;
    private String lastName;
    private String userEmail;
    private String phoneNumber;
}
