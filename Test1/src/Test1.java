import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) throws Exception {
        //封装获取获取web文件的操作
        Textread textread = new Textread();
        textread.copy();

//下载函数并排序的操作
        ImageDownload imageDownload = new ImageDownload();
        imageDownload.download();
    }
}
