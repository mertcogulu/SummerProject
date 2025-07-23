package summer_prac.edu_web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestDto {

    @NotBlank(message = "Enter a Test Name")
    private String testName;

}