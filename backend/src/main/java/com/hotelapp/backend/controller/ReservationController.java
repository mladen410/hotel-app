package com.hotelapp.backend.controller;

import com.hotelapp.backend.api.ReservationApi;
import com.hotelapp.backend.api.model.ReservationDto;
import com.hotelapp.backend.model.Reservation;
import com.hotelapp.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController implements ReservationApi {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    private ReservationDto convertToDto(Reservation entity) {
        if (entity == null) return null;
        ReservationDto dto = new ReservationDto();
        dto.setId(entity.getId());
        dto.setGuestName(entity.getGuestName());
        dto.setGuestEmail(entity.getGuestEmail());
        dto.setRoomNumber(entity.getRoomNumber());
        dto.setCheckInDate(entity.getCheckInDate());
        dto.setCheckOutDate(entity.getCheckOutDate());
        return dto;
    }

    private Reservation convertToEntity(ReservationDto dto) {
        if (dto == null) return null;
        Reservation entity = new Reservation();
        entity.setId(dto.getId());
        entity.setGuestName(dto.getGuestName());
        entity.setGuestEmail(dto.getGuestEmail());
        entity.setRoomNumber(dto.getRoomNumber());
        entity.setCheckInDate(dto.getCheckInDate());
        entity.setCheckOutDate(dto.getCheckOutDate());
        return entity;
    }

    @Override
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        List<ReservationDto> dtos = reservationService.getAllReservations()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ReservationDto> createReservation(ReservationDto reservationDto) {
        try {
            Reservation entity = convertToEntity(reservationDto);
            Reservation newReservation = reservationService.createReservation(entity);
            return new ResponseEntity<>(convertToDto(newReservation), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ReservationDto> getReservationById(Long id) {
        Optional<Reservation> reservationData = reservationService.getReservationById(id);
        if (reservationData.isPresent()) {
            return new ResponseEntity<>(convertToDto(reservationData.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ReservationDto> updateReservation(Long id, ReservationDto reservationDto) {
        Reservation entity = convertToEntity(reservationDto);
        Reservation updatedReservation = reservationService.updateReservation(id, entity);

        if (updatedReservation != null) {
            return new ResponseEntity<>(convertToDto(updatedReservation), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deleteReservation(Long id) {
        try {
            reservationService.deleteReservation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
