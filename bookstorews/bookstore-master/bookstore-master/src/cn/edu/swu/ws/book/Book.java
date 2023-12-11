package cn.edu.swu.ws.book;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private Float price;
    private String content;
    private String picture;

    public Book(){
    }

    public Book(int id, String name, String author, Float price, String content, String picture) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.content = content;
        this.picture = picture;
    }

    public Book(String name, String author, Float price, String content, String picture) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.content = content;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return this.picture;
    }
}
