package shuai.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "区县")
@Table(name = "t_qx")
public class Qx {
    private int qxid;
    private String qxname;
    private Set<Jd> jds = new HashSet<Jd>();

    public Qx() {
    }

    public Qx(String qxname) {
        this.qxname = qxname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qxid")
    public int getQxid() {
        return qxid;
    }

    public void setQxid(int qxid) {
        this.qxid = qxid;
    }

    @Column(name = "qxname")
    public String getQxname() {
        return qxname;
    }

    public void setQxname(String qxname) {
        this.qxname = qxname;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "qx")
	/*@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="qxid")*/
    public Set<Jd> getJds() {
        return jds;
    }

    public void setJds(Set<Jd> jds) {
        this.jds = jds;
    }


}
