package ac.ttcu.model.entity;

import ac.ttcu.common.Majors;
import ac.ttcu.common.Universities;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "uniMajor")
public class UniMajor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private Universities uni;
    @NotNull
    private Majors major;

    public UniMajor(Integer id) {
        this.id = id;
    }

    public UniMajor() {

    }


    public Integer getId() {
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
