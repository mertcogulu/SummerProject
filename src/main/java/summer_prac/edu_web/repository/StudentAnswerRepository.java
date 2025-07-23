package summer_prac.edu_web.repository;

import summer_prac.edu_web.entity.StudentAnswer;
import summer_prac.edu_web.entity.Test;
import summer_prac.edu_web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Long> {
    Optional<StudentAnswer> findById(Long id);

    @Query("from StudentAnswer o where o.answer = :answer")
    StudentAnswer findByAnswer(@Param("answer") String answer);

    @Query("from StudentAnswer o where o.test = :test and o.user = :user")
    List<StudentAnswer> findAnswers(@Param("test") Test test, @Param("user") User user);

    List<StudentAnswer> findByUser(User user);

}