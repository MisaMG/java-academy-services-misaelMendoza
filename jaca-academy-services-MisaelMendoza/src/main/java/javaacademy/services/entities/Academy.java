package javaacademy.services.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="academies")
public class Academy {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long academyId;

    @Column(name = "course_name")
    private String courseName;

    public long getAcademyId() {
        return academyId;
    }

    public void setAcademyId(long academyId) {
        this.academyId = academyId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Academy [academyId=" + academyId + ", courseName=" + courseName + "]";
    }

    
}
