package org.generation.italy.codeSchool.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileStudentRepository implements AbstractStudentRepository{

    private String fileName;

    public FileStudentRepository(String fileName) {
        this.fileName = fileName;
    }

    // @Override
    // public Student findById(int id) {

    //     BufferedReader br = null;
        
    //     try{
    //         FileReader fr = new FileReader("nonesisto.txt"); //leggere file un carattere alla volta
    //         br = new BufferedReader(fr); // legge i caratteri riga per riga fino al capo
    //         String line = br.readLine();
    //         System.out.println(line.length());
    //         //la riga sotto è per vedere un altro tipo di eccezione
    //         Class x = Class.forName("org.generation.italy.codeSchool.model.Area");
    //     // } catch (FileNotFoundException e){ // figlia di IOException, un caso
    //     //     System.out.println(e.getMessage()); //così è chiaro che stampa un messaggio
    //     } catch (IOException e){  // le Exception generali non vanno bene, bisogna essere specifici
    //         System.out.println(e.getMessage()); // quella generica deve stare dopo quella specifica
    //     } catch(ClassNotFoundException e){
    //         System.out.println(e.getMessage());
    //     } finally { //ATTENZIONE il finally non deve fare return e non deve lanciare eccezioni!!
    //         System.out.println("Io eseguo sempre");
    //         try {
    //             if(br != null){
    //                 br.close();
    //             }
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //     }
        
    //     //System.out.println("anche io penso di eseguire sempre, ma in realtà mi sbaglio!");

        
    // }

    //funzione che lancia automaticamente le eccezioni senza gestirle nei catch
    @Override
    public Student findById(int id) throws FileNotFoundException, IOException, ClassNotFoundException {

        //sto creando un bufferedReader con al suo interno direttamente il fileReader, saltando uno step
        //qui il finally non serve perchè le risorse verranno automaticamente chiuse 
        //nelle tonde posso metterci solo instazazioni degli oggetti, anche più di uno separati dal ;
        //funziona solo conoggetti che implementano l'interfaccia AutoCloseable
        try(BufferedReader br = new BufferedReader(new FileReader(Configuration.fileName));){
            //leggere file un carattere alla volta // legge i caratteri riga per riga fino al capo
            String line = br.readLine();
            System.out.println(line.length());
            //la riga sotto è per vedere un altro tipo di eccezione
            Class x = Class.forName("org.generation.italy.codeSchool.model.Areea");
            return null;
        }
        // } catch (FileNotFoundException e){ // figlia di IOException, un caso
        //     System.out.println(e.getMessage()); //così è chiaro che stampa un messaggio
        // } catch (IOException e){  // le Exception generali non vanno bene, bisogna essere specifici
        //     System.out.println(e.getMessage()); // quella generica deve stare dopo quella specifica
        // } catch(ClassNotFoundException e){
        //     System.out.println(e.getMessage());
        //}
        
        //System.out.println("anche io penso di eseguire sempre, ma in realtà mi sbaglio!");

        
    }

}
