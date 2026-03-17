package com.hotelapp.backend.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ReservationDto
 */

@JsonTypeName("Reservation")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-17T23:05:52.143650100+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class ReservationDto {

  private Long id;

  private String guestName;

  private String guestEmail;

  private Integer roomNumber;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate checkInDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate checkOutDate;

  public ReservationDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ReservationDto guestName(String guestName) {
    this.guestName = guestName;
    return this;
  }

  /**
   * Get guestName
   * @return guestName
  */
  
  @Schema(name = "guestName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("guestName")
  public String getGuestName() {
    return guestName;
  }

  public void setGuestName(String guestName) {
    this.guestName = guestName;
  }

  public ReservationDto guestEmail(String guestEmail) {
    this.guestEmail = guestEmail;
    return this;
  }

  /**
   * Get guestEmail
   * @return guestEmail
  */
  
  @Schema(name = "guestEmail", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("guestEmail")
  public String getGuestEmail() {
    return guestEmail;
  }

  public void setGuestEmail(String guestEmail) {
    this.guestEmail = guestEmail;
  }

  public ReservationDto roomNumber(Integer roomNumber) {
    this.roomNumber = roomNumber;
    return this;
  }

  /**
   * Get roomNumber
   * @return roomNumber
  */
  
  @Schema(name = "roomNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("roomNumber")
  public Integer getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(Integer roomNumber) {
    this.roomNumber = roomNumber;
  }

  public ReservationDto checkInDate(LocalDate checkInDate) {
    this.checkInDate = checkInDate;
    return this;
  }

  /**
   * Get checkInDate
   * @return checkInDate
  */
  @Valid 
  @Schema(name = "checkInDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("checkInDate")
  public LocalDate getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(LocalDate checkInDate) {
    this.checkInDate = checkInDate;
  }

  public ReservationDto checkOutDate(LocalDate checkOutDate) {
    this.checkOutDate = checkOutDate;
    return this;
  }

  /**
   * Get checkOutDate
   * @return checkOutDate
  */
  @Valid 
  @Schema(name = "checkOutDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("checkOutDate")
  public LocalDate getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(LocalDate checkOutDate) {
    this.checkOutDate = checkOutDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationDto reservation = (ReservationDto) o;
    return Objects.equals(this.id, reservation.id) &&
        Objects.equals(this.guestName, reservation.guestName) &&
        Objects.equals(this.guestEmail, reservation.guestEmail) &&
        Objects.equals(this.roomNumber, reservation.roomNumber) &&
        Objects.equals(this.checkInDate, reservation.checkInDate) &&
        Objects.equals(this.checkOutDate, reservation.checkOutDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, guestName, guestEmail, roomNumber, checkInDate, checkOutDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    guestName: ").append(toIndentedString(guestName)).append("\n");
    sb.append("    guestEmail: ").append(toIndentedString(guestEmail)).append("\n");
    sb.append("    roomNumber: ").append(toIndentedString(roomNumber)).append("\n");
    sb.append("    checkInDate: ").append(toIndentedString(checkInDate)).append("\n");
    sb.append("    checkOutDate: ").append(toIndentedString(checkOutDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

