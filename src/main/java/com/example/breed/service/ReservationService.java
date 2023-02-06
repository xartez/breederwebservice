package com.example.breed.service;

import com.example.breed.exceptions.ReservationNotFoundException;
import com.example.breed.model.Reservation;
import com.example.breed.repo.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    private  final ReservationRepo reservationRepo;

    @Autowired
    public ReservationService(ReservationRepo reservationRepo) { this.reservationRepo = reservationRepo;}

    public Reservation addReservation(Reservation reservation) { return reservationRepo.save(reservation);}

    public List<Reservation> findAllReservation() { return  reservationRepo.findAll();}

    public Reservation updateReservation(Reservation reservation) { return reservationRepo.save(reservation);}

    public Reservation findReservationByID(String id) throws Throwable {
        return reservationRepo.findReservationById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation by id " + id + " was not found"));
    }

    public void deleteReservation(String id) { reservationRepo.deleteReservationById(id);}
}
