import java.io.IOException;

public class Main {

    //二进制数据的读取
    //文件的操作
    public static void main(String[] args) throws IOException {
        ImageCopyer copyer = new ImageCopyer();
        String sourcePath = "/D:/image.jpg";
        String targetPath = "/D:/newimage/IMAGE.jpg";
//        copyer.copy(sourcePath,targetPath);
//        copyer.Advancecopy(sourcePath,targetPath);
        String imagePath = "https://ts2.cn.mm.bing.net/th?id=OVP.yFMRy3DQZ4SqWgqpAIUE9wIIFF&w=432&h=243&c=7&rs=2&qlt=90&o=6&dpr=1.3&pid=1.7";
        copyer.copyFromWeb(imagePath,targetPath);




        //collections 集合类




    }
}