package com.example.libsys.entities;

import javax.persistence.*;

@Table
@Entity
public class Book {
    @Id
    @SequenceGenerator(
            sequenceName = "bookID_seq",
            name = "bookID_seq",
            allocationSize = 1)
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "bookID_seq")
    private Long bookID;
    private String name;
    private String author;
    private long price;
    private String publicationHouse;
    private byte isInArchive;

    public Book() {
    }

    public Book(String name, String author, long price, String publicationHouse, byte isInArchive) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.publicationHouse = publicationHouse;
        this.isInArchive = isInArchive;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getPublicationHouse() {
        return publicationHouse;
    }

    public void setPublicationHouse(String publicationHouse) {
        this.publicationHouse = publicationHouse;
    }

    public byte getIsInArchive() {
        return isInArchive;
    }

    public void setIsInArchive(byte isInArchive) {
        this.isInArchive = isInArchive;
    }

}
