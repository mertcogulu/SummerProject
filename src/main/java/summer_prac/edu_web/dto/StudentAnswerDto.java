package summer_prac.edu_web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentAnswerDto {
    @NotBlank
    private String answer;
}