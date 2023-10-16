import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

//下载图片的函数实现
public class DownloadFunction
{
    public static void imagesDownload(String path, String dir) throws Exception {
        //创建路径
        URL url = new URL(path);
        InputStream in = url.openStream();
        //保存读取来的具体数据的字节数组
        byte data[] = new byte[1024];
        int lenth = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while ((lenth = in.read(data)) != -1) {
            out.write(data, 0, lenth);
            //写入数据
        }
        File file = new File(dir + File.separator + "01.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(out.toByteArray());
        //关闭
        fileOutputStream.close();
        out.close();
        in.close();
    }
}
