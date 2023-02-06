package com.example.breed.dto;

import com.example.breed.model.Dog;
import com.example.breed.model.Reservation;

import javax.persistence.OneToOne;

public class ReservationDTO {
    private int price;
    private int paid;
    private Dog dog;

    public ReservationDTO(Reservation reservation) {
        this.price = reservation.getPrice();
        this.paid = reservation.getPaid();
        this.dog = reservation.getDog();
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
        return "ReservationDTO{" +
                "price=" + price +
                ", paid=" + paid +
                ", dog=" + dog +
                '}';
    }
}
