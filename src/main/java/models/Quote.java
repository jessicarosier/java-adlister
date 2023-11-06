package models;

import models.Author;

import java.io.Serializable;

public class Quote implements Serializable {

    private long id;

    private String content;

    private Author author;

    public Quote() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
