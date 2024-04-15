package org.generation.italy.codeSchool;

import java.util.HashSet;
import java.util.Set;

import org.generation.italy.codeSchool.model.Course;
import org.generation.italy.codeSchool.model.CourseRepository;
import org.generation.italy.codeSchool.model.Exam;
import org.generation.italy.codeSchool.model.Student;
import org.generation.italy.codeSchool.model.StudentRepository;
import org.generation.italy.codeSchool.model.UserInterface;

public class Start {

    // blocco statico per provare il programma
    static {
        StudentRepository studentRepo = new StudentRepository();
        CourseRepository courseRepo = new CourseRepository();
        Student st = studentRepo.findById(1);
        Course course = courseRepo.getCourse(1);
        Exam ex1 = new Exam("Java Advanced", 10, course);
        Exam ex2 = new Exam("Sql", 6, course);
        st.addCourse(course);
        course.enroll(st);
        st.doExam(ex1);
        st.doExam(ex2);
    }

    public static void main(String[] args) {

        // simulazione di scuola di corsi
        // linea di comando del menù di scelte *
        // lista di corsi gestita dalla scuola *
        // crea nuovo corso e aggiungilo alla lista *
        // richiedere la lista di studenti iscritti al corso(input id corso)*
        // iscrivere uno studente al corso
        // ogni studente ha una lista di esami per ogni corso che segue (titolo e voto
        // finale)
        // inserire id studente id corso e avere indietro la media dei voti che quello
        // studente ha in quel corso

        // Stampa la lista dei corsi
         UserInterface u = new UserInterface();

         try {
            u.doMenu();
        } catch (ClassNotFoundException e) {
            System.out.println("ERRORE nella configurazione del sistema, contattare Sonia, grazie.");
        }

        // Student student1 = new Student("Giulio", "Zalone");
        // Student student2 = new Student("Giulio", "Zalone");
        // //Student student3 = student2; //copia l'indirizzo

        // student1.setId(20);
        // student2.setId(20);

        // Set<Student> hs = new HashSet<>();

        // System.out.println(student1.hashCode());
        // System.out.println(student2.hashCode());

        // hs.add(student1);
        // hs.add(student2);
        // //hs.add(student3);

        // //System.out.println(student1.equals(student2)); //controlla gli inderizzi dei due oggetti
        // System.out.println(hs.size());
    }

}
