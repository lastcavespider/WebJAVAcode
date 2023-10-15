import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class ImageCopyer {

    public void copyFromWeb(String sourcePath, String targetPath) throws IOException {
        URL url = new URL(sourcePath);
        URLConnection connection = url.openConnection();







        try (InputStream inputStream = connection.getInputStream()) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(targetPath)) {
                long start = (new Date()).getTime();

                int count = -1;
                byte[] data = new byte[1024];


                while((count = inputStream.read(data))!=-1)
                {
                    fileOutputStream.write(data,0,count);
                }


                long end = (new Date().getTime());
                System.out.println(end - start);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }













    public void copy(String sourceImage, String targetPath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(sourceImage)) {
            File directory = new File(targetPath).getParentFile();
            if(!directory.exists())//没有目录就创建目录
            {
                directory.mkdir();
            }
            try (FileOutputStream fileOutputStream = new FileOutputStream(targetPath)) {
                long start = (new Date()).getTime();
                int data;
                while ((data = fileInputStream.read()) != -1) {
                    fileOutputStream.write(data);
                }
                long end = (new Date().getTime());
                System.out.println(end - start);
            }
        }


    }

    public void Advancecopy(String sourceImage, String targetPath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(sourceImage)) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(targetPath)) {
                long start = (new Date()).getTime();

                int count = -1;
                byte[] data = new byte[1024];


                while((count = fileInputStream.read(data))!=-1)
                {
                    fileOutputStream.write(data,0,count);
                }


                long end = (new Date().getTime());
                System.out.println(end - start);
            }
        }
    }
}