package ac.ttcu.model.entity.dto;

import com.sun.istack.NotNull;

import java.io.Serializable;

public class UniMajorDTO implements Serializable {
    private Integer id;
    @NotNull
    private String uni;
    @NotNull

    private String major;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
