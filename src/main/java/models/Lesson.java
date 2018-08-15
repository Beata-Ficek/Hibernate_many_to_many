package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="lessons")
public class Lesson {

    private int id;
    private String title;
    private int classroomNumber;
    private List<Course> courses;
    private List<Student> students;


    public Lesson(){

    }

    public Lesson(String title, int classroomNumber){
        this.title = title;
        this.classroomNumber = classroomNumber;
        students = new ArrayList<Student>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "classroom_number")
    public int getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    @OneToMany(mappedBy="lesson", fetch = FetchType.LAZY)
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "students_lessons",
            joinColumns = {@JoinColumn(name = "lesson_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "student_id", nullable = false, updatable = false)})

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
