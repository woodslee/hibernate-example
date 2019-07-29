package shuai.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import shuai.model.Course;
import shuai.model.Jd;
import shuai.model.Qx;
import shuai.model.Student;

public class Demo {
	
	Session session=null;
	@Before
	public void init(){
		Configuration  configuration =new AnnotationConfiguration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		session=sessionFactory.openSession();
	}
	
	@Test
	public void test1(){
		List<Qx> qxs=session.createQuery("from 区县").list();
		for(Qx q:qxs){
			System.out.println(q.getQxname());
		}
	}
	
	@Test
	public void test2(){
		Transaction tr=session.beginTransaction();
		Qx qx=new Qx();
		qx.setQxname("高薪区");
		session.save(qx);
		tr.commit();
		
	}
	
	@Test
	public void test3(){
		Qx qx=(Qx) session.get(Qx.class,1);
		System.out.println(qx.getQxname());
		Set<Jd> jds=qx.getJds();
		for(Jd jd:jds){
			System.out.println(jd.getJdName());
		}
	}
	
	@Test
	public void test4(){
		//根据学生id查询所修课程
		Student student=(Student) session.get(Student.class, 1);
		Set<Course> courses=student.getCourses();
		System.out.println(student.getStuName()+"所选的课程有:");
		for(Course c:courses){
			System.out.println(c.getCourseName());
		}
		//根据课程id查询所有学生
		Course course=(Course) session.get(Course.class, 1);
		Set<Student> students=course.getStus();
		System.out.println("选择课程"+course.getCourseName()+"的学生有");
		for(Student s:students){
			System.out.println(s.getStuName());
		}
	}

	@After
	public void destory(){
		session.close();
	}
}
