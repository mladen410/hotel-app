package com.hotelapp.backend.service;

import com.hotelapp.backend.model.Reservation;
import com.hotelapp.backend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        if (reservationRepository.existsById(id)) {
            updatedReservation.setId(id);
            return reservationRepository.save(updatedReservation);
        }
        return null; // Or throw an exception depending on preferred error handling
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
