package summer_prac.edu_web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupFormDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid Email Format")
    @NotBlank(message = "Email is required")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;

    @Size(min = 6, message = "Passwords must match.")
    private String confirmPassword;
}