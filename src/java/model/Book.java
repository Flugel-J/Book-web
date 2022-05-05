/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class Book {
    private int id;
    private String uploader;
    private String title;
    private Date timeCreate;   
    private String description;
    private int viewed;
    private String detail;
    private List<String> categories;
    private String image;
    private boolean status;
    public Book(int id,String uploader, String title, String description, String detail) {
        this.id=id;
        this.uploader = uploader;
        this.title = title;
        this.description = description;
        this.detail = detail;
    }
    public Book() {
    }

  
    public int getId() {
        return id;
    }
  public void setId(int id) {
        this.id = id;
    }
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        if(image!=null)
            this.image = image;
        else
            this.image="default.png";
    }

  

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
    
    
}
