package com.harshita.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.harshita.demo.model.Student;
import com.harshita.demo.model.SubHeading;


public interface StudentRepo extends JpaRepository<Student,Integer>{

//	@Override
//	List<Student> findAll(); 
	
	
	List<Student> findBysubheading(int subheading);
	
//	@Query(value="SELECT t.topicname, t.topicid FROM topic t where t.topicid>36", nativeQuery=true )
//	public List<Student> findBysubheadingid();
	
//	@Query("select t.topicname from topic t")
//    List<Student> gettopicname();
//	@Query(value = "SELECT * FROM topic t WHERE t.topicname = 'topicname'",
//            nativeQuery=true  )
//    public List<Student> findByTopicname();
//	
	
	@Query(value="SELECT * FROM syllabus.topic t WHERE t.subheadingid=:subheading", nativeQuery=true)
	List<Student> findbysubheadingid(@Param("subheading")int subheading);
	
	
}
