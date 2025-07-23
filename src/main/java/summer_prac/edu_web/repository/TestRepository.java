package summer_prac.edu_web.repository;

import summer_prac.edu_web.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    Optional<Test> findById(Long id);
    @Query("from Test o where o.testName = :testName")
    Test findByName(@Param("testName") String testName);
}
