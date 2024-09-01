package me.lms.tddtest.tdd.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {
    private final File file;

  /*  @Rule
    public TemporaryFolder folder = new TemporaryFolder();*/

    public CSVLoader(String fileName){
        file = new File(fileName);
    }

    public List<Object[]> loadAll(){
        List<Object[]> objectList = new ArrayList<Object[]>();
        try{
            BufferedReader br = readerInit();
            String line = "";
            while((line = br.readLine()) != null){
                objectList.add(commaSeperatedStringsToObjects(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return objectList;
    }

    private BufferedReader readerInit(){
        BufferedReader br = null;
        try {
            br= new BufferedReader(new FileReader(this.file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br;
    }

    public Object[] commaSeperatedStringsToObjects(String str){
        String[] splitedStrings = str.split(",");
        Object[] objects = new Object[splitedStrings.length];
        for(int i =0; i<splitedStrings.length; i++){
            objects[i] = splitedStrings[i];
        }
        return objects;
    }

    private Object toIntegerIfPossible(String str){
        Object obj = null;
        try{
            obj = Integer.parseInt(str);
        }catch (NumberFormatException e){
            obj = str;
        }
        return obj;
    }






}
