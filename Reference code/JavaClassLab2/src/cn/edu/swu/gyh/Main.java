package cn.edu.swu.gyh;

public class Main {
    public static void main(String[] args)
    {
        Bicycle bike1 = new Bicycle();
        bike1.printstate();

        Bicycle bike2 = new Bicycle(10,5);
        bike2.printstate();
        bike1.printTYPE();
        bike2.printTYPE();
        bike1.speedUP(3);
        System.out.println(bike1.getSpeed());
        //Bicycle.TYPE="MountBicycle";
        bike1.printTYPE();
        bike2.printTYPE();




        //匿名类
        
        IBicycle bike5 = new IBicycle() {
           int s,g;
            @Override
            public void speedUP(int a) {
                s += a * 2;
            }

            @Override
            public void setGear(int a) {
                g = a * 2;
            }
        };






    }
}