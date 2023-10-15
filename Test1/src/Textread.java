import java.io.*;
import java.net.URL;

public class Textread {
    public void copy() throws IOException {
        //创建url
        URL url = new URL("http://10.122.7.154/javaweb/data/images-url.txt");
        File fileNet = new File("D:\\javacodeidea\\Test1\\src\\webpath.txt");
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(fileNet);
        byte[] buffer = new byte[1024];
        int lenth;
        //通过bufferedreader逐行读取
        while ((lenth = is.read(buffer)) != -1)
        {
            os.write(buffer, 0, lenth);
        }
        is.close();
        os.close();
    }


}
