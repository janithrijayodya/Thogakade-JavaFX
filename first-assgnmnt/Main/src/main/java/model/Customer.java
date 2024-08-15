package model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor


public class Customer {
    private String id;
    private String name;
    private String address;
    private String contact;
    private String title;
    private LocalDate date;

    public Customer(String id, String name, String address, String contact,String title,LocalDate date) {
        this.id=id;
        this.name=name;
        this.address=address;
        this.contact=contact;
        this.title=title;
        this.date=date;

    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getContact(){
        return contact;
    }
    public String getTitle(){
        return title;
    }
    public LocalDate getDate(){
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
