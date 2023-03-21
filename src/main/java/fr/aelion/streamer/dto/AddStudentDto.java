package fr.aelion.streamer.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AddStudentDto {
    @NotBlank(message = "LastName cannot be null")
    @Size(message = "LastName cant not be null")
    private  String lastName;
    private  String firstName;
    @NotNull(message = "email cannot be null")
    @Email
    private  String email;
    private  String phoneNumber;
    @NotNull(message = "login cannot be null")

    @Size(min = 8, message = "login must have at least 8 chars")
    @Min(8)
    private  String login;
    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "password must have at least 8 chars")
    @Min(8)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")
    private  String password;
}
