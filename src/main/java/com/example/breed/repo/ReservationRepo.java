package com.example.breed.repo;

import com.example.breed.model.Litter;
import com.example.breed.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReservationRepo extends JpaRepository<Reservation, String> {
    void deleteReservationById(String id);

    Optional<Reservation> findReservationById(String id);
}
