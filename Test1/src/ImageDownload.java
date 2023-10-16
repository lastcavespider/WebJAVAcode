import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class ImageDownload {
    public void download() throws Exception
    {
        //创建一个list对象存储链接
        ArrayList<String> list = new ArrayList();
        try (
                //创建reader和bufferedeader读取文件
                Reader fr = new FileReader("src\\webpath.txt");
                BufferedReader br = new BufferedReader(fr);
        )
        {
            //用bufferedreader逐行读取
            for (int i = 0; i < 5; i++)
            {
                list.add(br.readLine());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        //打印路径的列表
        for (int i = 0; i < 5; i++)
        {
            System.out.println(list.get(i));
        }
        //c盘根目录下创建文件夹images以及后续文件，放在dirName中
        ArrayList<String> dirName = new ArrayList<>();
        //根据url路径解析创建文件夹路径
        //注意分割的方式
        for (int i = 0; i < 5; i++)
        {
            //将分割后的字符串放入
            String[] PATH = list.get(i).split("/");

            String dirName0 = PATH[2] + "/" + PATH[3] + "/" + PATH[4] + "/";
            //将路径加入列表
            dirName.add(dirName0);
        }

        //创建文件夹保存图片
        for (int i = 0; i < 5; i++)
        {
            File dir = new File("C:/images/" + dirName.get(i));//使用字符串拼接文件夹路径
            dir.mkdirs();//类似于Linux命令行，可以直接猜
        }
        //下载图片
        DownloadFunction downloadFunction = new DownloadFunction();
        for (int i = 0; i < 5; i++)
        {
            downloadFunction.imagesDownload(list.get(i), "C:/images/" + dirName.get(i));
        }

        //比较图片大小并排序

        long[] photosize = new long[5];
        for (int i = 0; i < 5; i++)
        {
            photosize[i]=imagesize("C:/images/" + dirName.get(i)+"01.jpg");
        }
        //使用冒泡排序对字节大小排序

        long temp = 0;
        for (int j = 0; j < 4; j++)
        {
            for (int k = 0; k < 4 - j; k++)
            {
                if (photosize[k] < photosize[k + 1])
                {
                    temp = photosize[k];
                    photosize[k] = photosize[k + 1];
                    photosize[k + 1] = temp;
                }
            }
        }

        //创建txt文件，将结文件果录入
        Writer fw = new FileWriter("C:/images/images-sorted.txt", true);
        for (int i = 0; i < 5; i++)
        {
            fw.write(photosize[i] + "    ");
            for (int l = 0; l < 5; l++)
            {
                if (photosize[i] == imagesize("C:/images/" + dirName.get(l)+"01.jpg")) {
                    fw.write(list.get(l));
                }
            }
            fw.write("\r\n");
        }
        fw.flush();
    }

    //读取文件字节数的函数
    public static long imagesize(String path)
    {
        File f1 = new File(path);
        return f1.length();
    }

}
