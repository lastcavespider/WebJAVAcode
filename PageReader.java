package cn.edu.swu.gyh;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PageReader {
    public List<String> getUrls(String pageUrl) throws FileNotFoundException {
        List<String> strings = new ArrayList<>();
        File file = new File(pageUrl);
        FileReader reader = new FileReader(file);

        return null;
    }

}
