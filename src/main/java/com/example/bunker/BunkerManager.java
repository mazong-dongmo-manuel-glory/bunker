package com.example.bunker;
import com.example.bunker.pkgBunker.Personnel;
import com.example.bunker.pkgBunker.pkgGestionnaire.Administrateur;
import com.example.bunker.pkgBunker.pkgGestionnaire.Gestionnaire;
import javafx.scene.chart.XYChart;

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

}
