package cn.edu.swu.gyh;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args)
    {
        Main main = new Main();
//        main.mapDemo();
        main.dataDemon();
    }



    public void dataDemon()
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDate data = LocalDate.now();
        LocalDateTime dataTime = LocalDateTime.now();
        System.out.println(data);

        System.out.println(dataTime.format(dateTimeFormatter));

    }
    public void  listDemo()
    {
        Student s1 = new Student("001","Tom");
        Student s2 = new Student("002","Jerry");
        Student s3 = new Student("003","Linda");
        Student s4 = new Student("004","Danny");

        Student s5 = new Student("006","Spider");



    }
    public void mapDemo()
    {
        Student s1 = new Student("001","Tom");
        Student s2 = new Student("002","Jerry");
        Student s3 = new Student("003","Linda");
        Student s4 = new Student("004","Danny");

        Student s5 = new Student("006","Spider");

        Map<String,Student> students = new HashMap<>();

        students.put(s1.getId(),s1);
        students.put(s2.getId(),s2);
        students.put(s3.getId(),s3);
        students.put(s4.getId(),s4);
        students.put(s5.getId(),s5);

//        System.out.println(students.get("001"));

//        for(Iterator<String> it = students.keySet().iterator();it.hasNext();)
//        {
//            Student student = students.get(it.next());
//            System.out.println(student);
//        }
//
//        Iterator<Map.Entry<String,Student>> iterator = students.entrySet().iterator();
//        for (;iterator.hasNext();)
//        {
//            Map.Entry<String,Student> studentEntry = iterator.next();
//            System.out.println(studentEntry.getKey());
//        }



        students.forEach((key,val) -> {
            System.out.println(key);
            System.out.println(val);
        });//JAVA8 之后提供的拉姆达写法

        System.out.println(students.containsKey("004"));
        students.remove("004");
        System.out.println(students.containsKey("004"));



        //回去补课Lambda expression




    }
//任务     1 编写程序读取网络上的文件，并解析获取图片路径的列表
//        2 在c盘根目录创建一个文件夹images
//         根据读取图片的URL地址下载所有图片，并存储到images目录下
//    存储规则 例 http://www.swu.edu.cn\xywh\zhanbanzongban\01.jpg
//    c:\images\www.swu.edu.cn\zhanbanzongban\01.jpg
//


}