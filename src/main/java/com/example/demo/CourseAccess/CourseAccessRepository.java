package com.example.demo.CourseAccess;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseAccessRepository extends JpaRepository<CourseAccess, Long>{

}
