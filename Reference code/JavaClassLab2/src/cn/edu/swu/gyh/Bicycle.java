package cn.edu.swu.gyh;


//内部类
//class Whell
//{
//    int number;
//}
public class Bicycle implements IBicycle{
    protected int speed;
    protected  int gear;


    //加了final后不能修改
    public final static String TYPE = "Bicycle";

    //构造函数可以有多个
    //在没有自行添加构造函数时，Java类会自行产生一个默认的构造函数
    //当人为制定后，系统就不会产生默认构造函数
    public Bicycle()
    {
        System.out.println("hello");
        this.speed = 0;
        this.gear = 2;
    }
    public Bicycle(int speed,int gear)
    {
        this.speed = speed;
        this.gear = gear;
    }



    public void speedUP(int increment)
    {
        this.speed+=increment;
    }

    public void setGear(int gear)
    {
        this.gear=gear;
    }


    public int getSpeed()
    {
        return this.speed;
    }
    public int getGear()
    {
        return this.gear;
    }

    //静态的方法可以在类的层面进行使用
    public void printTYPE()
    {
        System.out.println(Bicycle.TYPE);
    }
    public void printstate()
    {
        System.out.println("Speed "+this.speed+" gear "+this.gear);
    }
}
