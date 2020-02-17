package vn.cwa.application.domain.repository.student;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;

import vn.cwa.application.domain.model.Student;

public interface StudentRepository {
	Optional<Student> findById(Long id);
	List<Student> findAll();
	Integer insert(Student student);
	void update(Student student);
	void deleteById(Long id);
	
	List<Student> getTest(@Param("tableName") String tableName);
	
	Long getIdByName(@Param("name") String name);
}
