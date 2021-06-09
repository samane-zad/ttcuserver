package ac.ttcu.model.entity.dto;

import ac.ttcu.common.Majors;
import ac.ttcu.common.Universities;
import com.sun.istack.NotNull;

import java.io.Serializable;

public class UniMajorDTO implements Serializable {
    private Integer id;
    @NotNull
    private Universities uni;
    @NotNull

    private Majors major;

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
