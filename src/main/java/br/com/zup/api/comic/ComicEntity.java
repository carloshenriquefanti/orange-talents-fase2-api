package br.com.zup.api.comic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.zup.api.customer.CustomerEntity;

@Entity
@Table(name="comic")
public class ComicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comic")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "ISBN", nullable = false)
    private String isbn;
    
    @Column(name = "ComicDetails", nullable = false)
    private String comicDetails;

    @Column(name = "day_discount")
    private String dayDiscount;

    @Column(name = "active_discount")
    private Boolean activeDiscount = false;

    @ManyToOne
    @JoinColumn (name = "id_customer", nullable = false)
    @JsonBackReference
    private CustomerEntity customer;


public ComicEntity() {
}

public ComicEntity(int id, String title, float price, String autor, String isbn, String comicDetails, String dayDiscount, Boolean activeDiscount, CustomerEntity customer) {
    this.id = id;
    this.title = title;
    this.autor = autor;
    this.price = price;
    this.isbn = isbn;
    this.comicDetails = comicDetails;
    this.dayDiscount = dayDiscount;
    this.activeDiscount = activeDiscount;
    this.customer = customer;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public float getPrice() {
    return price;
}

public void setPrice(float price) {
    this.price = price;
}

public String getAutor() {
    return autor;
}

public void setAutor(String autor) {
    this.autor = autor;
}

public String getIsbn() {
    return isbn;
}

public void setIsbn(String isbn) {
    this.isbn = isbn;
}

public String getComicDetais() {
    return comicDetails;
}

public void setComicDetails(String comicDetails) {
    this.comicDetails = comicDetails;
}

public String getDayDiscount() {
    return dayDiscount;
}

public void setDayDiscount(String dayDiscount) {
    this.dayDiscount = dayDiscount;
}

public Boolean getActiveDiscount() {
    return activeDiscount;
}

public void setActiveDiscount(Boolean activeDiscount) {
    this.activeDiscount = activeDiscount;
}

public CustomerEntity getCustomer() {
    return customer;
}

public void setCustomer(CustomerEntity customer) {
    this.customer = customer;
	}
}