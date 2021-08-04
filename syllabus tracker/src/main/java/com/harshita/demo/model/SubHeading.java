package com.harshita.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subheading")
public class SubHeading {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="subheading_id")
	int subheadingid;
	
	@Column(name="subheading_name")
	String subheadingname;
	
	@Column(name="section_id")
	int sectionid;

	public int getSubheadingid() {
		return subheadingid;
	}

	public void setSubheadingid(int subheadingid) {
		this.subheadingid = subheadingid;
	}

	public String getSubheadingname() {
		return subheadingname;
	}

	public void setSubheadingname(String subheadingname) {
		this.subheadingname = subheadingname;
	}

	public int getSectionid() {
		return sectionid;
	}

	public void setSectionid(int sectionid) {
		this.sectionid = sectionid;
	}

	@Override
	public String toString() {
		return "SubHeading [subheadingid=" + subheadingid + ", subheadingname=" + subheadingname + ", sectionid="
				+ sectionid + "]";
	}
	
	
}
