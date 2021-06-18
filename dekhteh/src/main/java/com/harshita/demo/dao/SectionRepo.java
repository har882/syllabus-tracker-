package com.harshita.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.harshita.demo.model.Section;

public interface SectionRepo  extends JpaRepository<Section,Integer> {
	

//	
//	@Query("select sec.section_name from section sec where sec.section_id = :section_id")
//	List<Section> getSectionSectionidById(@Param("section_id") int section_id);
	
	List<Section> findBysectionid(int sectionid);
	
	@Query(value="SELECT * FROM syllabus.section where syllabus.section.ExamBranch_id=:branch" ,nativeQuery=true)
	List<Section> findbybranch(@Param("branch")String branch);

}
