package com.android.deptlibrary;

public class Book {
    private int id;
    private String domain_name;
    private String book_no;
    private String book_title;
    private String author;
    private String publication;
    private String availability;
    //private String image;

    public Book(int id, String domain_name, String book_no, String book_title, String author, String publication, String availability) {
        this.id = id;
        this.domain_name = domain_name;
        this.book_no = book_no;
        this.book_title= book_title;
        this.author = author;
        this.publication = publication;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }
    public String getDomain_name(){
        return domain_name;
    }

    public String getBook_no()
    {
        return book_no;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication() {
        return publication;
    }
    public String getAvailability(){
        return availability;
    }


}


