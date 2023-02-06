package com.example.breed.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Reservation {
    @Id
    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String id;
    private int price;
    private int paid;
    @OneToOne(mappedBy = "reservation")
    private Dog dog;

    public Reservation(int price, int paid) {
        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.paid = paid;
    }


    public Reservation() {
        this.id = UUID.randomUUID().toString();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", price=" + price +
                ", paid=" + paid +
                ", dog=" + dog +
                '}';
    }
}
