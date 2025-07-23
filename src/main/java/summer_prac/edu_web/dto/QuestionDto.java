package summer_prac.edu_web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {

    @NotBlank(message = "Enter a Question")
    private String question;

    @NotBlank(message = "Option \"A\" needed")
    private String optionA;

    @NotBlank(message = "Option \"B\" needed")
    private String optionB;

    @NotBlank(message = "Option \"C\" needed")
    private String optionC;

    @NotBlank(message = "Enter The Correct Answer")
    private String correctAnswer;
}