package ac.ttcu.model.entity;

import ac.ttcu.common.Majors;
import ac.ttcu.common.Universities;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "uniMajor")
public class UniMajor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "uni")
    private Universities uni;
    @Column(name = "majors")
    private  Majors major;

    public UniMajor() {
    }

    public Long getId() {
        return id;
    }


    public Universities getUni() {
        return uni;
    }

    public void setUni(Universities uni) {
        this.uni = uni;
    }

    public Majors getMajor() {
        return major;
    }

    public void setMajor(Majors major) {
        this.major = major;
    }
}
