package com.example.bunker;
import com.example.bunker.pkgBunker.PersonneCompartor;
import com.example.bunker.pkgBunker.Personnel;
import com.example.bunker.pkgBunker.pkgEmployeMaintenance.Ingenieur;
import com.example.bunker.pkgBunker.pkgEmployeMaintenance.Ouvrier;
import com.example.bunker.pkgBunker.pkgForceSecurite.Armee;
import com.example.bunker.pkgBunker.pkgForceSecurite.Milice;
import com.example.bunker.pkgBunker.pkgGestionnaire.Administrateur;
import com.example.bunker.pkgBunker.pkgGestionnaire.Scientifique;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.io.*;
import java.util.*;
public class BunkerManager implements Serializable {

    private static final String CONFIG_FILE_PATH = "config.txt";

    public static Map<String, String> configMap = new HashMap<>();
    public static ArrayList<Personnel> personnels = new ArrayList<Personnel>(); ;

    public  static void  loadConfig(){
        try{
            File file = new File(CONFIG_FILE_PATH);
            if(!file.exists()){
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                configMap.put("maintenance","maintenace.txt");
                configMap.put("bunker","bunker.ser");
                configMap.put("gestionnaire","gestionnaire.txt");
                configMap.put("armee","armee.txt");
                for(String key : configMap.keySet()){
                    bw.write(key+"="+configMap.get(key)+"\n");
                }

                bw.close();
                fw.close();

            }else{
                BufferedReader br = new BufferedReader(new FileReader(CONFIG_FILE_PATH));
                String line;
                while((line = br.readLine()) != null){
                    configMap.put(line.split("=")[0],line.split("=")[1]);
                }
                System.out.println(configMap);
                br.close();
            }
            for(String key : configMap.keySet()){
                file = new File(configMap.get(key));
                if(!file.exists()){
                    file.createNewFile();
                }
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
        afficherConsole();

    }
    public static   void changeConfig(String key,String value){
        configMap.put(key,value);
    }
    public  static  void saveConfig(){
        try{
            File file = new File(CONFIG_FILE_PATH);
            if(!file.exists()){
                file.createNewFile();
            }else{
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for(String key : configMap.keySet()){
                    bw.write(key+"="+configMap.get(key)+"\n");
                }
                bw.close();
                fw.close();
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
        initWriteFile();

    }
    public static String getConfig(String key){
        return configMap.get(key);
    }

    public static void deserealize(){
        File file = new File(configMap.get("bunker"));
        if(file.exists()){
            try{
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                personnels = (ArrayList<Personnel>) ois.readObject();
                fis.close();
                ois.close();
            }catch (Exception exception){
                System.out.println(exception);

            }
        }

    }
    public static void  serealize(){
        File file = new File(configMap.get("bunker"));
        if(file.exists()){
            try{
                file.delete();
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(personnels);
                fos.close();
                oos.close();
            }catch ( Exception exception ){
                System.out.println(exception);
            }
        }
    }
    public static boolean delete(String matricule){
        for(Personnel personnel : personnels){
            if(personnel.getMatricule().equals(matricule)){
                personnels.remove(personnel);
                return true;
            }
        }
        return false;
    }

    public static void add(Personnel p){
        personnels.add(p);
    }
    public static void trierPersonnelsParDateNaissance() {
        Collections.sort(personnels, new PersonneCompartor());
    }
    public static void initData(){
        // Ajouter trois ouvriers
        Ouvrier ouvrier1 = new Ouvrier("OUV1", "John", "Doe", new GregorianCalendar(1990, 1, 1), true, "1", 3, "Electricité");
        Ouvrier ouvrier2 = new Ouvrier("OUV2", "Jane", "Doe", new GregorianCalendar(1992, 5, 15), true, "2", 5, "Plomberie");
        Ouvrier ouvrier3 = new Ouvrier("OUV3", "Jim", "Doe", new GregorianCalendar(1995, 9, 20), true, "3", 6, "Menuiserie");
        BunkerManager.add(ouvrier1);
        BunkerManager.add(ouvrier2);
        BunkerManager.add(ouvrier3);

        // Ajouter trois ingénieurs
        Ingenieur ingenieur1 = new Ingenieur("ING1", "John", "Smith", new GregorianCalendar(1985, 3, 10), true, "Maintenance", "Electricité", new GregorianCalendar(2010, 8, 15), 5);
        Ingenieur ingenieur2 = new Ingenieur("ING2", "Jane", "Smith", new GregorianCalendar(1988, 7, 22), true, "Maintenance", "Informatique", new GregorianCalendar(2012, 11, 30), 4);
        Ingenieur ingenieur3 = new Ingenieur("ING3", "Jim", "Smith", new GregorianCalendar(1991, 11, 18), true, "Maintenance", "Mécanique", new GregorianCalendar(2014, 2, 12), 3);
        BunkerManager.add(ingenieur1);
        BunkerManager.add(ingenieur2);
        BunkerManager.add(ingenieur3);

        // Ajouter trois scientifiques
        Scientifique scientifique1 = new Scientifique("SCI1", "John", "Doe", new GregorianCalendar(1980, 2, 8), true, 10, "Recherche", 2, new String[]{"Projet A", "Projet B"});
        Scientifique scientifique2 = new Scientifique("SCI2", "Jane", "Doe", new GregorianCalendar(1983, 6, 21), true, 8, "Recherche", 3, new String[]{"Projet C", "Projet D", "Projet E"});
        Scientifique scientifique3 = new Scientifique("SCI3", "Jim", "Doe", new GregorianCalendar(1986, 10, 15), true, 5, "Recherche", 1, new String[]{"Projet F"});
        BunkerManager.add(scientifique1);
        BunkerManager.add(scientifique2);
        BunkerManager.add(scientifique3);


        // Ajouter trois milices
        Milice milice1 = new Milice("MIL1", "John", "Doe", new GregorianCalendar(1990, 1, 1), true, "Lieutenant", "Sécurité intérieure", 5, "Arme1", 2);
        Milice milice2 = new Milice("MIL2", "Jane", "Doe", new GregorianCalendar(1992, 5, 15), true, "Sergent", "Patrouille", 3, "Arme2", 1);
        Milice milice3 = new Milice("MIL3", "Jim", "Doe", new GregorianCalendar(1995, 9, 20), true, "Caporal", "Gardiennage", 4, "Arme3", 3);
        BunkerManager.add(milice1);
        BunkerManager.add(milice2);
        BunkerManager.add(milice3);

        // Ajouter trois soldats de l'armée
        Armee armee1 = new Armee("ARM1", "Alan", "Smith", new GregorianCalendar(1985, 3, 10), true, "Capitaine", "Infanterie", 10, "Fusil", 20, 5, new String[]{"MISSION1", "MISSION2"});
        Armee armee2 = new Armee("ARM2", "Betty", "Smith", new GregorianCalendar(1988, 7, 22), true, "Lieutenant", "Artillerie", 8, "Canon", 15, 4, new String[]{"MISSION3", "MISSION4"});
        Armee armee3 = new Armee("ARM3", "Charlie", "Smith", new GregorianCalendar(1991, 11, 18), true, "Sergent", "Aviation", 6, "Avion", 10, 3, new String[]{"MISSION5", "MISSION6"});
        BunkerManager.add(armee1);
        BunkerManager.add(armee2);
        BunkerManager.add(armee3);
        // Ajouter trois administrateurs
        Administrateur admin1 = new Administrateur("ADM1", "Daniel", "Brown", new GregorianCalendar(1975, 4, 12), true, 30, "Gestion", 5, "ProjetAffecte1", "Directeur");
        Administrateur admin2 = new Administrateur("ADM2", "Emma", "Brown", new GregorianCalendar(1980, 8, 25), true, 25, "Finance", 4, "ProjetAffecte2", "Chef de département");
        Administrateur admin3 = new Administrateur("ADM3", "Frank", "Brown", new GregorianCalendar(1983, 12, 14), true, 20, "RH", 3, "ProjetAffecte3", "Manager");
        BunkerManager.add(admin1);
        BunkerManager.add(admin2);
        BunkerManager.add(admin3);
        BunkerManager.trierPersonnelsParDateNaissance();
    }

    public static void writeToFile(String fileName, List<Personnel> personnels) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String header = fileName + " - " + sdf.format(new Date());
            writer.write(header);
            writer.newLine();
            writer.newLine();

            for (Personnel p : personnels) {
                writer.write(p.toString());
                writer.newLine();
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static   void initWriteFile(){
        writeToFile(configMap.get("armee"), BunkerManager.personnels.stream()
                .filter(p -> p instanceof Milice || p instanceof Armee)
                .collect(Collectors.toList()));

        writeToFile(configMap.get("gestionnaire"), BunkerManager.personnels.stream()
                .filter(p -> p instanceof Administrateur)
                .collect(Collectors.toList()));

        writeToFile(configMap.get("maintenance"), BunkerManager.personnels.stream()
                .filter(p -> p instanceof Ouvrier || p instanceof Ingenieur)
                .collect(Collectors.toList()));

    }
    public static void afficherConsole(){

        try {
            System.out.println("Contenu du fichier "+configMap.get("armee"));
            Files.readAllLines(Paths.get(configMap.get("armee"))).forEach(System.out::println);

            System.out.println("Contenu du fichier "+configMap.get("gestionnaire"));

            Files.readAllLines(Paths.get(configMap.get("gestionnaire"))).forEach(System.out::println);

            System.out.println("Contenu du fichier "+configMap.get("maintenance"));

            Files.readAllLines(Paths.get(configMap.get("maintenance"))).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
