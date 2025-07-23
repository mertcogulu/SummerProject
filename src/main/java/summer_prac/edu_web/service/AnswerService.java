package summer_prac.edu_web.service;

import summer_prac.edu_web.entity.Questions;
import summer_prac.edu_web.entity.StudentAnswer;
import summer_prac.edu_web.entity.Test;
import summer_prac.edu_web.entity.User;
import summer_prac.edu_web.repository.StudentAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final StudentAnswerRepository studentAnswerRepository;

    public void submitAnswer(List<String> ans, Optional<Test> test, User user, List<Questions> questions){
        for (int i = 0; i < ans.size(); i++) {
            StudentAnswer studentAnswer = new StudentAnswer();
            studentAnswer.setAnswer(ans.get(i));
            studentAnswer.setTest(test.orElse(null));
            studentAnswer.setUser(user);
            studentAnswer.setQuestions(questions.get(i));

            studentAnswerRepository.save(studentAnswer);
        }
    }
    public List<StudentAnswer> getStudentTestAnswer(Optional<Test> testOptional, User user){
        if (testOptional.isEmpty()) {
            throw new IllegalArgumentException("Test not found");
        }
        Test test = testOptional.get();
        return studentAnswerRepository.findAnswers(test, user);
    }

    public List<StudentAnswer> getAllStudentAnswers(User user) {
        return studentAnswerRepository.findByUser(user);
    }


}