package summer_prac.edu_web.service;

import summer_prac.edu_web.dto.QuestionDto;
import summer_prac.edu_web.entity.Questions;
import summer_prac.edu_web.entity.Test;
import summer_prac.edu_web.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public void createNewQuestion(QuestionDto questionDto, Test test) {
        Questions question = new Questions();
        question.setQuestion(questionDto.getQuestion());
        question.setOptionA(questionDto.getOptionA());
        question.setOptionB(questionDto.getOptionB());
        question.setOptionC(questionDto.getOptionC());
        question.setCorrectAnswer(questionDto.getCorrectAnswer());
        question.setTest(test);

        questionRepository.save(question);
    }

    public void saveNewQuestion(Questions question) {questionRepository.save(question);}
}