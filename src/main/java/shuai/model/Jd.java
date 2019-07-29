package shuai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_jd")
public class Jd {
	private int jdid;
	private String jdName;
	private Qx qx;
	
	public Jd() {
	}
	
	public Jd(String jdName) {
		this.jdName = jdName;
	}

	public Jd(String jdName, Qx qx) {
		this.jdName = jdName;
		this.qx = qx;
	}
	@Id
	@GeneratedValue
	@Column(name="jdid")
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}
	@Column(name="jdname")
	public String getJdName() {
		return jdName;
	}
	public void setJdName(String jdName) {
		this.jdName = jdName;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="qxid")
	public Qx getQx() {
		return qx;
	}
	public void setQx(Qx qx) {
		this.qx = qx;
	}
	
	
}
