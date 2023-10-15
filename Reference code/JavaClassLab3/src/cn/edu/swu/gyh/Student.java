package cn.edu.swu.gyh;

public class Student
{
    public enum Sex {
        MALE, FEMALE
    }
    private String id;
    private String name;

    private Sex gender;

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Student(String id,String name)
    {
        this.id = id;
        this.name = name;

    }
    public Student(String id,String name,Sex gender)
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

}
