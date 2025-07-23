package summer_prac.edu_web.service;

import summer_prac.edu_web.dto.TestDto;
import summer_prac.edu_web.entity.Test;
import summer_prac.edu_web.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public void createNewTest(TestDto testDto) {
        Test test = new Test();
        test.setTestName(testDto.getTestName());

        testRepository.save(test);
    }

    public void saveNewTest(Test test) {testRepository.save(test);}
}