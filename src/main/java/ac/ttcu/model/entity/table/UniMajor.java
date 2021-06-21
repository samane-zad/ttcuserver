package ac.ttcu.model.entity.table;

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
    @Enumerated(EnumType.STRING)
    private Universities uni;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Majors major;

    public UniMajor(Integer id) {
        this.id = id;
    }

    public UniMajor() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
