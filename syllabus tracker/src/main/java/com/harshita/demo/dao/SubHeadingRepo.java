package com.harshita.demo.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshita.demo.model.Section;
import com.harshita.demo.model.SubHeading;

public interface SubHeadingRepo  extends JpaRepository<SubHeading,Integer>{

//	List<SubHeading> findBysectionidGreaterThan(int sectionid);
	
//	@Query("SELECT subheadingname FROM SubHeading")
//	public List<String> findBysubheadingid();
	
	List<SubHeading> findBysubheadingid(int subheadingid);
	
	@Query(value="SELECT * FROM syllabus.subheading s WHERE s.section_id=:topic", nativeQuery=true)
	List<SubHeading> findbytopic(@Param("topic")int topic);
	
	@Query(value="SELECT COUNT(*) FROM syllabus.subheading s WHERE s.subheading_id=:n && s.section_id=:k", nativeQuery=true )
	int getcount(@Param("n")int subheadingid, @Param("k") int sectionid);
}
