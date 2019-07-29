package shuai.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="t_student")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	private int stuid;
	private String stuName;
	private Set<Course> courses=new HashSet<Course>();
	
	public Student() {
	}
	
	public Student(String stuName) {
		super();
		this.stuName = stuName;
	}

	public Student(String stuName, Set<Course> courses) {
		this.stuName = stuName;
		this.courses = courses;
	}
	@Id
	@GeneratedValue
	@Column(name="stuid")
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	@Column(name="stuname")
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="r_course_stu",joinColumns=@JoinColumn(name="r_stu_id"),
				inverseJoinColumns=@JoinColumn(name="r_course_id"))
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
}
