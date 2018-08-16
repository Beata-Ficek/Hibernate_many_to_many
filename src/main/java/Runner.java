import db.DBHelper;
import db.DBStudent;
import models.*;

public class Runner {

    public static void main(String[] args) {




        Course English = new Course("English Literature", Level.BENG);
        DBHelper.save(English);
        Course Maths = new Course("Venn diagrams", Level.BSC);
        DBHelper.save(Maths);

        Lesson lesson1 = new Lesson("Lesson1", 12, Maths);
        DBHelper.save(lesson1);
        Lesson lesson2 = new Lesson("Lesson2", 11, English);
        DBHelper.save(lesson2);

        Mentor Asia = new Mentor("Asia");
        DBHelper.save(Asia);
        Mentor Sarah = new Mentor("Sarah");
        DBHelper.save(Sarah);

        Student Klaudia = new Student("Klaudia", 23, 2345, Maths, Asia);
        DBHelper.save(Klaudia);
        Student Ilona = new Student("Ilona", 24, 6789, English, Sarah);
        DBHelper.save(Ilona);


        DBStudent.addStudentToLesson(Klaudia, lesson1);
        DBStudent.addStudentToLesson(Ilona, lesson2);
    }

}
