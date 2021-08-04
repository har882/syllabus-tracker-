package com.harshita.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="section")
public class Section {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="section_id")
	int sectionid;
	
	@Column(name="section_name")
	String sectionname;
	


	public int getSectionid() {
		return sectionid;
	}

	public void setSectionid(int sectionid) {
		this.sectionid = sectionid;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	@Override
	public String toString() {
		return "Section [sectionid=" + sectionid + ", sectionname=" + sectionname + "]";
	}


	
}
