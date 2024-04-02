package org.generation.italy.codeSchool.model;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    // Integer + la versione ad oggetti della primitiva int perchè nelle generics non possiamo usare le primitive
    private StudentRepository studentRepo = new StudentRepository();
    private CourseRepository courseRepo = new CourseRepository();
    private Scanner console = new Scanner(System.in);

    public int doMenu(){
        
        int choice;

        do{
            printMenu();
            choice = console.nextInt();
            console.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Grazie per aver utilizzato il nostro programma, Arrivederci");
                    break;
                case 1:
                    printCourseList();
                    break;
                case 2:
                    addNewCourse();
                    break;
                case 3:
                    returnStudentsForCourse();
                    break;
                case 4:
                    addStudentToCourse();
                    break;
                case 5:
                    returnRavarageForCourse();
                    break;
                default:
                    System.out.println("Comando non valido!");
                    break;
            }
        }while(choice != 0);
        console.close();
        return choice;
    }

    private void printMenu(){
        System.out.println("""
            MENU:
            0)Esci
            1)Lista corsi 
            2)Crea nuovo corso
            3)Lista studenti iscritti per corso
            4)Iscrivere nuovo studente a un corso 
            5)Media voti Studente per corso

            Inserisci scelta:""");
    }

    private void returnRavarageForCourse(){
        System.out.print("Inserisci l'ID di uno studente: ");
                    int idS = console.nextInt();
                    console.nextLine();
                    Student st2 = studentRepo.findById(idS);
                    System.out.print("Inserisci l'ID del corso: ");
                    int idC = console.nextInt();
                    console.nextLine();
                    Course c2 = courseRepo.getCourse(idC);
                    if(st2 != null && c2 != null){
                        System.out.printf("La media dei voti dello studente %s per il corso con ID %d è %.2f%n", st2.toString(), idC, st2.calculateAverageForCourse(idC));
                    }
    }

    private void addStudentToCourse(){
        System.out.print("Inserisci l'ID del corso: ");
                    int idCourse = console.nextInt();
                    console.nextLine(); //altrimenti si mangia il return(Invio)
                    Course found = courseRepo.getCourse(idCourse);
                    System.out.print("Inserisci l'ID di uno studente: ");
                    int idStudent = console.nextInt();
                    console.nextLine();
                    Student st1 = studentRepo.findById(idStudent);
                    if(found != null && st1 != null){
                        found.enroll(st1);
                        st1.addCourse(found);
                        System.out.println("Lo studente è stato aggiunto al corso!");
                    }else{
                        System.out.println("Questo corso o lo studente non esistono.");
                    }
    }

    private void returnStudentsForCourse(){
        //creare un metodo
        System.out.print("Inserisci l'ID del corso: ");
        int id = console.nextInt();
        console.nextLine(); //altrimenti si mangia il return(Invio)
        Course courseFound = courseRepo.getCourse(id);
        if(courseFound != null){
            for(Student s : courseFound.listStudents()){
                System.out.println(s);
            }
        }else{
            System.out.println("Questo corso non esiste.");
        }
    }

    private void addNewCourse(){
        Course c = createCourse();
                    courseRepo.save(c);
                    System.out.printf("Corso inserito con id %d", c.getId());
    }

    private String inserStudentName(){
        System.out.print("inserisci il nome dello studente: ");
        String nameS = console.nextLine();
        return nameS;
    }

    private String inserStudentLastname(){
        System.out.print("inserisci il cognome dello studente: ");
        String lastnameS = console.nextLine();
        return lastnameS;
    }

    public Student registerStudent(){
        Student s = new Student(inserStudentName(), inserStudentLastname());
        return s;
    }

    public void printCourseList(){
        System.out.println("Lista dei corsi:");
        ArrayList<Course> courses = courseRepo.getAllCourses();
        for(Course course : courses){
            System.out.println(course);
            System.out.println("----------------------------- \n");
        }
    }

    public Course createCourse(){
        return new Course(insertTitle(), insertAreaTitle(), insertDifficultyLevel());
    }

    private String insertTitle(){
        System.out.print("inserisci il nome del corso: ");
        return console.nextLine();
    }

    private Area insertAreaTitle() {
        Area area;
        do{
            printAreaNames();
            System.out.println("Inserisci l'area del corso:");
            int numArea = console.nextInt();
            console.nextLine();
            area = Area.findAreaByCode(numArea);
            if (area != null){
                System.out.printf("Hai scelto: %s%n", area.toString()); //controllo inserimento  
            } else {
                System.out.println("Hai inserito un codice errato!");
            }  

        }while(area == null);

        return area;
    }

    private void printAreaNames(){
        for (String line : Area.getAreaNames()){
            System.out.println(line);
        }
    }

    private  DifficultyLevel insertDifficultyLevel() {

        boolean isFound = false;
        DifficultyLevel level= null;
        int numLevel;
        do{
            DifficultyLevel.getLevelNames();
            System.out.println("Inserisci l'area della difficoltà:");
            numLevel = console.nextInt();
            console.nextLine();

            for(int i=0; i < DifficultyLevel.values().length; i++){
                if(numLevel == (i+1)){
                    isFound = true;
                    level = DifficultyLevel.values()[i];
                }
            }
            System.out.printf("Hai scelto: %s", level.toString());//controllo inserimento
            System.out.println();

        }while(!isFound);

        return level;
    }

}
