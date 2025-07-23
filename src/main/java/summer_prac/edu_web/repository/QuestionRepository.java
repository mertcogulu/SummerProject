package summer_prac.edu_web.repository;

import summer_prac.edu_web.entity.Questions;

import summer_prac.edu_web.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Questions, Long> {
    Optional<Questions> findById(long id);
    @Query("from Questions o where o.test=:testId")
    List<Questions> questionsByTestId(@Param("testId") Optional<Test> testId);
}