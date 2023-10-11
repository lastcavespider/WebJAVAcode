package cn.edu.swu.gyh;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       PageReader pageReader = new PageReader();
        List<String> urls = pageReader.getUrls("http://10.122.7.154/javaweb/data/images-url.txt");
        System.out.println(urls);
    }
}