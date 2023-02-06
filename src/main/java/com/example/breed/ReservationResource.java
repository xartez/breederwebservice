package com.example.breed;

import com.example.breed.dto.ReservationDTO;
import com.example.breed.model.Reservation;
import com.example.breed.service.ReservationService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
public class ReservationResource {
    private  final ReservationService reservationService;

    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public List<ReservationDTO> getAllReservations() {
        return  reservationService.findAllReservation().stream().map(reservation -> {
            ReservationDTO reservationDTO = new ReservationDTO(reservation);
            return reservationDTO;
        }).collect(Collectors.toList());
    }

    @GetMapping("/find/{id}")
    public ReservationDTO getReservationById(@PathVariable("id")String id) throws Throwable {
        return new ReservationDTO(reservationService.findReservationByID(id));
    }

    @PostMapping("/add")
    public ReservationDTO addReservation(@RequestBody Reservation reservation) {
        return new ReservationDTO(reservationService.addReservation(reservation));
    }

    @PutMapping("/update")
    public  ReservationDTO updateReservation(@RequestBody Reservation reservation) {
        return new ReservationDTO(reservationService.updateReservation(reservation));
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteReservation(@PathVariable("id") String id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
