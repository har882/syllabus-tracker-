package com.harshita.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="topic")
public class Student {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="topicid")
	private int topicid;
	
	@Column(name="topicname")
	private String topicname;
	
	@Column(name="subheadingid")
	private int subheading;
//
//	public Student(int topicid, String topicname, int subheading) {
//		super();
//		this.topicid = topicid;
//		this.topicname = topicname;
//		this.subheading = subheading;
//	}
//	

	

	public int getTopicid() {
		return topicid;
	}

	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}

	public String getTopicname() {
		return topicname;
	}

	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}

	public int getSubheading() {
		return subheading;
	}

	public void setSubheading(int subheading) {
		this.subheading = subheading;
	}

	@Override
	public String toString() {
		return "Student [topicid=" + topicid + ", topicname=" + topicname + ", subheading=" + subheading + "]";
	}

	
	
}
