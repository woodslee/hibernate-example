package shuai.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_course")
public class Course {
	private int courseid;
	private String courseName;
	private Set<Student> stus=new HashSet<Student>();
	
	public Course() {
	}
	
	public Course(String courseName) {
		this.courseName = courseName;
	}

	public Course(String courseName, Set<Student> stus) {
		this.courseName = courseName;
		this.stus = stus;
	}
	@Id
	@GeneratedValue
	@Column(name="courseid")
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	@Column(name="coursename")
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="courses")
	public Set<Student> getStus() {
		return stus;
	}
	public void setStus(Set<Student> stus) {
		this.stus = stus;
	}
	
	
}
