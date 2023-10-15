package cn.edu.swu.gyh;

import java.io.*;
import java.nio.Buffer;
import java.util.List;
import java.util.ArrayList;
public class IOcode {
    public static void main(String[] args)
    {
        String filepath = "D:\\javacodeidea\\JavaClassLab2\\data\\test.txt";


    }
    public List<Pet> readPetsFromFile(String filePath)
    {
        List<Pet> pets = new ArrayList<>();
        File file = new File(filePath);
        try{
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
                String[] values = line.split(",");
                System.out.println(values[0]+"\t"+values[1]);
                Pet pet = new Pet();
                pets.add(pet);
            }
            reader.close();
        } catch (FileNotFoundException ex){
            System.out.println("ERROR");
        }catch (IOException ex)
        {
            System.out.println("ERROR IO");
        }


        return pets;
    }

}
